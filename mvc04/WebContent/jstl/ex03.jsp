<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL 조건문</h1>
	<h2>조건문</h2>
	<%
		boolean tf = true;
		pageContext.setAttribute("tf", tf);

		int su = 0;
		pageContext.setAttribute("su", su);
	%>
	<c:if test="${5>0 }">
		<p>참입니다.</p>
	</c:if>
	<!-- else문이 따로 존재하지 않아, 반대 조건의 모든 경우를 담아 if문으로 기재해야 한다. -->
	<c:if test="${5<0}">
		<p>거짓입니다.</p>
	</c:if>
	
	
	<c:if test="${su>0 }">
		<p>양수입니다.</p>
	</c:if>
	<c:if test="${su==0 }">
		<p>0입니다.</p>
	</c:if>
	<c:if test="${su<0 }">
		<p>음수입니다.</p>
	</c:if>
	
	
	<c:set value="-10" var="su2" ></c:set>
	<c:if test="${su2 gt 0 }">
		<p>양수입니다.</p>
	</c:if>
	<c:if test="${su2 eq 0 }">
		<p>0입니다.</p>
	</c:if>
	<c:if test="${su2 lt 0 }">
		<p>음수입니다.</p>
	</c:if>
	
		<c:choose>
		<c:when test="${su2==1 }">su2=1</c:when>
		<c:when test="${su2<0 }">su2=xxx</c:when>
		<c:when test="${su2==0}">su2=0</c:when>
		<c:otherwise>
			몰라
		</c:otherwise>
	</c:choose>
	
	<h2>반복문</h2>
	<c:forEach begin="1" end="10" var="su3" varStatus="status" step="2">
		<p>index: ${status.index}</p>
		<p>step: ${status.step}</p>
		<p>current: ${status.current}</p>
		<p>first: ${status.first}</p>
		<p>last: ${status.last}</p>
		<p>count: ${status.count}</p>
		<p>end: ${status.end}</p>
		<p>begin: ${status.begin}</p>
		<p>${su3 }</p>
		
		<%--${status.current} 현재 for문의 해당하는 번호
			${status.index} 0부터의 순서
			${status.count} 1부터의 순서
			${status.first} 첫 번째인지 여부
			${status.last} 마지막인지 여부
			${status.begin} for문의 시작 번호
			${status.end} for문의 끝 번호
			${status.step} for문의 증가값 --%>
	</c:forEach>
	
</body>
</html>