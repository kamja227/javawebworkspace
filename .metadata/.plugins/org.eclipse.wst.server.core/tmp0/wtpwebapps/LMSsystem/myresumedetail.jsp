<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Insert title here</title>
    <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Noto+Sans+KR:wght@100;500&display=swap" rel="stylesheet"/>
    <link href="css/atemplate.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="css/butan.css">
    <style rel="stylesheet" type="text/css">
     
    </style>
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="js/buttonjs.js"></script>
</head>
<%@ include file="template/myheader.jspf" %>
<%@ include file="template/mymenu.jspf" %>
<body>
	<!--content start  -->
	<form method="post">
		<div>
		<table class="table">
			<tr class="row" >
				<th class="thd" colspan="2">이력서 조회</th>
			</tr>
			<c:forEach items= "${ResumeDetailList}" var="bean">
			<tr class="row">
				<th class="thd">제목</th>
				<td class="tsub"><input type="text" name="resumeTitle" id="resumeTitle" value="${bean.resumeTitle}"></td>
			</tr>
			<tr class="row">
				<th class="thd">내용</th>
				<td class="tsub"><textarea id="resumeContent" name = "resumeContent">${bean.resumeContent}</textarea></td>
			</tr>
			</c:forEach>
		</table>
		</div>
		<div>
			<button type="submit">수정</button>
			<button type="reset">삭제</button>
		</div>
			
		
	</form>
	<!--content end  -->
</body>
</html>
