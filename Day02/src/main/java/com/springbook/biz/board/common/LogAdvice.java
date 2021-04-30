package com.springbook.biz.board.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect //pointcut + advice
public class LogAdvice {
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
  public void allPointcut() {}//참조용 메소드
    @Before("allPointcut()")
  public void printLog() {//실행 메소드
	   System.out.println("[로그 어드바이스 ]");
   }
}
