<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>delete Form</title>
	<link href="/spring/resources/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<h1 align="center"> 회원탈퇴 </h1>
	<form action="/spring/aopMember/deletePro.do" method="post">
	<table>
		<tr>
			<td>탈퇴를 원하시면 비밀번호를 입력하세요</td>
		</tr>
		<tr>
			<td><input type="password" name="pw"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="탈퇴"/></td>
		</tr>
	</table>
	</form>
</body>
</html>