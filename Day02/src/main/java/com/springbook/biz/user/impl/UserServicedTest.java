package com.springbook.biz.user.impl;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.user.UserVO;

public class UserServicedTest {

public static void main(String[] args) throws Exception{
AbstractApplicationContext factory = 
 new GenericXmlApplicationContext("applicationContext12.xml");
		 
	UserService service =(UserService)factory.getBean("userService");
	
	UserVO user = new UserVO();
	user.setId("kim");
	user.setPassword("1234");
	user.setName("김길동");
	user.setRole("admin");
	
	//"hong" 아이디 존재여부확인
	int result = service.getUserCnt(user);
	
	if(result==0) {
       service.insertUser(user);
	}else {
		System.out.println("이미 존재하는 아이디입니다.");
	}
	System.out.println("완료");
	
	
	//회원정보 조회
	
	user.setId("kim");
	
	UserVO userVO = service.getUser(user);
	System.out.println(userVO);
	
	System.out.println("---------------------------------");
	
	//로그인 테스트
	user.setId("kim");
	user.setPassword("1234");
	
	//객체 -UserVO 혹은 null
	if(service.getUserCntByPass(user)==1) {
		System.out.println("로그인 성공!");
		//세션에 저장.
	}else {
		System.out.println("id나 패스워드를 확인하세요");
	}
	
	//비밀번호 변경
	if(service.getUserCntByPass(user)==1) {
		  //변경할 비밀번호 
		user.setPassword("5678");
		service.updateUser(user);//변경처리
	}else {
		System.out.println("id나 패스워드를 확인하세요");
	}
	
	
	userVO = service.getUser(user);
	System.out.println(userVO);
	
	
	
	
    //자원해제
	factory.close();
	}
}
