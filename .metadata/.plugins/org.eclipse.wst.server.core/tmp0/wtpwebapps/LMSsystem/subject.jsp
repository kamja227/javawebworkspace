<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title> Title </title>
    <link rel="stylesheet" type="text/css" href="css/template.css"/>
    <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Noto+Sans+KR:wght@100;500&display=swap" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="css/jquery.bxslider.css"/>
    <style rel="stylesheet" type="text/css">
     
       #bx{
       
       margin: 0px auto;
       display: block;
        padding-top: 150px;
         padding-left: 28%;
         height: 1000px;
       }
        
        
    </style>

    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="js/jquery.bxslider.js"></script>
    <script type="text/javascript" src="js/menu.js"></script>
     <script type="text/javascript">
     $(document).ready(function(){ $('.bxslider').bxSlider({ 
    	 mode: 'horizontal',
    	 auto: true, 
    	 speed: 100, 
    	  slideWidth: 650,
    	
     }); 
     });
     
     

  
    </script>


    
   
</head>

<body>
<%@include file="template/header.jspf" %>
<%@include file="template/menu.jspf" %>

	<!--content start  -->
     
     <div id="bx">
 <ul class="bxslider"> 
<li><img src="img/java.jpg" /></li> 
<li><img src="img/javascript.jpg"/></li> 
<li><img src="img/web.jpg" /></li> 
</ul>

</div>

	<!--content end  -->    
    <%@ include file="template/footer.jspf" %>
   
</body></html>
