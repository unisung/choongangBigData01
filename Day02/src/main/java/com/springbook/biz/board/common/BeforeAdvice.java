package com.springbook.biz.board.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service//Bean등록
@Aspect//Pointcut + Advice
public class BeforeAdvice {
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut() {}
	
	@Before("allPointcut()")
	public void beforeLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object args[] =jp.getArgs(); //get(BoardVO);
		
		System.out.println("[사전처리]" + method+"() 메소드 args 정보: " +args[0].toString());
	}
	
	

}
