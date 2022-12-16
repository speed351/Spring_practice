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
		<h3>할일 정보 수정</h3>
		<form action="update" method="post">
			<input type="hidden" name="num" value="${dto.num}"/>
			<div>
				<label for="num">번호</label>
				<input type="text" id="num" value="${dto.num}" disabled />
			</div>
			<div>
				<label for="name">할일</label>
				<input type="text" name="content" value="${dto.content}" />
			</div>
			<div>
				<label for="regdate">등록일</label>
				<input type="text" name="regdate" value="${dto.regdate}" disabled/>
			</div>
			<button type="submit">수정확인</button>
			<button type="reset">취소</button>
		</form>
	</div>
</body>
</html>