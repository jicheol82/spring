<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>글 내용 content</title>
	<link href="/spring/resources/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<br />
	<h1 align="center">글 내용</h1>
	<%//request.getParameter("num") %>
	<table>
		<tr>
			<td colspan="2"><b>${article.subject}</b></td>
		</tr>
		<tr>
			<td colspan="2">${article.content}</td>
		</tr>
		<tr>
			<td>posted by 
				<a href="mailto:${article.email}"><b>${article.writer}</b></a>
				at ${article.reg}
			</td>
			<td>${article.readcount} viewed</td>
		</tr>
			<tr>
			<td colspan="2">
				<button onclick="window.location='/spring/board/modifyForm.do?pageNum=${pageNum}&num=${article.num}'" >수 정</button>
				<button onclick="window.location='/spring/board/deleteForm.do?pageNum=${pageNum}&num=${article.num}'" >삭 제</button>
				<button onclick="window.location='/spring/board/writeForm.do?pageNum=${pageNum}&num=${article.num}&ref=${article.ref}&re_level=${article.re_level}&re_step=${article.re_step}'">답 글</button>
				<button onclick="window.location='/spring/board/list.do?pageNum=${pageNum}'">리스트보기</button>
			</td>
		</tr>
	</table>
</body>
</html>