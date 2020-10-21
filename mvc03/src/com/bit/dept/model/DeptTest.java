package com.bit.dept.model;

import java.sql.SQLException;
import java.util.ArrayList;

public class DeptTest {

	public static void main(String[] args) {
		try {
			Dept04Dao dao = new Dept04Dao();
			System.out.println("connection: " + (dao.conn != null));

			// selectAll() test
			ArrayList<Dept04Dto> list = dao.selectAll(); 
			for(Dept04Dto bean : list){
				System.out.println(bean);
			}
			
			// insertOne() test
			dao = new Dept04Dao();
			System.out.println(dao.insertOne("È«º¸", "¼ö¿ø")>0); 
			
			// deleteOne() test
			dao = new Dept04Dao();
			System.out.println(dao.deleteOne(2)>0); 

			// maxDeptno() test
			dao = new Dept04Dao();
			int max = dao.maxDeptno();
			
			// updateOne() test
			dao = new Dept04Dao();
			Dept04Dto bean = new Dept04Dto(max, "edit1", "edit2");
			System.out.println(dao.updateOne(bean.getDeptno(), bean.getDname(), bean.getLoc())); 
	
			// selectOne() test
			dao = new Dept04Dao();
			bean = dao.selectOne(5); 
			System.out.println(bean);
			
			// rowCount() test
			dao = new Dept04Dao();
			System.out.println("rowCount:" + dao.rowCount()); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

}
