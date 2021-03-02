package spring.aop.advice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
public class MemberAspect {
	/*
	// point-cut & advice around
	@Pointcut("execution( * test*(..))")
	public void testPC() {
	}
	
	@Around("testPC()")
	public Object around(ProceedingJoinPoint j) throws Throwable{
		return j.proceed();
	}
	*/
	// 회원가입 요청을 할 때
	// 로그인이 된 상태에서 접근해야 한느 메서드가 요청이 되면
	// 먼저 로그인되어있는지 (session memId)가 있는지 확인하고,
	// 있으면 계속 진행, 없으면 로그인 폼으로 보내기
	@Around("execution(* test*(..))")
	public Object around(ProceedingJoinPoint j) throws Throwable{
		System.out.println("around!");
		// 로그인체크
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		
//		Object[] objs = j.getArgs();
//		for(Object o : objs) {
//			if(o instanceof HttpServletRequest) {
//				System.out.println("hsr");
//				HttpServletRequest request = (HttpServletRequest)o;
//				System.out.println(request.getParameter("id"));
//			}
//		}
		
		if(session.getAttribute("memId")==null) {
			System.out.println("로그인 안됨");
			return "aopMember/loginForm";
		}
		return j.proceed();
	}
}
