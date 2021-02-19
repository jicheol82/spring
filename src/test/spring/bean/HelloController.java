package test.spring.bean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller	//이 클래스는 컨트롤러라는 지정 어노테이션 / 
@RequestMapping("/test/*") // requestmapping @GetMapping을 쓰려면 /* 끝나는 형태로 써야 함/~~~/ 로 해야함
public class HelloController {
	// uri 기본 클래스
	//@RequestMapping({"hello.do","hi.do"}) //요청경로 
	//@RequestMapping("?.do")  
	//@RequestMapping("hello.do")
	//@RequestMapping(value="hello", method=RequestMethod.GET) //신버전에서도 사용가능
	//@RequestMapping(value="hello", method=RequestMethod.POST)
	@GetMapping("hello.do")	//신버전에서만 사용가능
	//@PostMapping("hello.do")
	public String hello() {
		System.out.println("hello controller!!!!!!");
		return "/WEB-INF/views/spring01/hello.jsp";
	}
}
/*
 * CRUD
 */