<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
	alert("글이 등록되었습니다.");
</script>
<!-- 주소 확인해보기 -->
<c:redirect url="/board/list.do?pageNum=${param.pageNum}" />



<body>
</body>
</html>