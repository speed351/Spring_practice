<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<div>
		<h1>index page</h1>
		<h3>공지사항</h3>
		<ul>
			<c:forEach var="tmp" items="${requestScope.noticeList}">
				<li>${tmp}</li>
			</c:forEach>
			<li><a href="fortune">오늘의 운세보기</a></li>
		</ul>
		<form action="send" method="post">
			<input type="text" name="msg" placeholder="서버에 할 말 입력...">
			<button type="submit">전송</button>
		</form>
		<img src="/hello/resources/images/kim1.png" alt="" />
	</div>
</head>
<body>

</body>
</html>