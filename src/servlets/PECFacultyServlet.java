package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Application;
import model.Credential;
import model.Faculty;
import services.AccountSvc;
import services.ApplicationSvc;
import services.CredentialSvc;


public class PECFacultyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
    public PECFacultyServlet() {
        super();
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("\n-------PEC FACULTY - GET");
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
			
				// ---------------------------------- pec-faculty?process=view ---------------------------------------------	
			case "view":
				System.out.println("[FAC_VIEW] START");
				
				request.getRequestDispatcher("allFaculty").forward(request, response);
				
				System.out.println("[FAC_VIEW] END");
			break;
			
			// ---------------------------------- pec-faculty?process=viewProfile&id=? ---------------------------------------------	
			case "viewProfile":
				System.out.println("[FAC_VIEWPROF] START");
				
				String profId = request.getParameter("id");
					System.out.println("Employee ID: "+profId);
					
					if(profId == null) {
						if (pecID == null) {
							System.out.println("[FAC_VIEWPROF] Direct to fac prof view");
							response.sendRedirect(request.getContextPath() + "/pec-login");	
							System.out.println("[FAC_VIEWPROF] DONE");
						}else {
							System.out.println("[FAC_VIEWPROF] Direct to fac prof view entry");
							response.sendRedirect(request.getContextPath() + "pec-faculty?process=view");	
							System.out.println("[FAC_VIEWPROF] DONE");
						}
					}else {
						
					
						List<Faculty> faculty = acc.getUserFrID(profId);
							session.setAttribute("fac", faculty);
							
						String facId = faculty.get(0).getEmpId();
						
						List<Application> application = app.getApp(facId,"Approved");
							session.setAttribute("app", application);
						
						List<Credential> cred_educ = cred.getCred("educ", facId);
							session.setAttribute("cred_educ",cred_educ);
						List<Credential> cred_prof = cred.getCred("prof", facId);
								session.setAttribute("cred_prof",cred_prof);
						List<Credential> cred_exp = cred.getCred("exp", facId);
								session.setAttribute("cred_exp",cred_exp);
						
							
						System.out.println("[FAC_VIEWPROF] DONE");
					}
					
					request.getRequestDispatcher("facultyProfilePEC").include(request, response);
				
					
				System.out.println("[FAC_VIEWPROF] END");
			break;
			
			
			// ---------------------------------- pec-faculty?process=getAll ---------------------------------------------	
			
			case "getAll":
				System.out.println("[GETUSERS] START");
				
				if(email.equals(null)) {
					System.out.println("[GETUSER] Direct to login");
					response.sendRedirect(request.getContextPath() + "/pec-login");	
					System.out.println("[GETUSER] DONE");
				}else {
					List<Faculty> Fac = acc.getAllUsers();
					session.setAttribute("facList",Fac);
					System.out.println("[GETUSER] DONE");
				}
			break;
			
		}
	}	
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("\n-------PEC FACULTY - GET");
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
			
				// ---------------------------------- pec-faculty?process=view ---------------------------------------------	
			case "view":
				System.out.println("[FAC_VIEW] START");
				
				request.getRequestDispatcher("allFaculty").forward(request, response);
				
				System.out.println("[FAC_VIEW] END");
			break;
			
			// ---------------------------------- pec-faculty?process=viewProfile&id=? ---------------------------------------------	
			case "viewProfile":
				System.out.println("[FAC_VIEWPROF] START");
				
				String profId = request.getParameter("id");
					System.out.println("Employee ID: "+profId);
					
					if(profId == null) {
						if (pecID == null) {
							System.out.println("[FAC_VIEWPROF] Direct to fac prof view");
							response.sendRedirect(request.getContextPath() + "/pec-login");	
							System.out.println("[FAC_VIEWPROF] DONE");
						}else {
							System.out.println("[FAC_VIEWPROF] Direct to fac prof view entry");
							response.sendRedirect(request.getContextPath() + "pec-faculty?process=view");	
							System.out.println("[FAC_VIEWPROF] DONE");
						}
					}else {
						
					
						List<Faculty> faculty = acc.getUserFrID(profId);
							session.setAttribute("fac", faculty);
						
						String facId = faculty.get(0).getEmpId();
							
						List<Application> application = app.getApp(facId,"Approved");
							session.setAttribute("app", application);
						
						List<Credential> cred_educ = cred.getCred("educ", facId);
							session.setAttribute("cred_educ",cred_educ);
						List<Credential> cred_prof = cred.getCred("prof", facId);
							session.setAttribute("cred_prof",cred_prof);
						List<Credential> cred_exp = cred.getCred("exp", facId);
							session.setAttribute("cred_exp",cred_exp);
							
							
						System.out.println("[FAC_VIEWPROF] DONE");
					}
					
					request.getRequestDispatcher("facultyProfilePEC").include(request, response);
				
					
				System.out.println("[FAC_VIEWPROF] END");
			break;
			
			
			// ---------------------------------- pec-faculty?process=getAll ---------------------------------------------	
			
			case "getAll":
				System.out.println("[GETUSERS] START");
				
				if(email.equals(null)) {
					System.out.println("[GETUSER] Direct to login");
					response.sendRedirect(request.getContextPath() + "/pec-login");	
					System.out.println("[GETUSER] DONE");
				}else {
					List<Faculty> Fac = acc.getAllUsers();
					session.setAttribute("facList",Fac);
					System.out.println("[GETUSER] DONE");
				}
			break;
			
		}
	}

}
