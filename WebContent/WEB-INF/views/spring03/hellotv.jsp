<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
	Bean 클래스 또는 컨트롤러에서 view로 전달되는 커맨드객체(Model 계층에
	삽입되는 객체)를 출력
	@ModelAttribute 어노테이션의 별칭을 지정하지 않으면,
	전달하는 객체의 클래스 타입의 앞글자를 소문자로 바꿔서
	속성명으로 전달.ex) TestTvDTO => testTvDTO 라는 이름으로
	view에 전달된 객체에 접근할 수 있다.
	
	@ModelAttirbuet 어노테이션이 붙은 메서드는
	해당클래스의 하위 @ReqeusetMapping 어노테이션이 붙은 다른 메서드보다
	선행되어 실행되게 설계되어있다.
	=> 이미 리턴되는 클래스가 Model속성으로 저장되어 있어서
	페이지에서 바로 꺼내 쓸 수 있다.
 --%>
	<h2>hello tv</h2>
	<h3>${tv2}</h3>
	<h3>${tv2.ch}</h3>
	<h3>${tv2.power}</h3>
	<h3>${tv2.col}</h3>
</body>
</html>