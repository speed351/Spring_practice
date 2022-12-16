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
			<li><a href="${pageContext.request.contextPath}/member/insertform">요청 파라미터 추출 테스트</a></li>
			<li><a href="${pageContext.request.contextPath}/move/test">Model 전달 테스트</a></li>
			<li><a href="di/test">Dependency Injection Test</a></li>
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