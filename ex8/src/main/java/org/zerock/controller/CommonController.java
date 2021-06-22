package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.zerock.domain.MemberVO;
import org.zerock.service.MemberService;

import lombok.Data;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@Data
public class CommonController {
   /* 회원정보 db저장 서비스 */
	@Setter(onMethod_=@Autowired)
	private MemberService memberService;
	
	@GetMapping("/accessError")
	public void accessError(Authentication auth, Model model) {
		log.info("access Denied : " + auth);
		
		model.addAttribute("msg", "Access Denied");
	}
	
	@GetMapping("/customLogin")
	public void loingInput(String error, String logout, Model model) {
		log.info("error: " + error);
		log.info("logout: " + logout);
		
		if(error !=null) model.addAttribute("error","Login Error Check Your Account");
		
		if(logout!=null) model.addAttribute("logout", "Logout!!");
		
	}
	
	@GetMapping("/customLogout")
	public void logoutGET() {
		log.info("custom logout");
	}
	
	@GetMapping("/registerMember")
	public void registerMemeber() {}
	
	@PostMapping("/registerMember")
	public void registerMemeber(MemberVO member) {
		log.info("registerMember........");
		log.info("member: "+member);
		memberService.registerMember(member);
		
	}
	
	
	
	
}
