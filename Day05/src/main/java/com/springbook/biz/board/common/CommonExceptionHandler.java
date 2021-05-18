package com.springbook.biz.board.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice("com.springbook.view")
public class CommonExceptionHandler {
	@ExceptionHandler(ArithmeticException.class)
	public ModelAndView handleArithmeticException(Exception e) {
		 ModelAndView mav = new ModelAndView("/common/arithmeticError.jsp");
		 mav.addObject("exception", e);
		 return mav;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e) {
		 ModelAndView mav = new ModelAndView("/common/error.jsp");
		 mav.addObject("exception", e);
		 return mav;
	}

}
