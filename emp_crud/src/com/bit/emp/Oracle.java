package com.bit.emp;

import java.sql.*;

public class Oracle {
	// database 접속해줄 메소드
	
	private Oracle() {
		/*
		 * 디자인 패턴
		 * - 싱글톤 패턴
		*/
	}
	private static Connection conn;
	
	public static Connection getConnection() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		try {
			if(conn == null || conn.isClosed()) {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}	
	
}
