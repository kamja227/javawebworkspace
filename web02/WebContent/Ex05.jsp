<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>request 내장객체</h1>
	<%
		System.out.println(request.toString());
		out.println("url : " + request.getRequestURL());
		out.println("<br>");
		out.println("server name : " + request.getServerName());
		out.println("<br>");
		out.println("server port : " + request.getServerPort());
		out.println("<br>");
		out.println("protocol : " + request.getProtocol());
		out.println("<br>");
		out.println("remote addr : " + request.getRemoteAddr());
		out.println("<br>");
		out.println("remote port : " + request.getRemotePort());
		out.println("<br>");
		out.println("path : " + request.getContextPath());
		out.println("<br>");
		out.println("uri : " + request.getRequestURI());
		
	%>

</body>
</html>