package com.springbook.biz.board.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect// Pointcut + advice
public class AfterReturningAdvice {
      @Pointcut("execution(* com.springbook.biz..*Impl.get*(..))")
      public void getPointcut() {}
      
      //클라이언트가 요청한 메소드가 정상처리 됬을 때 실행
      @AfterReturning(pointcut = "getPointcut()", returning = "returnObj")
      public void afterLog(JoinPoint jp, Object returnObj) {
    	  String method = jp.getSignature().getName();
    	  
    	  System.out.println("[사후처리]" + method + "() 메소드 리턴값: " + returnObj.toString());
      }
}
