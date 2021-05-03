package com.springbook.biz.board.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")// ~Impl로 끝나는 클래스내의 모든 메소든
	  public void allPointcut() {}//참조용 메소드
}
