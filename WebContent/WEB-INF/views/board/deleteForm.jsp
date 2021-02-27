<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>글 삭제 폼deleteForm</title>
	<link href="/spring/resources/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<br />
	<h1 align="center"> delete article (글삭제) </h1>
	<form action="/spring/board/deletePro.do?pageNum=${param.pageNum}" method="post">
		<%-- 글고유번호 숨겨서 보내기 --%>
		<input type="hidden" name="num" value="${param.num}"/>
		<table>
			<tr>
				<td>삭제를 원하시면 비밀번호를 입력하시오</td>
			</tr>
			<tr>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="삭제"/>
					<input type="button" value="취소" onclick="window.location='/spring/board/list.do?pageNum=${param.pageNum}'">
				</td>
			</tr>
		</table>
	</form>
</body>

</html>