<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSL</h1>
	<jsp:useBean id="bean1" scope="page" class="com.bit.model.JavaBean"></jsp:useBean>
	<c:set target="${bean1 }" property="su1" value="4321"></c:set>
	<c:set target="${bean1 }" property="su2" value="4.14"></c:set>
	<c:set target="${bean1 }" property="name" value="ABCD"></c:set>
	
	<ol>
		<li>${bean1.su1 }</li>
		<li>${bean1.su2 }</li>
		<li>${bean1.name }</li>
	</ol>
	
	<!-- 
	<jsp:setProperty property="su1" name="bean1" value="1234" />
	<jsp:setProperty property="su2" name="bean1" value="3.14" />
	<jsp:setProperty property="name" name="bean1" value="test" />

	<ol>
		<li><jsp:getProperty property="su1" name="bean1"/><</li>
		<li><jsp:getProperty property="su2" name="bean1"/><</li>
		<li><jsp:getProperty property="name" name="bean1"/><</li>
	</ol>
	-->
	
</body>
</html>