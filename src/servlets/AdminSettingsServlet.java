package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AdminSettings;
import services.AdminSettingsSvc;

public class AdminSettingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public AdminSettingsServlet() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("\n-------ADMIN - GET");
		AdminSettingsSvc as = new AdminSettingsSvc();
		
		HttpSession session = request.getSession(true);
		
//		String username = request.getParameter("username");
//			System.out.println("Username: "+username);
		
		String process = request.getParameter("process");
			System.out.println("Process: "+process);
			
		AdminSettings setting = as.getSettings(1);
			
			
		switch(process) {
	// ---------------------------------- admin-content-management?process=view ---------------------------------------------	
		case "view":
			System.out.println("[ADMIN_VIEW] Start");		
				
//				if(username==null) {
//					System.out.println("[ADMIN_VIEW] Direct to admin view");
//					response.sendRedirect(request.getContextPath() + "/admin");	
//					System.out.println("[ADMIN_VIEW] DONE");
//				}else {
				session.setAttribute("s",setting);
					System.out.println("[ADMIN_VIEW] DONE");
//				}
				request.getRequestDispatcher("adminContentMngmt").forward(request, response);

			
				break;
		
	// ---------------------------------- admin-content-management?process=saveAppearance ---------------------------------------------	
		case "saveAppearance":
			System.out.println("[ADMIN_SAVE APPEARANCE] Start");		
				
				setting.setFontColor(request.getParameter("fcolor"));
				setting.setColor1(request.getParameter("color1"));
				setting.setColor2(request.getParameter("color2"));
				
				
				if(as.updateSettings(setting) == true) {
						System.out.println("[ADMIN_SAVE APPEARANCE] Changes saved successfully.");
					response.sendRedirect(request.getContextPath() + "/admin-content-management?process=view");	
				
				}else {
						System.out.println("[ADMIN_SAVE APPEARANCE] Changes not saved"); 
					request.getRequestDispatcher("admin-content-management?process=view").include(request, response);
				}
					
					System.out.println("[ADMIN_SAVE APPEARANCE] DONE");

				break;
	
	// ---------------------------------- admin-content-management?process=saveAbout ---------------------------------------------	
		
			case "saveAbout":
			System.out.println("[ADMIN_SAVE ABOUT] Start");		

				setting.setMission(request.getParameter("mission"));
				setting.setVision(request.getParameter("vision"));
				setting.setGoals(request.getParameter("goals"));
				setting.setObjectives(request.getParameter("objectives"));
				setting.setEvaluation(request.getParameter("evaluation"));
				setting.setRatingScale(request.getParameter("ratingScale"));
				setting.setSalarySchedule(request.getParameter("salarySchedule"));
				setting.setOfficeAddress(request.getParameter("officeAddress"));
				setting.setEmailAddress(request.getParameter("emailAddress"));
				setting.setContactNumber(request.getParameter("contactNumber"));
				
				if(as.updateSettings(setting) == true) {
						System.out.println("[ADMIN_SAVE ABOUT] Changes saved successfully.");
					response.sendRedirect(request.getContextPath() + "/admin-content-management?process=view");	
				
				}else {
						System.out.println("[ADMIN_SAVE ABOUT] Changes not saved"); 
					request.getRequestDispatcher("admin-content-management?process=view").include(request, response);
				}
					
					System.out.println("[ADMIN_SAVE ABOUT] DONE");
			
				break;
		}
				
	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
 			throws ServletException, IOException {
		System.out.println("\n-------ADMIN - POST");
		AdminSettingsSvc as = new AdminSettingsSvc();
		
		HttpSession session = request.getSession(true);
		
//		String username = request.getParameter("username");
//			System.out.println("Username: "+username);
		
		String process = request.getParameter("process");
			System.out.println("Process: "+process);
			
		AdminSettings setting = as.getSettings(1);
			
			
		switch(process) {
		case "view":
			System.out.println("[ADMIN_VIEW] Start");		
				
//				if(username==null) {
//					System.out.println("[ADMIN_VIEW] Direct to admin view");
//					response.sendRedirect(request.getContextPath() + "/admin");	
//					System.out.println("[ADMIN_VIEW] DONE");
//				}else {
				session.setAttribute("s",setting);
					System.out.println("[ADMIN_VIEW] DONE");
//				}
				request.getRequestDispatcher("adminContentMngmt").forward(request, response);

			
				break;
		
				// ---------------------------------- admin-content-management?process=saveAppearance ---------------------------------------------	
		case "saveAppearance":
			System.out.println("[ADMIN_SAVE APPEARANCE] Start");		
				
			System.out.println("COLOR " + request.getParameter("fcolor"));
				setting.setFontColor(request.getParameter("fcolor"));
				setting.setColor1(request.getParameter("color1"));
				setting.setColor2(request.getParameter("color2"));
				
				
				if(as.updateSettings(setting) == true) {
						System.out.println("[ADMIN_SAVE APPEARANCE] Changes saved successfully.");
					response.sendRedirect(request.getContextPath() + "/admin-content-management?process=view");	
				
				}else {
						System.out.println("[ADMIN_SAVE APPEARANCE] Changes not saved"); 
					request.getRequestDispatcher("admin-content-management?process=view").include(request, response);
				}
					
					System.out.println("[ADMIN_SAVE APPEARANCE] DONE");

				break;
	
	// ---------------------------------- admin-content-management?process=saveAbout ---------------------------------------------	
		
		case "saveAbout":
		System.out.println("[ADMIN_SAVE ABOUT] Start");		

			setting.setMission(request.getParameter("mission"));
			setting.setVision(request.getParameter("vision"));
			setting.setGoals(request.getParameter("goals"));
			setting.setObjectives(request.getParameter("objectives"));
			setting.setEvaluation(request.getParameter("evaluation"));
			setting.setRatingScale(request.getParameter("ratingScale"));
			setting.setSalarySchedule(request.getParameter("salarySchedule"));
			setting.setOfficeAddress(request.getParameter("officeAddress"));
			setting.setEmailAddress(request.getParameter("emailAddress"));
			setting.setContactNumber(request.getParameter("contactNumber"));
			
			if(as.updateSettings(setting) == true) {
					System.out.println("[ADMIN_SAVE ABOUT] Changes saved successfully.");
				response.sendRedirect(request.getContextPath() + "/admin-content-management?process=view");	
			
			}else {
					System.out.println("[ADMIN_SAVE ABOUT] Changes not saved"); 
				request.getRequestDispatcher("admin-content-management?process=view").include(request, response);
			}
				
				System.out.println("[ADMIN_SAVE ABOUT] DONE");
		
			break;
		}
 	}

    
}