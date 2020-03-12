package services;

import java.util.List;

import javax.servlet.http.Part;

import dao.ApplicationDAO;
import dao.CCERankDAO;
import dao.CredentialDAO;
import dao.FacultyDAO;
import model.Application;
import others.GetDateTime;

public class ApplicationSvc {
	ApplicationDAO aDAO = new ApplicationDAO();
	CredentialDAO cDAO = new CredentialDAO();
	FacultyDAO fDAO = new FacultyDAO();
	CCERankDAO crDAO = new CCERankDAO();
	
	public List<Application> getApp(String empId, String status){
		System.out.println("*SERVICE: Get App");
		List <Application> app = aDAO.getApp(empId, status);
		System.out.println("**" + app);
		return app;
	}
	
	public List<Application> getSpecApp(String appId){
		System.out.println("*SERVICE: Get App " + appId);
		List <Application> app = aDAO.getSpecificApp(appId);
		System.out.println("**" + app);
		return app;
	}
	
	public boolean addApp(String empId, Part document) {
		System.out.println("*SERVICE: Add Application");
		
		Application A = new Application();
		
		System.out.println(GetDateTime.main(null));
		
		A.setDtSubmitted(GetDateTime.main(null));
		
			int scoreEduc = cDAO.getTotal(empId, "educ");
			if(scoreEduc>85) { scoreEduc = 85; }
		A.setScoreEduc(scoreEduc);
			int scoreExp = cDAO.getTotal(empId, "exp");
			if(scoreExp>25) { scoreExp = 25; }
		A.setScoreExp(scoreExp);
			int scoreProf = cDAO.getTotal(empId, "prof");
			if(scoreProf>90) { scoreProf = 90; }
		A.setScoreProf(scoreProf);
		A.setCurRank(fDAO.getCurrentRank(empId));
			String newRank = crDAO.getRank(scoreEduc+scoreExp+scoreProf);
		A.setNewRank(newRank);
		A.setEmpId(empId);
		A.setDocument(document);
		
		if(aDAO.add(A) == true) {
			System.out.println("**successful");
			return true;
		}else {
			System.out.println("**unsuccessful. Error in adding.");
			return false;
		}
}

	
	public List<Application> getAllApp(String status){
		System.out.println("*SERVICE: Get App");
		List <Application> app = aDAO.getAllApp(status);
		System.out.println("**" + app);
		return app;
	}
	
	public boolean checkAppOwner(String appId, String empId) {
		System.out.println("*SERVICE: Check Application Owner if " + empId);
		
		if(aDAO.checkAppOwner(appId).equals(empId)) {
			System.out.println("**authorized");
			return true;
		}else {
			System.out.println("**unauthorized");
			return false;
		}
	}
	
	public boolean changeStatus(String appId, String pecID, String newStatus, String remarks) {
		System.out.println("*SERVICE: Change status of " + appId+ " to " + newStatus);
		
		if(aDAO.updateStatus(appId, pecID, newStatus, remarks,GetDateTime.main(null))) {
			System.out.println("**successful");
			
			if(changeRank(appId)) {
				return true;
			}
			return false;
		}else {
			System.out.println("**failed");
			return false;
		}
	}
	

	public boolean changeRank(String appId) {
		System.out.println("*SERVICE: Change rank and score of faculty with app " + appId);
		
		List<Application> app = aDAO.getSpecificApp(appId);
		Application A = app.get(0);
		String empId = A.getEmpId();
		String newRank = A.getNewRank();
		int scoreEduc = A.getScoreEduc();
		int scoreExp = A.getScoreExp();
		int scoreProf =A.getScoreProf();
		
		if(fDAO.changeRank(empId, newRank, scoreEduc, scoreExp, scoreProf)) {
			System.out.println("**successful");
			return true;
		}else {
			System.out.println("**failed");
			return false;
		}
	}
	
	
	public String getAppOwner(String appId) {
		System.out.println("*SERVICE: Get Application Owner ");
		return aDAO.checkAppOwner(appId);
	}
	
	public String getRank(int score) {
		System.out.println("*SERVICE: Get Rank for Score of " + score);
		return crDAO.getRank(score);
	}
	
//	public boolean submitApp(String credType, String timestamp, String empId, String type, String subtype, String title, Part document) {
//		System.out.println("*SERVICE: Add Credential");
//		
//		Application A = new Application();
//		
//		System.out.println(GetDateTime.main(null));
//		
//		C.setTimestamp(GetDateTime.main(null));
//		C.setEmpId(empId);
//		C.setType(type);
//		C.setSubtype(subtype);
//		C.setTitle(title);
//		C.setDocument(document);
//		
//		if(aDAO.add(C, credType) == true) {
//			System.out.println("**successful");
//			return true;
//		}else {
//			System.out.println("**unsuccessful. Error in adding.");
//			return false;
//		}
//	}
}
