package servlets;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import others.Mail;
import others.RandomString;
import services.AccountSvc;

public class SettingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public SettingsServlet() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("\n-------ACCOUNT - GET");
		AccountSvc acc = new AccountSvc();
		
		HttpSession session = request.getSession(true);
		
		String process = request.getParameter("process");
			System.out.println("Process: "+process);
			
		String email = (String) session.getAttribute("email");
			System.out.println("Email: " + email);
			
		String empId = (String) session.getAttribute("empId");
			System.out.println("Emp ID: " + empId);
			
		switch(process) {
	// ---------------------------------- settings?process=editAccount ---------------------------------------------	
			case "editAccount":
				System.out.println("[EDIT ACCOUNT] START");	
				//String saveBtn = (String) session.getAttribute("saveButton");
				String save = request.getParameter("save");
				String saveBtn = request.getParameter("saveBtn");
				System.out.println(save + saveBtn);
				
				if(save == null) {
					request.getRequestDispatcher("account?process=getUser").include(request, response);
					request.getRequestDispatcher("edtAcct").forward(request, response);
			    	System.out.println("[EDIT] Forward to edtAcct");
				}else {
					if(saveBtn == null) {
						request.getRequestDispatcher("edtAcct").forward(request, response);
					}else {
						String fn = request.getParameter("fName");
						String mn = request.getParameter("mName");
						String ln = request.getParameter("lName");
						String cn = request.getParameter("cNumber");
						//String email = request.getParameter("email");
						String bd = request.getParameter("bDate");
						String gen = request.getParameter("gender");
						String add = request.getParameter("address");
						//String empId = request.getParameter("empId");
						String dept = request.getParameter("dept");
						//String psw = request.getParameter("password");
							System.out.println(email+" "+fn+" "+mn+" "+ln+" "+cn+" "+bd+" "+gen+" "+add+" "+dept);
							
							if(acc.updateUser(email,fn,mn,ln,cn,bd,gen,add,dept) == 0) {
									System.out.println("[EDIT] Account edited successfully.");
								request.setAttribute("errorMessageEdit","Account changes have been saved."); 
//								request.getRequestDispatcher("/account?process=getUser").include(request, response);
// 								request.getRequestDispatcher("/settings?process=editAccount").forward(request, response);
 								response.sendRedirect(request.getContextPath() + "/settings?process=editAccount");	
							}else {
									System.out.println("[EDIT] Account edit failed.");
								request.setAttribute("errorMessageEdit","Changes were not saved."); 
								request.getRequestDispatcher("settings?process=editAccount").include(request, response);
							}
							
					}
				System.out.println("[EDIT ACCOUNT] END");		
						
				}
				
				break;
				
				
		// ---------------------------------- settings?process=changeEmail ---------------------------------------------
				
			case "changeEmail":
			System.out.println("[CH EMAIL] START");

			//String changePwBtn = (String) session.getAttribute("changePw");
			String changeEmailBtn = request.getParameter("changeEmailBtn");
			String saveEmail = request.getParameter("save");
			System.out.println(saveEmail + changeEmailBtn);
			
			if(saveEmail == null) {			
				request.getRequestDispatcher("account?process=getUser").include(request, response);
				request.getRequestDispatcher("chngEml").forward(request, response);
			   	System.out.println("[EDIT] Forward to /chngEml");
			}else {
				String newEmail = request.getParameter("newEmail");
				System.out.println(email);
				if(changeEmailBtn == null) {
					request.getRequestDispatcher("chngEml").forward(request, response);
				}else {			
					if(acc.changeEmail(email, newEmail) == true) {
							System.out.println("[CH EMAIL] Account email changed successfully.");
						session.setAttribute("email",newEmail);
						request.setAttribute("errorMessageEmail","New email has been saved.");
						request.getRequestDispatcher("account?process=getUser").include(request, response);
						request.getRequestDispatcher("settings?process=changeEmail").forward(request, response);
					}else {
							System.out.println("[CH EMAIL] Account email change failed.");
						request.setAttribute("errorMessageEmail","Changes were not saved."); 
						request.getRequestDispatcher("chngEml").include(request, response);
					}
					System.out.println("[CH EMAIL] END");
				}
			}
			break;
			

			// ---------------------------------- account?process=verifiyEmail ---------------------------------------------
						
//				case "verifyEmail":
//					String codeIn = request.getParameter("codeIn");
//					System.out.println("codeIn: " + codeIn);
//					
//					
//					
//					if(codeIn == null) {
//						String emailIn = request.getParameter("email"); 
//					}
//						
//						
//						// SEND EMAIL FOR VERIFICATION 
//						String code = RandomString.generate(8);
//						String msgBod = "Hi " + fn + "!"  + "\n\n" +
//								"Thank you for creating an account in the PUP PASUC Website." + "\n\n" +
//								"Below is the code to verify your email: " + "\n\n" +
//								code + "\n\n\n" +
//								"PS. Do not reply to this email.";
//						String subj = "PUP PASUC: Email Verification";
//						
//						try {
//							Mail.Send(emailIn, pasucEmail, pasucPsw, subj, msgBod);
//						} catch (MessagingException e) {
//							System.err.println("Error in sending email.");
//							e.printStackTrace();
//							request.setAttribute("errorMessageRegister","Error sending email verification. Please try again."); 
//							request.getRequestDispatcher("/index").include(request, response);	
//						}
//						session.setAttribute("code",code);	
//						System.out.println("code: " + code);
//						
//						request.getRequestDispatcher("/vrfyEml").include(request, response);
//					}else {
//						String code = (String) session.getAttribute("code");
//						System.out.println("code: " + code);
//						
//						String fn = (String) session.getAttribute("fName"); 
//						String mn = (String) session.getAttribute("mName");
//						String ln = (String) session.getAttribute("lName");
//						String cn = ((String) session.getAttribute("cNumber")).replace("-","");
//							System.out.println(cn);
//						String emailIn = (String) session.getAttribute("email");
//						String bd = (String) session.getAttribute("bDate");
//						String gen = (String) session.getAttribute("gender");
//						String add = (String) session.getAttribute("address");
//						String empIdIn = (String) session.getAttribute("empId");
//						String dept = (String) session.getAttribute("dept");
//						String psw = (String) session.getAttribute("password");
//					
////						if(codeIn.equals(code)) {
//							// REGISTER ACCOUNT
//							
//							boolean result = acc.addUser(fn,  mn,  ln,  cn,  emailIn, bd,  gen,  add,  empIdIn,  dept,  psw);
//								System.out.println(result); //
//							
//							if(result == true) { 
//								System.out.println("SUCCESSFUL");
//								session.removeAttribute("code");
//								session.invalidate();
//								response.sendRedirect(request.getContextPath() + "/index");	
//								//request.getRequestDispatcher("/index").forward(request, response);
//							}else {
//								System.out.println("Error");
//								request.setAttribute("errorMessageRegister","Error creating account."); 
//								request.getRequestDispatcher("/index").include(request, response);	
//							}
//
//					break;
			
		
	// ---------------------------------- settings?process=changePassword ---------------------------------------------
			case "changePassword":
			System.out.println("[CH PW] START");
		
			String changePasswordBtn = request.getParameter("changePasswordBtn");
			String savePsw = request.getParameter("save");
			System.out.println(savePsw + changePasswordBtn);
			
			if(savePsw == null) {			
				request.getRequestDispatcher("/account?process=getUser").include(request, response);
				request.getRequestDispatcher("/chngPsswrd").forward(request, response);
			   	System.out.println("[CH PW] Forward to /chngPsswrd");
			}else {	
				if(changePasswordBtn == null) {
					request.getRequestDispatcher("/chngPsswrd").forward(request, response);
				}else {	
					String oldPassword = request.getParameter("oldPassword");
					String newPassword = request.getParameter("password");
					System.out.println("New Psw:" + newPassword);

					if(oldPassword.equals(newPassword)) {
						System.out.println("[CH PW] Account password change failed.");
						request.setAttribute("errorMessagePassword","There are no changes."); 
						request.getRequestDispatcher("/chngPsswrd").include(request, response);
					}else {
						if(acc.changePassword(email, oldPassword, newPassword) == true) {
							System.out.println("[CH PW] Account password changed successfully.");
							request.setAttribute("errorMessagePassword","New password has been saved.");
							request.getRequestDispatcher("/account?process=getUser").include(request, response);
							request.getRequestDispatcher("/settings?process=changePassword").forward(request, response);
						}else {
							System.out.println("[CH PW] Account password change failed.");
							request.setAttribute("errorMessagePassword","Changes were not saved."); 
							request.getRequestDispatcher("/chngPsswrd").include(request, response);
						}
					}
				}
			}				
			System.out.println("[CH PW] END");
		}	
				
	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
 			throws ServletException, IOException {
 		System.out.println("\n-------ACCOUNT - POST");
 		AccountSvc acc = new AccountSvc();
 		
 		HttpSession session = request.getSession(true);
 		
 		String process = request.getParameter("process");
 			System.out.println("Process: "+process);
 			
 		String email = (String) session.getAttribute("email");
 			System.out.println("Email: " + email);
 			
 		String empId = (String) session.getAttribute("empId");
 			System.out.println("Emp ID: " + empId);
 			
 		switch(process) {
 	// ---------------------------------- settings?process=editAccount ---------------------------------------------	
 			case "editAccount":
 				System.out.println("[EDIT ACCOUNT] START");	
 				//String saveBtn = (String) session.getAttribute("saveButton");
 				String save = request.getParameter("save");
 				String saveBtn = request.getParameter("saveBtn");
 				System.out.println(save + saveBtn);
 				
 				if(save == null) {
 					request.getRequestDispatcher("/account?process=getUser").include(request, response);
 					request.getRequestDispatcher("/edtAcct").forward(request, response);
 			    	System.out.println("[EDIT] Forward to /edtAcct");
 				}else {
 					if(saveBtn == null) {
 						request.getRequestDispatcher("/edtAcct").forward(request, response);
 					}else {
 						String fn = request.getParameter("fName");
 						String mn = request.getParameter("mName");
 						String ln = request.getParameter("lName");
 						String cn = request.getParameter("cNumber");
 						//String email = request.getParameter("email");
 						String bd = request.getParameter("bDate");
 						String gen = request.getParameter("gender");
 						String add = request.getParameter("address");
 						//String empId = request.getParameter("empId");
 						String dept = request.getParameter("dept");
 						//String psw = request.getParameter("password");
 							System.out.println(email+" "+fn+" "+mn+" "+ln+" "+cn+" "+bd+" "+gen+" "+add+" "+dept);
 							
 							if(acc.updateUser(email,fn,mn,ln,cn,bd,gen,add,dept) == 0) {
 									System.out.println("[EDIT] Account edited successfully.");
 								request.setAttribute("errorMessageEdit","Account changes have been saved."); 
// 								request.getRequestDispatcher("/account?process=getUser").include(request, response);
// 								request.getRequestDispatcher("/settings?process=editAccount").forward(request, response);
 								response.sendRedirect(request.getContextPath() + "/settings?process=editAccount");	
								
 							}else {
 									System.out.println("[EDIT] Account edit failed.");
 								request.setAttribute("errorMessageEdit","Changes were not saved."); 
 								request.getRequestDispatcher("/settings?process=editAccount").include(request, response);
 							}
 							
 					}
 				System.out.println("[EDIT ACCOUNT] END");		
 						
 				}
 				
 				break;
 				
 				
 		// ---------------------------------- settings?process=changeEmail ---------------------------------------------
 				
 			case "changeEmail":
 			System.out.println("[CH EMAIL] START");

 			//String changePwBtn = (String) session.getAttribute("changePw");
 			String changeEmailBtn = request.getParameter("changeEmailBtn");
 			String saveEmail = request.getParameter("save");
 			System.out.println(saveEmail + changeEmailBtn);
 			
 			if(saveEmail == null) {			
 				request.getRequestDispatcher("/account?process=getUser").include(request, response);
 				request.getRequestDispatcher("/changeEmail").forward(request, response);
 			   	System.out.println("[EDIT] Forward to /changeEmail");
 			}else {
 				String newEmail = request.getParameter("newEmail");
 				System.out.println(email);
 				if(changeEmailBtn == null) {
 					request.getRequestDispatcher("/changeEmail").forward(request, response);
 				}else {			
 					if(acc.changeEmail(email, newEmail) == true) {
 							System.out.println("[CH EMAIL] Account email changed successfully.");
 						session.setAttribute("email",newEmail);
 						request.setAttribute("errorMessageEmail","New email has been saved.");
 						request.getRequestDispatcher("/account?process=getUser").include(request, response);
 						request.getRequestDispatcher("/settings?process=changeEmail").forward(request, response);
 					}else {
 							System.out.println("[CH EMAIL] Account email change failed.");
 						request.setAttribute("errorMessageEmail","Changes were not saved."); 
 						request.getRequestDispatcher("/changeEmail").include(request, response);
 					}
 					System.out.println("[CH EMAIL] END");
 				}
 			}
 			break;
 		
 	// ---------------------------------- settings?process=changePassword ---------------------------------------------
 			case "changePassword":
 			System.out.println("[CH PW] START");
 		
 			String changePasswordBtn = request.getParameter("changePasswordBtn");
 			String savePsw = request.getParameter("save");
 			System.out.println("save=" + savePsw + " change " + changePasswordBtn);
 			
 			if(savePsw == null) {			
 				request.getRequestDispatcher("/account?process=getUser").include(request, response);
 				request.getRequestDispatcher("/chngPsswrd").forward(request, response);
 			   	System.out.println("[CH PW] Forward to /chngPsswrd");
 			}else {	
 				if(changePasswordBtn == null) {
 					request.getRequestDispatcher("/chngPsswrd").forward(request, response);
 				}else {	
 					String oldPassword = request.getParameter("oldPassword");
 					String newPassword = request.getParameter("password");
 					System.out.println("New Psw:" + newPassword);

 					if(oldPassword.equals(newPassword)) {
 						System.out.println("[CH PW] Account password change failed.");
 						request.setAttribute("errorMessagePassword","There are no changes."); 
 						request.getRequestDispatcher("/chngPsswrd").include(request, response);
 					}else {
 						if(acc.changePassword(email, oldPassword, newPassword) == true) {
 							System.out.println("[CH PW] Account password changed successfully.");
 							request.setAttribute("errorMessagePassword","New password has been saved.");
 							//request.getRequestDispatcher("/settings?process=changePassword").forward(request, response);
 							response.sendRedirect(request.getContextPath() + "/settings?process=changePassword");
 						}else {
 							System.out.println("[CH PW] Account password change failed.");
 							request.setAttribute("errorMessagePassword","Changes were not saved."); 
 							request.getRequestDispatcher("/chngPsswrd").include(request, response);
 						}
 					}
 				}
 			}				
 			System.out.println("[CH PW] END");
 		}	
 				
 	}

    
}