<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
	<link href="/spring/resources/style.css" rel="stylesheet" type="text/css" />
	<script>
		/* 유효성 검사 
		function check(){
			var inputs = document.inputForm;
			// 필수기입란 기입했는지 
			if(!inputs.id.value) {
				alert("아이디를 입력하세요");
				return false;
			}
			if(!inputs.pw.value) {
				alert("비밀번호를 입력하세요");
				return false;
			}
			if(!inputs.pwCh.value) {
				alert("비밀번호 확인란을 입력하세요");
				return false;
			}
			if(!inputs.name.value) {
				alert("이름을 입력하세요");
				return false;
			}
			// pw, pwCh 동일한지 
			if(inputs.pw.value != inputs.pwCh.value){
				alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
				return false;
			}
		}*/
		// id중복 확인 함수
		function openConfirmId(inputForm){ // <- this.form 
			console.log(inputForm.id.value); 
			if(inputForm.id.value == ""){ 
				alert("아이디를 입력하세요.");
				return; 
			}
			var url = "/spring/aopMember/confirmId.do?id="+inputForm.id.value;
			open(url, "confirm", "toolbars=no, location=no, status=no, menubar=no, scrollbars=no, resizable=no, width=300, height=300");
		}
	</script>
</head>
<c:if test="${sessionScope.memId != null}">
	<script>
		alert("로그아웃하고 가입해주세요.");
		window.location="/spring/aopMember/main.do";
	</script>
</c:if>
<c:if test="${sessionScope.memId == null}">
<body>
	<br />
	<h1 align="center"> 회원가입 </h1>
	<form action="/spring/member/signupPro.do" method="post" name="inputForm" >
		<table>
			<tr>
				<td>아이디*</td>
				<td><input type="text" name="id" /></td>
			</tr>	
			<tr>
				<td></td>
				<td><input type="button" value="아이디 중복 확인" onclick="openConfirmId(this.form)" /> </td>
			</tr>	
			<tr>
				<td>비밀번호*</td>
				<td><input type="password" name="pw" /></td>
			</tr>		
			<tr>
				<td>비밀번호 확인*</td>
				<td><input type="password" name="pwch" /></td>
			</tr>		
			<tr>
				<td>이름*</td>
				<td><input type="text" name="name" /></td>
			</tr>		
			<tr>
				<td>나이</td>
				<td><input type="text" name="age" /></td>
			</tr>		
			<tr>
				<td>email</td>
				<td><input type="text" name="email" /></td>
			</tr>		
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="가입" /> 
					<input type="reset" value="재작성" /> 
					<input type="button" value="취소" onclick="window.location='/spring/aopMember/main.do'"/> 
				</td>
			</tr>		
		</table>
	</form>
</body>
</c:if>
</html>