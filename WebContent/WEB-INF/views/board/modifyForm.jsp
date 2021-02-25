<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>글 수정</title>
	<link href="/web/jsp0216/style.css" rel="stylesheet" type="text/css"/>
</head>

<body>
	<br/>
	<h1 align="center">Modify Article</h1>
	<form action="/web/board/modifyPro.do?pageNum=${pageNum}" method="post">
		<%-- 글 고유번호 숨겨서 보내기 --%>
		<input type="hidden" name="num" value="${num}"/>
		<table>
			<tr>
				<td>작성자</td>
				<td align="left"><input type="text" name="writer" value="${article.writer}"/></td>
			</tr>
			<tr>
				<td>제 목</td>
				<td align="left"><input type="text" name="subject" value="${article.subject}"/></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td align="left"><input type="text" name="email" value="${article.email}"/></td>
			</tr>
			<tr>
				<td>내 용</td>
				<td><textarea rows="20" cols="70" name="content">${article.content}</textarea></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td align="left"><input type="password" name="pw"/></td>
			</tr>
			<tr>
				<td colspan="5">
				<input type="submit" value="수정"/>
				<input type="button" value="취소" onclick="window.location='/web/board/list.do?pageNum=${pageNum }'"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>

