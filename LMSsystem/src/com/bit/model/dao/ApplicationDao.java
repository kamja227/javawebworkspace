package com.bit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bit.Mysql.MysqlConnection;
import com.bit.model.dto.ApplicationDto;

public class ApplicationDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public List<ApplicationDto> getSelectAll() {
		List<ApplicationDto> list= new ArrayList<ApplicationDto>();
		try {
			String sql="select *from Application where deleted=0";
			
			conn=MysqlConnection.getConnection();
		    pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				ApplicationDto bean= new ApplicationDto();
				bean.setApplicationIdx(rs.getInt("applicationIdx"));
				bean.setApplicantIdx(rs.getInt("applicantIdx"));
				bean.setResumeIdx(rs.getInt("resumeIdx"));
				bean.setRecruitmentBoardIdx(rs.getInt("recruitmentBoardIdx"));
				bean.setEnrolledDate(rs.getDate("enrolledDate"));
				bean.setStatus(rs.getString("status"));
				list.add(bean);
			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
			
				if(rs!=null)	rs.close();
				if(pstmt!=null)	pstmt.close();
				if(conn!=null)	conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
				
		}
		return list;
	} // getSelectAll end
	
	public ApplicationDto selectOne(int applicationIdx){

		ApplicationDto bean= new ApplicationDto();
		try {
			String sql="select application.*, student.name as studentName from Application "
					+ "join Student on applicaton.applicantIdx = student.studentIdx "
					+ "where applicationIdx = ? student.deleted=0 application.deleted=0";
			
			conn=MysqlConnection.getConnection();
		    pstmt=conn.prepareStatement(sql);
		    pstmt.setInt(1, applicationIdx);
			rs=pstmt.executeQuery();
			if (rs.next()) {
				bean= new ApplicationDto();
				bean.setApplicationIdx(rs.getInt("applicationIdx"));
				bean.setApplicantIdx(rs.getInt("applicantIdx"));
				bean.setResumeIdx(rs.getInt("resumeIdx"));
				bean.setRecruitmentBoardIdx(rs.getInt("recruitmentBoardIdx"));
				bean.setEnrolledDate(rs.getDate("enrolledDate"));
				bean.setStatus(rs.getString("status"));
				bean.setStudentName(rs.getString("studentName"));
				
			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
			
				if(rs!=null)	rs.close();
				if(pstmt!=null)	pstmt.close();
				if(conn!=null)	conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}

		}
		return bean;
	} // selectOne end
	
	// 지원하기
	public int insertOne(int studentIdx, int resumeIdx, int recruitmentboardIdx) throws SQLException, ClassNotFoundException {
		String sql = "insert into Application(applicantIdx, resumeIdx, recruitmentboardIdx, enrolledDate) values (?, ?, ?, ?)";
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		Date time = new Date();
		String now = format1.format(time);
		
		System.out.println(studentIdx + ", " + resumeIdx + ", " + recruitmentboardIdx + ", " + now);
		
		try{
			conn=MysqlConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, studentIdx);
			pstmt.setInt(2, resumeIdx);
			pstmt.setInt(3, recruitmentboardIdx);
			pstmt.setString(4, now);
			
			return pstmt.executeUpdate();
		}finally{
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
	} // insertOne end
	
	//업데이트 status
	public int updateStatus(String status,int applicantIdx) throws SQLException, ClassNotFoundException{
		String sql = "update application set status=? where deleted=0 and applicantIdx=?";
		
		try{
			conn=MysqlConnection.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, status);
			pstmt.setInt(2, applicantIdx);
			return pstmt.executeUpdate();
			
		}finally{
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		
		
	} // updateStatus end
}
