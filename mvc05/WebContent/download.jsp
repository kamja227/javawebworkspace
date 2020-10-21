<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="template/header.jspf" %>
	<h1>업로드 완료</h1>
	<%--<a target="_blank" href="up/${rename }" >${origin }</a> --%>
	<a target="_blank" href="download.bit?file=${rename }&origin=${origin }" >${origin }</a>
</body>
</html>