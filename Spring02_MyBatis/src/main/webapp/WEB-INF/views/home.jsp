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
		<h3>인덱스 페이지 </h3>	
		<ul>
			<li><a href="member/list">회원 목록 보기</a></li>
			<li><a href="todo/list">할일 목록 보기</a></li>
		</ul>	
		<h3>공지사항</h3>
		<ul>
			<!-- tmp(string type이므로 바로 출력) , noticeList(list type이므로 forEach문을 통해 출력) -->
			<c:forEach var="tmp" items="${requestScope.noticeList }"> 
				<li>${tmp} </li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>