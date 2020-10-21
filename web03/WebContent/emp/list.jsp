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
			<h1>EMP LIST PAGE</h1>
			<table border = "1" width = "800" cellspacing="0">
				<tr>
					<th width = "55" bgcolor = "#aaaaaa">EMPNO</th>
					<th bgcolor = "#aaaaaa">ENAME</th>
					<th bgcolor = "#aaaaaa">DNAME</th>
					<th bgcolor = "#aaaaaa">LOC</th>
				</tr>
				<% 
				String sql = "select empno, ename, dname, loc from emp inner join dept using (deptno)";
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
					int cnt = 0;
					while(rs.next()) {
						String bg = "";
						if(cnt++%2 == 1) { bg = "bgcolor=\"#cccccc\"";}
				%>
				<tr>
					<td <%=bg%> ><a href = "detail.jsp?empno=<%=rs.getInt(1)%>"><%=rs.getInt(1) %></a></td>
					<td <%=bg%> ><%=rs.getString(2) %></td>
					<td <%=bg%> ><%=rs.getString(3) %></td>
					<td <%=bg%> ><%=rs.getString(4) %></td>
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