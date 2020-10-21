
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL의 활용</h1>
	<%
		String msg1 = "el로 출력 될까요";
		String msg2 = "page scope로 겹치면 어떻게 될까?";
		// 우선순위 page > request > session > application
		pageContext.setAttribute("msg1", msg1);
		pageContext.setAttribute("msg2", msg2);
		
		String[] msgs ={"java", "DB", "web", "framework"};
		pageContext.setAttribute("msgs", msgs);
		
		java.util.ArrayList<String> list = new java.util.ArrayList<String>();
		list.add("JAVA");
		list.add("DB");
		list.add("WEB");
		list.add("FRAMEWORK");
		pageContext.setAttribute("alist", list);
		
		java.util.HashMap<String, Integer> map = null;
		map = new java.util.HashMap<String, Integer>();
		map.put("key1", 1111);
		map.put("key2", 2222);
		map.put("key3", 3333);
		map.put("key4", 4444);
		pageContext.setAttribute("hmap", map);

	%>
	
	<p>page scope(java): <%=pageContext.getAttribute("msg1") %></p>
	<p>page scope(el): ${msg1 }</p>
	<p>page scope(java): <%=pageContext.getAttribute("msg2") %></p>
	<p>page scope(el): ${pageScope.msg2 }</p>
	<p>page scope(java): <%=request.getAttribute("msg2") %></p>
	<p>request scope(el): ${requestScope.msg2 }</p>
	<p>Array(el): ${msgs }</p><!-- String 배열 객체의 주소 출력 -->
	<ol>
		<li>${msgs[0] }</li>
		<li>${msgs[1] }</li>
		<li>${msgs[2] }</li>
		<li>${msgs[3] }</li>
	</ol>
	<p>ArrayList(java): <%=pageContext.getAttribute("alist") %></p><!-- toString()과 동일 -->
	<p>ArrayList(el): ${alist }</p><!-- toString()과 동일 -->
	<ol>
		<li>${alist.get(0) }</li>
		<li>${alist.get(1) }</li>
		<li>${alist.get(2) }</li>
		<li>${alist.get(3) }</li>		
	</ol>
	<p>HashMap(java): <%=pageContext.getAttribute("hmap") %></p><!-- toString()과 동일 -->
	<p>HashMap(el): ${hmap }</p><!-- toString()과 동일 -->
	<ul>
		<li>${hmap.key1 }</li>
		<li>${hmap.key2 }</li>
		<li>${hmap.key3 }</li>
		<li>${hmap.key4 }</li>
	</ul>
	<p>bean:<%=request.getAttribute("bean") %></p>
	<p>bean:${bean }</p>
	<dl>
		<dt>int su1</dt>
		<dd>${bean.su1 }</dd><!-- el이 알아서 getter로 멤버 필드로 호출한다. -->
		<dt>double su2</dt>
		<dd>${bean.su2 }</dd>
		<dt>char ch</dt>
		<dd>${bean.ch }</dd>
		<dt>String name</dt>
		<dd>${bean.name }</dd>
		<dt>java.util.Date nalja</dt>
		<dd>${bean.nalja }</dd>
		<dt>boolean tf</dt>
		<dd>${bean.tf}</dd>
	</dl>
	<p>${bean.tf ? "참" : "거짓"}</p>
</body>
</html>