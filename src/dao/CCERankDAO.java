package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.CCERank;

public class CCERankDAO {
	 String url = "jdbc:mysql://127.0.0.1/pup_pasuc?user=root&password=password&useSSL=false";
	 String table = "pup_pasuc.cce_rank";
	 Connection con = null;
	 Statement sta = null;
	 ResultSet rs = null;

	public List<CCERank> getCCERank(){
		System.out.println("****DAO: Get CCE Rank");
	    List<CCERank> cce_rank = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			sta = con.createStatement(); 
			String query = "SELECT * FROM " + table; 
			rs = sta.executeQuery(query); 
			
			while(rs.next()) {
			    CCERank cr = new CCERank();
				cr.setRankId(rs.getString("rank_id"));
				cr.setRankName(rs.getString("rank_name"));
				cr.setPtsMin(rs.getInt("pts_min"));
				cr.setPtsMax(rs.getInt("pts_max"));
				cce_rank.add(cr);
			}
			
			rs.close(); 
			sta.close(); 
		    con.close();
		    	
			return cce_rank;
		}catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
			return null;
		}
	}

	public String getRank(int score){
	System.out.println("****DAO: Get Rank with score of " + score);
	   String rank = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			sta = con.createStatement(); 
			String query = "SELECT * FROM " + table; 
			rs = sta.executeQuery(query); 
			
			while(rs.next()) {
				
				int ptsMin = rs.getInt("pts_min");
				int ptsMax = rs.getInt("pts_max");
				
				if (score >= ptsMin && score <= ptsMax) {
					rank = rs.getString("rank_name");
				}
				System.out.println("Rank " + rank + " " + ptsMin + "-" + ptsMax);
				
			}
			
			rs.close(); 
			sta.close(); 
		    con.close();
		    	
			return rank;
		}catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
			return null;
		}
	}

	
//	public  boolean update(CCERank CS){ // DONE
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
