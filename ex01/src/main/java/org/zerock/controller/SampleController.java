package org.zerock.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	//@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping("") /*  /sample/ */
	public void basic() {
		log.info("basic..................");
	}
	
	@RequestMapping("/write1") /*  /sample/write1 */
	public void write1() {
		log.info("write1..................");
	}
	
	@RequestMapping("/write2") /*  /sample/write2 */
	public void write2() {
		log.info("write2..................");
	}

	/* /sample/basic -> /sample/basic.jsp */
	@RequestMapping(value="/basic",method= {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		log.info("basic get.....");
	}
	
	@GetMapping("/basicOnlyGet") /*  /sample/basicOnlyGet -> basicOnlyGet.jsp */
	public void basicOnlyGet() {
		log.info("basic get only get .............");
	}
	
	/* 콘트롤러의 파라미터 수집 
	 * get방식 전송 
	 * - url에 파라미터 전송.
	 * -<a href="경로">
	 * - 자바스크립트 location.href="경로"
	 * - sendRedirect("경로")
	 * - <form method="get">
	 * */
	@GetMapping("/ex01") /* /sample/ex01 */
	public void ex01(SampleDTO dto) {
		log.info(" "+dto);
	}
	
	/*  파라미터값을 배열이나 리스트로 받은 경우 */
	@RequestMapping(value="/ex02List", method=RequestMethod.GET)
	public void ex02List(@RequestParam("ids") ArrayList<String> ids,
			  Model model) {
		log.info("ids:"+ids);
		model.addAttribute("ids",ids);
	}
	
	@RequestMapping(value="/ex02Array", method=RequestMethod.GET)
	public void ex02Array(@RequestParam("ids") String[] ids,
			  Model model) {
		log.info("ids:"+Arrays.toString(ids));
		model.addAttribute("ids",ids);
	}
	
	@GetMapping("/ex02Bean")
	public void ex02Bean(SampleDTOList list) {
		log.info("list dtos: " +list);
	}
	
	@GetMapping("/ex03")
	public void ex03(TodoDTO todo) {
		log.info("todo:"+todo);
	}
	
	
}
