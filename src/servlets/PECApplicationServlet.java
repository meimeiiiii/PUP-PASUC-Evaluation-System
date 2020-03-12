package servlets;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Application;
import model.Faculty;
import services.AccountSvc;
import services.ApplicationSvc;
import services.CredentialSvc;


public class PECApplicationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
    public PECApplicationServlet() {
        super();
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("\n-------PEC APPLICATION - GET");
		AccountSvc acc = new AccountSvc();
		ApplicationSvc app = new ApplicationSvc();
		CredentialSvc cred = new CredentialSvc();
		
		HttpSession session = request.getSession(true);
		
		String process = request.getParameter("process");
			System.out.println("Process: "+process);
			
		String email = (String) session.getAttribute("pecEMAIL");
			System.out.println("Email: " + email);
			
		String pecID = (String) session.getAttribute("pecID");
			System.out.println("PEC ID: " + pecID);
			
		switch(process) {
			
		// ---------------------------------- pec-application?process=view ---------------------------------------------	
		
		case "view":
			System.out.println("[APP_VIEW] START");
			
			request.getRequestDispatcher("pec-application?process=get").include(request, response);
			
			request.getRequestDispatcher("applicationPEC").forward(request, response);
			
			System.out.println("[APP_VIEW] END");
			
			break;
		
	// ---------------------------------- pec-application?process=get ---------------------------------------------	
					
		case "get":
			System.out.println("[GET APP] START");
			
			if(email==null) {
				
				String emailLog = request.getParameter("emailLogPEC");
				
				if(emailLog==null) {
					System.out.println("[APP_VIEW] Direct to app view");
					response.sendRedirect(request.getContextPath() + "/pec-login");	
					System.out.println("[APP_VIEW] DONE");
				}else {
					System.out.println("[APP_VIEW] FROM LOGIN");
					request.getRequestDispatcher("pec-account?process=getUser").include(request, response);
					System.out.println("[APP_VIEW] DONE");
				}
							
			}else {
				List<Application> application = app.getAllApp("Pending");
					
				application.addAll(app.getAllApp("Evaluated"));
				application.addAll(app.getAllApp("Approved"));
				
					session.setAttribute("pendingApp",application);
				
					List<Faculty> Fac = acc.getAllUsers();
					session.setAttribute("facListForApp",Fac);	
					System.out.println("GET FACULTY -- "  + Fac);
				
					System.out.println("[GET APP] DONE");
			}
		break;
		
		// ---------------------------------- pec-application?process=viewEntry&id=? -------------------------------------------	
		
		case "viewEntry":
			System.out.println("[VIEW ENTRY] START");
				String appId = request.getParameter("id");
				System.out.println("App ID: " + appId);
				
				if(appId == null) {
					if (pecID == null) {
						System.out.println("[VIEW ENTRY] Direct to app view");
						response.sendRedirect(request.getContextPath() + "/pec-login");	
						System.out.println("[VIEW ENTRY] DONE");
					}else {
						System.out.println("[VIEW ENTRY] Direct to app view entry");
						response.sendRedirect(request.getContextPath() + "pec-application?process=view");	
						System.out.println("[VIEW ENTRY] DONE");
					}
				}else {
					
					List<Application> application = app.getSpecApp(appId);
						session.setAttribute("app", application);
					List<Faculty> faculty = acc.getUserFrID(application.get(0).getEmpId());
						session.setAttribute("fac", faculty);
					request.getRequestDispatcher("/credential?process=get&id="+appId).include(request, response);
						
					System.out.println("[APP_VIEW] DONE");
				}
				
				request.getRequestDispatcher("applicationEntryPEC").include(request, response);
				System.out.println("[APP_VIEW] END");
				
			System.out.println("[VIEW ENTRY] DONE");
			
		break;
		
	// ---------------------------------- pec-application?process=changeCredStatus&appId=?&credId=? ---------------------------------------------	
	
		case "changeCredStatus":
			System.out.println("[UPDATE CRED] START");
			
			String appIdS = request.getParameter("appId");
				System.out.println("APP Id: " + appIdS);
			
			String credId = request.getParameter("credId");
				System.out.println("CRED Id: " + credId);
			String credStatus = request.getParameter("credStatus");
				System.out.println("Status: " + credStatus);
			int points = Integer.parseInt(request.getParameter("points"));
				System.out.println("Points: " + points);
			String remarks = request.getParameter("remarks");
				System.out.println("Remarks: " + remarks);
			
				
				if(cred.changeStatus(credId,points,credStatus,pecID,remarks)==true) {
					System.out.println("Successful status update");
					response.sendRedirect(request.getContextPath() + "/pec-application?process=viewEntry&id="+appIdS);
					//request.getRequestDispatcher("pec-application?process=viewEntry&id="+credId).forward(request, response);
				}else {
					System.out.println("Unsuccessful status update");
					response.sendRedirect(request.getContextPath() + "/pec-application?process=viewEntry&id="+appIdS);	
					
				}

			System.out.println("[UPDATE CRED] END");
			
			break;
		
		// ---------------------------------- pec-application?process=viewDocument&id=? ---------------------------------------------		
			
		case "viewDocument":
			String appIdView = request.getParameter("id");
				System.out.println("App ID: " + appIdView);
				
			byte[] documentB = cred.getDocument(appIdView);
				System.out.println("Doc: " + documentB);
			
			if(pecID != null) {
				response.setContentType("application/pdf");
	            response.setHeader("Content-Disposition", "inline");
	            response.setContentLength(documentB.length);
	                
	            OutputStream output = response.getOutputStream();
	            output.write(documentB);
	                
	            output.flush();
			}else {
				System.out.println("You are not authorized to view that document.");
				request.getRequestDispatcher("/pec-application?process=view").forward(request, response);
			}
			
		
			break;
		
			// ---------------------------------- pec-application?process=changeStatus&appId=? ---------------------------------------------	
			
				case "changeStatus":
					System.out.println("[UPDATE STATUS] START");
					
					String appIdCur = request.getParameter("appId");
						System.out.println("APP Id: " + appIdCur);
					
					String newStatus = (String) session.getAttribute("newAppStatus");
						System.out.println("New Status: " + newStatus);
						
					String remarksApp = (String) session.getAttribute("remarks");
						System.out.println("Remarks: " + remarksApp);
						
					if(app.changeStatus(appIdCur,pecID,newStatus,remarksApp)==true) {
						System.out.println("Successful status update");
						response.sendRedirect(request.getContextPath() + "/pec-application?process=viewEntry&id="+appIdCur);
					}else {
						System.out.println("Unsuccessful status update");
						response.sendRedirect(request.getContextPath() + "/pec-application?process=viewEntry&id="+appIdCur);	
						
					}
					System.out.println("[UPDATE STATUS] END");
					
					break;
				
			
		}
	}	
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("\n-------PEC APPLICATION - POST");
		AccountSvc acc = new AccountSvc();
		ApplicationSvc app = new ApplicationSvc();
		CredentialSvc cred = new CredentialSvc();
		
		HttpSession session = request.getSession(true);
		
		String process = request.getParameter("process");
			System.out.println("Process: "+process);
			
		String email = (String) session.getAttribute("pecEMAIL");
			System.out.println("Email: " + email);
			
		String pecID = (String) session.getAttribute("pecID");
			System.out.println("PEC ID: " + pecID);
			
			switch(process) {
			
			// ---------------------------------- pec-application?process=view ---------------------------------------------	
			
			case "view":
				System.out.println("[APP_VIEW] START");
				
				request.getRequestDispatcher("pec-application?process=get").include(request, response);
				
				request.getRequestDispatcher("applicationPEC").forward(request, response);
				
				System.out.println("[APP_VIEW] END");
				
				break;
			
		// ---------------------------------- pec-application?process=get ---------------------------------------------	
						
			case "get":
				System.out.println("[GET APP] START");
				
				if(email==null) {
					
					String emailLog = request.getParameter("emailLogPEC");
					
					if(emailLog==null) {
						System.out.println("[APP_VIEW] Direct to app view");
						response.sendRedirect(request.getContextPath() + "/pec-login");	
						System.out.println("[APP_VIEW] DONE");
					}else {
						System.out.println("[APP_VIEW] FROM LOGIN");
						request.getRequestDispatcher("pec-account?process=getUser").include(request, response);
						System.out.println("[APP_VIEW] DONE");
					}
								
				}else {
					List<Application> application = app.getAllApp("Pending");
					
					application.addAll(app.getAllApp("Evaluated"));
					application.addAll(app.getAllApp("Approved"));
					
						session.setAttribute("pendingApp",application);
					
						List<Faculty> Fac = acc.getAllUsers();
						session.setAttribute("facListForApp",Fac);	
					
						System.out.println("GET FACULTY -- "  + Fac);
						
						System.out.println("[GET APP] DONE");
				}
			break;
			
			// ---------------------------------- pec-application?process=viewEntry -------------------------------------------	
			
			case "viewEntry":
				System.out.println("[VIEW ENTRY] START");
					String appId = request.getParameter("id");
					System.out.println("App ID: " + appId);
					
					if(appId == null) {
						if (pecID == null) {
							System.out.println("[VIEW ENTRY] Direct to app view");
							response.sendRedirect(request.getContextPath() + "/pec-login");	
							System.out.println("[VIEW ENTRY] DONE");
						}else {
							System.out.println("[VIEW ENTRY] Direct to app view entry");
							response.sendRedirect(request.getContextPath() + "pec-application?process=view");	
							System.out.println("[VIEW ENTRY] DONE");
						}
					}else {
						
						List<Application> application = app.getSpecApp(appId);
							session.setAttribute("app", application);
						List<Faculty> faculty = acc.getUserFrID(application.get(0).getEmpId());
							session.setAttribute("fac", faculty);
						request.getRequestDispatcher("/credential?process=get&id="+appId).include(request, response);
							
						System.out.println("[APP_VIEW] DONE");
					}
					
					request.getRequestDispatcher("applicationEntryPEC").include(request, response);
					System.out.println("[APP_VIEW] END");
					
				System.out.println("[VIEW ENTRY] DONE");
				
			break;
			
			// ---------------------------------- pec-application?process=changeCredStatus&id=? ---------------------------------------------	
			
			case "changeCredStatus":
				System.out.println("[UPDATE CRED] START");
				
				String appIdS = request.getParameter("appId");
					System.out.println("APP Id: " + appIdS);
				
				String credId = request.getParameter("credId");
					System.out.println("CRED Id: " + credId);
				String credStatus = request.getParameter("credStatus");
					System.out.println("Status: " + credStatus);
				int points = Integer.parseInt(request.getParameter("points"));
					System.out.println("Points: " + points);
				String remarks = request.getParameter("displayValues");
					System.out.println("Remarks: " + remarks);
				
					
					if(cred.changeStatus(credId,points,credStatus,pecID,remarks)==true) {
						System.out.println("Successful status update");
						response.sendRedirect(request.getContextPath() + "/pec-application?process=viewEntry&id="+appIdS);
						//request.getRequestDispatcher("pec-application?process=viewEntry&id="+credId).forward(request, response);
					}else {
						System.out.println("Unsuccessful status update");
						response.sendRedirect(request.getContextPath() + "/pec-application?process=viewEntry&id="+appIdS);	
						
					}

				System.out.println("[UPDATE CRED] END");
				
				break;
				
				// ---------------------------------- pec-application?process=viewDocument&id=? ---------------------------------------------		
				
			case "viewDocument":
				String appIdView = request.getParameter("id");
					System.out.println("App ID: " + appIdView);
					
				byte[] documentB = cred.getDocument(appIdView);
					System.out.println("Doc: " + documentB);
				
				if(pecID != null) {
					response.setContentType("application/pdf");
		            response.setHeader("Content-Disposition", "inline");
		            response.setContentLength(documentB.length);
		                
		            OutputStream output = response.getOutputStream();
		            output.write(documentB);
		                
		            output.flush();
				}else {
					System.out.println("You are not authorized to view that document.");
					request.getRequestDispatcher("/pec-application?process=view").forward(request, response);
				}
				
			
				break;
			
				// ---------------------------------- pec-application?process=changeStatus&appId=? ---------------------------------------------	
				
			case "changeStatus":
				System.out.println("[UPDATE STATUS] START");
				
				String appIdCur = request.getParameter("appId");
					System.out.println("APP ID: " + appIdCur);
				
				String newStatus = request.getParameter("newAppStatus");
					System.out.println("New Status: " + newStatus);
					
				String remarksApp = request.getParameter("displayValues");
					System.out.println("Remarks: " + remarksApp);
					
				if(app.changeStatus(appIdCur,pecID,newStatus,remarksApp)==true) {
					System.out.println("Successful status update");
					
//					if(newStatus.equals("Approved")) {
//						app.changeRank(empId, scoreEduc, scoreExp, scoreProf)
//					}
					
					response.sendRedirect(request.getContextPath() + "/pec-application?process=viewEntry&id="+appIdCur);
				}else {
					System.out.println("Unsuccessful status update");
					response.sendRedirect(request.getContextPath() + "/pec-application?process=viewEntry&id="+appIdCur);	
					
				}
				System.out.println("[UPDATE STATUS] END");
				
				break;
				
		}
	}

}
