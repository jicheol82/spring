<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>modify form</title>
	<link href="/spring/resources/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<br />
	<h1 align="center"> 회원가입 </h1>
	<form action="/spring/aopMmber/modifyPro.do" method="post">
		<table>
			<tr>
				<td>아이디*</td>
				<td>${member.id}</td>
			</tr>	
			<tr>
				<td>비밀번호*</td>
				<td><input type="password" name="pw" value="${member.pw}" /></td>
			</tr>		
			<tr>
				<td>비밀번호 확인*</td>
				<td><input type="password" name="pwch" value="${member.pw}" /></td>
			</tr>		
			<tr>
				<td>이름*</td>
				<td>${member.name}</td>
			</tr>		
			<tr>
				<td>나이</td>
				<td><input type="text" name="age" value="${member.age}"/></td>
			</tr>		
			<tr>
				<td>email</td>
				<td><input type="text" name="email" value="${member.email}"/></td>
			</tr>		
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="수정" /> 
					<input type="reset" value="재작성" /> 
					<input type="button" value="취소" onclick="window.location='/spring/aopMember/main.do'"/> 
				</td>
			</tr>		
		</table>
	</form>
</body>
</html>