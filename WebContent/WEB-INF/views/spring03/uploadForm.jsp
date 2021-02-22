<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>upload Form</title>
</head>
<body>
	<form action="uploadPro.do" method="post" enctype="multipart/Form-data">
		Writer : <input type="text" name="writer"/><br/>
		File : <input type="file" name="img"/><br/>
		<input type="submit" value="upload"/>
	</form>
</body>
</html>