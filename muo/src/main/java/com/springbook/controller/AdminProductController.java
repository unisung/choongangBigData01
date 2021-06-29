package com.springbook.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springbook.domain.Criteria;
import com.springbook.domain.PageDTO;
import com.springbook.domain.ProductVO;
import com.springbook.service.ProductService;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
public class AdminProductController {

	/* @Setter(onMethod_=@Autowired) */
	private ProductService service;
	
	
	@RequestMapping(value="/admin/product/list", method=RequestMethod.GET)
	public void list(Model model, Criteria cri) {
		/* System.out.println("list" + service.getList()); */
		
		model.addAttribute("list", service.getListWithPaging(cri));
		int total = service.getTotalCount(cri);
		
		model.addAttribute("pageMaker", new PageDTO(cri, total));
	}
	
	@RequestMapping(value="/admin/product/write", method=RequestMethod.GET)
	public void registers(ProductVO vo) {
		
	}
	
	@RequestMapping(value="/admin/product/write", method=RequestMethod.POST)
	public String register(ProductVO vo, RedirectAttributes rttr) throws IllegalStateException, IOException {
		
		MultipartFile uploadFile1 = vo.getUploadFile1();
		MultipartFile uploadFile2 = vo.getUploadFile2();
		MultipartFile uploadFile3 = vo.getUploadFile3();
		
		if(!uploadFile1.isEmpty() && !uploadFile2.isEmpty() && !uploadFile3.isEmpty()) {
			
			String fileName1 = uploadFile1.getOriginalFilename();
			String fileName2 = uploadFile2.getOriginalFilename();
			String fileName3 = uploadFile3.getOriginalFilename();
			
			fileName1 = fileName1.substring(0,fileName1.lastIndexOf("."));
			fileName2 = fileName2.substring(0,fileName2.lastIndexOf("."));
			fileName3 = fileName3.substring(0,fileName3.lastIndexOf("."));
			
			String fileName_ex1 = uploadFile1.getOriginalFilename();
			String fileName_ex2 = uploadFile2.getOriginalFilename();
			String fileName_ex3 = uploadFile3.getOriginalFilename();
			
			String extend1 = fileName_ex1.substring(fileName_ex1.lastIndexOf(".")+1);
			String extend2 = fileName_ex2.substring(fileName_ex2.lastIndexOf(".")+1);
			String extend3 = fileName_ex3.substring(fileName_ex3.lastIndexOf(".")+1);
			
			fileName1 = fileName1 + "-" + UUID.randomUUID()+"."+extend1;
			fileName2 = fileName2 + "-" + UUID.randomUUID()+"."+extend2;
			fileName3 = fileName3 + "-" + UUID.randomUUID()+"."+extend3;
			
			uploadFile1.transferTo(new File("c:\\upload\\tmp"+fileName1));
			uploadFile2.transferTo(new File("c:\\upload\\tmp"+fileName2));
			uploadFile3.transferTo(new File("c:\\upload\\tmp"+fileName3));
			
			vo.setIt_img1(fileName1);
			vo.setIt_img2(fileName2);
			vo.setIt_img3(fileName3);
		}
		
		service.register(vo);
	    rttr.addFlashAttribute(vo.getIt_number());
		
		return "redirect:/admin/product/list";
	}
	
	@RequestMapping("/admin/product/get")
	public void getProduct(Long it_number, Model model) {
		
		ProductVO vo = service.getProduct(it_number);
		
		model.addAttribute("product", vo);
	}
	
	@PostMapping("admin/product/modify")
	public String modify(ProductVO vo) throws IllegalStateException, IOException {
		
		MultipartFile uploadFile1 = vo.getUploadFile1();
		MultipartFile uploadFile2 = vo.getUploadFile2();
		MultipartFile uploadFile3 = vo.getUploadFile3();
		
		if(!uploadFile1.isEmpty() && !uploadFile2.isEmpty() && !uploadFile3.isEmpty()) {
			
			String fileName1 = uploadFile1.getOriginalFilename();
			String fileName2 = uploadFile2.getOriginalFilename();
			String fileName3 = uploadFile3.getOriginalFilename();
			
			fileName1 = fileName1.substring(0,fileName1.lastIndexOf("."));
			fileName2 = fileName2.substring(0,fileName2.lastIndexOf("."));
			fileName3 = fileName3.substring(0,fileName3.lastIndexOf("."));
			
			String fileName_ex1 = uploadFile1.getOriginalFilename();
			String fileName_ex2 = uploadFile2.getOriginalFilename();
			String fileName_ex3 = uploadFile3.getOriginalFilename();
			
			String extend1 = fileName_ex1.substring(fileName_ex1.lastIndexOf(".")+1);
			String extend2 = fileName_ex2.substring(fileName_ex2.lastIndexOf(".")+1);
			String extend3 = fileName_ex3.substring(fileName_ex3.lastIndexOf(".")+1);
			
			fileName1 = fileName1 + "-" + UUID.randomUUID()+"."+extend1;
			fileName2 = fileName2 + "-" + UUID.randomUUID()+"."+extend2;
			fileName3 = fileName3 + "-" + UUID.randomUUID()+"."+extend3;
			
			uploadFile1.transferTo(new File("c:\\upload\\tmp"+fileName1));
			uploadFile2.transferTo(new File("c:\\upload\\tmp"+fileName2));
			uploadFile3.transferTo(new File("c:\\upload\\tmp"+fileName3));
			
			vo.setIt_img1(fileName1);
			vo.setIt_img2(fileName2);
			vo.setIt_img3(fileName3);
		}
		
		
		service.modify(vo);
		
		
		return "redirect:/admin/product/list";
	}
	
	@RequestMapping("/admin/product/listModify")
	public String listModify(ProductVO vo, @ModelAttribute("cri") Criteria cri) {
		
		System.out.println("처리전 vo = " + vo);
		
		System.out.println("it_number: " + vo.getIt_number());
		
		String str = vo.getIt_category2();
		String[] name = str.split(",");
		
		vo.setIt_category2(name[0]); 
		
		service.listModify(vo);

		System.out.println("처리후 vo = " + vo);
		System.out.println("=========================================");
		
		return "redirect:/admin/product/list" + cri.getListLink();
	}
	
	@RequestMapping("/admin/product/remove")
	public String remove(Long it_number) {
		
		service.remove(it_number);
		return "redirect:/admin/product/list";
	}
	
}










