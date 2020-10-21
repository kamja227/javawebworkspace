package com.bit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bit.Mysql.MysqlConnection;
import com.bit.model.dto.ClassRoomDto;

public class ClassRoomDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	public ClassRoomDao() {
		try {
			conn=MysqlConnection.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//��� Ŭ������ ���� ��������
	public List<ClassRoomDto> getClassRoom(){
		String sql="select * from classroom";
		
		List<ClassRoomDto> list = new ArrayList<ClassRoomDto>();
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				ClassRoomDto bean = new ClassRoomDto(rs.getInt("roomNum"), rs.getInt("inUse"));
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	//�� �ѹ��� ��� ������ �ٲ��ִ� �޼��� (��ѹ� �Ķ���� �־��ּ���)
	public int UpdateInUse(int roomNum) throws SQLException{
		String sql = "update classroom set inUse=0 where roomNum=?";
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, roomNum);
			return pstmt.executeUpdate();
		}finally{
			
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
	}
	
	// class���̺��� ����Ǿ� �ִ� Classroom�� ��� ������ roomnum���� �ٲ��ְ� inUse=0���� �ٲ��ְ� �̹� ����Ǿ� �־���
	// Ŭ���� ���� inUse=1���� ������ִ� �޼��� �Դϴ�.
	// ClassNum�� �̹� �����Ǿ� �ִ� ���ǽ��� ClassNum �־��ֽð�, roomNum�� �ٲ� ���ǽ��� �־��ֽø� �˴ϴ�.
	public int SelectedClassroomChange(int ClassNum,int roomNum) throws SQLException{
		String sql1 = "update classroom set inUse=1 where roomNum=?";
		String sql2 = "update classroom set inUse=0 where roomNum=?";
		
		try{
			pstmt=conn.prepareStatement(sql1);
			pstmt.setInt(1, ClassNum);
			int result=pstmt.executeUpdate();
			pstmt.close();
			pstmt=conn.prepareStatement(sql2);
			pstmt.setInt(1, roomNum);
			return result+= pstmt.executeUpdate();
			
		}finally{
			
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
	}

}
