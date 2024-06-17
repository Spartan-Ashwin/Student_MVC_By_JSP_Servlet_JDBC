package com.stdentmvc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlUtil {
	

	final static String DB_USER="root";
	final static String DB_PASSWORD="Special@26";
	final static String DB_NAME="jdbcdemo1";
	final static String DB_URL="jdbc:mysql://localhost:3306/"+DB_NAME;
	final static String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
	
	static Connection con;
	static Statement sta;
	
	static public void connectDb() throws ClassNotFoundException, SQLException{
		
		Class.forName(JDBC_DRIVER);
		con=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
		sta=con.createStatement();
	}
	
	static public int insert(String query) throws SQLException {
		
		int result=-1;
		query=query.trim();
		if(query.length()!=0) {
			
			result=sta.executeUpdate(query);
			
		}
		return result;
		
	}
	
     static public int update(String query) throws SQLException {
		
		int result=-1;
		query=query.trim();
		if(query.length()!=0) {
			
			result=sta.executeUpdate(query);
			
		}
		return result;
		
	}
     
     static public int delete(String query) throws SQLException {
 		
 		int result=-1;
 		query=query.trim();
 		if(query.length()!=0) {
 			
 			result=sta.executeUpdate(query);
 			
 		}
 		return result;
 		
 	}
     
     static public ResultSet fetch(String query) throws SQLException {
    	 
    	 ResultSet rs=null;
  		query=query.trim();
  		if(query.length()!=0) {
  			rs=sta.executeQuery(query);
  		}
    	 return rs;
     }
     
     static public void close() throws SQLException {
    	 if(con!=null)
    		 con.close();
    	 
    	 if(sta!=null)
    		 sta.close();
    	  
    	 
     }

}
