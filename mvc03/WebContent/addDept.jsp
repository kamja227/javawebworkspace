<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="template/head.jspf" %>
<title>Insert title here</title>
</head>
<body>
<%@ include file="template/header.jspf" %>
<%@ include file="template/menu.jspf" %>
   <h2>입력페이지</h2>
         <form method="post" action="">
         
         <div>
         	<label for="id">id</label>
         	<input type="text" name="id" id="id"/>
         </div>
         <div>
         <label for="dname">dname</label>
         <input type="text" name="dname" id="dname"/>
         </div>
         <div>
         <label for="loc">loc</label>
         <input type="text" name="loc" id="loc"/>
         </div>
         
         <div>
         <button type="submit">입력</button>
         <button type="reset">리셋</button>
         <button type="button" onclick="history.back();">뒤로</button>
         
         </div>

         </form>
<%@ include file="template/footer.jspf" %>
</body>
</html>