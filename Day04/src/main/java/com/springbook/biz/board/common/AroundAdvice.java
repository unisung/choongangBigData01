package com.springbook.biz.board.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {
   @Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
   public void aroundPointcut() {}
   
   @Around("aroundPointcut()")
   public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
	   String method = pjp.getSignature().getName();
	   StopWatch stopWatch = new StopWatch();
	   stopWatch.start();
	   
	   //before
	   System.out.println("[AROUND-BEFORE]:비즈니스 메소드 수행 전");
	   
	   //AroudnAdvice에서 클라이이언트 요청 메소드를 대신 실행
	   Object returnObj = pjp.proceed();
	   
	   stopWatch.stop();
	   
	   System.out.println("[AROUND-AFTER]:비즈니스 메소드 수행 후");
	   
	   System.out.println(method +"() 메소드 수행에 걸린 시간:" + stopWatch.getTotalTimeMillis());
	   
	   //실행한 메소드가 속한 객체 리턴
	   return returnObj;
   }
	
}
