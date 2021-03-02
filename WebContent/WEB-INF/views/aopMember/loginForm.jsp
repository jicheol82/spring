<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="/spring/resources/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<br/>
	<h1 align="center">로그인</h1>
	<form action="/spring/aopMember/loginPro.do" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"/></td>
			</tr>
			<tr>
				<td>비밀전호</td>
				<td><input type="password" name="pw"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="로그인"/>
					<input type="button" value="회원가입" onclick="location='/spring/aopMember/signupForm.do'"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>