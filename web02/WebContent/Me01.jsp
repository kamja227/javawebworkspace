<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<%!
	public int add(int a, int b) {
		return a+b;
	}
	public int subtract(int a, int b) {
		return a-b;
	}
	%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
<% 
	int a=3, b=9;

	int add = add(a,b);
	int subtract = subtract(a,b);
%>
	<%=a%>+<%=b%>=<%=add %> <br>
	<%=a%>-<%=b%>=<%=subtract %>

</body>
</html>