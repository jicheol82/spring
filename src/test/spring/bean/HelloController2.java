package test.spring.bean;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import test.spring.model.TestBean;
import test.spring.model.TestDTO;

@Controller
public class HelloController2 {
	
	// 아래와 같이 인스턴스 변수로 사용도 가능하나
	// framework에 따라 사용이 불가능 할 수도 있다.
	// 객체생성은 framework가 한다
	// private Date day = new Date(); 
	// 대신 context.xml에서 bean태그를 이용하여 객체를 사용하여
	// 의존성 자동 주입을 실시한다(객체 생성을 스프링이 한다)
	
	@Autowired
	private Date day = null;
	
	// 자동의존성 주입될때, 기본적으로 "클래스 타입으로 구분"해서 가져오는데
	// 같은 타입의 bean이 두개가 있으면 
	// 클래스타입과 bean의 id속성값과 변수명이 동일한 것을 연결시켜줌
	@Autowired
	private TestBean testBean = null;
	@Autowired
	private TestBean testBean2 = null;
	
	@RequestMapping("hello2.do")
	public String hello2() {
		
		System.out.println(day);
		System.out.println(testBean);

		//		testBean.setNum(100);
//		testBean.setName("hello");
		
		System.out.println(testBean.getName());
		System.out.println(testBean.getNum());
		System.out.println(testBean.getReg());
		System.out.println("**************");
		System.out.println(testBean2);
		System.out.println(testBean2.getName());
		System.out.println(testBean2.getNum());
		System.out.println(testBean2.getReg());
		return "/WEB-INF/views/spring01/hello.jsp";
	}
	// form 페이지 매핑
	@RequestMapping("form.do")
	public String form() {
		// form.do를 요청하면 보여줘야할 jsp 페이지 경로 리턴
		return "/WEB-INF/views/spring02/form.jsp";
	}
	
	// pro.do 요청 매핑
	// Model 인터페이스로 처리한 경우
	/*
	@RequestMapping("pro.do")
	public String pro(Model model, TestDTO dto, String id, int pw, HttpServletRequest request, HttpServletResponse response) { 
		//request.getP~이렇게 할 필요 없음
		// 매개변수로 form의 name속성과 동일하게 만드는 방법-가장 간단한 방법
//		System.out.println(id);
//		System.out.println(pw+10);
//		System.out.println(dto);
//		System.out.println(dto.getId());
//		System.out.println(dto.getPw());
//		System.out.println(request);
//		System.out.println(response);
//		System.out.println(request.getSession());
		// view에 dto전달
		model.addAttribute("dto", dto);
		
		return "/WEB-INF/views/spring02/pro.jsp";
	}
	*/
	// ModelAndView 클래스 이용하는 경우
	@RequestMapping("pro.do")
	public ModelAndView pro(TestDTO dto) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", dto);
		mv.setViewName("/WEB-INF/views/spring02/pro.jsp");
		return mv;
	}
	
}
