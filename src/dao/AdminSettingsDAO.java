package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import model.AdminSettings;

public class AdminSettingsDAO {
	 String url = "jdbc:mysql://127.0.0.1/pup_pasuc?user=root&password=password&useSSL=false";
	 String table = "pup_pasuc.admin_settings";
	 Connection con = null;
	 Statement sta = null;
	 ResultSet rs = null;

/**
 *  int id, String username, String password, String fontColor, 
		String color1, String color2, String vision, String mission, String goals, String objectives,
		String evaluation, String ratingScale, String salarySched, String officeAdd, String emailAdd, 
		String contactNo, String schoolName, String emailDomain, Part logo
	 **/
	public boolean updateSettings(AdminSettings A){ // DONE
			try {
				System.out.println("***DAO: Update " + A.getId());
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url);
				sta = con.createStatement();
				String query = "UPDATE " +  table				
						+ " SET `username` = '" + A.getUsername() + "',`password` = '" + A.getPassword()
						+ "',`font_color` = '" + A.getFontColor() + "',`color_1` = '" + A.getColor1()
						+ "',`color_2` = '" + A.getColor2() + "',`vision` = '" + A.getVision()
						+ "',`mission` = '" + A.getMission() + "',`goals` = '" + A.getGoals() + "',`objectives` = '" + A.getObjectives()
						+ "',`evaluation` = '" + A.getEvaluation() + "',`rating_scale` = '" + A.getRatingScale()
						+ "',`salary_sched` = '" + A.getSalarySchedule() + "',`office_add` = '" + A.getOfficeAddress()
						+ "',`email_add` = '" + A.getEmailAddress() + "',`contact_no` = '" + A.getContactNumber()
						+ "',`school_name` = '" + A.getSchoolName() + "',`email_domain` = '" + A.getEmailDomain()
						+ "' WHERE `id` = '" + A.getId() + "';";
				
				
				System.out.println("*****query: "+query);
				
				int c = sta.executeUpdate(query);

			    sta.close(); 
			   	con.close();
			    
			    System.out.println("*****Successful c = " + c);
				
				if (c == 1 ) {
					
//					con = DriverManager.getConnection(url);
//					sta = con.createStatement();
//					
//					query = "UPDATE " +  table				
//							+ " SET `logo` = '?'"; 
//					System.out.println("*****query: "+query);
//					
//					java.sql.PreparedStatement ps = con.prepareStatement(query);
//					
//					InputStream inputStream = null;
//		            inputStream = A.getLogo().getInputStream();
//		            ps.setBinaryStream(1, inputStream, (int) A.getLogo().getSize());
//					
//			    	ps.addBatch();
//			    	ps.executeBatch();
//			    	ps.close(); 
//			    	sta.close(); 
//					con.close();
										
					return true;
				}
				
				return false;
				
			}catch (Exception e) {
				System.err.println("Exception: "+e.getMessage());
				return true;
			}
		}


	public AdminSettings getSettings(int id){
		System.out.println("****DAO: Get settings of " + id);
		AdminSettings A = new AdminSettings();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			sta = con.createStatement(); 
			String query = "SELECT * FROM " + table + " WHERE id=" + id; 
			rs = sta.executeQuery(query); 
			
			if(rs.next()) {
			   
				A.setId(rs.getInt("id"));
				A.setUsername(rs.getString("username"));
				A.setPassword(rs.getString("password"));
				A.setFontColor(rs.getString("font_color"));
				A.setColor1(rs.getString("color_1"));
				A.setColor2(rs.getString("color_2"));
				A.setMission(rs.getString("mission"));
				A.setVision(rs.getString("vision"));
				A.setGoals(rs.getString("goals"));
				A.setObjectives(rs.getString("objectives"));
				A.setEvaluation(rs.getString("evaluation"));
				A.setRatingScale(rs.getString("rating_scale"));
				A.setSalarySchedule(rs.getString("salary_sched"));
				A.setOfficeAddress(rs.getString("office_add"));
				A.setEmailAddress(rs.getString("email_add"));
				A.setContactNumber(rs.getString("contact_no"));
				A.setSchoolName(rs.getString("school_name"));
				A.setEmailDomain(rs.getString("email_domain"));
//				A.setLogoB(rs.getBlob("logo").getBytes(1,(int)rs.getBlob("logo").length()));
				System.out.println(A.getId());
			}
			
			
			rs.close(); 
			sta.close(); 
		    con.close();
		    	
			return A;
		}catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
			return null;
		}
	}
	
}
