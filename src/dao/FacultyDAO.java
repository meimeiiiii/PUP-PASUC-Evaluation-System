package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Faculty;

public class FacultyDAO{
	// String url = "jdbc:mysql://127.0.0.1/pup_pasuc?user=root&password=password&useSSL=false";
	 String url = "jdbc:mysql://127.0.0.1/pup_pasuc?user=IerizNicolle&password=Onetwothree45!&useSSL=false";
	 String table = "pup_pasuc.faculty";
	 Connection con = null;
	 Statement sta = null;
	 ResultSet rs = null;
	
	public  boolean checkEmpId(String empId){
		try{
			System.out.println("***DAO: Check ID " + empId);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			
			String query = "SELECT * FROM " + table + " WHERE employee_id=?";
			System.out.println("*****query: "+query);
			
			java.sql.PreparedStatement st = con.prepareStatement(query);
			st.setString(1,empId);
			
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				System.out.println("****Exists");
				rs.close();
				st.close();
				con.close();
				return true;
			}

			System.out.println("****Doesn't exist");
			rs.close();
			st.close();
			con.close();
			return false;
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
		return false;
	}
	
	public  boolean checkAccount(String email, String psw){ 
		try{
			System.out.println("***DAO: Check account " + email);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			
			String query = "SELECT * FROM " + table + " WHERE `email_add`=?";
			System.out.println("*****query: "+query);
			
			java.sql.PreparedStatement st = con.prepareStatement(query);
			st.setString(1,email);
			//st.setString(2,psw);
			
			ResultSet rs = st.executeQuery();
			

			while (rs.next()) {
				System.out.println("Email " + rs.getString("email_add"));
				System.out.println("Password " + rs.getString("psw"));
				
				if(rs.getString("psw").equals(psw)) {
					System.out.println("****Match");
					rs.close();
					st.close();
					con.close();
					return true;
				}
				
			}
				System.out.println("****Not Match");
				rs.close();
				st.close();
				con.close();
				return false;
			
		}
		catch(SQLException ex){
			while (ex!=null){
				System.err.println ("SQL Exception: " + ex.getMessage ());
				ex = ex.getNextException();
			}
			return false;
		}
		catch(java.lang.Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
	
	public  boolean forgotpw(String email){ 
		try{
			System.out.println("***DAO: Forgot Email" + email);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			
			String query = "SELECT * FROM " + table + " WHERE `email_add`=?";
			System.out.println("*****query: "+query);
			
			java.sql.PreparedStatement st = con.prepareStatement(query);
			st.setString(1,email);
			
			ResultSet rs = st.executeQuery();
			

			while (rs.next()) {
				System.out.println("Email " + rs.getString("email_add"));
				System.out.println("****Match");
				return true;
			}
				System.out.println("****Not Match");
				rs.close();
				st.close();
				con.close();
				return false;
			
		}
		catch(SQLException ex){
			while (ex!=null){
				System.err.println ("SQL Exception: " + ex.getMessage ());
				ex = ex.getNextException();
			}
			return false;
		}
		catch(java.lang.Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
	
	
	public  boolean checkEmail(String email){
		try{
			System.out.println("***DAO: Check email " + email);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			
			String query = "SELECT * FROM " + table + " WHERE email_add=?";
			System.out.println("*****query: "+query);
			
			java.sql.PreparedStatement st = con.prepareStatement(query);
			st.setString(1,email);
			
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				System.out.println("****Exists");
				rs.close();
				st.close();
				con.close();
				return true; 
			}
			
			rs.close();
			st.close();
			con.close();
			
			System.out.println("****Doesn't exist");
			return false;
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
		return false;
	}
	
	public String getCurrentRank(String empId){
		try{
			System.out.println("***DAO: Get rank " + empId);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			
		
//			String query = "SELECT rank FROM " + table + " WHERE employee_id=?";
//			System.out.println("*****query: "+query);
//			
//			
//			java.sql.PreparedStatement st = con.prepareStatement(query);
//			st.setString(1,empId);
//			
//			ResultSet rs = st.executeQuery();
//			
//			if (rs.next()) {
//				String rank = rs.getString("rank");
//				System.out.println("****Exists");
//				System.out.println("rank: " + rank);
//				rs.close();
//				st.close();
//				con.close();
//				return rank; 
//			}
//			
//			rs.close();
//			st.close();
//			con.close();
			
			sta = con.createStatement();
			
			String query = "SELECT * FROM " + table + " WHERE employee_id='" + empId + "'";
			System.out.println("*****query: "+query);
			
			rs = sta.executeQuery(query);
			
			while(rs.next()) {
				String rank = rs.getString("rank");
				System.out.println("****Exists");
				System.out.println("rank: " + rank);
				rs.close();
				sta.close();
				con.close();
				return rank; 
			}
	
			rs.close();
			sta.close();
			con.close();
			
			System.out.println("****Doesn't exist");
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
	
	
	// ADD RANK FIELD IN ADD AND UPDATE
	public  boolean add(Faculty F){ 
		try {
			System.out.println("***DAO: Add");
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
		
			String query = "INSERT INTO " +  table
				+ " (`employee_id`, `f_name`, `m_name`, `l_name`, `c_number`, `email_add`, `b_date`, `gender`, `address`, `department`, `psw`, `score_educ`, `score_exp`, `score_prof`, `rank`) " 
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			
			System.out.println("*****query: "+query);
			
			java.sql.PreparedStatement ps = con.prepareStatement(query);

				ps.setString(1,F.getEmpId());
				ps.setString(2,F.getFirstName());
				ps.setString(3,F.getMiddleName());
				ps.setString(4,F.getLastName());
				ps.setString(5,F.getContactNumber());
				ps.setString(6,F.getEmail());
				ps.setString(7,F.getBirthDate());
				ps.setString(8,F.getGender());
				ps.setString(9,F.getAddress());
				ps.setString(10,F.getDepartment());
				ps.setString(11,F.getPassword());
				ps.setInt(12,F.getScoreEduc());
				ps.setInt(13,F.getScoreExp());
				ps.setInt(14,F.getScoreProf());
				ps.setString(15,F.getRank());
				
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

	public  boolean update(Faculty F){
		try {
			System.out.println("****DAO: Update " + F.getEmail());
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			sta = con.createStatement();
			String query = "UPDATE " +  table
				+ " SET `f_name`='" + F.getFirstName()+ "', `m_name`='" + F.getMiddleName() 
				+ "', `l_name`='" + F.getLastName() + "', `c_number`='" + F.getContactNumber() 
				+ "', `b_date`='" + F.getBirthDate() + "', `gender`='" + F.getGender() 
				+ "', `address`='" + F.getAddress() + "', `department`='" + F.getDepartment() 
				+ "' WHERE email_add = '" + F.getEmail() + "';";
			
			System.out.println("*****query: "+query);
			
			int c = sta.executeUpdate(query);
			
			System.out.println("*****Successful c=" + c);
			
			sta.close();
			con.close();
			
//			String query = "UPDATE " +  table
//					+ " SET `f_name`=?, `m_name`=?, `l_name`=?, `c_number`=?, `b_date`=?, `gender`="
//					+ "?, `address`=?, `department`=? WHERE 'email_add' = '" + F.getEmail() + "';";
//				
//			System.out.println("Query:" + query);
//			
//			java.sql.PreparedStatement ps = con.prepareStatement(query);
//		  
//			System.out.println(F.getEmpId());
//			System.out.println(F.getFirstName());
//			System.out.println(F.getMiddleName());
//			System.out.println(F.getLastName());
//			System.out.println(F.getContactNumber());
//			System.out.println(F.getEmail());
//			System.out.println(F.getBirthDate());
//			System.out.println(F.getGender());
//			System.out.println(F.getAddress());
//			System.out.println(F.getDepartment());
//			System.out.println(F.getPassword());
//			
//				ps.setString(1,F.getFirstName());
//				ps.setString(2,F.getMiddleName());
//				ps.setString(3,F.getLastName());
//				ps.setString(4,F.getContactNumber());
//				ps.setString(5,F.getBirthDate());
//				ps.setString(6,F.getGender());
//				ps.setString(7,F.getAddress());
//				ps.setString(8,F.getDepartment());
				
//		    	ps.addBatch();
//		    //	ps.executeBatch();
//		    System.out.println("*****PS: "+ps.executeBatch());
//		    	ps.close(); 
//		    	con.close();
		    	
		    	
		    
		    	
		    System.out.println("****Successful");
		    	
			return true;
			
		}catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
			return false;
		}
	}
	
	public int delete(String email){
		try {
			System.out.println("****DAO: Delete " + email);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			sta = con.createStatement();
			String query = "DELETE from " +  table + " where email_add='" +  email + "'";
			System.out.println("*****query: "+query);
			
			int c = sta.executeUpdate(query);
			
			System.out.println("*****Successful c = " + c);
			
			sta.close();
			con.close();
			
			return c;
		}
		catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
			return 0;
		}
	}
	
	public int changeEmail(String oldEmail, String newEmail){
		try {
			System.out.println("****DAO: Change Email fr " + oldEmail + " to " + newEmail);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			sta = con.createStatement();
			String query = "UPDATE " +  table + " SET email_add='" + newEmail + "' where email_add='" +  oldEmail + "'";
			System.out.println("*****query: "+query);
					
			int c = sta.executeUpdate(query);
			
			System.out.println("*****Successful c = " + c);
			
			sta.close();
			con.close();
			
			return c;
		}
		catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
			return 0;
		}
	}

	public boolean changePassword(String email, String newPassword){
		try {
			System.out.println("****DAO: Change Password to " + newPassword);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			sta = con.createStatement();
			String query = "UPDATE " +  table + " SET psw='" + newPassword + "' where email_add='" +  email + "'";
			System.out.println("*****query: "+query);
					
			int c = sta.executeUpdate(query);
			
			System.out.println("*****Successful c = " + c);
			
			sta.close();
			con.close();
			
			if (c == 1) { return true; }
			else { return false; }
		}
		catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
			return false;
		}
	}
	
	public List<Faculty> getUser(String email){
		System.out.println("****DAO: Get user " + email);
	    List<Faculty> faculty = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			sta = con.createStatement(); 
			String query = "SELECT * FROM " + table + " WHERE email_add='" + email +"'"; 
			rs = sta.executeQuery(query); 

			if(rs.next()) {
			    Faculty F = new Faculty();
				F.setEmpId(rs.getString("employee_id"));
				F.setFirstName(rs.getString("f_name"));
				F.setMiddleName(rs.getString("m_name"));
				F.setLastName(rs.getString("l_name"));
				F.setContactNumber(rs.getString("c_number"));
				F.setEmail(rs.getString("email_add"));
				F.setBirthDate(rs.getString("b_date"));
				F.setGender(rs.getString("gender"));
				F.setAddress(rs.getString("address"));
				F.setDepartment(rs.getString("department"));
				F.setRank(rs.getString("rank"));
				F.setPassword(rs.getString("psw"));
				F.setScoreEduc(rs.getInt("score_educ"));
				F.setScoreExp(rs.getInt("score_exp"));
				F.setScoreProf(rs.getInt("score_prof"));
				faculty.add(F);
			}
			
			rs.close(); 
			sta.close(); 
		    con.close();
		    	
			return faculty;

		}catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
			return null;
		}
	}

	public List<Faculty> getUserfromID(String empId){
		System.out.println("****DAO: Get user " + empId);
	    List<Faculty> faculty = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			sta = con.createStatement(); 
			String query = "SELECT * FROM " + table + " WHERE employee_id='" + empId +"'"; 
			rs = sta.executeQuery(query); 

			if(rs.next()) {
			    Faculty F = new Faculty();
				F.setEmpId(rs.getString("employee_id"));
				F.setFirstName(rs.getString("f_name"));
				F.setMiddleName(rs.getString("m_name"));
				F.setLastName(rs.getString("l_name"));
				F.setContactNumber(rs.getString("c_number"));
				F.setEmail(rs.getString("email_add"));
				F.setBirthDate(rs.getString("b_date"));
				F.setGender(rs.getString("gender"));
				F.setAddress(rs.getString("address"));
				F.setDepartment(rs.getString("department"));
				F.setRank(rs.getString("rank"));
				F.setPassword(rs.getString("psw"));
				F.setScoreEduc(rs.getInt("score_educ"));
				F.setScoreExp(rs.getInt("score_exp"));
				F.setScoreProf(rs.getInt("score_prof"));
				faculty.add(F);
			}
			
			rs.close(); 
			sta.close(); 
		    con.close();
		    	
			return faculty;

		}catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
			return null;
		}
	}
	
	
	public List<Faculty> getEmailandId(){
		System.out.println("****DAO: Get all email & empId");
	    List<Faculty> faculty = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			sta = con.createStatement(); 
			String query = "SELECT email_add,employee_id FROM " + table; 
			rs = sta.executeQuery(query); 
			
			if(rs.next()) {
			    Faculty F = new Faculty();
				F.setEmail(rs.getString(0));
				F.setEmpId(rs.getString(1));
				faculty.add(F);
			}
			
			rs.close(); 
			sta.close(); 
		    con.close();
		    	
			return faculty;

		}catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
			return null;
		}
	}

	public List<Faculty> getAllUsers(){
		System.out.println("****DAO: Get users");
	    List<Faculty> faculty = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			sta = con.createStatement(); 
			String query = "SELECT * FROM " + table; 
			rs = sta.executeQuery(query); 
			
			while(rs.next()) {
			    Faculty F = new Faculty();
				F.setEmpId(rs.getString("employee_id"));
				F.setFirstName(rs.getString("f_name"));
				F.setMiddleName(rs.getString("m_name"));
				F.setLastName(rs.getString("l_name"));
				F.setContactNumber(rs.getString("c_number"));
				F.setEmail(rs.getString("email_add"));
				F.setBirthDate(rs.getString("b_date"));
				F.setGender(rs.getString("gender"));
				F.setAddress(rs.getString("address"));
				F.setDepartment(rs.getString("department"));
				F.setRank(rs.getString("rank"));
				F.setScoreEduc(rs.getInt("score_educ"));
				F.setScoreExp(rs.getInt("score_exp"));
				F.setScoreProf(rs.getInt("score_prof"));
				faculty.add(F);
			}
			
			rs.close(); 
			sta.close(); 
		    con.close();
		    	
			return faculty;

		}catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
			return null;
		}
	}
	
	public boolean changeRank(String empId, String newRank, int scoreEduc, int scoreExp, int scoreProf){
		try {
			System.out.println("****DAO: Change Rank to " + newRank);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			sta = con.createStatement();
			String query = "UPDATE " +  table + " SET `rank`='" + newRank + "', " +
					"`score_educ`='" + scoreEduc + "', " + "`score_exp`='" + scoreExp + "', " + "`score_prof`='" + scoreProf + "' " +
					"where `employee_id`='" +  empId + "'";
			System.out.println("*****query: "+query);
					
			int c = sta.executeUpdate(query);
			
			System.out.println("*****Successful c = " + c);
			
			sta.close();
			con.close();
			
			if (c==1) {
				return true;
			}
			
			return false;
		}
		catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
			return false;
		}
	}
	
	public List<Faculty> getAllForAdmin(){
		System.out.println("****DAO: Get users");
	    List<Faculty> faculty = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			sta = con.createStatement(); 
			String query = "SELECT * FROM " + table; 
			rs = sta.executeQuery(query); 
			
			while(rs.next()) {
			    Faculty F = new Faculty();
				F.setEmpId(rs.getString("employee_id"));
				F.setFirstName(rs.getString("f_name"));
				F.setMiddleName(rs.getString("m_name"));
				F.setLastName(rs.getString("l_name"));
				F.setContactNumber(rs.getString("c_number"));
				F.setEmail(rs.getString("email_add"));
				F.setBirthDate(rs.getString("b_date"));
				F.setGender(rs.getString("gender"));
				F.setAddress(rs.getString("address"));
				F.setDepartment(rs.getString("department"));
				F.setRank(rs.getString("rank"));
				F.setPassword(rs.getString("psw"));
				F.setScoreEduc(rs.getInt("score_educ"));
				F.setScoreExp(rs.getInt("score_exp"));
				F.setScoreProf(rs.getInt("score_prof"));
				faculty.add(F);
			}
			
			rs.close(); 
			sta.close(); 
		    con.close();
		    	
			return faculty;

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