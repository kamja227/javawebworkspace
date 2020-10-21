<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.bit.model.dto.AttendanceDto, java.util.ArrayList, java.text.SimpleDateFormat, java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/butan.css"/>
<link rel="stylesheet" type="text/css" href="../css/atemplate.css"/>
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Noto+Sans+KR:wght@100;500&display=swap" rel="stylesheet"/>
<style rel="stylesheet" type="text/css">
	
	#content{
		margin-top:100px;
		text-align: center;
		width: 1000px;
	}
	
	#etc{
		padding:0px;
		height: 50px;
		
	}
	input{
		margin-top:10px;
	}
	
	
</style>
<script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="../js/buttonjs.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#back').on('click',function(){
		window.history.back();
	});
	
	$('#searchbtn').click(function(){
		var search1 = ($('#search1').val());
		var search2 = ($('#search2').val());
		console.log(search1);
		console.log(search2);
		/*
		location.href="http://localhost:8080/LMSsystem/admin/astudentlist.bit?search1=" + search1 + 
		 "&search2=" + search2 + "&today=" + date;
		*/
	});
});


var getUrlParameter = function getUrlParameter(sParam) {
    var sPageURL = window.location.search.substring(1),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : decodeURIComponent(sParameterName[1]);
        }
    }
};


</script>
</head>

<body>
<%@ include file="../template/adminheader.jspf" %>
<%@ include file="../template/adminmenu.jspf" %>

<div id="content">
<!-- content start -->
	<h2>학생 관리 페이지</h2>

	<select id="search1">
		<option value="">반 선택</option>
		<c:forEach items="${classlist}" var="class">
		<option value="${class.classIdx }">${class.classTitle }</option>
		</c:forEach>
	</select>
	
	<input type="text" placeholder="교육과정명 or 과목명을 검색하세요." id="search2" />
	<button type="button" class="buttn" id="searchbtn" style="cursor: pointer;">검색</button>
	
	<table class="table">
	
	 <tr class="title row">
	 	<th class="thd">수강 과정명</th>
	 	<th class="thd">이름</th>
	 	<th class="thd">연락처</th>
	 </tr>
	 	<c:forEach items="${list }" var="bean">
		<tr class="row">
			<td class="tsub"><a href="${detail }" class="an">${bean.classTitle }</a></td>
			<td class="tsub"><a href="${detail }" class="an">${bean.name }</a></td>
			<td class="tsub"><a href="${detail }" class="an">${bean.contact }</a></td>
		</tr>
		</c:forEach>
	</table>
	
	 <div class="bt">
	 	<button type="button" class="buttn" id="back" style="cursor: pointer;">뒤로</button>
	 		<c:url value="aattendanceedit.bit" var="edit">
				<c:param name="classIdx" value="${classIdx }"/>
				<c:param name="classTitle" value="${classTitle }"/>
				<c:param name="today" value="${today }"/>
			</c:url>
	 	<button type="button" class="buttn"><a class="an" href="${edit }">수정</a></button>
	 </div>
<!-- content end -->
</div>

<%@ include file="../template/adminfooter.jspf" %>
</body>
</html>