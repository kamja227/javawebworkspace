<%@page import="java.util.Enumeration"%>
<%@page import="com.sun.jmx.snmp.Enumerated"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
   <%
      java.util.Enumeration<String> names = null;
      names = request.getParameterNames();
      while (names.hasMoreElements()) {
         System.out.println(names.nextElement());
      }

      java.util.Map<String, String[]> map = null;
      map = request.getParameterMap();

      java.util.Set<String> keys = map.keySet();
      java.util.Iterator<String> ite = keys.iterator();
      while (ite.hasNext()) {
         String key = ite.next();
         System.out.println(java.util.Arrays.toString(map.get(key)));
      }

      Enumeration enu = request.getHeaderNames();
      while (enu.hasMoreElements()) {
         System.out.println(request.getHeader(enu.nextElement().toString()));
      }

      String id = request.getParameter("id");
      String pw = request.getParameter("pw");
      String[] ra = request.getParameterValues("ra");
   %>
   <h1>
      Method:<%=request.getMethod()%></h1>
   <p>
      id:<%=id%></p>
   <p>
      pw:<%=pw%></p>
   <p>
      checkbox:<%=java.util.Arrays.toString(ra)%>
</body>
</html>