package services;

import java.util.List;

import dao.ActivityLogDAO;
import model.Activity;
import others.GetDateTime;

public class ActivityLogSvc {
		ActivityLogDAO aDAO = new ActivityLogDAO();
		
		public boolean add(String empId, String actName){
			System.out.println("*SERVICE: Add Activity of " + empId );
			
			Activity A = new Activity();
			
			System.out.println(GetDateTime.main(null));
			
			A.setTimestamp(GetDateTime.main(null));
			A.setEmpId(empId);
			A.setActivityName(actName);
			
			
			if(aDAO.add(A) == true) {
				System.out.println("**successful");
				return true;
			}else {
				System.out.println("**unsuccessful. Error in adding.");
				return false;
		}
	}

	public List<Activity> getActivity(String empId){
		System.out.println("*SERVICE: Get Act Log of " + empId);
		List <Activity> A = aDAO.getActivity(empId);
		System.out.println("**" + A);
		return A;
	}
	
	
}
