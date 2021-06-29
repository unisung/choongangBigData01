package com.springbook.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomNoOpPasswordEncoder implements PasswordEncoder{

	/* 패스워드 암호화 메소드*/
	@Override
	public String encode(CharSequence rawPassword) {
		  log.warn("before encode: "+rawPassword);
		return rawPassword.toString();
	}

	 /* 암호화 된 비번과 평문으로 입력받은 비번 비교 메소드*/
	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		log.warn("matches: "+rawPassword+":"+encodedPassword);
		return rawPassword.toString().equals(encodedPassword);
	}

}
