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
	user.setId("hong");
	user.setPassword("1234");
	user.setName("홍길동");
	user.setRole("user");
	
    service.insertUser(user);
	
	System.out.println("완료");
	
	
	//회원정보 조회
	
	user.setId("hong");
	
	UserVO userVO = service.getUser(user);
	System.out.println(userVO);
	
	System.out.println("---------------------------------");
	
	
    //자원해제
	factory.close();
	}
}
