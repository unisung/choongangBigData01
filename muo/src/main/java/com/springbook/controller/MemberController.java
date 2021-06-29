package com.springbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springbook.domain.Criteria;
import com.springbook.domain.MemberVO;
import com.springbook.domain.PageDTO;
import com.springbook.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/member")
@Log4j
@AllArgsConstructor
public class MemberController {
	private MemberService service;
	
	//회원 리스트_MemberManageList
	@RequestMapping(value="/list", method = {RequestMethod.GET, RequestMethod.POST})
	public void list(Model model, Criteria cri) {
		log.info("memberList");
		model.addAttribute("memberList", service.getListWithPaging(cri));
		
		int total=service.getTotal(cri);
		log.info("total: "+total);
		model.addAttribute("pageMaker", new PageDTO(cri, total));
	}
	
	
	//게시글 상세보기_MemberManageView
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("mb_seq")int mb_seq,Model model,@ModelAttribute("cri") Criteria cri,
			RedirectAttributes rttr) {
		MemberVO member=service.get(mb_seq);
		model.addAttribute("member", member);
		rttr.addFlashAttribute("result","");
	}
	
	//조회페이지 이동_list->MemberManageView
	/*
	 * @GetMapping("/modify") public void modify(@ModelAttribute("member")MemberVO
	 * member,Model model,@ModelAttribute("cri") Criteria cri) {
	 * model.addAttribute("member",service.get(member.getMb_seq())); } //회원
	 * 수정처리_MemberManageView
	 * 
	 * @PostMapping("/modify") public String modify(MemberVO
	 * member,@ModelAttribute("cri") Criteria cri,RedirectAttributes rttr) {
	 * if(service.modify(member)) rttr.addFlashAttribute("result", "success");
	 * 
	 * return "redirect:/member/list"+cri.getListLink(); }
	 */
	
	//회원 삭제처리_MemberManageView
	@PostMapping("/remove")
	public String remove(@RequestParam("mb_seq")int mb_seq,@ModelAttribute("cri") Criteria cri,RedirectAttributes rttr) {
		System.out.println("cri: "+cri);
		if(service.remove(mb_seq))
			rttr.addFlashAttribute("result", "success");
		return "redirect:/member/list"+cri.getListLink();
	}
	
	@GetMapping("/register")
	public void register() {
		
	}
	/*
	 * //회원가입 insert_MemberJoin //등록처리
	 * 
	 * @PostMapping("/register") public String register(MemberVO member,
	 * RedirectAttributes rttr) { log.info("register: "+member);
	 * 
	 * service.registerMember(member);
	 * System.out.println("신규등록한 고객번호: "+member.getMb_seq());
	 * rttr.addFlashAttribute("result", member.getMb_seq());//등록한 고객번호를 list로 전달
	 * 
	 * return "redirect:/member/list"; }
	 */
	
	//비번찾기
	@GetMapping("/findPW")
	public void findPW() {
		
	}
	@PostMapping("/findPW")
	public String findPW(MemberVO member, RedirectAttributes rttr) {
		log.info("findPW: "+member);
		
		System.out.println(service.findPW(member));
		rttr.addFlashAttribute("result", service.findPW(member));//비번을 list로 전달
		
		return "redirect:/member/list";//나중에 로그인 페이지로 이동으로 바꾸기
	}
	
	//회원정보수정
	@GetMapping("/updateInfo")
	public void updateInfo() {}
	
}