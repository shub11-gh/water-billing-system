package com.reva.water.util;

import java.sql.Connection;
import java.sql.DriverManager;
import io.github.cdimascio.dotenv.Dotenv;

public class DBUtil {
	private static String url = dotenv.get("DB_URL");
	private static String user = dotenv.get("DB_USER");
	private static String password = dotenv.get("DB_PASSWORD");
	
	public static Connection getDBConnection(){
		Connection conn=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
			if(conn!=null) 
			{
				System.out.println("Connection Successful");
			}
		}
		
		catch(Exception e){
			e.printStackTrace();
		}

		return conn;
	}
}
