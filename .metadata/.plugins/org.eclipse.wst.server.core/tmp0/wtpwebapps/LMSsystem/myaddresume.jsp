<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link href="css/butan.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="css/jquery.bxslider.css"/>
    <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Noto+Sans+KR:wght@100;500&display=swap" rel="stylesheet"/>
    <link href="css/atemplate.css" rel="stylesheet" type="text/css"/>
    <style rel="stylesheet" type="text/css">
    	.resume{
    		text-align: center;
    	}
    	.resumeti{

    		text-align: center;
    	}
    	.resumeti>lable{
    		padding-left: -100px;
    	}
    	.resumeti>input{
    		width: 800px;
    		margin:10px;
    		font-size: 20px;
    		
    	}
    	.resumeta{
    		text-align: center;
    		margin:0px auto;
    		padding-top: 50px;
    	}
    	.resumeta>textarea{
    		height: 500px;
    		margin:0px auto;
    		width: 800px;
    	}
    	
    </style>

</head>
<body>
<%@ include file="template/myheader.jspf" %>
<%@ include file="template/mymenu.jspf" %>
	<div id="content">
		<!--content start  -->
		<div class="resume">
			<h2>이력서 작성</h2>
		</div>
		<div class = "resumeti">
			<label>이름</label>
			<input type="text">
		</div>
		<div class = "resumeti">
			<label>전화번호</label>
			<input type="text">
		</div>
		<div class = "resumeti">
			<label>이메일</label>
			<input type="text">
		</div>
		
		<form method="post">
			<div class = "resumeti">
				<label>제목</label>
				<input type="text" name = "resumeTitle">
			</div>
	
			<div class="resumeta" >
				<textarea name = "resumeContent"></textarea>
			</div>
				
			<div class="btn1">
				<button class="buttn" type="submit">입력</button>
				<button class="buttn" type="reset">취소</button>
			</div>
		</form>
		<!--content end  -->
	</div>
<%@ include file="template/myfooter.jspf" %>
</body>
</html>
