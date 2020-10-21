<%@page import="java.util.StringTokenizer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL etc...</h1>
	<%
		String msg = "java, DB, web,, framework, app";
		pageContext.setAttribute("msg", msg);
	
		/* 구분자 사이에 데이터가 없는 경우, ''데이터를 데이터로 취급한다.
		String[] result = msg.split(",");
		for(String st : result){
			System.out.println(st);
		}
		*/
		
		//구분자 사이에 데이터가 없는 경우, 데이터로 취급하지 않는다.
		StringTokenizer stToken = new StringTokenizer(msg, ",");
		while(stToken.hasMoreTokens()){
			System.out.println(stToken.nextToken());
		}
	%>
	
	<!-- forToken: StringTokenizer와 비슷한 기능을 수행한다. -->
	<ul>
		<c:forTokens items="${msg }" delims=","  var="ele">
			<li>${ele }</li>
		</c:forTokens>
	</ul>
	
	<div>
		<c:import url="https://www.bitcamp.co.kr"></c:import>
	</div>
</body>
</html>