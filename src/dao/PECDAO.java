package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.PEC;

public class PECDAO{
	// String url = "jdbc:mysql://127.0.0.1/pup_pasuc?user=root&password=password&useSSL=false";
	 String url = "jdbc:mysql://127.0.0.1/pup_pasuc?user=IerizNicolle&password=Onetwothree45!&useSSL=false";
	 String table = "pup_pasuc.pec";
	 Connection con = null;
	 Statement sta = null;
	 ResultSet rs = null;
	
	public  boolean checkPECId(String pecId){
		try{
			System.out.println("***DAO: Check ID " + pecId);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			
			String query = "SELECT * FROM " + table + " WHERE pec_id=?";
			System.out.println("*****query: "+query);
			
			java.sql.PreparedStatement st = con.prepareStatement(query);
			st.setString(1,pecId);
			
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
			
			String query = "SELECT * FROM " + table + " WHERE email_add=? AND psw=?";
			System.out.println("*****query: "+query);
			
			java.sql.PreparedStatement st = con.prepareStatement(query);
			st.setString(1,email);
			st.setString(2,psw);
			
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				System.out.println("****Match");
				rs.close();
				st.close();
				con.close();
				return true;
			}

			System.out.println("****Not match");
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
	
	public  boolean checkUsername(String email){
		try{
			System.out.println("***DAO: Check username " + email);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			
			String query = "SELECT * FROM " + table + " WHERE username=?";
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

	public  boolean add(PEC PEC){ 
		try {
			System.out.println("***DAO: Add");
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
		
			String query = "INSERT INTO " +  table
				+ " (`email_add`,`f_name`,`m_name`,`l_name`,`position`,`psw`,`rights`) " 
				+ "VALUES (?, ?, ?, ?, ?, ?, ?);";
			
			System.out.println("*****query: "+query);
			
			java.sql.PreparedStatement ps = con.prepareStatement(query);

				ps.setString(1,PEC.getEmail());
				ps.setString(2,PEC.getFirstName());
				ps.setString(3,PEC.getMiddleName());
				ps.setString(4,PEC.getLastName());
				ps.setString(5,PEC.getPosition());
				ps.setString(6,PEC.getPassword());
				ps.setString(7,PEC.getRights());
				
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

//	public  boolean update(Faculty F){
//		try {
//			System.out.println("****DAO: Update " + F.getEmail());
//			Class.forName("com.mysql.jdbc.Driver");
//			con = DriverManager.getConnection(url);
//			sta = con.createStatement();
//			String query = "UPDATE " +  table
//				+ " SET `f_name`='" + F.getFirstName()+ "', `m_name`='" + F.getMiddleName() 
//				+ "', `l_name`='" + F.getLastName() + "', `c_number`='" + F.getContactNumber() 
//				+ "', `b_date`='" + F.getBirthDate() + "', `gender`='" + F.getGender() 
//				+ "', `address`='" + F.getAddress() + "', `department`='" + F.getDepartment() 
//				+ "' WHERE email_add = '" + F.getEmail() + "';";
//			
//			System.out.println("*****query: "+query);
//			
//			int c = sta.executeUpdate(query);
//			
//			System.out.println("*****Successful c=" + c);
//			
//			sta.close();
//			con.close();
//			
////			String query = "UPDATE " +  table
////					+ " SET `f_name`=?, `m_name`=?, `l_name`=?, `c_number`=?, `b_date`=?, `gender`="
////					+ "?, `address`=?, `department`=? WHERE 'email_add' = '" + F.getEmail() + "';";
////				
////			System.out.println("Query:" + query);
////			
////			java.sql.PreparedStatement ps = con.prepareStatement(query);
////		  
////			System.out.println(F.getEmpId());
////			System.out.println(F.getFirstName());
////			System.out.println(F.getMiddleName());
////			System.out.println(F.getLastName());
////			System.out.println(F.getContactNumber());
////			System.out.println(F.getEmail());
////			System.out.println(F.getBirthDate());
////			System.out.println(F.getGender());
////			System.out.println(F.getAddress());
////			System.out.println(F.getDepartment());
////			System.out.println(F.getPassword());
////			
////				ps.setString(1,F.getFirstName());
////				ps.setString(2,F.getMiddleName());
////				ps.setString(3,F.getLastName());
////				ps.setString(4,F.getContactNumber());
////				ps.setString(5,F.getBirthDate());
////				ps.setString(6,F.getGender());
////				ps.setString(7,F.getAddress());
////				ps.setString(8,F.getDepartment());
//				
////		    	ps.addBatch();
////		    //	ps.executeBatch();
////		    System.out.println("*****PS: "+ps.executeBatch());
////		    	ps.close(); 
////		    	con.close();
//		    	
//		    	
//		    
//		    	
//		    System.out.println("****Successful");
//		    	
//			return true;
//			
//		}catch (Exception e) {
//			System.err.println("Exception: "+e.getMessage());
//			return false;
//		}
//	}
//	

	
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
			
			if(c>0) {
				return true;
			}
			
			return false;
		}
		catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
			return false;
		}
	}
	
	public boolean changeEmail(String oldEmail, String newEmail){
		try {
			System.out.println("****DAO: Change Email to " + newEmail);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			sta = con.createStatement();
			String query = "UPDATE " +  table + " SET email_add='" + newEmail + "' where email_add='" +  oldEmail + "'";
			System.out.println("*****query: "+query);
					
			int c = sta.executeUpdate(query);
			
			System.out.println("*****Successful c = " + c);
			
			sta.close();
			con.close();
			
			if(c>0) {
				return true;
			}
			
			return false;
		}
		catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
			return false;
		}
	}
	
	public List<PEC> getUser(String email){
		System.out.println("****DAO: Get user " + email);
	    List<PEC> PEC = new ArrayList<>();
	    PEC P = new PEC();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			sta = con.createStatement(); 
			String query = "SELECT * FROM " + table + " WHERE email_add='" + email +"'"; 
			rs = sta.executeQuery(query); 

			if(rs.next()) {
				P.setPecId(rs.getString("pec_id"));
				P.setEmail(rs.getString("email_add"));
				P.setFirstName(rs.getString("f_name"));
				P.setMiddleName(rs.getString("m_name"));
				P.setLastName(rs.getString("l_name"));
				P.setPosition(rs.getString("position"));
				P.setRights(rs.getString("rights"));
				P.setPassword(rs.getString("psw"));
				PEC.add(P);
			}
			
			rs.close(); 
			sta.close(); 
		    con.close();
		    	
			return PEC;

		}catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
			return null;
		}
	}
	
	public List<PEC> getAllUsers(){
		System.out.println("****DAO: Get PEC");
		List<PEC> PEC = new ArrayList<>();

		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			sta = con.createStatement(); 
			String query = "SELECT * FROM " + table; 
			rs = sta.executeQuery(query); 
			
			while(rs.next()) {
				PEC P = new PEC();
					P.setPecId(rs.getString("pec_id"));
					P.setFirstName(rs.getString("f_name"));
					P.setMiddleName(rs.getString("m_name"));
					P.setLastName(rs.getString("l_name"));
					P.setPosition(rs.getString("position"));
					P.setRights(rs.getString("rights"));
					P.setEmail(rs.getString("email_add"));
					
				
				PEC.add(P);
			}
			
			rs.close(); 
			sta.close(); 
		    con.close();
		    	
			return PEC;

		}catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
			return null;
		}
	}
	
//	public int changePosition(String pecId, String newPosition){
//		try {
//			System.out.println("****DAO: Change Rank to " + newPosition);
//			Class.forName("com.mysql.jdbc.Driver");
//			con = DriverManager.getConnection(url);
//			sta = con.createStatement();
//			String query = "UPDATE " +  table + " SET position='" + newPosition + "' where pec_id='" +  pecId + "'";
//			System.out.println("*****query: "+query);
//					
//			int c = sta.executeUpdate(query);
//			
//			System.out.println("*****Successful c = " + c);
//			
//			sta.close();
//			con.close();
//			
//			return c;
//		}
//		catch (Exception e) {
//			System.err.println("Exception: "+e.getMessage());
//			return 0;
//		}
//	}
//	
//	
	
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