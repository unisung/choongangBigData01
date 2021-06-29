package org.zerock.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping("/sendEmail")
	public void sendEmail(HttpServletRequest request, 
			                           HttpServletResponse response) throws Exception{
		
		//메일관련정보
		String host ="smtp.naver.com";
		final String username="vctor"; //네이버 이메일 주소중 @naver.com 앞주소만 작성
		final String password="naver1234!"; //네이버 비밀번호
		int port=465;                  //네이버 SMTP 포트 번호
		
		//메일내용
		String recipient = "vctor@naver.com";//메일 발송할 이메일 주소
		String subject ="이메일 발송시 제목";//
		String body ="이름: 홍길동입니다. \n\n"; //메일 작성시 내용
		
		Properties props = System.getProperties();
		
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.trust",host);
		
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			String un=username;
			String pw=password;
			protected  PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(un, pw);
			}
		});
		
		session.setDebug(true);//디버그 설정
		
		//메일 객체 생성
		Message mimeMessage = new MimeMessage(session);
		mimeMessage.setFrom(new InternetAddress("vctor@naver.com"));//발신자
		mimeMessage.setRecipient(Message.RecipientType.TO, 
				                                  new InternetAddress(recipient)); //수신자
		mimeMessage.setSubject(subject);//메일 제목
		mimeMessage.setText(body);//메일 내용
		
		//메일 발송
		Transport.send(mimeMessage);
	}
	
	
	@RequestMapping("/sendGmail")
	public void sendGmail(HttpServletRequest request, 
			                           HttpServletResponse response) throws Exception{
		
		//지메일관련정보
		String host ="smtp.gmail.com";
		final String username="unisung001@gmail.com"; //gmail주소
		final String password="tempPassword!"; //gmail 비밀번호
		int port=465;                  //gmail SMTP 포트 번호
		
		//메일내용
		String recipient = "vctor@naver.com";//메일 발송할 이메일 주소
		String subject ="단체 메일을 발송합니다.";//
		String body ="6월30일 프로젝트발표회가 있습니다. \n\n"; //메일 작성시 내용
		
		//SMTP 서버 설정
		Properties props = new Properties();
		
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.trust",host);
		
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			String un=username;
			String pw=password;
			protected  PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(un, pw);
			}
		});
		
		
		session.setDebug(true);//디버그 설정
		
		//다중메일 발송
		InternetAddress[] addArray = new InternetAddress[3];
		addArray[0]=new InternetAddress("vctor@naver.com");
		addArray[1]=new InternetAddress("user001@gmail.com");
		addArray[2]=new InternetAddress("coolkh2@naver.com");
		
		
		//메일 객체 생성
		Message mimeMessage = new MimeMessage(session);
		mimeMessage.setFrom(new InternetAddress(username));//발신자
		
		
		/*
		 * mimeMessage.setRecipient(Message.RecipientType.TO, new
		 * InternetAddress(recipient)); //수신자
		 */		
		mimeMessage.setRecipients(Message.RecipientType.TO, addArray); //수신자
		
		mimeMessage.setSubject(subject);//메일 제목
		
		mimeMessage.setText(body);//메일 내용
		
		//메일 발송
		Transport.send(mimeMessage);
	}
}
