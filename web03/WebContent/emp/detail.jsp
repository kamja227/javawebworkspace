<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table width = "100%">
	<tr>
		<td colspan = "6"><img src = "../img/logo.png"></td>
	</tr>
	<tr>
		<td bgcolor = "gray"> </td>
		<td bgcolor = "#aaaaaaa" width = "120" align = "CENTER"> <a href = "../index.jsp"> [HOME] </a></td>
		<td bgcolor = "#aaaaaaa" width = "120" align = "CENTER"> <a href = "../dept/list.jsp"> [DEPT] </a></td>
		<td bgcolor = "#aaaaaaa" width = "120" align = "CENTER"> <a href = "list.jsp"> [E M P] </a></td>
		<td bgcolor = "#aaaaaaa" width = "120" align = "CENTER"> <a href = "../login/list.jsp"> [LOGIN] </a></td>
		<td bgcolor = "gray"> </td>
	</tr>
	<tr>
		<td colspan = "6">
		<!-- content start -->
		<center>
			<h1>EMP DETAIL PAGE</h1>
			<table border = "1" width = "800" cellspacing="0">
				<% 
				String empno = request.getParameter("empno");
				String sql = "select empno, ename,job,mgr,hiredate,sal,comm,";
				sql += "(select dname from dept where dept.deptno = emp.deptno)";
				sql += "from emp where empno =" + empno;
				
				String driver = "oracle.jdbc.driver.OracleDriver";
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "scott";
				String password = "tiger";
				
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				
				try {
					Class.forName(driver);
					conn = DriverManager.getConnection(url, user, password);
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql);
					if(rs.next()) {
				%>
				<tr>
					<td bgcolor = "#aaaaaa" align = "CENTER"><font color = "white">empno</font></td>
					<td><%=rs.getString(1) %></td>
				</tr>
				<tr>
					<td bgcolor = "#aaaaaa" align = "CENTER"><font color = "white">ename</font></td>
					<td><%=rs.getString(2) %></td>
				</tr>
				<tr>
					<td bgcolor = "#aaaaaa" align = "CENTER"><font color = "white">job</font></td>
					<td><%=rs.getString(3) %></td>
				</tr>
				<tr>
					<td bgcolor = "#aaaaaa" align = "CENTER"><font color = "white">mgr</font></td>
					<td><%=rs.getString(4) %></td>
				</tr>
				<tr>
					<td bgcolor = "#aaaaaa" align = "CENTER"><font color = "white">hiredate</font></td>
					<td><%=rs.getString(5) %></td>
				</tr>
				<tr>
					<td bgcolor = "#aaaaaa" align = "CENTER"><font color = "white">sal</font></td>
					<td><%=rs.getString(6) %></td>
				</tr>
				<tr>
					<td bgcolor = "#aaaaaa" align = "CENTER"><font color = "white">comm</font></td>
					<td><%=rs.getString(7) %></td>
				</tr>
				<tr>
					<td bgcolor = "#aaaaaa" align = "CENTER"><font color = "white">dname</font></td>
					<td><%=rs.getString(8) %></td>
				</tr>
				<tr>
					<td calspan = "2" align = "CENTER">
						<a href = "edit.jsp?empno=<%=rs.getInt(1)%>">[수 정]</a>
						<a href = "edit.jsp?empno=<%=rs.getInt(1)%>">[삭 제]</a>
					</td>
					<td></td>
				</tr>

				<% 
						}
					} finally {
						if(rs != null) rs.close();
						if(stmt != null) stmt.close();
						if(conn != null) conn.close();
					}
				%>
			</center>
			</table>
			<a href = "add.jsp">[입 력]</a>
		<!-- content start -->
		</td>		
	</tr>
	<tr>
		<td colspan = "6" bgcolor = "gray" align = "CENTER">
			비트캠프 서울시 서초구 강남대로 459 (서초동, 백암빌딩) 사업자등록번호 : 214-85-24928 <br>
			(주)비트컴퓨터 서초본원 대표이사 : 조현정 / 문의 : 02-3486-9600 / 팩스 : 02-6007-1245 <br>
			통신판매업 신고번호 : 제 서초-00098호 / 개인정보보호관리책임자 : 최종진 <br>
			Copyright (c) 비트캠프 All rights reserved. 
		</td>
	</tr>
</table>
</body>
</html>