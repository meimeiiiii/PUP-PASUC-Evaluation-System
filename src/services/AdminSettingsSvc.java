package services;

import dao.AdminSettingsDAO;
import model.AdminSettings;

public class AdminSettingsSvc {
	AdminSettingsDAO aDAO = new AdminSettingsDAO();
	
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
		
//	public String getRank(int score) {
//		System.out.println("*SERVICE: Get Rank for Score of " + score);
//		return crDAO.getRank(score);
//	}

}
