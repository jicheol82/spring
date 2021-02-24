package member.controller.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import member.model.dto.MemberDTO;
import member.service.bean.MemberService;

@Controller
@RequestMapping("/member/")
public class MemberController {
	// 비즈니스 처리 요청 -> service 객체 필요
	@Autowired
	private MemberService memberService = null;
	@RequestMapping("main.do")
	public String main() {
		return "member/main";
	}
	
	@RequestMapping("signupForm.do")
	public String signupForm() {
		return "member/signupForm";
	}
	
	@RequestMapping("signupPro.do")
	public String signupPro(MemberDTO dto) throws Exception { //dispatcherServlet으로 에러 보냄
		// 회원가입처리 -> 비즈니스 로직처리 -> service
		memberService.addMember(dto);
		return "member/main";
	}
}
