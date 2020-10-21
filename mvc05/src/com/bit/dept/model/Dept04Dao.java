package com.bit.dept.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Dept04Dao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public Dept04Dao(){
		// connection pool API
		// https://tomcat.apache.org/tomcat-7.0-doc/jdbc-pool.html
		try {
			InitialContext init = new InitialContext();
			
			javax.sql.DataSource dataSource=null;
			dataSource=(DataSource) init.lookup("java:/comp/env/jdbc/oracle");
			
//			InitialContext init = new InitialContext();
//			javax.naming.Context context = null;
//			context=(Context) init.lookup("java:/comp/env");
//			
//			javax.sql.DataSource dataSource=null;
//			dataSource=(DataSource) context.lookup("jdbc/oracle");
			
			conn=dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
//		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
//												"scott", "tiger");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	} // Dept04Dao constructor end;
	
	public List<Dept04Dto> selectAll(){
		List<Dept04Dto> list = new ArrayList<Dept04Dto>();
		try {
			conn.setAutoCommit(false);
			// 커넥션이 동일해야한다.
//			pstmt = conn.prepareStatement("insert~~~~;commit"); // conn.setAutoCommit(true);
//			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("select * from dept04");
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				list.add(new Dept04Dto(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	} // selectAll end
}
