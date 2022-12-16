<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/member/list.jsp</title>
</head>
<body>
	<div class="container">
		<a href="${pageContext.request.contextPath}/member/insertform">회원 가입</a>
		<h3>회원 목록</h3>
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>주소</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="tmp" items="${list }">
					<tr>
						<th>${tmp.num}</th>
						<th>${tmp.name}</th>
						<th>${tmp.addr}</th>
						<th><a href="delete?num=${tmp.num}">삭제</a></th>
						<th><a href="updateform?num=${tmp.num}">수정</a></th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="${pageContext.request.contextPath}">HOME</a>
	</div>
</body>
</html>