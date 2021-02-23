<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> test page</h2>
	<h2> count : ${count}</h2>
	<h2> count : ${maxAge}</h2>
	<!-- jstl사용하려면 라이브러리 필요  -->
	<c:forEach var="user" items="${userList}" varStatus="status">
		<h3>${status.count} : ${user.id} / ${user.pw} / ${user.age} / ${user.reg}</h3>
	</c:forEach>
		<h2>dto : ${dto.id} / ${dto.pw} / ${dto.age} / ${dto.reg}</h3>
		<h2>reg : ${reg}</h2>
</body>
</html>