package org.zerock.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class CommonController {
	
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
	
	
	
}
