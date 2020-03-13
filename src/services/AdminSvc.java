package services;

import java.util.List;

import dao.AdminDAO;
import dao.ApplicationDAO;
import dao.CredentialDAO;
import dao.FacultyDAO;
import dao.PECDAO;
import model.AdminSettings;
import model.Application;
import model.Credential;
import model.Faculty;
import model.PEC;

public class AdminSvc {
	AdminDAO aDAO = new AdminDAO();
	FacultyDAO fDAO = new FacultyDAO();
	CredentialDAO cDAO = new CredentialDAO();
	ApplicationDAO apDAO = new ApplicationDAO();
	PECDAO pDAO = new PECDAO();
	
	
	public AdminSettings getSettings(int id){
		System.out.println("*SERVICE: Get settings");
		AdminSettings setting = aDAO.getSettings(id);
		System.out.println("**" + setting);
		return setting;
	}
	
	public boolean updateSettings(AdminSettings setting) {
		System.out.println("*SERVICE: Update setting " + setting.getId());
		
		if(aDAO.updateSettings(setting)) {
			System.out.println("**successful");
			return true;
		}else {
			System.out.println("**failed");
			return false;
		}
	}
		
	
	public List<Faculty> getFaculty(){
		System.out.println("*SERVICE: Get User");
		List <Faculty> Faculty = fDAO.getAllForAdmin();
		System.out.println("**" + Faculty);
		return Faculty;
	}
	
	public List<Credential> getCred(){
		System.out.println("*SERVICE: Get Cred");
		List <Credential> credential = cDAO.getAllCredForAdmin();
		System.out.println("**" + credential);
		return credential;
	}
	
	public List<Application> getApp(){
		System.out.println("*SERVICE: Get App");
		List <Application> app = apDAO.getAllAppForAdmin();
		System.out.println("**" + app);
		return app;
	}
	
	public List<PEC> getPEC(){
		System.out.println("*SERVICE: Get PEC Members");
		List <PEC> pec = pDAO.getAllUsers();
		System.out.println("**" + pec);
		return pec;
	}
	
	
	
//	public String getRank(int score) {
//		System.out.println("*SERVICE: Get Rank for Score of " + score);
//		return crDAO.getRank(score);
//	}

}
