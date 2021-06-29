package com.springbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*front 확인용--------------*/

@Controller
public class frontController {
	
	@RequestMapping("index")
	public void index() {}
	
	@RequestMapping("/member/membership")
	public void membership() {}
	
	@RequestMapping("company")
	public void company() {}
	
	@RequestMapping("personalInfo")
	public void person() {}
	
	@RequestMapping("condition")
	public void condition() {}
	
	@RequestMapping("/member/mypage")
	public void mypage() {}
	

	
	
	@RequestMapping("/shop/cart")
	public void cart() {}
	
	@RequestMapping("/shop/payment")
	public void payment() {}
	
	
	@RequestMapping("/magazine/list")
	public String magazine() {
		return "/magazine/list";
	}
	
	@RequestMapping("/magazine/view")
	public void magazinev() {}
	
	@RequestMapping("/magazine/write")
	public void magazinew() {}
	
	@RequestMapping("/coupon/list")
	public String coupon() {
		return "/coupon/coupon";
	}
	
	
	@RequestMapping("/admin/coupon")
	public String ad_coupon_l() {
		return "/admin/coupon/list";
	}
	
	@RequestMapping("/admin/coupon/write")
	public String ad_coupon_w() {
		return "/admin/coupon/write";
	}
	
	

	
	
	@RequestMapping("/faq/list")
	public String faq_l() {
		return "/faq/list";
	}
	
	@RequestMapping("/faq/write")
	public String faq_w() {
		return "/faq/write";
	}
	
	@RequestMapping("/event/list")
	public String event_l() {
		return "/event/list";
	}

	@RequestMapping("/event/view")
	public String event_v() {
		return "/event/view";
	}
	
	@RequestMapping("/event/write")
	public String event_w() {
		return "/event/write";
	}
	
	
	
	
	
}
	