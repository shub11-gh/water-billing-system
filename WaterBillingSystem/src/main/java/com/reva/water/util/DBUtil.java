package com.reva.water.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	private static String url = "jdbc:mysql://localhost:3306/water_billing_system";
	private static String user = "root";
	private static String password = "Shub@9611";
	
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
