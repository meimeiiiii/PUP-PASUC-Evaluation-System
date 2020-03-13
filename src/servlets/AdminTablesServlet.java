package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AdminSettings;
import model.Application;
import model.Credential;
import model.Faculty;
import model.PEC;
import services.AdminSvc;


public class AdminTablesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
    public AdminTablesServlet() {
        super();
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("\n------ADMIN LOGIN - GET");
		AdminSvc admin = new AdminSvc();
		
		HttpSession session = request.getSession(true);
		
		String process = request.getParameter("process");
			System.out.println("Process: "+process);
			
		String username = request.getParameter("userLog");
			System.out.println("Username: " + username);
			
		String password = request.getParameter("pswLog");
			System.out.println("Password: " + password);
			
		switch(process) {
			
				// ---------------------------------- admin-home?process=login ---------------------------------------------	
			case "login":
				System.out.println("[ADMIN LOGIN] START");
				
				AdminSettings as = admin.getSettings(1);
				System.out.println(as.getUsername() + " " + as.getPassword());

				if(as.getUsername().equals(username) && as.getPassword().equals(password)) {
					session.setAttribute("username", username);
					session.setAttribute("password", password);
					request.getRequestDispatcher("admin-home?process=view").forward(request, response);
				}else {
					System.out.println("[ADMIN LOGIN] Incorrect username or password.");
//					request.setAttribute("errorMessageLogin","Incorrect email or password."); 
					request.getRequestDispatcher("/admin").forward(request, response); //changed forward fr include
			
				}
				
				
				System.out.println("[ADMIN LOGIN] END");
			break;
			
			// ---------------------------------- admin-home?process=view ---------------------------------------------			
			
			
			case "view":
				System.out.println("[ADMIN VIEW] START");
				
				List<Faculty> fac = admin.getFaculty();
					session.setAttribute("fac", fac);
				List<Credential> cred = admin.getCred();
					session.setAttribute("cred", cred);
				List<Application> app = admin.getApp();
					session.setAttribute("app", app);
				List<PEC> pec = admin.getPEC();
					session.setAttribute("pec", pec);
				
				request.getRequestDispatcher("adminDb").include(request, response);

				System.out.println("[ADMIN VIEW] END");
			break;
			
			// ---------------------------------- admin-home?process=logout ---------------------------------------------			
			
			case "logout":
				System.out.println("[ADMIN VILOGOUTEW] START.");
				session.removeAttribute("username");
				session.removeAttribute("password");
				session.removeAttribute("fac");
				session.removeAttribute("cred");
				session.removeAttribute("app");
				session.removeAttribute("pec");
				session.invalidate();
				System.out.println("[ADMIN LOGOUT] END.");
		        response.sendRedirect(request.getContextPath() + "/index");
		        	
				break;
			
		}
	}	
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("\n------ADMIN LOGIN - POST");
		AdminSvc admin = new AdminSvc();
		
		HttpSession session = request.getSession(true);
		
		String process = request.getParameter("process");
			System.out.println("Process: "+process);
			
		String username = request.getParameter("userLog");
			System.out.println("Username: " + username);
			
		String password = request.getParameter("pswLog");
			System.out.println("Password: " + password);
			
		switch(process) {
			
				// ---------------------------------- admin-home?process=login ---------------------------------------------	
			case "login":
				System.out.println("[ADMIN LOGIN] START");
				
				AdminSettings as = admin.getSettings(1);
				System.out.println(as.getUsername() + " " + as.getPassword());
				
				if(as.getUsername().equals(username) && as.getPassword().equals(password)) {
					request.getRequestDispatcher("admin-home?process=view").forward(request, response);
				}else {
					System.out.println("[ADMIN LOGIN] Incorrect username or password.");
//					request.setAttribute("errorMessageLogin","Incorrect email or password."); 
					request.getRequestDispatcher("/admin").forward(request, response); //changed forward fr include
			
				}
				
				
				System.out.println("[ADMIN LOGIN] END");
			break;
			
			
			// ---------------------------------- admin-home?process=view ---------------------------------------------			
			
			
			case "view":
				System.out.println("[ADMIN VIEW] START");
				
				List<Faculty> fac = admin.getFaculty();
					session.setAttribute("fac", fac);
				List<Credential> cred = admin.getCred();
					session.setAttribute("cred", cred);
				List<Application> app = admin.getApp();
					session.setAttribute("app", app);
				List<PEC> pec = admin.getPEC();
					session.setAttribute("pec", pec);
				
				request.getRequestDispatcher("adminDb").include(request, response);

				System.out.println("[ADMIN VIEW] END");
			break;
			
			// ---------------------------------- admin-home?process=logout ---------------------------------------------			
			
			case "logout":
				System.out.println("[ADMIN VILOGOUTEW] START.");
				
					session.removeAttribute("username");
					session.removeAttribute("password");
					session.removeAttribute("fac");
					session.removeAttribute("cred");
					session.removeAttribute("app");
					session.removeAttribute("pec");
					session.invalidate();
					
				System.out.println("[ADMIN LOGOUT] END.");
		        response.sendRedirect(request.getContextPath() + "/index");
		        	
				break;
			
		}
	}

}
