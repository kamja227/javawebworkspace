package com.bit.emp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class Emp02Update {

	public int update(int sabun, String name, int pay) {
		String sql = "{call emp02update(?, '"+ name +"',"+ pay +","+ sabun +")}";
		CallableStatement cstmt = null;

		int result = 0;
		try {
			cstmt = Oracle.getConnection().prepareCall(sql);
			cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.INTEGER);
			cstmt.execute();
			
			result = cstmt.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(cstmt != null) cstmt.close();
				if(Oracle.getConnection() != null) Oracle.getConnection().close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
		
	}

}
