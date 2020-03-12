package services;

import java.util.List;

import javax.servlet.http.Part;

import dao.CCEScoreDAO;
import dao.CredentialDAO;
import model.CCEScore;
import model.Credential;
import others.GetDateTime;

public class CredentialSvc {
	CredentialDAO cDAO = new CredentialDAO();
	CCEScoreDAO csDAO = new CCEScoreDAO();
	
	public boolean addCred(String category, String timestamp, String empId, String type, String subtype, 
					String title, Part document) {
		System.out.println("*SERVICE: Add Credential");
		
		Credential C = new Credential();
		
		System.out.println(GetDateTime.main(null));
		
		C.setTimestamp(GetDateTime.main(null));
		C.setEmpId(empId);
		C.setCategory(category);
		C.setType(type);
		C.setSubtype(subtype);
		C.setTitle(title);
		C.setDocument(document);
		
		int score = 0;
		List <CCEScore> cs = csDAO.getCCEScore();
		
		for(int i=0; i<=cs.size()-1; i++) {
			//System.out.println(category);
			//System.out.println("CRED DETAILS " + cs.get(i).getCategory() + "\t" + cs.get(i).getType() + "\t" + cs.get(i).getSubType() );
			if(cs.get(i).getType().equals(type) &&
					cs.get(i).getSubType().equals(subtype)
				) {
				score = cs.get(i).getPoints();
				System.out.println("CRED DETAILS " + cs.get(i).getCategory() + "\t" + cs.get(i).getType() + "\t" + cs.get(i).getSubType() );
				
			}
		}
		System.out.println("score: " + score);
		C.setScore(score);
		
		if(cDAO.add(C) == true) {
			System.out.println("**successful");
			return true;
		}else {
			System.out.println("**unsuccessful. Error in adding.");
			return false;
		}
	}

	public boolean delCred(String credId) {
		System.out.println("*SERVICE: Delete cred");
		if(cDAO.checkCred(credId) == true) {
			if(cDAO.delete(credId) == true) {				// DELETE
				System.out.println("**successful");
				return true;
			}else {
				System.out.println("**unsuccessful");
				return false;
			}
		}else {
			System.out.println("**unsuccessful. Does not exist.");
			return false;
		}
	}
	

	public boolean updateAppId(String empId, String appId) {
		System.out.println("*SERVICE: Update cred app ID to " + appId);
			if(cDAO.updateAppId(empId,appId) == true) {				// DELETE
				System.out.println("**successful");
				return true;
			}else {
				System.out.println("**unsuccessful");
				return false;
			}
	}
	
	public boolean checkCredOwner(String credId, String empId) {
		System.out.println("*SERVICE: Check Credential Owner");
		
		if(cDAO.checkCredOwner(credId).equals(empId)) {
			System.out.println("**authorized");
			return true;
		}else {
			System.out.println("**unauthorized");
			return false;
		}
		
		
	}
	
	public List<Credential> getCred(String category, String empId){
		System.out.println("*SERVICE: Get Cred");
		List <Credential> credential = cDAO.getCred(category,empId);
		System.out.println("**" + credential);
		return credential;
	}
	
	public List<Credential> getCredOfApp(String category, String appId, String empId){
		System.out.println("*SERVICE: Get Cred");
		List <Credential> credential = cDAO.getNewCred(category,appId, empId);
		System.out.println("**" + credential);
		return credential;
	}

	public List<Credential> getCredOfAppForPEC(String category, String appId){
		System.out.println("*SERVICE: Get Cred");
		List <Credential> credential = cDAO.getCredForPEC(category,appId);
		System.out.println("**" + credential);
		return credential;
	}
	
	public boolean changeStatus(String credId, int score, String status, String evaluatorId, String remarks ){
		System.out.println("*SERVICE: Update Credential Status");
		
		Credential C = new Credential();
		
		C.setCredId(credId);
		C.setScore(score);
		C.setStatus(status);
		C.setEvaluatorId(evaluatorId);
		C.setRemarks(remarks);
		
		if(cDAO.updateCred_E(C) == true) {
			System.out.println("**updated");
			return true;
		}else {
			System.out.println("**not updated");
			return false;
		}
	}
	
	
	public byte[] getDocument(String credId) {
		System.out.println("*SERVICE: Get Document");
		byte[] doc = cDAO.getDocument(credId);
		System.out.println("**" + doc);
		return doc;
	}
	
	public int getTotal(String empId, String category) {
		System.out.println("*SERVICE: Get Total of " + category);
		int score = cDAO.getTotal(empId, category);
		return score;
		
	}
	
	
	public List<CCEScore> getCCEScore(){
		System.out.println("*SERVICE: Get App");
		List <CCEScore> cs = csDAO.getCCEScore();
		System.out.println("**" + cs);
		return cs;
	}
}
