package dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.io.InputStream;

import model.Credential;

public class CredentialDAO{
	 String url = "jdbc:mysql://127.0.0.1/pup_pasuc?user=root&password=password&useSSL=false";
	 String table = "pup_pasuc.credential";
	 Connection con = null;
	 Statement sta = null;
	 ResultSet rs = null;
			
	public  boolean add(Credential C){ // DONE
	try {
		System.out.println("***DAO: Add");
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url);
	
		String query = "INSERT INTO " +  table
			+ " (`timestamp`,`employee_id`,`type`,`subtype`,`title`,`document`,`score`,`category`)"
			+ " VALUES(?,?,?,?,?,?,?,?)";

		System.out.println("*****query: "+query);
		
		java.sql.PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1,C.getTimestamp());
			ps.setString(2,C.getEmpId());
			ps.setString(3,C.getType());
			ps.setString(4,C.getSubtype());
			ps.setString(5,C.getTitle());

            InputStream inputStream = null;
            inputStream = C.getDocument().getInputStream();
             ps.setBinaryStream(6, inputStream, (int) C.getDocument().getSize());
			
            ps.setInt(7,C.getScore());
            ps.setString(8,C.getCategory());
            
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
	
	public  boolean updateAppId(String empId, String appId){ // DONE
	try {
	
		System.out.println("***DAO: Update appId");
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url);
		sta = con.createStatement();
		String query = "UPDATE " +  table				
			+ " SET `application_id` = '" + appId
			+ "' WHERE `employee_id` = '" + empId + "' AND `application_id`=''";
		
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
	
//	public  boolean update(Credential C, String category){ // DONE
//		try {
//			
////			 timestamp  type subtype title 
////			document score status evaluator_id remarks applied			
//			
//			System.out.println("***DAO: Update " + C.getEmpId());
//			Class.forName("com.mysql.jdbc.Driver");
//			con = DriverManager.getConnection(url);
//			sta = con.createStatement();
//			String query = "UPDATE " +  table + category				
//				+ " SET `timestamp` = '" + C.getTimestamp() + "',`type` = '" + C.getType() 
//				+ "',`subtype` = '" + C.getSubtype() + "',`title` = '" + C.getTitle() 
//				+ "',`document` = '" + C.getDocumentB() 
//				+ "' WHERE `cred_id` = '" + C.getCredId() + "';";
//			
//			System.out.println("*****query: "+query);
//			
//			int c = sta.executeUpdate(query);
//		
////                InputStream inputStream = null;
////
////                inputStream = C.getDocument().getInputStream();
////                
////                ps.setBinaryStream(6, inputStream, (int) C.getDocument().getSize());
//
//		    sta.close(); 
//		   	con.close();
//		    		    	
//		    System.out.println("*****Successful c = " + c);
//			
//			return true;
//			
//		}catch (Exception e) {
//			System.err.println("Exception: "+e.getMessage());
//			return false;
//		}
//	}

	public boolean delete(String credId){
		try {
			System.out.println("****DAO: Delete " + credId);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			sta = con.createStatement();
			String query = "DELETE from " +  table + " where cred_id='" +  credId + "'";
			System.out.println("*****query: "+query);
			
			int c = sta.executeUpdate(query);
			
			System.out.println("*****Successful c = " + c);
			
			sta.close();
			con.close();
			
			return true;
		}
		catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
			return false;
		}
	}
	
	public  boolean checkCred(String credId){
		try{
			System.out.println("***DAO: Check Cred " + credId);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			
			String query = "SELECT * FROM " + table + " WHERE cred_id=?";
			System.out.println("*****query: "+query);
			
			java.sql.PreparedStatement st = con.prepareStatement(query);
			st.setString(1,credId);
			
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
	
	public String checkCredOwner(String credId){
		try{
			System.out.println("***DAO: Check Cred Owner of " + credId);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			
			String query = "SELECT employee_id FROM " + table + " WHERE cred_id=?";
			System.out.println("*****query: "+query);
			
			java.sql.PreparedStatement st = con.prepareStatement(query);
			st.setString(1,credId);
			
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				String owner = rs.getString(1); System.out.println("Owner: " + owner);
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
	
	public List<Credential> getCred(String category, String empId){
		System.out.println("****DAO: Get " + category + " credential of " + empId);
	    List<Credential> cred = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			sta = con.createStatement(); 
			String query = "SELECT * FROM " + table + " WHERE employee_id='" + empId +"' AND category ='" + category +"'"; 
			rs = sta.executeQuery(query); 
			int i=0;
			while(rs.next()) {
			    Credential C = new Credential();
				System.out.println("ROW #" +i);
				C.setCredId(rs.getString("cred_id"));
				C.setTimestamp(rs.getString("timestamp"));
				C.setEmpId(rs.getString("employee_id"));
				C.setCategory(rs.getString("category"));
				C.setType(rs.getString("type"));
				C.setSubtype(rs.getString("subtype"));
				C.setTitle(rs.getString("title"));
				C.setDocumentB(rs.getBlob("document").getBytes(1,(int)rs.getBlob("document").length()));
				C.setScore(rs.getInt("score"));
				C.setStatus(rs.getString("status"));
				C.setRemarks(rs.getString("remarks"));
				C.setAppId(rs.getString("application_id"));
				C.setEvaluatorId(rs.getString("evaluator_id"));
				cred.add(C);
					i++;
			}
			
			rs.close(); 
			sta.close(); 
		    con.close();
		    	
			return cred;
			
		}catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
			return null;
		}
	}

	public List<Credential> getNewCred(String category, String appId, String empId){
		System.out.println("****DAO: Get new credential of " + empId);
	    List<Credential> cred = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			sta = con.createStatement(); 
			String query = "SELECT * FROM " + table + " WHERE application_id='" + appId +"' AND category ='" + category + "' AND employee_id ='" + empId + "'"; 
			rs = sta.executeQuery(query); 
			int i=0;
			while(rs.next()) {
			    Credential C = new Credential();
				System.out.println("ROW #" +i);
				C.setCredId(rs.getString("cred_id"));
				C.setTimestamp(rs.getString("timestamp"));
				C.setEmpId(rs.getString("employee_id"));
				C.setCategory(rs.getString("category"));
				C.setType(rs.getString("type"));
				C.setSubtype(rs.getString("subtype"));
				C.setTitle(rs.getString("title"));
				C.setDocumentB(rs.getBlob("document").getBytes(1,(int)rs.getBlob("document").length()));
				C.setScore(rs.getInt("score"));
				C.setStatus(rs.getString("status"));
				C.setRemarks(rs.getString("remarks"));
				cred.add(C);
					i++;
			}

			
			rs.close(); 
			sta.close(); 
		    con.close();
		    	
			return cred;

		}catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
			return null;
		}
	}
	
	public List<Credential> getCredForPEC(String category, String appId){
		System.out.println("****DAO: Get cred of " + appId);
	    List<Credential> cred = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			sta = con.createStatement(); 
			String query = "SELECT * FROM " + table + " WHERE application_id='" + appId +"' AND category ='" + category  + "'"; 
			rs = sta.executeQuery(query); 
			int i=0;
			while(rs.next()) {
			    Credential C = new Credential();
				System.out.println("ROW #" +i);
				C.setCredId(rs.getString("cred_id"));
				C.setTimestamp(rs.getString("timestamp"));
				C.setEmpId(rs.getString("employee_id"));
				C.setCategory(rs.getString("category"));
				C.setType(rs.getString("type"));
				C.setSubtype(rs.getString("subtype"));
				C.setTitle(rs.getString("title"));
				C.setDocumentB(rs.getBlob("document").getBytes(1,(int)rs.getBlob("document").length()));
				C.setScore(rs.getInt("score"));
				C.setStatus(rs.getString("status"));
				C.setRemarks(rs.getString("remarks"));
				cred.add(C);
					i++;
			}

			
			rs.close(); 
			sta.close(); 
		    con.close();
		    	
			return cred;

		}catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
			return null;
		}
	}
	
	public boolean updateCred_E(Credential C){
		try {
			System.out.println("****DAO: Update " + C.getCredId());
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			sta = con.createStatement();
			
			String query = "UPDATE " +  table + " SET score='" + C.getScore() + "', status='" + C.getStatus() + 
					"', evaluator_id='" + C.getEvaluatorId() + "', remarks='" + C.getRemarks() + 
					"' where cred_id='" +  C.getCredId() + "'";
			System.out.println("*****query: "+query);
					
			int c = sta.executeUpdate(query);
			
			System.out.println("*****Successful c = " + c);
			
			sta.close();
			con.close();
			
			return true;
		}
		catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
			return false;
		}
	}
	
//	public boolean updateCred_A(Credential C){
//		try {
//			System.out.println("****DAO: Update " + C.getCredId());
//			Class.forName("com.mysql.jdbc.Driver");
//			con = DriverManager.getConnection(url);
//			
//			String query = "UPDATE " +  table + " SET "
//					+ " (`timestamp`,`type`,`subtype`,`title`,`document`,`score`)"
//					+ " VALUES(?,?,?,?,?,?)";
//
//				System.out.println("*****query: "+query);
//				
//				java.sql.PreparedStatement ps = con.prepareStatement(query);
//
//					ps.setString(1,C.getTimestamp());
//					ps.setString(2,C.getType());
//					ps.setString(3,C.getSubtype());
//					ps.setString(4,C.getTitle());
//
//					if (C.getDocument() != null) {
//						  InputStream inputStream = null;
//				          inputStream = C.getDocument().getInputStream();
//				          ps.setBinaryStream(5, inputStream, (int) C.getDocument().getSize());
//							
//					}
//		          
//		            ps.setInt(6,C.getScore());
//		            
//		        	ps.addBatch();
//			    	ps.executeBatch();
//			    	ps.close(); 
//			    	con.close(); 
//			
//			return true;
//		}
//		catch (Exception e) {
//			System.err.println("Exception: "+e.getMessage());
//			return false;
//		}
//	}
//	
	public int getTotal(String empId, String category){ // DONE
		try {
		
			System.out.println("***DAO: Get total score of " + category);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			sta = con.createStatement();
	
			String query = "SELECT * from " +  table				
					+ " WHERE employee_id=? AND category=? AND application_id=''";
			System.out.println("*****query: "+query);
			
			java.sql.PreparedStatement st = con.prepareStatement(query);
			st.setString(1,empId);
			st.setString(2,category);
			
			ResultSet rs = st.executeQuery();
			
			int total = 0;
			while (rs.next()) {
				total += rs.getInt("score");
				System.out.print(total + " ");
			}
			
			rs.close();
			st.close();
			con.close();
		    		    	
			return total;
			
		}catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
			return 0;
		}
	}
	
	public int getApprovedTotal(String empId, String category){ // DONE
		try {
		
			System.out.println("***DAO: Get total score of " + category);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			sta = con.createStatement();
	
			String query = "SELECT * from " +  table				
					+ " WHERE employee_id=? AND category=? AND status='Approved'";
			System.out.println("*****query: "+query);
			
			java.sql.PreparedStatement st = con.prepareStatement(query);
			st.setString(1,empId);
			st.setString(2,category);
			
			ResultSet rs = st.executeQuery();
			
			int total = 0;
			while (rs.next()) {
				total += rs.getInt("score");
				System.out.print(total + " ");
			}
			
			rs.close();
			st.close();
			con.close();
		    		    	
			return total;
			
		}catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
			return 0;
		}
	}
	
	public byte[] getDocument(String credId) {
		try {
			System.out.println("***DAO: Get document of " + credId);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			sta = con.createStatement();

			String query = "SELECT document from " +  table				
					+ " WHERE `cred_id`=?";
			System.out.println("*****query: "+query);
			
			java.sql.PreparedStatement st = con.prepareStatement(query);
			st.setString(1,credId);
			
			ResultSet rs = st.executeQuery();
			
			byte[] doc = null;
			while (rs.next()) {
				doc = rs.getBlob("document").getBytes(1,(int)rs.getBlob("document").length());
				System.out.print("document: " + doc);
			}
			
			rs.close();
			st.close();
			con.close();
		    		    	
			return doc;
			
		}catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
			return null;
		}
	}


		public List<Credential> getAllCredForAdmin(){
			System.out.println("****DAO: Get all credential");
		    List<Credential> cred = new ArrayList<>();
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url);
				sta = con.createStatement(); 
				String query = "SELECT * FROM " + table; 
				rs = sta.executeQuery(query); 
				int i=0;
				while(rs.next()) {
				    Credential C = new Credential();
					System.out.println("ROW #" +i);
					C.setCredId(rs.getString("cred_id"));
					C.setTimestamp(rs.getString("timestamp"));
					C.setEmpId(rs.getString("employee_id"));
					C.setCategory(rs.getString("category"));
					C.setType(rs.getString("type"));
					C.setSubtype(rs.getString("subtype"));
					C.setTitle(rs.getString("title"));
					C.setDocumentB(rs.getBlob("document").getBytes(1,(int)rs.getBlob("document").length()));
					C.setScore(rs.getInt("score"));
					C.setStatus(rs.getString("status"));
					C.setRemarks(rs.getString("remarks"));
					C.setAppId(rs.getString("application_id"));
					C.setEvaluatorId(rs.getString("evaluator_id"));
					cred.add(C);
						i++;
				}
				
				rs.close(); 
				sta.close(); 
			    con.close();
			    	
				return cred;
				
			}catch (Exception e) {
				System.err.println("Exception: "+e.getMessage());
				return null;
			}
		}

	
}
	


//	public boolean applyCred(Credential C){
//		try {
//			System.out.println("****DAO: Update " + C.getCredId());
//			Class.forName("com.mysql.jdbc.Driver");
//			con = DriverManager.getConnection(url);
//			sta = con.createStatement();
//			
//			String query = "UPDATE " +  table + " SET applied='" + C.getApplied() +
//					"' where cred_id='" +  C.getCredId() + "'";
//			System.out.println("*****query: "+query);
//					
//			int c = sta.executeUpdate(query);
//			
//			System.out.println("*****Successful c = " + c);
//			
//			sta.close();
//			con.close();
//			
//			return true;
//		}
//		catch (Exception e) {
//			System.err.println("Exception: "+e.getMessage());
//			return false;
//		}
//	}
//	

	



//int c = sta.executeUpdate("INSERT INTO " +  table
//	+ " (`f_name`, `m_name`, `l_name`, `c_number`, `email_add`, `b_date`, `gender`, `address`, "
//	+ "	 `employee_id`, `department`, `psw`, `rank`, `points`)"
//	+ " VALUES ('" + fn + "', '" + mn + "', '" + ln + "', '" + cn
//	+ "', '" + email + "', '" + bd + "', '" + gen + "', '" + add 
//	+ "', '" + empId + "', '" + dept + "', '" + psw + "', 'Instructor I', '0')");
//
//sta.close();
//con.close();