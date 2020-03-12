package servlets;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.*;
import javax.servlet.http.*;

import model.Activity;
import model.Faculty;
import others.Mail;
import others.RandomString;
import services.AccountSvc;
import services.ActivityLogSvc;

public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String pasucEmail = "pup.cores@gmail.com";
	String pasucPsw = "CoRES123!";
	
    public AccountServlet() {
        super();
    }
    
 //!!!!---------------GET----------------GET----------------- GET --------------GET--------------GET------------------GET---------!!!!!
    
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
//						throws ServletException, IOException {
//		System.out.println("\n-------ACCOUNT - GET");
//		
//		AccountSvc acc = new AccountSvc();
//		
//		HttpSession session = request.getSession(true);
//		
//		String process = request.getParameter("process");
//			System.out.println("Process: "+process);
//			
//		String email = (String) session.getAttribute("email");
//			System.out.println("Email: " + email);
//			
//		String empId = (String) session.getAttribute("empId");
//			System.out.println("Emp ID: " + empId);
//			
//		switch(process) {

    //		
//		// ---------------------------------- account?process=login ---------------------------------------------	
//			case "login":
//				
//				System.out.println("[LOGIN] START");		
//				String emailLog = request.getParameter("emailLog");
//				String pswLog = request.getParameter("pswLog");
//				
//				if(acc.login(emailLog,pswLog) == true){
//					System.out.println("[LOGIN] Sucessful");
//					session.setAttribute("email",emailLog);
//					request.getRequestDispatcher("/account?process=getUser").include(request, response);
//					
//				}else {
//					System.out.println("[LOGIN] Incorrect email or password.");
//					request.setAttribute("errorMessageLogin","Incorrect email or password."); 
//					request.getRequestDispatcher("/index").forward(request, response); //changed forward fr include
//				}
//				
//				break;
//				
//				
//		// ---------------------------------- account?process=logout ---------------------------------------------			
//					
//			case "logout":
//				System.out.println("[LOGOUT] START.");
//				session.removeAttribute("email");
//				session.removeAttribute("empId");
//				session.removeAttribute("faculty");
//				session.invalidate();
//				System.out.println("[LOGOUT] END.");
//		        response.sendRedirect(request.getContextPath() + "/index");
//		        	
//				break;
//		
//		// ---------------------------------- account?process=forgotPassword ---------------------------------------------
//			
//			case "forgotPassword":
//				System.out.println("[FORGOT PW] START.");
//				System.out.println("[FORGOT PW] END.");
//				request.getRequestDispatcher("/about").forward(request, response);
//				break;
//
//		// ---------------------------------- account?process=register ---------------------------------------------
//					
//			case "register":
//				String fn = request.getParameter("fName");
//				String mn = request.getParameter("mName");
//				String ln = request.getParameter("lName");
//				String cn = request.getParameter("cNumber");
//				String emailIn = request.getParameter("email");
//				String bd = request.getParameter("bDate");
//				String gen = request.getParameter("gender");
//				String add = request.getParameter("address");
//				String empIdIn = request.getParameter("empId");
//				String dept = request.getParameter("dept");
//				String psw = request.getParameter("password");
//					
//				boolean result = acc.addUser(fn,  mn,  ln,  cn,  emailIn, bd,  gen,  add,  empIdIn,  dept,  psw);
//					System.out.println(result); //
//				
//				if(result == 0) { 
//					System.out.println("SUCCESSFUL");
//					response.sendRedirect(request.getContextPath() + "/index");	
//					//request.getRequestDispatcher("/index").forward(request, response);
//				}else if (result == 1) { 
//					System.out.println("Email address has an existing account.");
//					request.setAttribute("errorMessageRegister","Email address has an existing account."); 
//					request.getRequestDispatcher("/index").include(request, response);
//				}else if (result == 2){	
//					System.out.println("Employee ID has an existing account.");
//					request.setAttribute("errorMessageRegister","Employee ID has an existing account.");
//					request.getRequestDispatcher("/index").include(request, response);
//				}
//				break;
//		
//		// ---------------------------------- account?process=verifyEmail ---------------------------------------------		
//						
//			case "verifyEmail":
//				System.out.println("[VERIFY EMAIL] START.");
//				System.out.println("[VERIFY EMAIL] END.");
//				request.getRequestDispatcher("/about").forward(request, response);
//				break;
//				
//		// ---------------------------------- account?process=getUser ---------------------------------------------		
//								
//			case "getUser":
//				System.out.println("[GETUSER] START");
//				
//				if(email.equals(null)) {
//					System.out.println("[GETUSER] Direct to index");
//					response.sendRedirect(request.getContextPath() + "/index");	
//					System.out.println("[GETUSER] DONE");
//				}else {
//					List<Faculty> faculty = acc.getUser(email);
//					session.setAttribute("faculty",faculty);
//					
//					Faculty f = faculty.get(0);
//					session.setAttribute("empId",f.getEmpId());
//						System.out.println(session.getAttribute("empId"));
//					session.setAttribute("selectedGen", f.getGender());
//					session.setAttribute("selectedDept", f.getDepartment());
//					System.out.println(session.getAttribute("selectedGen"));
//					System.out.println(session.getAttribute("selectedDept"));
//					System.out.println("[GETUSER] DONE");
//				}
//				break;
//			
//		}
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("\n-------ACCOUNT - GET");
		AccountSvc acc = new AccountSvc();
		ActivityLogSvc act = new ActivityLogSvc();
		
		HttpSession session = request.getSession(true);
		
		String process = request.getParameter("process");
			System.out.println("Process: "+process);
			
		String email = (String) session.getAttribute("email");
			System.out.println("Email: " + email);
			
		String empId = (String) session.getAttribute("empId");
			System.out.println("Emp ID: " + empId);
			
		switch(process) {
		
		// ---------------------------------- account?process=login ---------------------------------------------	
		case "login":
			
			System.out.println("[LOGIN] START");		
			String emailLog = request.getParameter("emailLog");
			String pswLog = request.getParameter("pswLog");
			
			if(acc.login(emailLog,pswLog) == true){
				System.out.println("[LOGIN] Sucessful");
				
				session.setAttribute("email",emailLog);
				request.getRequestDispatcher("/account?process=getUser").include(request, response);
				
			}else {
				System.out.println("[LOGIN] Incorrect email or password.");
				request.setAttribute("errorMessageLogin","Incorrect email or password."); 
				request.getRequestDispatcher("/index").forward(request, response); //changed forward fr include
			}
			
			break;
			
			
	// ---------------------------------- account?process=logout ---------------------------------------------			
				
		case "logout":
			System.out.println("[LOGOUT] START.");
			session.removeAttribute("email");
			session.removeAttribute("empId");
			session.removeAttribute("faculty");
			session.invalidate();
			System.out.println("[LOGOUT] END.");
	        response.sendRedirect(request.getContextPath() + "/index");
	        	
			break;
	
	// ---------------------------------- account?process=forgotPassword ---------------------------------------------
		
		case "forgotPassword":
			System.out.println("[FORGOT PW] START.");
			System.out.println("[FORGOT PW] END.");
			request.getRequestDispatcher("/about").forward(request, response);
			break;

	// ---------------------------------- account?process=register ---------------------------------------------
				
		case "register":
			String codeIn = request.getParameter("codeIn");
			System.out.println("codeIn: " + codeIn);
			
			if(codeIn == null) {
				String emailIn = request.getParameter("email"); 
				String fn = request.getParameter("fName");
				session.setAttribute("fName",fn);
				session.setAttribute("mName",request.getParameter("mName"));
				session.setAttribute("lName",request.getParameter("lName"));
				session.setAttribute("cNumber",request.getParameter("cNumber")); 
				session.setAttribute("email",emailIn);
				session.setAttribute("bDate",request.getParameter("bDate"));
				session.setAttribute("gender",request.getParameter("gender"));
				session.setAttribute("address",request.getParameter("address"));
				session.setAttribute("empId",request.getParameter("empId"));
				session.setAttribute("dept",request.getParameter("dept"));
				session.setAttribute("password",request.getParameter("password"));
				session.setAttribute("score",request.getParameter("score"));
				
				// SEND EMAIL FOR VERIFICATION 
				String code = RandomString.generate(8);
				String msgBod = "Hi " + fn + "!"  + "\n\n" +
						"Thank you for creating an account in the PUP PASUC Website." + "\n\n" +
						"Below is the code to verify your email: " + "\n\n" +
						code + "\n\n\n" +
						"PS. Do not reply to this email.";
				String subj = "PUP PASUC: Email Verification";
				
				try {
					Mail.Send(emailIn, pasucEmail, pasucPsw, subj, msgBod);
				} catch (MessagingException e) {
					System.err.println("Error in sending email.");
					e.printStackTrace();
					request.setAttribute("errorMessageRegister","Error sending email verification. Please try again."); 
					request.getRequestDispatcher("/index").include(request, response);	
				}
				session.setAttribute("code",code);	
				System.out.println("code: " + code);
				
				request.getRequestDispatcher("/vrfyEml").include(request, response);
			}else {
				String code = (String) session.getAttribute("code");
				System.out.println("code: " + code);
				
				String fn = (String) session.getAttribute("fName"); 
				String mn = (String) session.getAttribute("mName");
				String ln = (String) session.getAttribute("lName");
				String cn = ((String) session.getAttribute("cNumber")).replace("-","");
					System.out.println(cn);
				String emailIn = (String) session.getAttribute("email");
				String bd = (String) session.getAttribute("bDate");
				String gen = (String) session.getAttribute("gender");
				String add = (String) session.getAttribute("address");
				String empIdIn = (String) session.getAttribute("empId");
				String dept = (String) session.getAttribute("dept");
				String psw = (String) session.getAttribute("password");
				int scoreEduc = Integer.parseInt((String)session.getAttribute("scoreEduc"));
				int scoreExp = Integer.parseInt((String)session.getAttribute("scoreExp"));
				int scoreProf = Integer.parseInt((String)session.getAttribute("scoreProf"));
			
//				if(codeIn.equals(code)) {
					// REGISTER ACCOUNT
					
					boolean result = acc.addUser(fn,  mn,  ln,  cn,  emailIn, bd,  gen,  add,  empIdIn,  dept,  psw, 
									scoreEduc, scoreExp, scoreProf);
						System.out.println(result); //
					
					if(result == true) { 
						System.out.println("SUCCESSFUL");
						act.add(empIdIn, "Account created successfully");
						session.removeAttribute("code");
						session.invalidate();
						response.sendRedirect(request.getContextPath() + "/index");	
						//request.getRequestDispatcher("/index").forward(request, response);
					}else {
						System.out.println("Error");
						request.setAttribute("errorMessageRegister","Error creating account."); 
						request.getRequestDispatcher("/index").include(request, response);	
					}
//				}else {
//					System.out.println("Wrong Code");
//				}
			}
			
		
//			}else if (result == 1) { 
//				System.out.println("Email address has an existing account.");
//				request.setAttribute("errorMessageRegister","Email address has an existing account."); 
//				request.getRequestDispatcher("/index").include(request, response);
//			}else if (result == 2){	
//				System.out.println("Employee ID has an existing account.");
//				request.setAttribute("errorMessageRegister","Employee ID has an existing account.");
//				request.getRequestDispatcher("/index").include(request, response);
//			}
			break;
	
//	// ---------------------------------- account?process=verifyEmail ---------------------------------------------		
//			
//		case "verifyEmail":
//			System.out.println("[VERIFY EMAIL] START.");
//			
//			
//			
//			System.out.println("[VERIFY EMAIL] END.");
//			request.getRequestDispatcher("/about").forward(request, response);
//			break;
//			
	// ---------------------------------- account?process=getUser ---------------------------------------------		
							
		case "getUser":
			System.out.println("[GETUSER] START");
			
			if(email==null) {
				System.out.println("[GETUSER] Direct to index");
				response.sendRedirect(request.getContextPath() + "/index");	
				System.out.println("[GETUSER] DONE");
			}else {
				List<Faculty> faculty = acc.getUser(email);
				session.setAttribute("faculty",faculty);
				System.out.println("Get User: " + faculty);
				Faculty f = faculty.get(0);
				session.setAttribute("empId",f.getEmpId());
					System.out.println(session.getAttribute("empId"));
				session.setAttribute("selectedGen", f.getGender());
				session.setAttribute("selectedDept", f.getDepartment());
				System.out.println(session.getAttribute("selectedGen"));
				System.out.println(session.getAttribute("selectedDept"));
				
				List<Activity> a = act.getActivity(empId);
				session.setAttribute("act_log",a);
				
				System.out.println("[GETUSER] DONE");
				
				
			}
			break;
			
	// ---------------------------------- account?process=getExistingEmailandId ---------------------------------------------		
		case "getExistingEmailandId":	
			System.out.println("[GET ALL EMAIL ID] START.");
			
			List<Faculty> existingEmailandId = acc.getEmailandId();
			session.setAttribute("existingEmailId",existingEmailandId);
			
			System.out.println("[GET ALL EMAIL ID] END.");
			break;
	}
	}

    
    
//!!!!---------------POST----------------POST----------------- POST --------------POST--------------POST------------------POST---------!!!!!
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("\n-------ACCOUNT - POST");
		
		AccountSvc acc = new AccountSvc();
		
		ActivityLogSvc act = new ActivityLogSvc();
		
		HttpSession session = request.getSession(true);
		
		String process = request.getParameter("process");
			System.out.println("Process: "+process);
			
		String email = (String) session.getAttribute("email");
			System.out.println("Email: " + email);
			
		String empId = (String) session.getAttribute("empId");
			System.out.println("Emp ID: " + empId);
			
		switch(process) {
		
		// ---------------------------------- account?process=login ---------------------------------------------	
			case "login":
				
				System.out.println("[LOGIN] START");		
				String emailLog = request.getParameter("emailLog");
				String pswLog = request.getParameter("pswLog");
				
				if(acc.login(emailLog,pswLog) == true){
					System.out.println("[LOGIN] Sucessful");
					act.add(empId, "Logged in");
					session.setAttribute("email",emailLog);
					request.getRequestDispatcher("/account?process=getUser").include(request, response);
					
				}else {
					System.out.println("[LOGIN] Incorrect email or password.");
					request.setAttribute("errorMessageLogin","Incorrect email or password."); 
					request.getRequestDispatcher("/index").forward(request, response); //changed forward fr include
				}
				
				break;
				
				
		// ---------------------------------- account?process=logout ---------------------------------------------			
					
			case "logout":
				System.out.println("[LOGOUT] START.");
				session.removeAttribute("email");
				session.removeAttribute("empId");
				session.removeAttribute("faculty");
				session.invalidate();
				System.out.println("[LOGOUT] END.");
		        response.sendRedirect(request.getContextPath() + "/index");
		        	
				break;
		
		// ---------------------------------- account?process=forgotPassword ---------------------------------------------
			
			case "forgotPassword":
				System.out.println("[FORGOT PW] START.");
				System.out.println("[FORGOT PW] END.");
				request.getRequestDispatcher("/about").forward(request, response);
				break;

		// ---------------------------------- account?process=register ---------------------------------------------

			case "register":
				String codeIn = request.getParameter("codeIn");
				System.out.println("codeIn: " + codeIn);
				
				if(codeIn == null) {
					String emailIn = request.getParameter("email"); 
					String fn = request.getParameter("fName");
					session.setAttribute("fName",fn);
					session.setAttribute("mName",request.getParameter("mName"));
					session.setAttribute("lName",request.getParameter("lName"));
					session.setAttribute("cNumber",request.getParameter("cNumber")); 
					session.setAttribute("email",emailIn);
					session.setAttribute("bDate",request.getParameter("bDate"));
					session.setAttribute("gender",request.getParameter("gender"));
					session.setAttribute("address",request.getParameter("address"));
					session.setAttribute("empId",request.getParameter("empId"));
					session.setAttribute("dept",request.getParameter("dept"));
					session.setAttribute("password",request.getParameter("password"));
					session.setAttribute("scoreEduc",request.getParameter("scoreEduc"));
					session.setAttribute("scoreExp",request.getParameter("scoreExp"));
					session.setAttribute("scoreProf",request.getParameter("scoreProf"));
					
					// SEND EMAIL FOR VERIFICATION 
					String code = RandomString.generate(8);
					String msgBod = "Hi " + fn + "!"  + "\n\n" +
							"Thank you for creating an account in the PUP PASUC Website." + "\n\n" +
							"Below is the code to verify your email: " + "\n\n" +
							code + "\n\n\n" +
							"PS. Do not reply to this email.";
					String subj = "PUP PASUC: Email Verification";
					
					try {
						Mail.Send(emailIn, pasucEmail, pasucPsw, subj, msgBod);
					} catch (MessagingException e) {
						System.err.println("Error in sending email.");
						e.printStackTrace();
						request.setAttribute("errorMessageRegister","Error sending email verification. Please try again."); 
						request.getRequestDispatcher("/index").include(request, response);	
					}
					session.setAttribute("code",code);	
					System.out.println("code: " + code);
					
					request.getRequestDispatcher("/vrfyEml").include(request, response);
				}else {
					String code = (String) session.getAttribute("code");
					System.out.println("code: " + code);
					
					String fn = (String) session.getAttribute("fName"); 
					String mn = (String) session.getAttribute("mName");
					String ln = (String) session.getAttribute("lName");
					String cn = ((String) session.getAttribute("cNumber")).replace("-","");
						System.out.println(cn);
					String emailIn = (String) session.getAttribute("email");
					String bd = (String) session.getAttribute("bDate");
					String gen = (String) session.getAttribute("gender");
					String add = (String) session.getAttribute("address");
					String empIdIn = (String) session.getAttribute("empId");
					String dept = (String) session.getAttribute("dept");
					String psw = (String) session.getAttribute("password");
					int scoreEduc = Integer.parseInt((String)session.getAttribute("scoreEduc"));
					int scoreExp = Integer.parseInt((String)session.getAttribute("scoreExp"));
					int scoreProf = Integer.parseInt((String)session.getAttribute("scoreProf"));
				
//					if(codeIn.equals(code)) {
						// REGISTER ACCOUNT
						
						boolean result = acc.addUser(fn,  mn,  ln,  cn,  emailIn, bd,  gen,  add,  empIdIn,  dept,  psw, 
										scoreEduc, scoreExp, scoreProf);
						
						if(result == true) { 
							System.out.println("SUCCESSFUL");
							act.add(empIdIn, "Account created successfully");
							session.removeAttribute("code");
							session.invalidate();
							response.sendRedirect(request.getContextPath() + "/index");	
							//request.getRequestDispatcher("/index").forward(request, response);
						}else {
							System.out.println("Error");
							request.setAttribute("errorMessageRegister","Error creating account."); 
							request.getRequestDispatcher("/index").include(request, response);	
						}
//					}else {
//						System.out.println("Wrong Code");
//					}
				}
				
			
//				}else if (result == 1) { 
//					System.out.println("Email address has an existing account.");
//					request.setAttribute("errorMessageRegister","Email address has an existing account."); 
//					request.getRequestDispatcher("/index").include(request, response);
//				}else if (result == 2){	
//					System.out.println("Employee ID has an existing account.");
//					request.setAttribute("errorMessageRegister","Employee ID has an existing account.");
//					request.getRequestDispatcher("/index").include(request, response);
//				}
				break;
		
//		// ---------------------------------- account?process=verifyEmail ---------------------------------------------		
//				
//			case "verifyEmail":
//				System.out.println("[VERIFY EMAIL] START.");
//				
//				
//				
//				System.out.println("[VERIFY EMAIL] END.");
//				request.getRequestDispatcher("/about").forward(request, response);
//				break;
//				
		// ---------------------------------- account?process=getUser ---------------------------------------------		
								
			case "getUser":
				System.out.println("[GETUSER] START");
				
				if(email==null) {
					System.out.println("[GETUSER] Direct to index");
					response.sendRedirect(request.getContextPath() + "/index");	
					System.out.println("[GETUSER] DONE");
				}else {
					List<Faculty> faculty = acc.getUser(email);
					session.setAttribute("faculty",faculty);
					System.out.println("Get User: " + faculty);
					Faculty f = faculty.get(0);
					session.setAttribute("empId",f.getEmpId());
						System.out.println(session.getAttribute("empId"));
					session.setAttribute("selectedGen", f.getGender());
					session.setAttribute("selectedDept", f.getDepartment());
					System.out.println(session.getAttribute("selectedGen"));
					System.out.println(session.getAttribute("selectedDept"));
					
					List<Activity> a = act.getActivity(empId);
					session.setAttribute("act_log",a);
					
					System.out.println("[GETUSER] DONE");
				}
				break;
				
		// ---------------------------------- account?process=getExistingEmailandId ---------------------------------------------		
			case "getExistingEmailandId":	
				System.out.println("[GET ALL EMAIL ID] START.");
				
				List<Faculty> existingEmailandId = acc.getEmailandId();
				session.setAttribute("existingEmailId",existingEmailandId);
				
				System.out.println("[GET ALL EMAIL ID] END.");
				break;
		}

	}
}
