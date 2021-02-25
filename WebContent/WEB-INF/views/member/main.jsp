<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>main</title>
	<link href="/spring/resources/style.css" rel="stylesheet" type="text/css" />
</head>
<c:if test="${sessionScope.memId == null}">
<body>
	<h1 align="center">메인 페이지</h1>
	<table>
		<tr>
			<td>
				<button onclick="location='/spring/member/loginForm.do'">로그인</button>
			</td>
		</tr>
		<tr>
			<td>
				<button onclick="location='/spring/member/signupForm.do'">회원가입</button>
			</td>
		</tr>
	</table>
</body>
</c:if>
<c:if test="${sessionScope.memId != null}">
<body>
	<h1 align="center">메인 페이지</h1>
	<table>
		<tr>
			<td>
				${sessionScope.memId} 님 환영합니다. <br/>
				<button onclick="location='/spring/member/logout.do'">로그아웃</button><br/>
				<button onclick="location='/spring/member/modify.do'">회원정보변경</button>
			</td>
		</tr>
	</table>
</body>
</c:if>
</html>