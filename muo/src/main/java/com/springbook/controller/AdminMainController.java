package com.springbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springbook.service.AdminMainService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
public class AdminMainController {

	private AdminMainService service;
	
	@GetMapping("/admin/index")
	public String getReainCount(Model model) {
		log.info("getRemainCount");
		model.addAttribute("remainCount",service.getRemainCount());
		model.addAttribute("soldOut",service.getSoldOut());
		model.addAttribute("Sale",service.getSale());
		model.addAttribute("neworder",service.getNewOrder());
		model.addAttribute("progress",service.getProgress());
		model.addAttribute("arrival",service.getArrival());
		model.addAttribute("change",service.getChange());
		model.addAttribute("refund",service.getRefund());
		model.addAttribute("QnaList",service.getQnaList());
		model.addAttribute("NoticeList",service.getNoticeList());
		
		return "/admin/main";
	}
	
	
}
