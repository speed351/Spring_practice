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
		<h3>Alert</h3>
		<p>
			<strong>${dto.orgFileName}</strong> 파일이 갤러리에 업로드 되었습니다.
			<a href="${pageContext.request.contextPath}/gallery/list">확인</a>
			
		</p>
	</div>
</body>
</html>