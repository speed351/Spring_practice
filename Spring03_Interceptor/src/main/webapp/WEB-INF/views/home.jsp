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
			<li><a href="play">놀러가기</a></li>
			<li><a href="users/loginform">로그인</a></li>
			<li><a href="users/logout">로그아웃</a></li>
			<li><a href="users/info">개인정보(로그인 필요)</a></li>
			<li><a href="file/insertform">파일 업로드</a></li>
			<li><a href="cafe/insertform">SmartEditor 테스트</a></li>
		</ul>	
		<img src="${pageContext.request.contextPath}/resources/images/SouthKorea.png" alt="한국" />
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