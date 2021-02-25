<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>modify</title>
	<link href="/spring/resources/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<br/>
	<h1 align="center">회원정보변경</h1>
	<table>
		<tr>
			<td>
				<button onclick="location='/spring/member/modifyForm.do'">정보수정</button><br/>
			</td>
		</tr>
		<tr>
			<td>
				<button onclick="location='/spring/member/deleteForm.do'">회원탈퇴</button><br/>
			</td>
		</tr>
		<tr>
			<td>
				<button onclick="location='/spring/member/main.do'">메인으로</button>
			</td>
		</tr>
	</table>
</body>
</html>