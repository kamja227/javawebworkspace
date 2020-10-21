
<%@page import="java.util.ArrayList"%>
<%@page import="com.bit.model.dao.AttendanceDao"%>
<%@page import="com.bit.model.dto.AttendanceDto"%>
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

                 h2{
                  width: 95px;
                 }
                 
      .center>table {
    width: 300px;
    height:300px;
    border: 1px solid black;
      position: absolute;
      top:40%;
      left: 50%;
      transform:translate(-50%, -50%);
  
  }
  
  
  .page{
 
  background-color: yellow;
 
  
   
  }
    </style>
     <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
</head>
<%@ include file="template/myheader.jspf" %>
<%@ include file="template/mymenu.jspf" %>
<body>
	<!--content start  -->
<div class="center">
 <h2>출결확인</h2>
 <table class="table">
 	<tr class="row">
 	
	<th class="thd">날짜</th>
	<th class="thd">출석확인</th>
 	</tr>
 <%
 AttendanceDao dao=new AttendanceDao();
 int count=dao.selectCnt();

ArrayList<AttendanceDto>  list= (ArrayList<AttendanceDto>)request.getAttribute("attendancelist");
	

 %>
 <%
for(int i=0; i<list.size(); i++){
 %>

	
	<tr class="row">
	    <td  class="tsub"><%=list.get(i).getAttendDate()%></td>
	     <td  class="tsub"><%=list.get(i).getAttendanceStatus() %></td>
	     </tr>

<%

}

%>
    </table>
    
    
    <%
  
    	
  /*  
  로우수/10
  10 /10 = 1
  
  33 / 10 
 if (총로수우%10) != 0 
 	left = 1
 else
	left = 0	
  
	
	
	33 - 33%10 = 30
  
	페이지 링크 수 =( 총 로우수 -로우수%10)10 + left 을 더해줌
  */  	
	int left = -1;
  
	if(count%10 != 0){
		left = 1;
	}else{
		left = 0;
	}
	int totalPage = (count - count%10)/10 + left;
  
 	 for(int i=1; i<=totalPage; i++){
 		 
 		 /*
 		 
 		 start 0                                   page 1 2 3 4 5 
 		 		 11												
 		 		 21
 		 		 31
 		 		 41
 		 		 
 		 		 (clickP-1)*10+1          
 		 		 
 		 
 		 */
    %>
    <a href="myattendance.bit?page=<%=i%>" class="page">[<%=i%>]</a>
    
    <%
    
    };
    
    %>
</div>
	<!--content end  -->
  <%@ include file="template/myfooter.jspf" %>
</body>
</html>
