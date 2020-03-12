package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.CCEScore;

public class CCEScoreDAO {
	 String url = "jdbc:mysql://127.0.0.1/pup_pasuc?user=root&password=password&useSSL=false";
	 String table = "pup_pasuc.cce_score";
	 Connection con = null;
	 Statement sta = null;
	 ResultSet rs = null;

	public List<CCEScore> getCCEScore(){
		System.out.println("****DAO: Get CCE Score");
	    List<CCEScore> cce_score = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			sta = con.createStatement(); 
			String query = "SELECT * FROM " + table; 
			rs = sta.executeQuery(query); 
			
			while(rs.next()) {
			    CCEScore cs = new CCEScore();
				cs.setScoreId(rs.getString("score_id"));
				cs.setCategory(rs.getString("category"));
				cs.setType(rs.getString("type"));
				cs.setSubType(rs.getString("subtype"));
				cs.setPoints(rs.getInt("points"));
				cce_score.add(cs);
			}
			
			rs.close(); 
			sta.close(); 
		    con.close();
		    	
			return cce_score;
		}catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
			return null;
		}
	}

//	public  boolean update(CCEScore CS){ // DONE
//		try {
//			System.out.println("***DAO: Add");
//			Class.forName("com.mysql.jdbc.Driver");
//			con = DriverManager.getConnection(url);
//		
//			String query = "UPDATE " +  table
//				+ " SET (`timestamp`,`employee_id`,`type`,`subtype`,`title`,`document`)"
//				+ " VALUES(?,?,?,?,?,?)";
//			
//			System.out.println("*****query: "+query);
//			
//			java.sql.PreparedStatement ps = con.prepareStatement(query);
//
//				ps.setString(1,C.getTimestamp());
//				ps.setString(2,C.getEmpId());
//				ps.setString(3,C.getType());
//				ps.setString(4,C.getSubtype());
//				ps.setString(5,C.getTitle());
//
//	            InputStream inputStream = null;
//
//	            inputStream = C.getDocument().getInputStream();
//	            
//	            ps.setBinaryStream(6, inputStream, (int) C.getDocument().getSize());
//				
//		    	ps.addBatch();
//		    	ps.executeBatch();
//		    	ps.close(); 
//		    	con.close();
//		    	
//			System.out.println("****Successful");
//			
//			return true;
//			
//		}catch (Exception e) {
//			System.err.println("Exception: "+e.getMessage());
//			return false;
//		}
//	}

}
