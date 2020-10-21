<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.sql.*, java.util.*, com.bit.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<%
ArrayList<EmpDto> list = new ArrayList<EmpDto>();
Connection conn = null;
Statement stmt = null;
ResultSet rs = null;
try{
	conn = MyOracle.getConnection();
	stmt = conn.createStatement();
	rs = stmt.executeQuery("select * from emp02");
	while(rs.next()) {
		EmpDto bean = new EmpDto();
		bean.setSabun(rs.getInt("sabun"));
		bean.setName(rs.getString("name"));
		bean.setNalja(rs.getDate("nalja"));
		bean.setPay(rs.getInt("pay"));
		list.add(bean);
	}
}finally{
		if(rs != null)rs.close();
		if(stmt != null)stmt.close();
		if(conn != null)conn.close();
}
%>
<body>
	<h1>리스트페이지</h1>
	<table width = "800">
		<tr>
			<td>사번</td>
			<td>이름</td>
			<td>날짜</td>
			<td>금액</td>
		</tr>
		<%
		for(EmpDto bean : list) {
		%>
		<tr>
			<td><a href="?title=emp/detail&sabun=<%=bean.getSabun() %>"><%=bean.getSabun() %></a></td>
			<td><a href="?title=emp/detail&sabun=<%=bean.getSabun() %>"><%=bean.getName() %></a></td>
			<td><a href="?title=emp/detail&sabun=<%=bean.getSabun() %>"><%=bean.getNalja() %></a></td>
			<td><a href="?title=emp/detail&sabun=<%=bean.getSabun() %>"><%=bean.getPay() %></a></td>
		</tr>
		<%} %>

	</table>
	<a href="?title=emp/add">[입 력]</a>
	<a href="?title=emp/add">[입 력]</a>
	
</body>
</html>