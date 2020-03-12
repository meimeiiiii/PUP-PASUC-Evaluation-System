package servlets;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PEC;
import others.Mail;
import others.RandomString;
import services.AccountSvc;


public class PECAccountServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
    public PECAccountServlet() {
        super();
    }
    
    String pasucEmail = "pup.cores@gmail.com";
	String pasucPsw = "CoRES123!";
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("\n-------PEC ACCOUNT - GET");
		AccountSvc acc = new AccountSvc();
		
		HttpSession session = request.getSession(true);
		
		String process = request.getParameter("process");
			System.out.println("Process: "+process);
			
		String email = (String) session.getAttribute("pecEMAIL");
			System.out.println("Email: " + email);
			
		String pecID = (String) session.getAttribute("pecID");
			System.out.println("PEC ID: " + pecID);
			
		switch(process) {
		
		// ---------------------------------- pec-account?process=login ---------------------------------------------	
		case "login":
			System.out.println("[LOGIN] START");
			
			String emailLog = request.getParameter("emailLogPEC");
			String pswLog = request.getParameter("pswLogPEC");
			
			if(acc.loginPEC(emailLog,pswLog) == true){
				System.out.println("[LOGIN] Sucessful");
				session.setAttribute("pecEMAIL",emailLog);
				
			}else {
				System.out.println("[LOGIN] Incorrect email or password.");
				request.setAttribute("errorMessageLogin","Incorrect email or password."); 
				request.getRequestDispatcher("/pec-login").forward(request, response); //changed forward fr include
				//response.sendRedirect(request.getContextPath() + "/pec-login");	
			}
			
			System.out.println("[LOGIN] END");
			break;
			
			// ---------------------------------- pec-account?process=getUser ---------------------------------------------	
			
		case "getUser":
			System.out.println("[GETUSER] START");
			
			if(email.equals(null)) {
				System.out.println("[GETUSER] Direct to login");
				response.sendRedirect(request.getContextPath() + "/pec-login");	
				System.out.println("[GETUSER] DONE");
			}else {
				List<PEC> PEC = acc.getUserPEC(email);
				session.setAttribute("pec",PEC);
				
				PEC P = PEC.get(0);
				session.setAttribute("pecID",P.getPecId());
					System.out.println(session.getAttribute("pecID"));
				session.setAttribute("selectedPosition", P.getPosition());
					System.out.println(session.getAttribute("selectedPosition"));
				session.setAttribute("rights", P.getRights());
					System.out.println(session.getAttribute("rights"));
				System.out.println("[GETUSER] DONE");
			}
			break;
			
			// ---------------------------------- pec-account?process=logout ---------------------------------------------			
			
			case "logout":
				System.out.println("[LOGOUT] START.");
				session.removeAttribute("pecEMAIL");
				session.removeAttribute("pecID");
				session.removeAttribute("pec");
				session.invalidate();
				System.out.println("[LOGOUT] END.");
			    response.sendRedirect(request.getContextPath() + "/pec-login");
				        	
			break;
			
			// ---------------------------------- pec-account?process=register ---------------------------------------------			
			
			
			case "register":
								
					String emailIn = request.getParameter("emailIn"); 
					String fn = request.getParameter("fName");
					String mn = request.getParameter("mName");
					String ln = request.getParameter("lName");
					String position = request.getParameter("position");
					String rights = request.getParameter("rights"); 
					
					
					// SEND EMAIL FOR PASSWORD
					String psw = RandomString.generate(8);
					String msgBod = "Hi " + fn + "!"  + "\n\n" +
							"Your account in the PUP PASUC Website has been created." + "\n\n" +
							"Below is your temporary password: " + "\n\n" +
							psw + "\n\n\n" +
							"Please change your password after your first log in.\n\n" +
							"PS. Do not reply to this email.";
					String subj = "PUP PASUC: Account Confirmation";
					
					try {
						Mail.Send(emailIn, pasucEmail, pasucPsw, subj, msgBod);
					} catch (MessagingException e) {
						System.err.println("Error in sending email.");
						e.printStackTrace();
						request.setAttribute("errorMessageRegister","Error sending email verification. Please try again."); 
						request.getRequestDispatcher("/index").include(request, response);	
					}
					System.out.println("Password: " + psw);
				
					request.getRequestDispatcher("/vrfyEml").include(request, response);
				
		
						boolean result = acc.addUserPEC( fn,  mn,  ln,  email, 
								 position,  rights, psw); //
						
						if(result == true) { 
							System.out.println("SUCCESSFUL");
							response.sendRedirect(request.getContextPath() + "/pec-members?process=view");	
							//request.getRequestDispatcher("/index").forward(request, response);
						}else {
							System.out.println("Error");
							request.setAttribute("errorMessageRegister","Error creating account."); 
							request.getRequestDispatcher("/pec-members?process=view").include(request, response);	
						}
				}
			
		}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("\n-------PEC ACCOUNT - POST");
		AccountSvc acc = new AccountSvc();
		
		HttpSession session = request.getSession(true);
		
		String process = request.getParameter("process");
			System.out.println("Process: "+process);
			
		String email = (String) session.getAttribute("pecEMAIL");
			System.out.println("Email: " + email);
			
		String pecID = (String) session.getAttribute("pecID");
			System.out.println("PEC ID: " + pecID);
			
		switch(process) {
		
		// ---------------------------------- pec-account?process=login ---------------------------------------------	
		case "login":
			System.out.println("[LOGIN] START");
			
			String emailLog = request.getParameter("emailLogPEC");
			String pswLog = request.getParameter("pswLogPEC");
			
			if(acc.loginPEC(emailLog,pswLog) == true){
				System.out.println("[LOGIN] Sucessful");
				session.setAttribute("pecEMAIL",emailLog);
				
			}else {
				System.out.println("[LOGIN] Incorrect email or password.");
				request.setAttribute("errorMessageLogin","Incorrect email or password."); 
				request.getRequestDispatcher("/pec-login").forward(request, response); //changed forward fr include
				//response.sendRedirect(request.getContextPath() + "/pec-login");	
			}
			
			System.out.println("[LOGIN] END");
			break;
			
			// ---------------------------------- pec-account?process=getUser ---------------------------------------------	
			
		case "getUser":
			System.out.println("[GETUSER] START");
			
			if(email==null) {
				System.out.println("[GETUSER] Direct to login");
				response.sendRedirect(request.getContextPath() + "/pec-login");	
				System.out.println("[GETUSER] DONE");
			}else {
				List<PEC> PEC = acc.getUserPEC(email);
				session.setAttribute("pec",PEC);
				
				PEC P = PEC.get(0);
				session.setAttribute("pecID",P.getPecId());
					System.out.println(session.getAttribute("pecID"));
				session.setAttribute("selectedPosition", P.getPosition());
					System.out.println(session.getAttribute("selectedPosition"));
				session.setAttribute("rights", P.getRights());
					System.out.println(session.getAttribute("rights"));
				System.out.println("[GETUSER] DONE");
			}
			break;
			
			// ---------------------------------- pec-account?process=logout ---------------------------------------------			
			
			case "logout":
				System.out.println("[LOGOUT] START.");
				session.removeAttribute("pecEMAIL");
				session.removeAttribute("pecID");
				session.removeAttribute("pec");
				session.invalidate();
				System.out.println("[LOGOUT] END.");
			    response.sendRedirect(request.getContextPath() + "/pec-login");
				        	
			break;
		
			// ---------------------------------- pec-account?process=register ---------------------------------------------			
			
			
						case "register":
											
								String emailIn = request.getParameter("emailIn"); 
								String fn = request.getParameter("fName");
								String mn = request.getParameter("mName");
								String ln = request.getParameter("lName");
								String position = request.getParameter("position");
								String rights = request.getParameter("rights"); 
								
								
								// SEND EMAIL FOR PASSWORD
								String psw = RandomString.generate(8);
								String msgBod = "Hi " + fn + "!"  + "\n\n" +
										"Your account in the PUP PASUC Website has been created." + "\n\n" +
										"Below is your temporary password: " + "\n\n" +
										psw + "\n\n\n" +
										"Please change your password after your first log in.\n\n" +
										"PS. Do not reply to this email.";
								String subj = "PUP PASUC: Account Confirmation";
								
								try {
									Mail.Send(emailIn, pasucEmail, pasucPsw, subj, msgBod);
								} catch (MessagingException e) {
									System.err.println("Error in sending email.");
									e.printStackTrace();
									request.setAttribute("errorMessageRegister","Error sending email verification. Please try again."); 
									request.getRequestDispatcher("/index").include(request, response);	
								}
								System.out.println("Password: " + psw);
							
								request.getRequestDispatcher("/vrfyEml").include(request, response);
							
					
									boolean result = acc.addUserPEC( fn,  mn,  ln,  email, 
											 position,  rights, psw); //
									
									if(result == true) { 
										System.out.println("SUCCESSFUL");
										response.sendRedirect(request.getContextPath() + "/pec-members?process=view");	
										//request.getRequestDispatcher("/index").forward(request, response);
									}else {
										System.out.println("Error");
										request.setAttribute("errorMessageRegister","Error creating account."); 
										request.getRequestDispatcher("/pec-members?process=view").include(request, response);	
									}
							}
			
		}
	}


