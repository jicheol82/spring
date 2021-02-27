<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deletePro</title>
</head>
<body>

<c:if test="${result == 1 }">
	<c:redirect url="/board/list.do?pageNum=${param.pageNum }" />
</c:if>
<c:if test="${result == 0 }">
	<script>
		alert("비밀번호가 맞지 않습니다. 다시 시도해보세요")
		history.go(-1);
	</script>
</c:if>

</body>
</html>