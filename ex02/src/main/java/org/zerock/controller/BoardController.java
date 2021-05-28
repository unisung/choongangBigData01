package org.zerock.controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
@AllArgsConstructor
public class BoardController {
	
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list");
		model.addAttribute("list",service.getList());
	}
	
	
	@GetMapping("/register")
	public void registerForm(BoardVO board) {
	}
	
	/* 등록 처리 */
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr ) {
	  log.info("register:"+board);
	  
	  service.register(board);
	  
	  System.out.println("신규등록한 글번호: " +board.getBno());
	  rttr.addFlashAttribute("result", board.getBno());//등록한 글 번호를 list로 전달
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/get")
	public void get(@RequestParam("bno") Long bno, Model model) {
		BoardVO board=service.get(bno);
		model.addAttribute("board",board);
	}
	
	@GetMapping("/modify")
	public void modify() {}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		service.modify(board);
		return "redirect:/board/list";
	}
	
	@GetMapping("/remove")
	public void remove() {}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		return "redirect:/board/list";
	}
	
	
	

}
