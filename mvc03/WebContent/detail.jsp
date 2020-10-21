<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/template/head.jspf" %>
<style type="text/css">
	#content{}
	#content>h2{}
	#content>form{}
	#content>form>div{}	
	#content>form>div>input{
		border-width: 0px;
	}	
	#content>form>div>label>input{}
	#content>form>div>label>input>button{}
</style>
<script type="text/javascript">
	$(function(){
		$('#dname, #loc').prop('readonly', true);
		$('form').one('submit', function(){ // 단 한번만 수행되는 메서드 one()
			$('#dname, #loc').prop('readonly', false);
			$('h2').text('수정 페이지');
			$('form').find('input').css('border-width', '2px');
			$('form').find('button').eq(1).text('취소');
			$('form').off('reset', del);
			
			return false; // submit 작동 막기
		});
		$('form').one('reset', del);
	});
	
	function del(){
		alert('delete');
		return false;
	}
</script>
</head>
<body>
<%@ include file="/template/header.jspf" %>
<%@ include file="/template/menu.jspf" %>
	<h2>상세 페이지</h2>
	<form method="post">
		<div>
			<label for="deptno">deptno</label>
			<input type="text" name="deptno" id="deptno" value="${bean.deptno }" readonly/>
		</div>
		<div>
			<label for="dname">dname</label>
			<input type="text" name="dname" id="dname" value="${bean.dname }" />
		</div>
		<div>
			<label for="loc">loc</label>
			<input type="text" name="loc" id="loc" value="${bean.loc }" />
		</div>
		
		<div>
			<button type="submit">수정</button>
			<button type="button" onclick="/dept/delete.bit">삭제</button>
			<button type="reset">취소</button>
			<button type="button" onclick="history.back();">뒤로</button>
		</div>
	</form>
<%@ include file="/template/footer.jspf" %>
</body>
</html>