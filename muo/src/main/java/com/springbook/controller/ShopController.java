package com.springbook.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.domain.Criteria;
import com.springbook.domain.PageDTO;
import com.springbook.domain.ProductVO;
import com.springbook.domain.ShopCriteria;
import com.springbook.domain.ShopCriteria2;
import com.springbook.service.ShopService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/shop/*")
@Log4j
@AllArgsConstructor
public class ShopController {

	private ShopService service;

	@GetMapping("/list")
	public void list( ProductVO vo, ShopCriteria shop, Model model, HttpServletRequest request) {
		
		String it_category1 = request.getParameter("c1");
		String it_category2 = request.getParameter("c2");
	
		System.out.println("-------------------------------------");
		System.out.println(it_category1 + "," + it_category2);
		System.out.println("-------------------------------------");
		
		shop.setIt_category1(it_category1);
		shop.setIt_category2(it_category2);

		List<ProductVO> productlist = service.getList(shop);
		model.addAttribute("list", productlist);
		System.out.println("product" + productlist);

		int total = service.getTotalCount(shop);
		model.addAttribute("pageMaker", new PageDTO(shop, total));
	}
	
	@GetMapping("/new")
	public void getListNew(ShopCriteria2 shop2, Model model) {
		
		List<ProductVO> productlistShop = service.getListNew(shop2);
		model.addAttribute("list", productlistShop);
		System.out.println("productlistShop" + productlistShop);

		int total = service.getTotalCountNew(shop2);
		model.addAttribute("pageMaker", new PageDTO(shop2, total));
		
	}
	
	@GetMapping("/best")
	public void getListBest(ShopCriteria2 shop2, Model model) {
		
		List<ProductVO> productlistShop = service.getListBest(shop2);
		model.addAttribute("list", productlistShop);
		System.out.println("productlistShop" + productlistShop);

		int total = service.getTotalCountBest(shop2);
		model.addAttribute("pageMaker", new PageDTO(shop2, total));
		
	}
	
	@GetMapping("/sale")
	public void getListSale(ShopCriteria2 shop2, Model model) {
		
		List<ProductVO> productlistShop = service.getListSale(shop2);
		model.addAttribute("list", productlistShop);
		System.out.println("productlistShop" + productlistShop);

		int total = service.getTotalCountSale(shop2);
		model.addAttribute("pageMaker", new PageDTO(shop2, total));
		
	}
	

	@GetMapping("/view")
	public void get(Model model, String it_number) {

		ProductVO vo = service.get(it_number);
		model.addAttribute("vo", vo);
		System.out.println(vo);

	}

}
