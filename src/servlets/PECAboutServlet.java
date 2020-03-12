package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CCERank;
import model.CCEScore;
import services.AboutSvc;


public class PECAboutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
    public PECAboutServlet() {
        super();
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("\n-------PEC ABOUT - GET");
		AboutSvc abt = new AboutSvc();
		
		HttpSession session = request.getSession(true);
		
		String process = request.getParameter("process");
			System.out.println("Process: "+process);
			
		String email = (String) session.getAttribute("pecEMAIL");
			System.out.println("Email: " + email);
			
		String pecID = (String) session.getAttribute("pecID");
			System.out.println("PEC ID: " + pecID);
			
		switch(process) {
			
				// ---------------------------------- pec-about?process=view ---------------------------------------------	
			case "view":
				System.out.println("[ABT_VIEW] START");
				
				List<CCEScore> cs = abt.getCCEScore();
				session.setAttribute("cce_score",cs);
				
				List<CCERank> cr = abt.getCCERank();
				session.setAttribute("cce_rank",cr);
				
				
				request.getRequestDispatcher("aboutPEC").forward(request, response);
				
				System.out.println("[ABT_VIEW] END");
			break;
			
			
		}
	}	
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("\n-------PEC ABOUT - POST");
		AboutSvc abt = new AboutSvc();
		
		HttpSession session = request.getSession(true);
		
		String process = request.getParameter("process");
			System.out.println("Process: "+process);
			
		String email = (String) session.getAttribute("pecEMAIL");
			System.out.println("Email: " + email);
			
		String pecID = (String) session.getAttribute("pecID");
			System.out.println("PEC ID: " + pecID);
			
		switch(process) {
			// ---------------------------------- pec-about?process=view ---------------------------------------------	
			case "view":
				System.out.println("[ABT_VIEW] START");
				
				List<CCEScore> cs = abt.getCCEScore();
				session.setAttribute("cce_score",cs);
				
				List<CCERank> cr = abt.getCCERank();
				session.setAttribute("cce_rank",cr);
				
				
				request.getRequestDispatcher("aboutPEC").forward(request, response);
				
				System.out.println("[ABT_VIEW] END");
			break;
		
		}
	}

}
