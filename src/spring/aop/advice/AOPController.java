package spring.aop.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/aop/")
public class AOPController {
	@Autowired
	private Tv tv = null;
	@RequestMapping("main.do")
	public String main() {
		System.out.println("main method ㅗ출!");
		//System.out.println(0/0);
		return "aop/testAop";
	}
	@RequestMapping("main2.do")
	public String main2() {
		System.out.println("main22222 method ㅗ출!");
		tv.power();
		tv.channel();
		return "aop/testAop";
	}
	@RequestMapping("main3.do")
	public String main3() {
		System.out.println("main3333 호출");
		main100(); // 맵핑이 없는 내부메서드 실행시 aop작동안함. controller통해 온게 아니니까
		return "aop/testAop";
	}
	
	public void main100() {
		System.out.println("----------------------main100");
	}
	
}
