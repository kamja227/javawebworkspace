<%@page import="java.util.ArrayList"%>
<%@page import="com.bit.model.dto.ClassDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Noto+Sans+KR:wght@100;500&display=swap" rel="stylesheet"/>
    <link href="../css/atemplate.css" rel="stylesheet" type="text/css"/>
    <link href="../css/butan.css" rel="stylesheet" type="text/css"/>
    <style rel="stylesheet" type="text/css">
    	h2{
    		text-align: center;
    	}
    	
    </style>
	<script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="../js/menu.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
				$('.Dselect').hide();
			
			$('#delete').on('click',function(){
				$('.Dselect').show(function(){
				$('#delete').attr("type","submit");
				});
			})
			/* .stop().$('#delete').on('click',function(){
				
			 });*/
			
			
				
			
			
		});
	</script>
</head>
<body>
<%@ include file="../template/adminheader.jspf" %>
<%@ include file="../template/adminmenu.jspf" %>
	<div id="content">
	<h2>교육 과정 관리 페이지</h2>
		<!--content start  -->
		<form method="post">
		<table class="table">
		<tr class="row">
			<th class="thd Dselect" >삭제선택</th>
			<th class="thd">교육 과정명/과목</th>
			<th class="thd">시작일</th>
			<th class="thd">종료일</th>
			<th class="thd">신청 인원</th>
			<th class="thd">상태</th>
		</tr>
		
		<c:forEach items="${classlist }" var="bean">
		<tr class="row">
			<td class="tsub Dselect"><input type="checkbox" name="${bean.classIdx }"/></td>
			<td class="tsub"><a class="an" href="acoursedetail.bit?idx=${bean.classIdx }">${bean.classTitle}</a></td>
			<td class="tsub"><a class="an" href="acoursedetail.bit?idx=${bean.classIdx }">${bean.startDate}</a></td>
			<td class="tsub"><a class="an" href="acoursedetail.bit?idx=${bean.classIdx }">${bean.endDate }</a></td>
			<td class="tsub"><a class="an" href="acoursedetail.bit?idx=${bean.classIdx }">${bean.cnt }</a></td>
			<c:if test="${bean.status eq 0}"><td class="tsub"><a class="an" href="#">모집 전</a></td></c:if>
			<c:if test="${bean.status eq 1}"><td class="tsub"><a class="an" href="#">모집 중</a></td></c:if>
			<c:if test="${bean.status eq 2}"><td class="tsub"><a class="an" href="#">모집 마감</a></td></c:if>
		</tr>
		</c:forEach>
		<tr class="row">
			<td class="tsub">
				<button id="delete" class="buttn" type="button">삭제</button>
			</td>
		
		</tr>
		</table>
		</form>
		
		<!--content end  -->
	</div>
<%@ include file="../template/adminfooter.jspf" %>
</body>
</html>