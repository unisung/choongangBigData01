package com.springbook.biz.board.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect //pointcut + advice
public class LogAdvice2 {

    @Before("PointcutCommon.allPointcut()")
  public void printLog() {//실행 메소드
	   System.out.println("[공통로그] 비즈니스 로직 수행 전 동작");
   }
}