package com.bit.emp;

import java.sql.*;

public class Emp02Insert {
// 프로시저 호출 방법
	public void insert(int sabun, String name, int pay) {
		// sql = {call 프로시저명}
		
		String sql = "{call emp02insert(" + sabun + ", '"+ name +"', " + pay + ")}";
		Connection conn = null;
		CallableStatement cstmt = null;
		try {
			conn = Oracle.getConnection();
			cstmt = conn.prepareCall(sql);
			cstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(cstmt != null) cstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		Emp02Insert me = new Emp02Insert();

	}

	
} // Emp02Insert end
