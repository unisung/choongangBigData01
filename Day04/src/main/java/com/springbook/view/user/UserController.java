package com.springbook.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService service;
	
	@RequestMapping(value="/login.do", 
			        method=RequestMethod.GET)
	   public String loginForm() {
		//return new ModelAndView("login.jsp");
		return "login.jsp";
	}
	
	@RequestMapping(value="/login.do", 
	        method=RequestMethod.POST)
	public String login(UserVO user, HttpSession session) {
		UserVO vo;
		try {
			vo =service.getLogin(user);
			
			if(vo!=null) {
				session.setAttribute("user", vo);
				return "redirect:getBoardList.do";
			}else {
				return "redirect:login.do";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		//return new ModelAndView("login.jsp");
		return null;
}


}
