package com.bit.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bit.model.dto.ClassDto;
   
public class ClassDao {
   private Connection conn;
   private PreparedStatement pstmt;
   private ResultSet rs;
   
   public ClassDao() throws SQLException{
		
		try { // jdbc connect j 라이브러리 로딩 예외 처리
			 Class.forName("com.mysql.cj.jdbc.Driver"); // 해당 클래스가 메모리에 로드 및 실행
	         String url = "jdbc:mysql://192.168.0.216:2080/lmssystem?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
//	          String url = "jdbc:mysql://localhost:3306/lmssystem?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
	         String user = "server3zo";
//	          String user = "root";
	         String password = "123456";
//	         String password = "0494";
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: " + e.getMessage());
		} 
		
	}
   
   public ArrayList<ClassDto> selectAll(){
	   String sql = "SELECT @RNUM := @RNUM + 1 AS rownum, a.* "
			   	+ " FROM (SELECT * FROM class where deleted=0 ORDER BY classIdx DESC  ) a, "
			   	+ " ( SELECT @RNUM := 0 ) b";
//      String sql="select @rownum=@rownum+1 as rownum, * from class where deleted=0 order by startDate";
	  
      ArrayList<ClassDto> list = new ArrayList<ClassDto>();
      try {
    		pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
         while(rs.next()){
            ClassDto bean = new ClassDto();
            bean.setClassIdx(rs.getInt("classIdx"));
            bean.setClassTitle(rs.getString("classTitle"));
            bean.setSubjectTitle(rs.getString("subjectTitle"));
            bean.setStartDate(rs.getDate("startDate"));
            bean.setEndDate(rs.getDate("endDate"));
            bean.setCnt(rs.getInt("cnt"));
            bean.setStatus(rs.getInt("status"));
            bean.setRownum(rs.getInt("rownum"));
            list.add(bean);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally{
         try {
        	if(rs != null) rs.close();
        	if(pstmt != null) pstmt.close();
            if(conn!=null)conn.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
      
      return list;
   }

   public ClassDto selectOne(int classIdx){
	      String sql="select * from class where deleted=0 and classIdx=?";
	      ClassDto bean = null;
	      
	      try {
	    		pstmt = conn.prepareStatement(sql);
	    		pstmt.setInt(1, classIdx);
				rs = pstmt.executeQuery();
	         if(rs.next()){
	            bean = new ClassDto(rs.getInt("classIdx"), rs.getString("classTitle"), rs.getString("subjectTitle"), 
	            		rs.getInt("teacherId"), rs.getDate("startDate"), rs.getDate("endDate"), rs.getInt("managerId"), 
	            		rs.getInt("classRoom"), rs.getInt("cnt"), rs.getInt("status"), rs.getString("etc"), rs.getInt("deleted"));
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally{
	         try {
	        	if(rs != null) rs.close();
	        	if(pstmt != null) pstmt.close();
	            if(conn != null)conn.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	      
	      return bean;
  } // selectOne end
   
// 정보수정 및 학생 관리 수정
	public int  updateOne(int classIdx, String classTitle, String subjectTitle, int teacherId, Date startDate, 
			Date endDate, int managerId, int classRoom, int status, String etc) throws SQLException {
		String sql = "update Class set classTitle=?, subjectTitle=?, teacherId=?, startDate=?, endDate=?, managerId=?, "
				+ "classRoom=?, status=?, etc=? where classIdx=?";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, classTitle);
			pstmt.setString(2, subjectTitle);
			pstmt.setInt(3, teacherId);
			pstmt.setDate(4, startDate);
			pstmt.setDate(5, endDate);
			pstmt.setInt(6, managerId);
			pstmt.setInt(7, classRoom);
			pstmt.setInt(8, status);
			pstmt.setString(9, etc);
			pstmt.setInt(10, classIdx);
			
			return pstmt.executeUpdate();
		}finally{
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
	} // updateOne end
	
	// 교육 등록
	public int insertOne(String classTitle, String subjectTitle, int teacherId, Date startDate, Date endDate, 
			int managerId, int classRoom, int status, String etc) throws SQLException {
		String sql = "insert into Class(classTitle, subjectTitle, teacherId, startDate, endDate, "
				+ "managerId, classRoom, status, etc) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, classTitle);
			pstmt.setString(2, subjectTitle);
			pstmt.setInt(3, teacherId);
			pstmt.setDate(4, startDate);
			pstmt.setDate(5, endDate);
			pstmt.setInt(6, managerId);
			pstmt.setInt(7, classRoom);
			pstmt.setInt(8, status);
			pstmt.setString(9, etc);
			
			return pstmt.executeUpdate();
		}finally{
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
	} // insertOne end
	
	// 수강신청시, cnt 칼럼 값 증가
	public int enrolledStudent(int classIdx, int cnt) throws SQLException {
		String sql = "update Class set cnt=cnt+1 where deleted=0 and classIdx=?";
		if(cnt >= 29) {
			sql = "update Class set cnt=30, status=2 where deleted=0 and classIdx=?";
		}
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, classIdx);
			
			return pstmt.executeUpdate();
		} finally{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
	} // enrolledStudent end
	
	// 수강취소시, cnt 칼럼 값 감소
	public int canceledStudent(int classIdx, int cnt) throws SQLException {
		String sql = "update Class set cnt=cnt-1 where deleted=0 and classIdx=?";
		if(cnt <= 1) return -1;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, classIdx);
			return pstmt.executeUpdate();
		} finally{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
	} // canceledStudent end
	
	public int rowCount() throws SQLException{
		String sql = "select count(*) as cnt from Class where deleted=0";
		try{
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) return rs.getInt("cnt");
		} finally{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
		return 0;
	} // rowCount end
}