package com.springbook.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.springbook.domain.MemberVO;
import com.springbook.mapper.MemberMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailService implements UserDetailsService{
     @Setter(onMethod_=@Autowired)
     private MemberMapper memberMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.warn("Load User By UserName : " + username);
		
		//useName means userid
		MemberVO vo = memberMapper.read(username);
		
		log.warn("required by member mapper: " + vo);
		
		return vo==null? null : new CustomUser(vo);
	}

}
