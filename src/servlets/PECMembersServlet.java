package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PEC;
import services.AccountSvc;


public class PECMembersServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
    public PECMembersServlet() {
        super();
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("\n-------PEC MEMBERS - GET");
		AccountSvc acc = new AccountSvc();
		
		HttpSession session = request.getSession(true);
		
		String process = request.getParameter("process");
			System.out.println("Process: "+process);
			
		String email = (String) session.getAttribute("pecEMAIL");
			System.out.println("Email: " + email);
			
		String pecID = (String) session.getAttribute("pecID");
			System.out.println("PEC ID: " + pecID);
			
		switch(process) {
			
				// ---------------------------------- pec-members?process=view ---------------------------------------------	
			case "view":
				System.out.println("[PEC_VIEW] START");
				
				List<PEC> pec_mem = acc.getAllUserPEC();
				session.setAttribute("pec_members",pec_mem);
				
				request.getRequestDispatcher("membersPEC").forward(request, response);
				
				System.out.println("[PEC_VIEW] END");
			break;
			
			
		}
	}	
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("\n-------PEC ABOUT - POST");
		AccountSvc acc = new AccountSvc();
		
		HttpSession session = request.getSession(true);
		
		String process = request.getParameter("process");
			System.out.println("Process: "+process);
			
		String email = (String) session.getAttribute("pecEMAIL");
			System.out.println("Email: " + email);
			
		String pecID = (String) session.getAttribute("pecID");
			System.out.println("PEC ID: " + pecID);
			
			switch(process) {
			
			// ---------------------------------- pec-members?process=view ---------------------------------------------	
			case "view":
				System.out.println("[PEC_VIEW] START");
				
				List<PEC> pec_mem = acc.getAllUserPEC();
				session.setAttribute("pec_members",pec_mem);
				
				request.getRequestDispatcher("membersPEC").forward(request, response);
				
				System.out.println("[PEC_VIEW] END");
			break;
		
		}
	}

}
