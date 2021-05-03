package com.springbook.biz.board.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect//Pointcut + Advice
public class AfterThrowingAdvice {
   @Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
   public void afterThrowingPointcut() {}
   
   @AfterThrowing(pointcut = "afterThrowingPointcut()", throwing = "execptObj")
   public void exceptionLog(JoinPoint jp, Exception execptObj) {
	   String method = jp.getSignature().getName();
	   System.out.println(method +"() 메소드 수행 중 예외 발생" );
	   
	   if(execptObj  instanceof IllegalArgumentException) {
		  System.out.println("부적합한 값이 입력되었습니다.");
	}
   }
}
