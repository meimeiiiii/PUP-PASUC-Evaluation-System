package servlets;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.Application;
import model.CCERank;
import services.AboutSvc;
import services.ActivityLogSvc;
import services.ApplicationSvc;
import services.CredentialSvc;

@MultipartConfig(maxFileSize = 16177215)

public class ApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ApplicationServlet() {
        super();
    }
    
 //!!!!---------------GET----------------GET----------------- GET --------------GET--------------GET------------------GET---------!!!!!
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
						throws ServletException, IOException {
		System.out.println("\n-------CRED - GET");
		
		ApplicationSvc app = new ApplicationSvc();
		CredentialSvc cred = new CredentialSvc();
		ActivityLogSvc act = new ActivityLogSvc();
		
		HttpSession session = request.getSession(true);
		
		String process = request.getParameter("process");
			System.out.println("Process: " + process);
			
		String email = (String) session.getAttribute("email");
			System.out.println("Email: " + email);
			
		String empId = (String) session.getAttribute("empId");
			System.out.println("Emp ID: " + empId);
		
			switch(process) {
			
			// ---------------------------------- application?process=view ---------------------------------------------		
				
			case "view":
				System.out.println("[APP_VIEW] START");
				
				if(email==null) {
					System.out.println("[APP_VIEW] Direct to app view");
					response.sendRedirect(request.getContextPath() + "/index");	
					System.out.println("[APP_VIEW] DONE");
				}else {
					
					List<Application> pendingApp = app.getApp(empId, "Pending");
					String appId = "";
					
					System.out.println("Pending App size: " + pendingApp.size());
					
					if(pendingApp.size() > 0) {
						session.setAttribute("pendingApp",pendingApp);
						appId = pendingApp.get(0).getAppId();
						System.out.println("Pending App ID: " + appId);
						
					}
					
					request.getRequestDispatcher("/credential?process=get&id="+appId).include(request, response);
					
					List<Application> prevApp = app.getApp(empId, "Approved");
						session.setAttribute("prevApp",prevApp);
						
						if(prevApp.size() > 0) {
							System.out.println("!!!!! There are previous applications");
							List<Application> latestApp = new ArrayList<>();
							latestApp.add(prevApp.get(0));
							
							session.setAttribute("latestApp",latestApp);
							System.out.println("LATEST APP: " + prevApp.get(0));

						}else {
							System.out.println("!!!!! There are no previous applications");
							Application a = new Application();
							a.setAppId("0");
							List<Application> latestApp = new ArrayList<>();
							latestApp.add(a);
							
							session.setAttribute("latestApp",latestApp);
							System.out.println("LATEST APP: " + latestApp);
						}
								
						AboutSvc abt = new AboutSvc();
						
						List<CCERank> cr = abt.getCCERank();
						System.out.println("!!!!!! GET CCE RANK LIST " + cr);
						session.setAttribute("cr",cr);
						
					System.out.println("[APP_VIEW] DONE");
				}
				
				request.getRequestDispatcher("applctn").include(request, response);
				System.out.println("[APP_VIEW] END");
				
				
				break;
				
				
		// ---------------------------------- application?process=submit ---------------------------------------------		
										
			case "submit":
				System.out.println("[APP_SUBMIT] START");
				
				String submitAppBtn = request.getParameter("submitAppBtn");
					System.out.println("Submit btn: " + submitAppBtn);
				
				if(submitAppBtn==null) {
					response.sendRedirect(request.getContextPath() + "/application?process=view");	
				   	System.out.println("[EDIT] Forward to /chngEml");
				}else {
					
					response.setContentType("text/html;charset=UTF-8");
					
					Part document = request.getPart("fileinput_letter");
					
					boolean result = app.addApp(empId,document);
						System.out.println(result); 
						
					if(result == true) { 
						System.out.println("[APP_SUBMIT] SUCCESSFUL");
						
						
						List<Application> pendingApp = app.getApp(empId, "Pending");
						
						String pendingAppId = pendingApp.get(0).getAppId();
						
						act.add(empId, "Application (#" + pendingAppId + ") submitted successfully");
						request.getRequestDispatcher("credential?process=changeAppId&id="+pendingAppId).include(request, response);
						
						response.sendRedirect(request.getContextPath() + "/application?process=view");	
//						request.getRequestDispatcher("/application?process=view").forward(request, response);
					}else { 
						System.out.println("[APP_SUBMIT] FAIlED.");
	//					request.setAttribute("errorMessageRegister","Email address has an existing account."); 
						request.getRequestDispatcher("/application?process=view").forward(request, response);
					}
				
				}	
				System.out.println("[APP_SUBMIT] END");
				break;	
				
				
				// ---------------------------------- application?process=viewDocument&id=? ---------------------------------------------		
								
					case "viewDocument":
						String appId = request.getParameter("id");
							System.out.println("App ID: " + appId);
						byte[] documentB = cred.getDocument(appId);
							System.out.println("Doc: " + documentB);
						
						if(app.checkAppOwner(appId, empId) == true) {
							response.setContentType("application/pdf");
				            response.setHeader("Content-Disposition", "inline");
				            response.setContentLength(documentB.length);
				                
				            OutputStream output = response.getOutputStream();
				            output.write(documentB);
				                
				            output.flush();
						}else {
							System.out.println("You are not authorized to view that document.");
							request.getRequestDispatcher("/application?process=view").forward(request, response);
						}
						
					
						break;
			}	
				
		}

//!!!!---------------POST----------------POST----------------- POST --------------POST--------------POST------------------POST---------!!!!!
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("\n-------APP - POST");
		
		ApplicationSvc app = new ApplicationSvc();
		CredentialSvc cred = new CredentialSvc();
		ActivityLogSvc act = new ActivityLogSvc();
		
		HttpSession session = request.getSession(true);
		
		String process = request.getParameter("process");
			System.out.println("Process: " + process);
			
		String email = (String) session.getAttribute("email");
			System.out.println("Email: " + email);
			
		String empId = (String) session.getAttribute("empId");
			System.out.println("Emp ID: " + empId);
		
			switch(process) {
			
			// ---------------------------------- application?process=view ---------------------------------------------		
			
			case "view":
				System.out.println("[APP_VIEW] START");
				
				if(email==null) {
					System.out.println("[APP_VIEW] Direct to app view");
					response.sendRedirect(request.getContextPath() + "/index");	
					System.out.println("[APP_VIEW] DONE");
				}else {
					
					List<Application> pendingApp = app.getApp(empId, "Pending");
					String appId = "";
					
					if(pendingApp != null) {
						session.setAttribute("pendingApp",pendingApp);
						appId = pendingApp.get(0).getAppId();
						System.out.println("Pending App ID: " + appId);
						
					}else {
						request.getRequestDispatcher("/credential?process=get&id="+appId).include(request, response);
						
						List<Application> prevApp = app.getApp(empId, "Approved");
							session.setAttribute("prevApp",prevApp);
							
							if(prevApp != null) {
								System.out.println("!!!!! There are previous applications");
								List<Application> latestApp = new ArrayList<>();
								latestApp.add(prevApp.get(0));
								
								session.setAttribute("latestApp",latestApp);
								System.out.println("LATEST APP: " + prevApp.get(0));

							}else {
								System.out.println("!!!!! There are no previous applications");
								Application a = new Application();
								a.setAppId("0");
								List<Application> latestApp = new ArrayList<>();
								latestApp.add(a);
								
								session.setAttribute("latestApp",latestApp);
								System.out.println("LATEST APP: " + latestApp);
								
//								String recomRank = app.getRank(score);
//								session.setAttribute("recomRank",recomRank);
//								System.out.println("LATEST APP: " + latestApp);
							}
							
							AboutSvc abt = new AboutSvc();
							
							List<CCERank> cr = abt.getCCERank();
							System.out.println("!!!!!! GET CCE RANK LIST " + cr);
							session.setAttribute("cr",cr);
							
						System.out.println("[APP_VIEW] DONE");
					}
					
				}
				
				request.getRequestDispatcher("applctn").include(request, response);
				System.out.println("[APP_VIEW] END");
				
				
				break;
				
				
		// ---------------------------------- application?process=submit ---------------------------------------------		
										
			case "submit":
				System.out.println("[APP_SUBMIT] START");
				
				String submitAppBtn = request.getParameter("submitAppBtn");
					System.out.println("Submit btn: " + submitAppBtn);
				
				if(submitAppBtn==null) {
					response.sendRedirect(request.getContextPath() + "/application?process=view");	
				   	System.out.println("[EDIT] Forward to /chngEml");
				}else {
					
					response.setContentType("text/html;charset=UTF-8");
					
					Part document = request.getPart("fileinput_letter");
					
					boolean result = app.addApp(empId,document);
						System.out.println(result); 
						
					if(result == true) { 
						System.out.println("[APP_SUBMIT] SUCCESSFUL");
						
						List<Application> pendingApp = app.getApp(empId, "Pending");
						
						String pendingAppId = pendingApp.get(0).getAppId();
						
						act.add(empId, "Application (#" + pendingAppId + ") submitted successfully");
						
						request.getRequestDispatcher("credential?process=changeAppId&id="+pendingAppId).include(request, response);
						
						response.sendRedirect(request.getContextPath() + "/application?process=view");	
//						request.getRequestDispatcher("/application?process=view").forward(request, response);
					}else { 
						System.out.println("[APP_SUBMIT] FAIlED.");
	//					request.setAttribute("errorMessageRegister","Email address has an existing account."); 
						request.getRequestDispatcher("/application?process=view").forward(request, response);
					}
				
				}	
				System.out.println("[APP_SUBMIT] END");
				break;	
				
				
				// ---------------------------------- application?process=viewDocument&id=? ---------------------------------------------		
								
					case "viewDocument":
						String appId = request.getParameter("id");
							System.out.println("App ID: " + appId);
						byte[] documentB = cred.getDocument(appId);
							System.out.println("Doc: " + documentB);
						
						if(app.checkAppOwner(appId, empId) == true) {
							response.setContentType("application/pdf");
				            response.setHeader("Content-Disposition", "inline");
				            response.setContentLength(documentB.length);
				                
				            OutputStream output = response.getOutputStream();
				            output.write(documentB);
				                
				            output.flush();
						}else {
							System.out.println("You are not authorized to view that document.");
							request.getRequestDispatcher("/application?process=view").forward(request, response);
						}
						
					
						break;
			}	
	}
}
