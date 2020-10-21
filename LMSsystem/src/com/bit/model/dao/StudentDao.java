package com.bit.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bit.Mysql.MysqlConnection;
import com.bit.model.dto.StudentDto;

public class StudentDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public StudentDao() throws SQLException{
		
		try { // jdbc connect j ���̺귯�� �ε� ���� ó��
			 Class.forName("com.mysql.cj.jdbc.Driver"); // �ش� Ŭ������ �޸𸮿� �ε� �� ����
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
	
	public StudentDto login(String userId, String password) {
		String sql = "select * from Student where deleted=0 and userId=? and password=?";
		StudentDto bean = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()){
				bean = new StudentDto();
				bean.setStudentIdx(rs.getInt("studentIdx"));
				bean.setUserId(rs.getString("userId"));
				bean.setPassword(rs.getString("password"));
				bean.setName(rs.getString("name"));
				bean.setContact(rs.getString("contact"));
				bean.setEmail(rs.getString("email"));
				bean.setClassIdx(rs.getInt("classIdx"));
				bean.setMemo(rs.getString("memo"));
				bean.setDeleted(rs.getInt("deleted"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return bean;
	} // login end
	
	
	public ArrayList<StudentDto> selectAll(){		
		ArrayList<StudentDto> list = new ArrayList<StudentDto>();
		String sql = "select * from Student where deleted = 0 order by studentIdx asc";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				list.add(new StudentDto(rs.getInt("studentIdx"), rs.getString("userId"), rs.getString("password"), 
						rs.getString("name"), rs.getString("contact"), rs.getString("email"), 
						rs.getInt("classIdx"), rs.getString("memo"), rs.getInt("deleted")));
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
	
	
	public ArrayList<StudentDto> selectJoinAll(String search1, String search2 ) {
		String sql = "select Student.*, class.classTiitle as classTitle from Student "
				+ "join Class on student.classIdx = class.classIdx "
				+ "where Student.deleted=0 and Class.deleted=0 "
				+ search1 + " "
				+ search2 + " "
				+ "order by name asc";
		ArrayList<StudentDto> list = new ArrayList<StudentDto>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				StudentDto bean = new StudentDto();
				bean.setStudentIdx(rs.getInt("studentIdx"));
				bean.setUserId(rs.getString("userId"));
				bean.setPassword(rs.getString("password"));
				bean.setName(rs.getString("name"));
				bean.setContact(rs.getString("contact"));
				bean.setEmail(rs.getString("email"));
				bean.setClassIdx(rs.getInt("classIdx"));
				bean.setMemo(rs.getString("memo"));
				bean.setDeleted(rs.getInt("deleted"));
				bean.setClassTitle(rs.getString("classTitle"));
				list.add(bean);
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
	} // selectJoinAll end
	
	// �ݺ� �л� ������ ��������
	public ArrayList<StudentDto> classAll(int classIdx){
		ArrayList<StudentDto> list = new ArrayList<StudentDto>();
		String sql = "select * from Student where deleted = 0 and classIdx=? order by name";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, classIdx);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				list.add(new StudentDto(rs.getInt("studentIdx"), rs.getString("userId"), rs.getString("password"), 
						rs.getString("name"), rs.getString("contact"), rs.getString("email"), 
						rs.getInt("classIdx"), rs.getString("memo"), rs.getInt("deleted")));
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
	} // classAll end
	
	public StudentDto selectOne(int studentIdx){
		StudentDto bean = null;
		String sql = "select * from Student where deleted = 0 and studentIdx = ?";
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, studentIdx);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				bean = new StudentDto(rs.getInt("studentIdx"), rs.getString("userId"), rs.getString("password"), 
						rs.getString("name"), rs.getString("contact"), rs.getString("email"), 
						rs.getInt("classIdx"), rs.getString("memo"), rs.getInt("deleted"));
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
		return bean;
	} // selectOne end
	
	// �������� �� �л� ���� ����
	public int updateOne(int studentIdx, String password, String name, String contact, String email, int classIdx, String memo, int deleted) throws SQLException {
		String sql = "update Student set password=?, name=?, contact=?, email=?, classIdx=?, memo=?, "
				+ "deleted=? where studentIdx=?";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, name);
			pstmt.setString(3, contact);
			pstmt.setString(3, email);
			pstmt.setInt(4, classIdx);
			pstmt.setString(5, memo);
			pstmt.setInt(6, deleted);
			pstmt.setInt(7, studentIdx);
			
			return pstmt.executeUpdate();
		}finally{
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
	} // updateOne end
	
	
	
	
	
	//���������� �л���������
	public int updateinfoOne(String name,String contact,String email,String password,int studentIdx){
		String sql ="update student set name=?,contact=?,email=?,password=? where studentIdx=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, contact);
			pstmt.setString(3, email);
			pstmt.setString(4,password);
			pstmt.setInt(5, studentIdx);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
				try {
					if(conn != null)conn.close();
					if(pstmt != null) pstmt.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
		}
		return -1;
		
	}
	////���������� �л��������� end
	
	//���������� �л��������� ����Ʈ��
	   public ArrayList<StudentDto> getStudentInfo(int studentIdx){
		 String sql="select name,contact,email,password from student where studentIdx=?";
		 
		 ArrayList<StudentDto> list=new ArrayList<StudentDto>();  
		 try {
			conn=MysqlConnection.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,studentIdx);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				StudentDto bean=new StudentDto();
				bean.setName(rs.getString("name"));
				bean.setContact((rs.getString("contact")));
				bean.setEmail(rs.getString("email"));
				bean.setPassword(rs.getString("password"));
				list.add(bean);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	   }
	 //���������� �л��������� ����Ʈ�� end
	
	   
	// ȸ�� ����
	public int insertOne(String userId, String password, String name, String contact, String email) throws SQLException {
		String sql = "insert into Student(userId, password, name, contact, email) values (?, ?, ?, ?, ?)";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, password);
			pstmt.setString(3, name);
			pstmt.setString(4, contact);
			pstmt.setString(5, email);
			
			return pstmt.executeUpdate();
		}finally{
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
	} // insertOne end
	
	
	//ȸ������ ���̵��ߺ��˻�
		public int joinIdCheck(String userId) {
			String sql="select userId from student where userId=?";
			
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, userId);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					
					return 1;
				}
			
			} catch (SQLException e) {
				
				e.printStackTrace();
			}

			return -1;
			
		}
		// joinIdCheckend
		
	
	// ������û
	public int enrollClass(int studentIdx, int classIdx) throws SQLException {
			String sql = "update Student set classIdx=? where deleted=0 and studentIdx=?";
			try{
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, classIdx);
				pstmt.setInt(2, studentIdx);
				
				return pstmt.executeUpdate();
			}finally{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}
		} // enrolledClass end
	
	
	// �������
	public int cancelClass(int studentIdx) throws SQLException {
		String sql = "update Student set classIdx=0 where deleted=0 and studentIdx=?";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, studentIdx);
			
			return pstmt.executeUpdate();
		}finally{
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
	} // enrolledClass end
		
	
	public int rowCount() throws SQLException{
		String sql = "select count(*) as cnt from Student where deleted=0";
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
	
	// ���̵� ã��
	public String findUserId(String name, String contact) {
		String sql = "select userId from Student where deleted=0 and name=? and contact=?";
		String userId = "";
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, contact);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				userId = rs.getString("userId");
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
		return userId;
	} // findUserId end
	
	// ��й�ȣ ã��
	public String findPassword(String id, String name, String contact) {
		String sql = "select userId from Student where deleted=0 and userId=? name=? and contact=?";
		String userId = "";
		try {
			
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, contact);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				userId = rs.getString("userId");
				return userId;
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
		return userId;
	}
	
	public int updatePassword(String userId, String newPassword) throws SQLException {
		String sql = "update Student set password=? where deleted=0 and userId=?";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newPassword);
			pstmt.setString(1, userId);
			
			return pstmt.executeUpdate();
		}finally{
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
	} // findPassword end
	
	// ȸ�� Ż��
	public int deleteOne(int studentIdx) throws SQLException {
		String sql = "update Student set deleted=1 where deleted=0 and studentIdx=?";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, studentIdx);
			
			return pstmt.executeUpdate();
		}finally{
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
	}

	
}