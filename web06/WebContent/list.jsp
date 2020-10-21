<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>

<body>
	<table width = "1024" align = "center">
		<tr>
			<td>
				<img alt = "" src = "img/logo.png">
			</td>
		</tr>
		<tr>
			<td bgcolor = "gray" align = "center">
				<a href = "./index.jsp">[HOME]</a>
				<a href = "./list.jsp">[E M P]</a>
				<a href = "#">[DEPT]</a>
				<a href = "#">[LOGIN]</a>
			</td>
		</tr>
		<tr>
			<td>
			<!-- center start -->
			<h1 align = "center">목록</h1>
			<table border = "1" align = "center" width = "900" bgcolor = "#cccccc">
				<tr>
					<th>사번</th>
					<th>이름</th>
					<th>날짜</th>
					<th>금액</th>
				</tr>
				<%
				com.bit.emp.Emp02List emp = new com.bit.emp.Emp02List();
				java.util.ArrayList<com.bit.emp.dto.Emp02Bean> list = emp.list();
				for(int i=0; i<list.size(); i++) {
					com.bit.emp.dto.Emp02Bean bean = list.get(i);
				%>
				<tr>
					<td><a href = "detail.jsp?idx=<%=bean.getSabun() %>"><%=bean.getSabun() %></a></td>
					<td><a href = "detail.jsp?idx=<%=bean.getSabun() %>"><%=bean.getName() %></a></td>
					<td><a href = "detail.jsp?idx=<%=bean.getSabun() %>"><%=bean.getNalja() %></a></td>
					<td><a href = "detail.jsp?idx=<%=bean.getSabun() %>"><%=bean.getPay() %></a></td>
				</tr>
				<%} %>
			</table>
			<!-- center end -->
			</td>
		</tr>
		<td><a href = "add.jsp">입력</a></td>
		<tr>
			<td bgcolor = "gray" align = "center">
			비트캠프 서울시 서초구 강남대로 459 (서초동, 백암빌딩)<br>
			Copyright (c) 비트캠프 All rights reserved.<br>
			</td>
		</tr>
	
	
	
	
	</table>

</body>
</html>