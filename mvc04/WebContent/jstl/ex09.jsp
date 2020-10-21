<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>param id:<%=request.getParameter("id") %></h2>
	<h2>param id:${param.id }</h2>
	<h2>param attr name:${name }</h2>
	<h2>param attr name:${requestScope.id }</h2>
	<form><button>이동</button></form>

</body>
</html>