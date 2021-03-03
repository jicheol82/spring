<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="/spring/resources/jquery-3.6.0.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#btn").click(function(){
				$("h2").css("color","red");
				$("#id1").css("color","blue");
				$(".cls1").css("color","green");
			})
			$("#btn1").click(function(){
				$("li:even").css("color", "red");
				$("li:odd").css("color", "blue");
				$("li").attr("class", "test");
			})
			$("#btn2").click(function(){
				$("img").attr("src", "/spring/resources/img/default.jpg");
			})
			$("#sbtn").click(function(){
				$("img").show();
			})
			$("#hbtn").click(function(){
				$("img").hide();
			})
			$("#btn3").click(function(){
				alert($("#id2").val());
				$("h3").text($("#id2").val());
				$("#id2").val(""); //.remove는 없애버림
			})
			$("select").change(function(){
				$("#h3_1").text($(this).val());
				$("#h3_1").append("<h3>hello</h3>")
			})
		})
	</script>
</head>
<body>
	<h2>jquery</h2>
	<h2>hello jquery</h2>
	<h2 id="id1">id jquery</h2>
	<h2 class="cls1">class jquery</h2>
	<button id="btn">color</button>
	
	<ul>
		<li>111111</li>
		<li>222222</li>
		<li>333333</li>
		<li>444444</li>
	</ul>
	<button id="btn1">event</button>
	<br/>
	
	<img src="/spring/resources/img/beach.jpg" width="100"/><br/>
	<button id="btn2">event</button>
	<button id="sbtn">show</button>
	<button id="hbtn">hide</button>
	<br/>
	
	<h3>입력값 작성</h3>
	<input type="text" name="id" id="id2"/>
	<button id="btn3">확인</button>
	<br/>
	
	<h3 id="h3_1">과목선택</h3>
	<select>
		<option>java</option>
		<option>jsp</option>
		<option>frame</option>
		<option>jquery</option>
	</select>
	
</body>
</html>