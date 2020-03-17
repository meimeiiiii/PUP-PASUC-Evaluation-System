package dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.io.InputStream;

import model.Application;

public class ApplicationDAO{
	// String url = "jdbc:mysql://127.0.0.1/pup_pasuc?user=root&password=password&useSSL=false";
	 String url = "jdbc:mysql://127.0.0.1/pup_pasuc?user=IerizNicolle&password=Onetwothree45!&useSSL=false";
	 String table = "pup_pasuc.application";
	 Connection con = null;
	 Statement sta = null;
	 ResultSet rs = null;
			
	public  boolean add(Application A){ // DONE
	try {
		System.out.println("***DAO: Add");
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url);
	
		String query = "INSERT INTO " +  table
				+ " (`datetime_submitted`,`score_educ`,`score_exp`,`score_prof`,`cur_rank`,`new_rank`,`employee_id`,`letter`)"
				+ " VALUES(?,?,?,?,?,?,?,?)";
		
		System.out.println("*****query: "+query);
		
		java.sql.PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1,A.getDtSubmitted());
			ps.setInt(2,A.getScoreEduc());
			ps.setInt(3,A.getScoreExp());
			ps.setInt(4,A.getScoreProf());
			ps.setString(5,A.getCurRank());
			ps.setString(6,A.getNewRank());
			ps.setString(7,A.getEmpId());
			
			InputStream inputStream = null;
            inputStream = A.getDocument().getInputStream();
            ps.setBinaryStream(8, inputStream, (int) A.getDocument().getSize());
			
            
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
	
	public  boolean updateScores(String appId, int scoreEduc, int scoreExp, int scoreProf, String newRank, String empId){ // DONE
		try {
			System.out.println("***DAO: Update " + appId);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			sta = con.createStatement();
			String query = "UPDATE " +  table				
				+ " SET `score_educ` = '" + scoreEduc + "',`score_exp` = '" + scoreExp
				+ "',`score_prof` = '" + scoreProf + "',`new_rank` = '" + newRank
				+ "' WHERE `application_id` = '" + appId + "';";
			
			System.out.println("*****query: "+query);
			
			int c = sta.executeUpdate(query);

		    sta.close(); 
		   	con.close();
		    		    	
		    System.out.println("*****Successful c = " + c);
			
			return true;
			
		}catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
			return false;
		}
	}

	
	public  boolean updateStatusFinal(String appId, String evaluatorId, String dtApproved, String status, String remarks){ // DONE
		try {
			System.out.println("***DAO: Update " + appId);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			sta = con.createStatement();
			String query = "UPDATE " +  table				
				+ " SET `evaluator_id` = '" + evaluatorId + "',`datetime_approved` = '" + dtApproved
				+ "',`status` = '" + status + "',`remarks` = '" + remarks
				+ "' WHERE `application_id` = '" + appId + "';";
			
			System.out.println("*****query: "+query);
			
			int c = sta.executeUpdate(query);

		    sta.close(); 
		   	con.close();
		    		    	
		    System.out.println("*****Successful c = " + c);
			
			return true;
			
		}catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
			return false;
		}
	}
	
	public boolean updateStatus(String appId, String evaluatorId, String status, String remarks, String dtApproved){ // DONE
		try {
			System.out.println("***DAO: Update " + appId);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			sta = con.createStatement();
			String query = "UPDATE " +  table				
					+ " SET `evaluator_id` = '" + evaluatorId + "',`datetime_approved` = '" + dtApproved
					+ "',`status` = '" + status + "',`remarks` = '" + remarks
					+ "' WHERE `application_id` = '" + appId + "';";
				
			System.out.println("*****query: "+query);
			
			int c = sta.executeUpdate(query);

		    sta.close(); 
		   	con.close();
		    		    	
		    System.out.println("*****Successful c = " + c);
			
			if (c == 1 ) {
				return true;
			}
			
			return false;
			
		}catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
			return true;
		}
	}

	
	public List<Application> getSpecificApp(String appId){
		System.out.println("****DAO: Get application " + appId);
	    List<Application> app = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			sta = con.createStatement(); 
			String query = "SELECT * FROM " + table + " WHERE application_id='" + appId + "'"; 
			rs = sta.executeQuery(query); 
			
			int i=0;
			while(rs.next()) {
			    Application A = new Application();
				System.out.println("ROW #" +i);
				A.setAppId(rs.getString("application_id"));
				A.setDtSubmitted(rs.getString("datetime_submitted"));
				A.setScoreEduc(rs.getInt("score_educ"));
				A.setScoreExp(rs.getInt("score_exp"));
				A.setScoreProf(rs.getInt("score_prof"));
				A.setTotal(rs.getInt("total"));
				A.setCurRank(rs.getString("cur_rank"));
				A.setNewRank(rs.getString("new_rank"));
				A.setEvaluatorId(rs.getString("evaluator_id"));
				A.setDtApproved(rs.getString("datetime_approved"));
				A.setStatus(rs.getString("status"));
				A.setRemarks(rs.getString("remarks"));
				A.setEmpId(rs.getString("employee_id"));
				A.setDocumentB(rs.getBlob("letter").getBytes(1,(int)rs.getBlob("letter").length()));

				app.add(A);

					i++;
			}
			
			rs.close(); 
			sta.close(); 
		    con.close();
		    	
			return app;
		}catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
			return null;
		}
	}

	
	public List<Application> getApp(String empId, String status){
		System.out.println("****DAO: Get application of " + empId);
	    List<Application> app = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			sta = con.createStatement(); 
			String query = "SELECT * FROM " + table + " WHERE employee_id='" + empId +"' AND status ='" + status + "'"; 
			rs = sta.executeQuery(query); 
			
			int i=0;
			while(rs.next()) {
			    Application A = new Application();
				System.out.println("ROW #" +i);
				A.setAppId(rs.getString("application_id"));
				A.setDtSubmitted(rs.getString("datetime_submitted"));
				A.setScoreEduc(rs.getInt("score_educ"));
				A.setScoreExp(rs.getInt("score_exp"));
				A.setScoreProf(rs.getInt("score_prof"));
				A.setTotal(rs.getInt("total"));
				A.setCurRank(rs.getString("cur_rank"));
				A.setNewRank(rs.getString("new_rank"));
				A.setEvaluatorId(rs.getString("evaluator_id"));
				A.setDtApproved(rs.getString("datetime_approved"));
				A.setStatus(rs.getString("status"));
				A.setRemarks(rs.getString("remarks"));
				A.setEmpId(rs.getString("employee_id"));
				A.setDocumentB(rs.getBlob("letter").getBytes(1,(int)rs.getBlob("letter").length()));

				app.add(A);

					i++;
			}
			
			rs.close(); 
			sta.close(); 
		    con.close();
		    	
			return app;
		}catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
			return null;
		}
	}

	public List<Application> getAllApp(String status){
		System.out.println("****DAO: Get all applications");
	    List<Application> app = new ArrayList<>();
	    
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			sta = con.createStatement(); 
			String query = "SELECT * FROM " + table + " WHERE status='" + status +"'"; 
			rs = sta.executeQuery(query); 
			
			int i=0;
			while(rs.next()) {
				Application A = new Application();
				System.out.println("ROW #" +i);
				A.setAppId(rs.getString("application_id"));
				A.setDtSubmitted(rs.getString("datetime_submitted"));
				A.setScoreEduc(rs.getInt("score_educ"));
				A.setScoreExp(rs.getInt("score_exp"));
				A.setScoreProf(rs.getInt("score_prof"));
				A.setTotal(rs.getInt("total"));
				A.setCurRank(rs.getString("cur_rank"));
				A.setNewRank(rs.getString("new_rank"));
				A.setEvaluatorId(rs.getString("evaluator_id"));
				A.setDtApproved(rs.getString("datetime_approved"));
				A.setStatus(rs.getString("status"));
				A.setRemarks(rs.getString("remarks"));
				A.setEmpId(rs.getString("employee_id"));
				A.setDocumentB(rs.getBlob("letter").getBytes(1,(int)rs.getBlob("letter").length()));

				app.add(A);
				i++;
			}
			
			rs.close(); 
			sta.close(); 
		    con.close();
		    	
			return app;

		}catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
			return null;
		}
	}
	
	public String checkAppOwner(String appId){
		try{
			System.out.println("***DAO: Check App Owner of " + appId);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			
			String query = "SELECT employee_id FROM " + table + " WHERE application_id=?";
			System.out.println("*****query: "+query);
			
			java.sql.PreparedStatement st = con.prepareStatement(query);
			st.setString(1,appId);
			
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				String owner = rs.getString("employee_id"); System.out.println("Owner: " + owner);
				rs.close();
				st.close();
				con.close();
				return owner;
			}

			System.out.println("****Doesn't exist");
			rs.close();
			st.close();
			con.close();
			return null;
		}
		catch(SQLException ex){
			while (ex!=null){
				System.err.println ("SQL Exception: " + ex.getMessage ());
				ex = ex.getNextException();
			}
		}
		catch(java.lang.Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	public List<Application> getAllAppForAdmin(){
		System.out.println("****DAO: Get all applications");
	    List<Application> app = new ArrayList<>();
	    
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			sta = con.createStatement(); 
			String query = "SELECT * FROM " + table; 
			rs = sta.executeQuery(query); 
			
			int i=0;
			while(rs.next()) {
				Application A = new Application();
				System.out.println("ROW #" +i);
				A.setAppId(rs.getString("application_id"));
				A.setDtSubmitted(rs.getString("datetime_submitted"));
				A.setScoreEduc(rs.getInt("score_educ"));
				A.setScoreExp(rs.getInt("score_exp"));
				A.setScoreProf(rs.getInt("score_prof"));
				A.setTotal(rs.getInt("total"));
				A.setCurRank(rs.getString("cur_rank"));
				A.setNewRank(rs.getString("new_rank"));
				A.setEvaluatorId(rs.getString("evaluator_id"));
				A.setDtApproved(rs.getString("datetime_approved"));
				A.setStatus(rs.getString("status"));
				A.setRemarks(rs.getString("remarks"));
				A.setEmpId(rs.getString("employee_id"));
				A.setDocumentB(rs.getBlob("letter").getBytes(1,(int)rs.getBlob("letter").length()));

				app.add(A);
				i++;
			}
			
			rs.close(); 
			sta.close(); 
		    con.close();
		    	
			return app;

		}catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
			return null;
		}
	}
	
	
}


//int c = sta.executeUpdate("INSERT INTO " +  table
//	+ " (`f_name`, `m_name`, `l_name`, `c_number`, `email_add`, `b_date`, `gender`, `address`, "
//	+ "	 `employee_id`, `department`, `psw`, `rank`, `points`)"
//	+ " VALUES ('" + fn + "', '" + mn + "', '" + ln + "', '" + cn
//	+ "', '" + email + "', '" + bd + "', '" + gen + "', '" + add 
//	+ "', '" + empId + "', '" + dept + "', '" + psw + "', 'Instructor I', '0')");
//
//sta.close();
//con.close();