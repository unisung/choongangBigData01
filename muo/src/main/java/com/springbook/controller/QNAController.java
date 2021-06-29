package com.springbook.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.domain.Criteria;
import com.springbook.domain.PageDTO;
import com.springbook.domain.QNAVO;
import com.springbook.service.QNAService;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@AllArgsConstructor
public class QNAController {
	
	@Setter(onMethod_= @Autowired)
	private QNAService service;

	@RequestMapping("/qna/list")
	public void list(Model model, Criteria cri) {
		
		/*
		 * List<QNAVO>list = service.getList();
		 * 
		 * model.addAttribute("list", list);
		 */
		
		model.addAttribute("list", service.getListWithPaging(cri));
		int total = service.getTotalCount(cri);
		
		model.addAttribute("pageMaker", new PageDTO(cri, total));
		System.out.println(total);
	}
	
	@RequestMapping(value="/qna/write", method=RequestMethod.GET)
	public void write() {
		System.out.println("df");
	}

	@RequestMapping(value="/qna/write", method=RequestMethod.POST)
	public String writes(QNAVO vo) throws IllegalStateException, IOException {
		System.out.println("------------1");
		MultipartFile uploadFile = vo.getUploadFile();

		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();

			fileName=fileName.substring(0,fileName.lastIndexOf("."));
		     String fileName2=uploadFile.getOriginalFilename();
		     
		     
			String extend=fileName2.substring(fileName2.lastIndexOf(".")+1);
			
			System.out.println("파일명:"+fileName);
			System.out.println("확장자:"+extend);
			
			
			fileName=fileName+"-"+UUID.randomUUID()+"."+extend;
			System.out.println("파일명:"+fileName);
			
			uploadFile.transferTo(new File("c:/upload/"+fileName));
			vo.setQna_img(fileName);
		}
		System.out.println(vo);
		
		service.register(vo);
		
		return "redirect:/qna/list";
	}
	
	@RequestMapping("/qna/view")
	public void view(Long qna_bno, Model model) {
		
		QNAVO vo = service.getQNA(qna_bno);
		
		System.out.println(vo);
		
		model.addAttribute("qna", vo);
	}
	

	@RequestMapping(value="/qna/modify", method=RequestMethod.GET)
	public void modify(Long qna_bno, Model model) {
		
		model.addAttribute("qna_bno",qna_bno);
		view(qna_bno, model);
	}
	
	@RequestMapping(value="/qna/modify", method=RequestMethod.POST)
	public String modify(QNAVO vo) throws IllegalStateException, IOException {
		
		MultipartFile uploadFile = vo.getUploadFile();

		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();

			fileName=fileName.substring(0,fileName.lastIndexOf("."));
		     String fileName2=uploadFile.getOriginalFilename();
		     
		     
			String extend=fileName2.substring(fileName2.lastIndexOf(".")+1);
			
			System.out.println("파일명:"+fileName);
			System.out.println("확장자:"+extend);
			
			
			fileName=fileName+"-"+UUID.randomUUID()+"."+extend;
			System.out.println("파일명:"+fileName);
			
			uploadFile.transferTo(new File("c:/upload/"+fileName));
			vo.setQna_img(fileName);
		}
		
		service.modify(vo);
		
		
		return "redirect:/qna/list";
	}
	
	@RequestMapping("/qna/remove")
	public String remove(Long qna_bno) {
		
		service.remove(qna_bno);
		
		return "redirect:/qna/list";
	}
	
}
