package org.zerock.controller;


import java.security.Principal;
import java.time.LocalDateTime;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.CalendarVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.ScheduleVO;
import org.zerock.service.CalendarService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/calendar/*")
@AllArgsConstructor
public class CalendarController {
  //spring4.3이후 자동 autowired
	private CalendarService service;
	
	/* 게시글 리스트 */
	
	  @GetMapping("/monthly")//spring 4.3이후 getMapping 
	  @PreAuthorize("isAuthenticated()")
	  public void list(@ModelAttribute("calendar") CalendarVO calendar, 
			                                                  Model model,Principal principal) {
	log.info("유저...............: "+principal.getName());
  
	   log.info("list: " + calendar); 
	   if(calendar.getId()==null) calendar.setId(principal.getName());
	   
	  LocalDateTime now = LocalDateTime.now();
	  String year=String.valueOf(now.getYear());
	   //예) 2021년 4월 -> 2021-4-> 2021-04
	  String month = now.getMonthValue()>9? String.valueOf(now.getMonthValue()):"0"+String.valueOf(now.getMonthValue());
	   if(calendar.getY()==null) calendar.setY(year);
	   if(calendar.getM()==null) calendar.setM(month);
	  
	   
	   model.addAttribute("list", service.getList(calendar)); 
	   log.info("controller:---------------------------------- "+service.getScheduleList(calendar));
	   model.addAttribute("schedule", service.getScheduleList(calendar)); 
	   
	  }
	 
	  @GetMapping("/register") // /board/register
	  @PreAuthorize("isAuthenticated()")
		public void register() {
		}
	  
	  
	/* 게시글 등록 */
	@PostMapping("/register") // /board/register
	@PreAuthorize("isAuthenticated()")
	public String register(@ModelAttribute("calendar") CalendarVO calendar, 
			                        RedirectAttributes rttr, Criteria cri) {
		
		log.info("register: "+calendar);
		
	    service.register(calendar);
		//BoardServiceImple에서 insertSelectKey()메소드로 글등록 후 글 번호를 받을수 있음.
		
		rttr.addFlashAttribute("result", calendar.getY()+"-"+calendar.getM()+"-"+calendar.getD()+"-"+calendar.getSeq()); //게시글 번호를 result값으로 전달
		
		//return "redirect:/calendar/monthly?id="+calendar.getId()+"&y="+calendar.getY()+"&m="+calendar.getM();//
		return "redirect:/calendar/monthly"+cri.getCalendarLink();//
	}
	
	/* 게시글 상세 조회 / 게시글 수정 폼 */
	@GetMapping({"/get","/modify"})
	public void get(@ModelAttribute("calendar") CalendarVO calendar,
			               @ModelAttribute("schedule") ScheduleVO scheduleVO,Model model) {
		
		log.info("/get");
		log.info("------------ calenarVO: "+calendar);
		log.info("------------ scheduleVO: "+scheduleVO);
		
		scheduleVO = service.getSchedule(calendar);
		log.info(scheduleVO);
		
		
	model.addAttribute("schedule",scheduleVO);
	}
	
	
	
	/* 게시글 수정 처리 */
	@PostMapping("/modify")
	@PreAuthorize("isAuthenticated()")
	/*public String modify(BoardVO board, RedirectAttributes rttr, @ModelAttribute("cri") Criteria cri) { */
	public String modify(@ModelAttribute("calendar") CalendarVO calendar, 
			                      RedirectAttributes rttr, Criteria cri) {
		log.info("modify:" + calendar);
		
		service.modify(calendar);

		return "redirect:/calendar/monthly"+cri.getCalendarLink();/* +cri.getListLink() *///UriComponentBuilder를 이용한 파라미터 전송
	}
	
	/* 게시글 삭제 */
	@PostMapping("/remove")
	@PreAuthorize("isAuthenticated()")
	public String remove(@ModelAttribute("calendar") CalendarVO calendar, RedirectAttributes rttr,  Criteria cri) {
		log.info("remove...." + calendar);
		if(service.remove(calendar)) {
			rttr.addFlashAttribute("result","success");
		}
		

		return "redirect:/calendar/monthly";
	}
	
	
}
