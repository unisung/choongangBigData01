package org.zerock.controller;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.domain.ProductVO;
import org.zerock.domain.UserVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/list")
	public void list(Model model) {
		List<ProductVO> list =Arrays.asList(
				new ProductVO(1, "DB.jpg", "3조 DB", 10000),
				new ProductVO(2, "DB.jpg", "3조 DB", 10000),
				new ProductVO(3, "DB.jpg", "3조 DB", 10000),
				new ProductVO(4, "DB.jpg", "3조 DB", 10000),
				
				new ProductVO(5, "DB.jpg", "3조 DB", 10000),
				new ProductVO(6, "DB.jpg", "3조 DB", 10000),
				new ProductVO(7, "DB.jpg", "3조 DB", 10000),
				new ProductVO(8, "DB.jpg", "3조 DB", 10000),
				
				new ProductVO(9, "DB.jpg", "3조 DB", 10000),
				new ProductVO(10, "DB.jpg", "3조 DB", 10000),
				new ProductVO(11, "DB.jpg", "3조 DB", 10000),
				new ProductVO(12, "DB.jpg", "3조 DB", 10000),
				
				new ProductVO(13, "DB.jpg", "3조 DB", 10000),
				new ProductVO(14, "DB.jpg", "3조 DB", 10000),
				new ProductVO(15, "DB.jpg", "3조 DB", 10000)
				);
		
		model.addAttribute("list",list);
	}
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public void login() {}
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String loginPro(UserVO vo, HttpSession session, HttpServletResponse response) {
		if(vo.getId().equals("hong") & vo.getPwd().equals("1234")) {
			 session.setAttribute("use", vo);
			 Cookie cookie = new Cookie("id",vo.getId());
			 Cookie cookie2 = new Cookie("pwd",vo.getPwd());
			 response.addCookie(cookie);
			 response.addCookie(cookie2);
		}
		
		return "redirect:/";
	}
	
	@RequestMapping("/logout")
	public String logout(UserVO vo,HttpSession session, HttpServletResponse response) {
		session.invalidate();
		
		Cookie cookie = new Cookie("id",vo.getId());
		 Cookie cookie2 = new Cookie("pwd",vo.getPwd());
		 cookie.setMaxAge(0);
		 cookie2.setMaxAge(0);
		 
		 response.addCookie(cookie);
		 response.addCookie(cookie2);
		return "redirect:/login";
	}
	
	@RequestMapping("/monthly")
	public void monthly( Model model) {
		LocalDate date = LocalDate.now();
		
		System.out.println(date.getYear());
		System.out.println(date.getMonthValue()<10?"0"+date.getMonthValue():date.getMonthValue());
		System.out.println(date.getDayOfMonth()<10?"0"+date.getDayOfMonth():date.getDayOfMonth());
		
		LocalDate date2 = LocalDate.of(date.getYear(), date.getMonthValue(), date.getDayOfMonth());
		
		System.out.println(date2.getYear()+"-"+(date2.getMonthValue()-1)+"-"+date2.getDayOfMonth());
		model.addAttribute("currentYear", date.getYear());
		model.addAttribute("currentMonth",date.getMonthValue());
		model.addAttribute("currentDate", date.getDayOfMonth());
		
		LocalDate date3=date.minusMonths(7);
		System.out.println(date3.getYear()+"-"+date3.getMonthValue()+"-"+date3.getDayOfMonth());
		
		LocalDate date4=date.plusMonths(7);
		System.out.println(date4.getYear()+"-"+date4.getMonthValue()+"-"+date4.getDayOfMonth());
		
		model.addAttribute("currentYear", date3.getYear());
		model.addAttribute("currentMonth",date3.getMonthValue());
		model.addAttribute("currentDate", date3.getDayOfMonth());
		
	}
}
