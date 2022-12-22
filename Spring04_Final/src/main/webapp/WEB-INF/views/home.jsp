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
		<c:choose>
			<c:when test="${ empty sessionScope.id}">
				<a href="${pageContext.request.contextPath}/users/login_form">로그인</a>
				<a href="${pageContext.request.contextPath}/users/signup_form">회원가입</a>
			</c:when>
			<c:otherwise>
				<p>
					<a href="${pageContext.request.contextPath}/users/info">${sessionScope.id }</a>
					로그인중... <a href="${pageContext.request.contextPath}/users/logout">로그아웃</a>
				</p>
			</c:otherwise>
		</c:choose>
		<ul>
			<li><a href="get_msg">msg</a></li>
			<li><a href="get_person">person</a></li>
			<li><a href="get_user">user</a></li>
			<li><a href="get_friends">friends</a></li>
			<li><a href="get_users">users</a></li>
			<li><a href="file/list">자료실 목록 보기</a></li>
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