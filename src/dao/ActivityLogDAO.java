package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Activity;

public class ActivityLogDAO {
	// String url = "jdbc:mysql://127.0.0.1/pup_pasuc?user=root&password=password&useSSL=false";
	 String url = "jdbc:mysql://127.0.0.1/pup_pasuc?user=IerizNicolle&password=Onetwothree45!&useSSL=false";
	 String table = "pup_pasuc.activity_log";
	 Connection con = null;
	 Statement sta = null;
	 ResultSet rs = null;

	public  boolean add(Activity A){
		try {
			System.out.println("***DAO: Add");
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
		
			String query = "INSERT INTO "+ table + 
					" (`timestamp`,`employee_id`,`activity_name`)" + 
					" VALUES(?,?,?);";
			
			System.out.println("*****query: "+query);
			
			java.sql.PreparedStatement ps = con.prepareStatement(query);

				ps.setString(1,A.getTimestamp());
				ps.setString(2,A.getEmpId());
				ps.setString(3,A.getActivityName());
				
		    	ps.addBatch();
		    	ps.executeBatch();
		    	ps.close(); 
		    	con.close();
		    	
			System.out.println("****Successful");
			
			return true;
			
		}catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
			return false;
		}
	}

	public List<Activity> getActivity(String empId){
		System.out.println("****DAO: Get activity of " + empId);
	    List<Activity> act = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			sta = con.createStatement(); 
			String query = "SELECT * FROM " + table + " WHERE employee_id='" + empId +"'"; 
			rs = sta.executeQuery(query); 
			
			while(rs.next()) {
			    Activity A = new Activity();
				A.setActId(rs.getString("activity_id"));
				A.setTimestamp(rs.getString("timestamp"));
				A.setEmpId(rs.getString("employee_id"));
				A.setActivityName(rs.getString("activity_name"));
				act.add(A);
			}
			
			rs.close(); 
			sta.close(); 
		    con.close();
		    	
			return act;
		}catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
			return null;
		}
	}
	
	
}







