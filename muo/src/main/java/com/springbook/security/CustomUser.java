package com.springbook.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import com.springbook.domain.MemberVO;

import lombok.Data;

@Data
public class CustomUser extends User {

	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MemberVO member;

	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	public CustomUser(MemberVO vo) {
		super(vo.getMb_id(), vo.getMb_pw(), 
				  vo.getAuthList().stream()
				  .map(auth->new SimpleGrantedAuthority(auth.getAuth()))
				  .collect(Collectors.toList()));
		this.member = vo;
	}
	
	
	
	
	
	

}
