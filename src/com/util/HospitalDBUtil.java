	package com.util;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;

	public class HospitalDBUtil {
		public static final String URL="jdbc:oracle:thin:@localhost:1521:orcl";
		public static final String DRIVER_NAME="oracle.jdbc.driver.OracleDriver";
		public static final String USERNAME="system";
		public static final String PASSWORD="Jarvish123";

		public static Connection getConnection() {
			Connection con=null;
			try {
				Class.forName(DRIVER_NAME);
				//System.out.println("database util");
				con=DriverManager.getConnection(URL, USERNAME, PASSWORD);
				
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
			} 
			return con;
		}
		public static void closeConnection(Connection con) {
			if(con!=null) {
				try {
					con.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		public static void closeStatement(PreparedStatement ps) {
			if(ps!=null) {
				try {
					ps.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}


