<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<p>
			<!-- form 전송된 파라미터를 view page에서 사용할 수 있다. -->
			<strong>${param.id }</strong> 회원님 가입었습니다.
			<a href="${pageContext.request.contextPath}/users/login_form">로그인 하러 가기</a>
		</p>
	</div>
</body>
</html>