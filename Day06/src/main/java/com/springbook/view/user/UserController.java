package com.springbook.view.user;

import java.sql.SQLException;

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
		return "login";
	}
	
	@RequestMapping(value="/login.do", 
	        method=RequestMethod.POST)
	public String login(UserVO user, HttpSession session) {
		UserVO vo;
		try {
		if(service.getUserCntByPass(user)>0) {
			    vo =service.getLogin(user);
			
				if(vo!=null) {
					session.setAttribute("user", vo);
					return "redirect:getBoardList.do";
				}else {
					return "redirect:login.do";
				 }
			}else
				return "redirect:login.do";
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
}
	
	@RequestMapping(value="logout.do",method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();//세션정보 삭제
		return "redirect:getBoardList.do";
	}

	@RequestMapping(value="membership.do",method=RequestMethod.GET)
	public String membership() {
		return "membership";
	}
	
	@RequestMapping(value="insertMember.do",method=RequestMethod.POST)
	public String insertMember(UserVO user) throws Exception {
		System.out.println("user:"+user);
		service.insertUser(user);
		return "redirect:login.do";
	}
	
	
		@RequestMapping(value="changePass.do",method=RequestMethod.GET)
	public String changepassForm() {
		return "changePass";
	}
		
		@RequestMapping(value="idPassCheck.do",method=RequestMethod.POST)
  public String idPassCheck(UserVO user) {
				if(service.getUserCntByPass(user)>0) {
							return "redirect:changePassForm.do";
				}else {
							return "redirect:changePass.do";
				}
		  }	//idPassCheck()끝.
		

 @RequestMapping(value="changePassForm.do",method=RequestMethod.GET)
	public String changepassInputForm() {
		return "changePassForm";
	}
 

 @RequestMapping(value="deleteUser.do",
		                     method=RequestMethod.GET)
	public String deleteUser() {
		return "deleteUser";
	}
 
 @RequestMapping(value="deleteUser.do",
         method=RequestMethod.POST)
public String deleteUser(UserVO user) throws Exception{
	 if(service.getUserCntByPass(user)>0) {
		 service.deleteUser(user);
			return "redirect:login.do";
	 }else {
			return "redirect:deleteUser.do";
	 }
 } 
		 
	@RequestMapping(value="updatePassword.do",
         method=RequestMethod.POST)
public String updateUser(UserVO user) throws Exception{
	 service.updateUser(user);
	 return "redirect:login.do";
}
		
}
