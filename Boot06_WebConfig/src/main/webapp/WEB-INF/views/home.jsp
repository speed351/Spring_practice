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
		<h3>인덱스</h3>
		<%-- Spring Boot에서 추가된 static 폴더에 있는 자원 사용하기 --%>
		<img src="${pageContext.request.contextPath}/images/t1.jpg" alt="img"  style="width:200px;"/>
		<%-- 
			Resources Handler설정으로 추가한 resources 폴더에 있는 자원 사용하기
			static 폴더와 달리 jsp 페이지도 가능하다.
		 --%>
		<img src="${pageContext.request.contextPath}/resources/images/m1.png" alt="img" style="width:200px;"/>
		<li><a href="${pageContext.request.contextPath}/resources/test.jsp">test jsp</a></li>
		<li><a href="${pageContext.request.contextPath}/users/info">test info</a></li>
		<li><a href="${pageContext.request.contextPath}/users/loginform">test login</a></li>
		<h3>공지사항</h3>
		<ul>
			<c:forEach var="tmp" items="${noticeList }">
				<li>${tmp }</li>
			</c:forEach>
			
		</ul>
	</div>
</body>
</html>