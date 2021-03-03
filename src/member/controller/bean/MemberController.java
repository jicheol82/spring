package member.controller.bean;

import java.net.URLDecoder;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	// 로그인 폼 페이지
	@RequestMapping("loginForm.do")
	public String loginForm() {
		
		return "member/loginForm";
	}
	// 로그인 처리 페이지
	@RequestMapping("loginPro.do")
	public String loginPro(MemberDTO dto, Model model) throws Exception{
		int result = memberService.idPwCheck(dto);
		System.out.println("ctrler result : "+result);
		model.addAttribute("result", result);
		return "member/loginPro";
	}
	// 로그아웃 처리
	@RequestMapping("logout.do")
	public String logout() throws Exception {
		// 세션 지우는 서비스 메서드 호출, 내가 지울 세션이름 던져주기
		// 로그아웃 뿐만 아니라
		// 만약에 세션에 저장된 다른 속성을 지울때 같은 메서드 이용 가능
		memberService.logout("memId");
		return "member/main";
	}
	
	// 회원정보변경
	@RequestMapping("modify.do")
	public String modify() {
		return "member/modify";
	}
	
	//회원정보 수정
	@RequestMapping("modifyForm.do")
	public String modifyForm(HttpSession session, Model model) throws Exception {
		// 해당 회원의 정보 가져오기
		MemberDTO member = memberService.getMember((String)session.getAttribute("memId"));
		model.addAttribute("member", member);
		return "member/modifyForm";
	}
	
	//회원정보수정pro
	@RequestMapping("modifyPro.do")
	public String modifyPro(MemberDTO dto) throws Exception{
		memberService.modifyMember(dto);
		return "member/main";
	}
	//회원삭제 form
	@RequestMapping("deleteForm.do")
	public String deleteForm() {
		return "member/deleteForm";
	}
	// 회원삭제 pro
	@RequestMapping("deletePro.do")
	public String deletePro(MemberDTO dto, Model model) throws Exception {
		int result = memberService.deleteMember(dto);
		model.addAttribute("result", result);
		return "member/deletePro";
	}
	
	//confirmId
	@RequestMapping("confirmId.do")
	public String confirmId(String id, Model model) throws Exception{
		int check = memberService.idCheck(id);
		model.addAttribute("check", check);
		model.addAttribute("trialId", id);
		return "member/confirmId";
	}
	// ajax 요청 받는 매칭
	@RequestMapping(value="ajaxIdAvail.do", method=RequestMethod.POST, produces="application/text; charset=utf8")
	 //<-viewresolver사용하지 말아야 함
	public @ResponseBody String ajaxIdAvail(String id) throws Exception{
//	public ResponseEntity<String> ajaxIdAvail(String id) throws Exception{
		String result = "";
		// 매개변수로 전달받은 id가 db존재하는지 확인
		int check = memberService.idCheck(id);
		if(check==1) {
			result = "이미 존재하는 id입니다";
		}else {
			result = "사용가능한 id입니다";
		}
		
		//result = URLDecoder.decode(result, "UTF-8");
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.add("Content-type", "text/html;charset=utf-8");
		return result;
//		return new ResponseEntity<String>(result, responseHeaders, HttpStatus.OK);	
	}
}
