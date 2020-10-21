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
                 
         button{
      width: 100px;
     height: 50px;
      position: absolute;
         top: 50%;
    left: 49%;
     transform:translate(-50%, -50%);
     }
      
    table{
  border: solid 2px black;
    width: 200px;
  height: 100px;
        position: absolute;
         top: 30%;
    left: 50%;
      transform:translate(-50%, -50%);
      
    }
    
    </style>
        <script type="text/javascript" src="js/jquery-1.12.4.js"></script> 
          
     
    <script type="text/javascript" src="js/buttonjs.js"></script>
    <script type="text/javascript">
    
       $(document).ready(function() {
        	$('input').eq(0).click(function() {
				alert('이름은 변경할수없습니다.');
			});
        	  $('.buttn').attr("disabled",true);
       
        	$('input').keyup(function() {
        	var pass1=$('#password1').val();
            var pass2=$('#password2').val();
        		
            if(pass1 !=""||pass2 !=""){
            	
            	  $('.buttn').attr("disabled",true);
            if(pass1==pass2){
        			$('.buttn').attr("disabled",false);
        		
               }else if(pass1!=pass2){
            	   $('.buttn').attr("disabled",true);
           
               }
            }
            
            
          
            
           
      	  var phoneword= /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;
 
            $('#contact').keyup(function() {
            	
        
            		
            
            
            
            	
            	
        
            }); 
            
            
            
 
        
			});
      
        });
        	
        	</script>
</head>
<%@include file="template/myheader.jspf" %>
<%@include file="template/mymenu.jspf" %>
<body>
	<!--content start  -->
<div class="content">
<h2>정보수정</h2>
 <form class="send"    method="post">
 <table>
<c:forEach  items="${student}" var="bean">
<tr class="row">
<td class="tsub">이름<input type="text" name="name" readonly="readonly" value="${bean.name}"/></td>
</tr>
<tr class="row">
<td class="tsub">연락처<input type="text"  name="contact"  id="contact" value="${bean.contact}"/></td>
</tr>
<tr class="row">
<td class="tsub">이메일<input type="text" name="email" value="${bean.email}"/></td>
</tr>
<tr class="row">
<td class="tsub">변경할 비밀번호<input type="password" name="password"  id="password1" value=""/></td>
</tr>
<tr class="row">
<td class="tsub">변경할 비밀번호 확인<input type="password" id="password2" value=""/></td>
</tr>
</c:forEach>
</table>
<button   class="buttn"  type="submit">수정</button>
</form>
</div>
	<!--content end  -->
</body>
</html>
