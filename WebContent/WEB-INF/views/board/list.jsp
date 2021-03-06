<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판 목록(게시판 메인))</title>
	<link href="/spring/resources/style.css" rel="stylesheet" type="text/css">
</head>

<body>
	<br />
	<h1 align="center"> 게시판 </h1>
	<%-- 게시글이 없을때 --%>
	<c:if test="${count == 0 }">
		<table>
			<tr>
				<td colspan="5" align="right"><button onclick="window.location='/spring/board/writeForm.do'">글쓰기</button></td>
			</tr>
			<tr>
				<td align="center"> 게시글이 없습니다. </td>
			</tr>
		</table>
	</c:if>
	<c:if test="${count != 0 }">
		<table>
			<tr>
				<td colspan="5" align="right"><button onclick="window.location='/spring/board/writeForm.do?pageNum=${pageNum}'">글쓰기</button></td>
			</tr>
			<tr>
				<td>No.</td>
				<td>제	목</td>
				<td>작성자</td>
				<td>시	간</td>
				<td>조회수</td>
			</tr>	
			<%-- 게시글 목록 tr/td/반복해서 뿌려주기 (게시판에서 list 페이지가 제일 어렵다) --%>
			<c:forEach var="article" items="${articleList}">
			<tr>
				<td>
					${number}
					<c:set var="number" value="${number +1}" />
				</td>
				<td align="left">
					<c:set var="wid" value="0"></c:set>
					<c:if test="${article.re_level > 0 }">
						<c:set var="wid" value="${30*article.re_level }"></c:set>
						<img src="/spring/resources/img/tabImg.PNG" width="${wid}"/>
						<img src="/spring/resources/img/replyImg.png" width="10"/>
					</c:if>
					<a href="/spring/board/content.do?num=${article.num }&pageNum=${pageNum}">${article.subject}</a>
				</td>
				<td><a href="mailto:${article.email}">${article.writer}</a></td>
				<td>${article.reg}</td>
				<td>${article.readcount}</td>
			</tr>
			</c:forEach>
		</table>
		<br /><br />
		<%-- 페이지 번호 뷰어--%>
		<div align="center">
			<h4> 현재 페이지 : ${pageNum}</h4>
			<fmt:parseNumber var="res" value="${count / pageSize }" integerOnly="true" />
			<c:set value="${res + (count % pageSize == 0 ? 0 : 1) }" var="pageCount" />
			<fmt:parseNumber var="result" value="${(currPage -1)/pageBlock }" integerOnly="true" />
			<fmt:parseNumber var="startPage" value="${result * pageBlock + 1 }"/>
			<fmt:parseNumber var="endPage" value="${startPage + pageBlock -1 }"/>
			<c:if test="${endPage > pageCount }">
				<c:set var="endPage" value="${pageCount }" />
			</c:if>
		<!--  앞으로 가는 기호(11~20 보고있을때 1~10으로 이동하는 버튼) -->
				
			<c:if test="${param.sel != null && param.search != null }">
				<c:if test="${startPage > pageBlock }">
					<a href="/spring/board/list.do?pageNum=${startPage-pageBlock}&sel=${param.sel}&search=${param.search}" class="pageNums"> &lt; </a>
				</c:if>		
				<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
					<a href="/spring/board/list.do?pageNum=${i}&sel=${param.sel}&search=${param.search}" class="pageNums"> &nbsp; [&nbsp; ${i} &nbsp;] </a>
				</c:forEach>
				<c:if test="${endPage < pageCount}">
					<a href="/spring/board/list.do?pageNum=${startPage+pageBlock}&sel=${param.sel}&search=${param.search}" class="pageNums" > &gt; </a>
				</c:if>		
			</c:if>
			<c:if test="${param.sel == null && param.search == null }">
				<c:if test="${startPage > pageBlock }">
					<a href="/spring/board/list.do?pageNum=${startPage-pageBlock}" class="pageNums"> &lt; </a>
				</c:if>		
				<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
					<a href="/spring/board/list.do?pageNum=${i}" class="pageNums" > [&nbsp; ${i} &nbsp;] </a>
				</c:forEach>
				<c:if test="${endPage < pageCount}">
					<a href="/spring/board/list.do?pageNum=${startPage+pageBlock}" class="pageNums" > &gt; </a>
				</c:if>	
			</c:if>
			<!--   // 뒤로 가는 기호(1~10 보고있을때 11~20으로 이동하는 버튼) -->
			
			<br /><br />	
			<%-- 작성자/내용 검색 --%>	
			<form action="/spring/board/list.do">
				<select name="sel">
					<option value="null" >선택</option>
					<option value="writer" >작성자</option>
					<option value="content">내용</option>
				</select>
				<input type="text" name="search">		
				<input type="submit" value="검색">		
			</form>
		</div>
	</c:if>
		<br />
		<div align="center">
			<button onclick="window.location='/spring/board/list.do'">전체글보기</button>			
		</div>
</body>
</html>

