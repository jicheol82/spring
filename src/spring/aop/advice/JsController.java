package spring.aop.advice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jquery/")
public class JsController {
	@RequestMapping("test.do")
	public String exjquery() {
		System.out.println("test.do요청");
		return "jquery/test01";
	}
}
