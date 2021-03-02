package spring.aop.advice;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import member.model.dto.MemberDTO;
import member.service.bean.MemberService;

@Controller
@RequestMapping("/aopMember/")
public class AopMemberController {
	// 비즈니스 처리 요청 -> service 객체 필요
	@Autowired
	private MemberService memberService = null;
	@RequestMapping("main.do")
	public String testmain() {
		return "aopMember/main";
	}
	
	@RequestMapping("signupForm.do")
	public String signupForm() {
		return "aopMember/signupForm";
	}
	
	@RequestMapping("signupPro.do")
	public String signupPro(MemberDTO dto) throws Exception { //dispatcherServlet으로 에러 보냄
		// 회원가입처리 -> 비즈니스 로직처리 -> service
		memberService.addMember(dto);
		return "aopMember/main";
	}
	// 로그인 폼 페이지
	@RequestMapping("loginForm.do")
	public String loginForm() {
		
		return "aopMember/loginForm";
	}
	// 로그인 처리 페이지
	@RequestMapping("loginPro.do")
	public String loginPro(MemberDTO dto, Model model) throws Exception{
		int result = memberService.idPwCheck(dto);
		System.out.println("ctrler result : "+result);
		model.addAttribute("result", result);
		return "aopMember/loginPro";
	}
	// 로그아웃 처리
	@RequestMapping("logout.do")
	public String testlogout() throws Exception {
		// 세션 지우는 서비스 메서드 호출, 내가 지울 세션이름 던져주기
		// 로그아웃 뿐만 아니라
		// 만약에 세션에 저장된 다른 속성을 지울때 같은 메서드 이용 가능
		memberService.logout("memId");
		return "aopMember/main";
	}
	
	// 회원정보변경
	@RequestMapping("modify.do")
	public String testmodify(HttpRequest request) {
		return "aopMember/modify";
	}
	
	//회원정보 수정
	@RequestMapping("modifyForm.do")
	public String testmodifyForm(HttpSession session, Model model) throws Exception {
		// 해당 회원의 정보 가져오기
		MemberDTO member = memberService.getMember((String)session.getAttribute("memId"));
		model.addAttribute("member", member);
		return "aopMember/modifyForm";
	}
	
	//회원정보수정pro
	@RequestMapping("modifyPro.do")
	public String testmodifyPro(MemberDTO dto) throws Exception{
		memberService.modifyMember(dto);
		return "aopMember/main";
	}
	//회원삭제 form
	@RequestMapping("deleteForm.do")
	public String testdeleteForm() {
		return "aopMember/deleteForm";
	}
	// 회원삭제 pro
	@RequestMapping("deletePro.do")
	public String testdeletePro(MemberDTO dto, Model model) throws Exception {
		int result = memberService.deleteMember(dto);
		model.addAttribute("result", result);
		return "aopMember/deletePro";
	}
	
	//confirmId
	@RequestMapping("confirmId.do")
	public String confirmId(String id, Model model) throws Exception{
		int check = memberService.idCheck(id);
		model.addAttribute("check", check);
		model.addAttribute("trialId", id);
		return "aopMember/confirmId";
	}
}
