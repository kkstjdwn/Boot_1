package com.coo.b1.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CustomAOP {
	
	@Before("execution(* com.coo.b1.member.MemberService.memberSingIn(..))")
	public void before() throws Exception{
		System.out.println("로그인 시도");
	}
	
	@After("execution(* com.coo.b1.member.MemberService.memberSingIn(..))")
	public void afterReturning() throws Exception{
		System.out.println("로그인 성공");
	}
	
	@AfterThrowing("execution(* com.coo.b1.member.MemberService.memberSignUp(..))")
	public void afterThrowing() throws Exception{
		System.out.println("After Throwing");
	}
	
	@Around("execution(* com.coo.b1.member.MemberService.memberSingIn(..))")
	public Object around(ProceedingJoinPoint pjp)throws Throwable{
		System.out.println("메서드 실행전");
		
		Object obj = pjp.proceed();
		
		System.out.println("실행후");
		
		return obj;
	}
}
