package spring.aop.advice;

import org.aspectj.lang.ProceedingJoinPoint;

// 공통으로 돌아가야할 기능 구현
public class Advice {

	// before
	public void before() {
		System.out.println("before 발생!");
	}
	
	// after
	public void after() {
		System.out.println("after 발생");
	}
	// afterRetuning
	public void afterReturning() {
		System.out.println("afterReturning 발생");
	}
	// afterThrowing
	public void afterThrowing() {
		System.out.println("afterThrowing 발생");
	}
	// around 메서드 구현 방법!
	// org.aspectj.lang.ProceedingJoinPoint 타입을 첫번째 매개변수로 지정해야 함.
	// 리턴타입은 Object 타입으로 j.proceed()호출시 리턴해주는 객체의 타입이 object이며,
	// 해당 리턴 받은 객체를 메서드에서 리턴해줘야함.
	public Object around(ProceedingJoinPoint j) throws Throwable{
		System.out.println("around before 발생");
		// proceed() 메서드는 핵심메서드, 즉, 원래 호출되어야하는 메서들 호출해준다.
		// 원래 실행하려고 했던 것으로 돌리는 기능
		Object obj = j.proceed();
		System.out.println("around after 발생");
		return obj;
	}
	
}
