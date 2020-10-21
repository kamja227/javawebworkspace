package com.bit.emp;

import java.sql.*;

public class Oracle {
	// database �������� �޼ҵ�
	
	private Oracle() {
		/*
		 * ������ ����
		 * - �̱��� ����
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