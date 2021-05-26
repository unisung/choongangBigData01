package org.zerock.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.function.Consumer;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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
	
	/* 기본타입의 값 선언시 @ModelAttribute()로 선언하면 
	 *  view페이지(.jsp)까지 전달 됨
	 * */
	@GetMapping("/ex04") /* /sample/ex04 */
	/*public void ex04(SampleDTO dto, int page, Model model) {*/
	public void ex04(SampleDTO dto, @ModelAttribute("page") int page) {
		log.info("dto:"+dto);
		log.info("page:"+page);
		//model.addAttribute("page",page);
	}
	
	/* pom.xml에 jackson-databind 추가 후 */
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("/ex06......");
		
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");
		
		return dto;
	}
	
@GetMapping("/ex07")
public ResponseEntity<String> ex07(){
		log.info("/ex07....");
		
		String msg ="{\"name\":\"홍길동\"}";
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<String>(msg, header, HttpStatus.BAD_GATEWAY);
		
	}

  /* 파일 업로드 */
  @GetMapping("/exUpload")
  public void exUpload() {
	  log.info("/exUpload");
  }
  
  @PostMapping("/exUploadPost")
  public void exUploadPost(ArrayList<MultipartFile> files) {
	 // for(MultipartFile file:files) {
	//	   log.info("---------------------------");
	//	   log.info("name:" + file.getOriginalFilename());
	//	   log.info("size:"+file.getSize());
	 // }
	/*  
	  files.forEach(new Consumer<MultipartFile>() {
		@Override
		public void accept(MultipartFile file) {
            log.info("name:"+file.getOriginalFilename());
			log.info("size:"+file.getSize());
		}
	});
	*/
	  files.forEach(t-> {
	            log.info("name:"+t.getOriginalFilename());
				log.info("size:"+t.getSize());
		});
  }
}