<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	Date nowTime=new Date();
	SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<form action="${pageContext.request.contextPath}/todo/insert" method="post">
			<div>
				<label for="name">할 일</label>
				<input type="text" name="content" id="content" />
			</div>
			<div>
				<label for="name">등록일</label>
				<input type="text" name="regdate" value="<%=sf.format(nowTime) %>" id="regdate" disabled/>
			</div>
			<button type="submit">등록하기</button>
		</form>
	</div>
</body>
</html>