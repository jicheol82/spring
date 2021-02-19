package test.spring.testPkg;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("test.do")
	public String test() {
		System.out.println("test controller!!!!");
		return "/WEB-INF/views/spring01/test.jsp";
	}
	
}