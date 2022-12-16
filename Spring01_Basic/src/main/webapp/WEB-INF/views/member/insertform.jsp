<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/member/insertform.jsp</title>
</head>
<body>
	<div class="container">
		<h3>회원 가입 1</h3>
		<form action="${pageContext.request.contextPath}/member/insert1" method="post">
			번호 <input type="text" name="num" /><br/>
			이름 <input type="text" name="name" /><br/>
			주소 <input type="text" name="addr" /><br/>
			<button type="submit">추가</button>
		</form>
		
		
		<h3>회원 가입2</h3>
		<form action="${pageContext.request.contextPath}/member/insert2" method="post">
			번호 <input type="text" name="num" /><br/>
			이름 <input type="text" name="name" /><br/>
			주소 <input type="text" name="addr" /><br/>
			<button type="submit">추가</button>
		</form>
		
		<h3>회원 가입3</h3>
		<form action="${pageContext.request.contextPath}/member/insert3" method="post">
			번호 <input type="text" name="num" /><br/>
			이름 <input type="text" name="name" /><br/>
			주소 <input type="text" name="addr" /><br/>
			<button type="submit">추가</button>
		</form>
	</div>
</body>
</html>