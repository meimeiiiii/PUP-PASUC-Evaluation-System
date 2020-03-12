package servlets;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.CCEScore;
import model.Credential;
import others.GetDateTime;
import services.ActivityLogSvc;
import services.ApplicationSvc;
import services.CredentialSvc;

@MultipartConfig(maxFileSize = 16177215)

public class CredentialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CredentialServlet() {
        super();
    }
    
 //!!!!---------------GET----------------GET----------------- GET --------------GET--------------GET------------------GET---------!!!!!
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
						throws ServletException, IOException {
		System.out.println("\n-------CRED - GET");
		
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
						
			// ---------------------------------- credential?process=? ---------------------------------------------		
			
				case "view":
					System.out.println("[CRED_VIEW] Start");
					
					
					if(email==null) {
						System.out.println("[CRED_VIEW] Direct to cred view");
						response.sendRedirect(request.getContextPath() + "/index");	
						System.out.println("[CRED_VIEW] DONE");
					}else {
						List<Credential> cred_educ = cred.getCred("educ", empId);
							session.setAttribute("cred_educ",cred_educ);
						List<Credential> cred_prof = cred.getCred("prof", empId);
							session.setAttribute("cred_prof",cred_prof);
						List<Credential> cred_exp = cred.getCred("exp", empId);
							session.setAttribute("cred_exp",cred_exp);
						List<CCEScore> cs = cred.getCCEScore();
							session.setAttribute("ccescore",cs);
						
	
						//session.setAttribute("cred_exp",cred_exp);
						//session.setAttribute("cred_profdev",cred_profdev);
						
						//Credential c = cred.get(0);
						
						System.out.println("[CRED_VIEW] DONE");
					}
					request.getRequestDispatcher("crdntl").forward(request, response);
					break;
					
					
					// ---------------------------------- credential?process=get&id=? ---------------------------------------------		
					
					case "get":
						System.out.println("[CRED_GET] Start");
						
						String appId = request.getParameter("id");
							System.out.println("appID: " + appId);			
						
						if(email==null) {
								String emailPEC = (String) session.getAttribute("pecEMAIL");
								System.out.println("emailPEC: " + emailPEC);
							if(emailPEC==null) {
								System.out.println("[CRED_GET] Direct to cred get");
								response.sendRedirect(request.getContextPath() + "/index");	
								System.out.println("[CRED_GET] DONE");
							}else {
								ApplicationSvc app = new ApplicationSvc();
								
								empId = app.getAppOwner(appId);
									System.out.println("emp id: " + empId);
								
//								List<Credential> cred_educ = cred.getCredOfAppForPEC("educ", appId);
//									session.setAttribute("cred_educ",cred_educ);
//								List<Credential> cred_prof = cred.getCredOfAppForPEC("prof", appId);
//									session.setAttribute("cred_prof",cred_prof);
//								List<Credential> cred_exp = cred.getCredOfAppForPEC("exp", appId);
//									session.setAttribute("cred_exp",cred_exp);
								
								List<Credential> cred_educ = cred.getCredOfApp("educ", appId, empId);
									session.setAttribute("cred_educ",cred_educ);
								List<Credential> cred_prof = cred.getCredOfApp("prof", appId, empId);
									session.setAttribute("cred_prof",cred_prof);
								List<Credential> cred_exp = cred.getCredOfApp("exp", appId, empId);
									session.setAttribute("cred_exp",cred_exp);
									
									int score_educ = cred.getTotal(empId, "educ");
										session.setAttribute("total_educ",score_educ);	System.out.println("Educ: " + score_educ);
									int score_prof = cred.getTotal(empId, "prof");
										session.setAttribute("total_prof",score_prof);	System.out.println("Prof: " + score_prof);
									int score_exp = cred.getTotal(empId, "exp");
										session.setAttribute("total_educ",score_exp);	System.out.println("Exp: " + score_exp);
							}
						}else {
							List<Credential> cred_educ = cred.getCredOfApp("educ", appId, empId);
								session.setAttribute("cred_educ",cred_educ);
							List<Credential> cred_prof = cred.getCredOfApp("prof", appId, empId);
								session.setAttribute("cred_prof",cred_prof);
							List<Credential> cred_exp = cred.getCredOfApp("exp", appId, empId);
								session.setAttribute("cred_exp",cred_exp);
								
								int score_educ = cred.getTotal(empId, "educ");
									session.setAttribute("total_educ",score_educ);	System.out.println("Educ: " + score_educ);
								int score_prof = cred.getTotal(empId, "prof");
									session.setAttribute("total_prof",score_prof);	System.out.println("Prof: " + score_prof);
								int score_exp = cred.getTotal(empId, "exp");
									session.setAttribute("total_educ",score_exp);	System.out.println("Exp: " + score_exp);
															
								
							System.out.println("[CRED_GET] DONE");
						}	
					break;

									
					
			
			// ---------------------------------- credential?process=viewDocument&id=? ---------------------------------------------		
							
				case "viewDocument":
					String credId = request.getParameter("id");
						System.out.println("Cred ID: " + credId);
					byte[] documentB = cred.getDocument(credId);
						System.out.println("Doc: " + documentB);
					
					if(cred.checkCredOwner(credId, empId) == true) {
						response.setContentType("application/pdf");
			            response.setHeader("Content-Disposition", "inline");
			            response.setContentLength(documentB.length);
			                
			            OutputStream output = response.getOutputStream();
			            output.write(documentB);
			                
			            output.flush();
					}else if(session.getAttribute("pecID")!=null) {
						response.setContentType("application/pdf");
			            response.setHeader("Content-Disposition", "inline");
			            response.setContentLength(documentB.length);
			                
			            OutputStream output = response.getOutputStream();
			            output.write(documentB);
			                
			            output.flush();
					}else {
						System.out.println("You are not authorized to view that document.");
						request.getRequestDispatcher("/credential?process=view").forward(request, response);
					}
					
				
					break;
					
			// ---------------------------------- credential?process=add&class=? ---------------------------------------------		
			
				case "add":
					System.out.println("[ADD_CRED] START");
					
					response.setContentType("text/html;charset=UTF-8");
					
					String credType = request.getParameter("class");
					String timestamp = GetDateTime.main(null);
					String type = request.getParameter("maintype_" + credType);
					String subtype = request.getParameter("subtype_" + credType);
					String title = request.getParameter("credtitle_" + credType);
					Part document = request.getPart("fileinput_" + credType);
				
	
					System.out.println("[ADD_CRED] " + credType + " " + timestamp  + " " + type  + " " + subtype  
							+ " " + title  + " " + document);
					
					boolean result = cred.addCred(credType,timestamp,empId,type,subtype,title,document);
						System.out.println(result); 
					if(result == true) { 
						System.out.println("[ADD_CRED] SUCCESSFUL");
						act.add(empId, "Credential added successfully");
						
						request.getRequestDispatcher("/credential?process=view").forward(request, response);
					}else { 
						System.out.println("[ADD_CRED] FAIlED.");
	//					request.setAttribute("errorMessageRegister","Email address has an existing account."); 
						request.getRequestDispatcher("/credential?process=view").forward(request, response);
					}
					System.out.println("[ADD_CRED] END");
					break;
					
			// ---------------------------------- credential?process=delete&id=? ---------------------------------------------		
						
				case "delete":
					System.out.println("[DEL_CRED] Start");

					String credIdDel = request.getParameter("id");
					System.out.println("Cred ID: " + credIdDel);
					
					if(cred.checkCredOwner(credIdDel, empId) == true) {
						if (cred.delCred(credIdDel)==true) {
							System.out.println("[DEL_CRED] SUCCESSFUL");
							act.add(empId, "Credential (#" + credIdDel + ") deleted successfully");
							request.getRequestDispatcher("/credential?process=view").forward(request, response);
						}else { 
							System.out.println("[DEL_CRED] FAIlED.");
							request.getRequestDispatcher("/credential?process=view").forward(request, response);
						}
					}else {
						System.out.println("You are not authorized to view that document.");
						request.getRequestDispatcher("/credential?process=view").forward(request, response);
					}

					break;
					// ---------------------------------- credential?process=delete&id=? ---------------------------------------------		
					
				case "changeAppId":
					System.out.println("[CH APP ID] Start");

					String pendingAppId = request.getParameter("id");
					System.out.println("App ID: " + pendingAppId);
					
					if(cred.updateAppId(empId,pendingAppId) == true) {		
						System.out.println("[CH APP ID] SUCCESSFUL");
					}else { 
						System.out.println("[CH APP ID] FAIlED.");
					}

					break;	
			}
		}

//!!!!---------------POST----------------POST----------------- POST --------------POST--------------POST------------------POST---------!!!!!
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("\n-------CRED - POST");
		
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
			
			// ---------------------------------- credential?process=? ---------------------------------------------		
			
			case "view":
				System.out.println("[CRED_VIEW] Start");
				
				if(email==null) {
					System.out.println("[CRED_VIEW] Direct to cred view");
					response.sendRedirect(request.getContextPath() + "/index");	
					System.out.println("[CRED_VIEW] DONE");
				}else {
					List<Credential> cred_educ = cred.getCred("educ", empId);
						session.setAttribute("cred_educ",cred_educ);
					List<Credential> cred_prof = cred.getCred("prof", empId);
						session.setAttribute("cred_prof",cred_prof);
					List<Credential> cred_exp = cred.getCred("exp", empId);
						session.setAttribute("cred_exp",cred_exp);
					

					//session.setAttribute("cred_exp",cred_exp);
					//session.setAttribute("cred_profdev",cred_profdev);
					
					//Credential c = cred.get(0);
					
					System.out.println("[CRED_VIEW] DONE");
				}
				request.getRequestDispatcher("crdntl").forward(request, response);
				break;
		
				// ---------------------------------- credential?process=get&id=? ---------------------------------------------		
				
			case "get":
				System.out.println("[CRED_GET] Start");
				
				String appId = request.getParameter("id");
					System.out.println("appID: " + appId);			
				
				if(email==null) {
						String emailPEC = (String) session.getAttribute("pecEMAIL");
						System.out.println("emailPEC: " + emailPEC);
					if(emailPEC==null) {
						System.out.println("[CRED_GET] Direct to cred get");
						response.sendRedirect(request.getContextPath() + "/index");	
						System.out.println("[CRED_GET] DONE");
					}else {
						ApplicationSvc app = new ApplicationSvc();
						
						empId = app.getAppOwner(appId);
							System.out.println("emp id: " + empId);
						
//						List<Credential> cred_educ = cred.getCredOfAppForPEC("educ", appId);
//							session.setAttribute("cred_educ",cred_educ);
//						List<Credential> cred_prof = cred.getCredOfAppForPEC("prof", appId);
//							session.setAttribute("cred_prof",cred_prof);
//						List<Credential> cred_exp = cred.getCredOfAppForPEC("exp", appId);
//							session.setAttribute("cred_exp",cred_exp);
						
						List<Credential> cred_educ = cred.getCredOfApp("educ", appId, empId);
							session.setAttribute("cred_educ",cred_educ);
						List<Credential> cred_prof = cred.getCredOfApp("prof", appId, empId);
							session.setAttribute("cred_prof",cred_prof);
						List<Credential> cred_exp = cred.getCredOfApp("exp", appId, empId);
							session.setAttribute("cred_exp",cred_exp);
							
							int score_educ = cred.getTotal(empId, "educ");
								session.setAttribute("total_educ",score_educ);	System.out.println("Educ: " + score_educ);
							int score_prof = cred.getTotal(empId, "prof");
								session.setAttribute("total_prof",score_prof);	System.out.println("Prof: " + score_prof);
							int score_exp = cred.getTotal(empId, "exp");
								session.setAttribute("total_educ",score_exp);	System.out.println("Exp: " + score_exp);
					}
				}else {
					List<Credential> cred_educ = cred.getCredOfApp("educ", appId, empId);
						session.setAttribute("cred_educ",cred_educ);
					List<Credential> cred_prof = cred.getCredOfApp("prof", appId, empId);
						session.setAttribute("cred_prof",cred_prof);
					List<Credential> cred_exp = cred.getCredOfApp("exp", appId, empId);
						session.setAttribute("cred_exp",cred_exp);
						
						int score_educ = cred.getTotal(empId, "educ");
							session.setAttribute("total_educ",score_educ);	System.out.println("Educ: " + score_educ);
						int score_prof = cred.getTotal(empId, "prof");
							session.setAttribute("total_prof",score_prof);	System.out.println("Prof: " + score_prof);
						int score_exp = cred.getTotal(empId, "exp");
							session.setAttribute("total_educ",score_exp);	System.out.println("Exp: " + score_exp);
													
						
					System.out.println("[CRED_GET] DONE");
				}	
			break;
				
		// ---------------------------------- credential?process=viewDocument&id=? ---------------------------------------------		
						
				case "viewDocument":
					String credId = request.getParameter("id");
						System.out.println("Cred ID: " + credId);
					byte[] documentB = cred.getDocument(credId);
						System.out.println("Doc: " + documentB);
					
					if(cred.checkCredOwner(credId, empId) == true) {
						response.setContentType("application/pdf");
			            response.setHeader("Content-Disposition", "inline");
			            response.setContentLength(documentB.length);
			                
			            OutputStream output = response.getOutputStream();
			            output.write(documentB);
			                
			            output.flush();
					}else if(session.getAttribute("pecID")!=null) {
						response.setContentType("application/pdf");
			            response.setHeader("Content-Disposition", "inline");
			            response.setContentLength(documentB.length);
			                
			            OutputStream output = response.getOutputStream();
			            output.write(documentB);
			                
			            output.flush();
					}else {
						System.out.println("You are not authorized to view that document.");
						request.getRequestDispatcher("/credential?process=view").forward(request, response);
					}
					
				
					break;
				
		// ---------------------------------- credential?process=add&class=? ---------------------------------------------		
		
			case "add":
				System.out.println("[ADD_CRED] START");
				
				response.setContentType("text/html;charset=UTF-8");
				
				String credType = request.getParameter("class");
				String timestamp = GetDateTime.main(null);
				String type = request.getParameter("maintype_" + credType);
				String subtype = request.getParameter("subtype_" + credType);
				String title = request.getParameter("credtitle_" + credType);
				Part document = request.getPart("fileinput_" + credType);
			

				System.out.println("[ADD_CRED] " + credType + " " + timestamp  + " " + type  + " " + subtype  
						+ " " + title  + " " + document);
				
				boolean result = cred.addCred(credType,timestamp,empId,type,subtype,title,document);
					System.out.println(result); 
				if(result == true) { 
					System.out.println("[ADD_CRED] SUCCESSFUL");
					act.add(empId, "Credential added successfully");
					response.sendRedirect(request.getContextPath() + "/credential?process=view");	
//					request.getRequestDispatcher("/credential?process=view").forward(request, response);
				}else { 
					System.out.println("[ADD_CRED] FAIlED.");
//					request.setAttribute("errorMessageRegister","Email address has an existing account."); 
					request.getRequestDispatcher("/credential?process=view").forward(request, response);
				}
				System.out.println("[ADD_CRED] END");
				break;
				
		// ---------------------------------- credential?process=delete&id=? ---------------------------------------------		
					
			case "delete":
				System.out.println("[DEL_CRED] Start");

				String credIdDel = request.getParameter("id");
				System.out.println("Cred ID: " + credIdDel);
				
				if(cred.checkCredOwner(credIdDel, empId) == true) {
					if (cred.delCred(credIdDel)==true) {
						System.out.println("[DEL_CRED] SUCCESSFUL");
						act.add(empId, "Credential (#" + credIdDel + ") deleted successfully");
						request.getRequestDispatcher("/credential?process=view").forward(request, response);
					}else { 
						System.out.println("[DEL_CRED] FAIlED.");
						request.getRequestDispatcher("/credential?process=view").forward(request, response);
					}
				}else {
					System.out.println("You are not authorized to view that document.");
					request.getRequestDispatcher("/credential?process=view").forward(request, response);
				}

				break;
	
	// ---------------------------------- credential?process=delete&id=? ---------------------------------------------		
				
			case "changeAppId":
				System.out.println("[CH APP ID] Start");

				String pendingAppId = request.getParameter("id");
				System.out.println("App ID: " + pendingAppId);
				
				if(cred.updateAppId(empId,pendingAppId) == true) {		
					System.out.println("[CH APP ID] SUCCESSFUL");
					
				}else { 
					System.out.println("[CH APP ID] FAIlED.");
				}

				break;	
				
		}
	}
}
