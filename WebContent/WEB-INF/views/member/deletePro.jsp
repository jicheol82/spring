<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<c:if test="${result==0 }">
	<script>
		alert("비밀번호 오류");
		history.go(-1);
	</script>
</c:if>
<c:if test="${result==1 }">
	<c:redirect url="/member/main.do"/>
</c:if>
<body>

</body>
</html>