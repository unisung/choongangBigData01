package org.zerock.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.zerock.domain.MemberVO;

import lombok.Data;

@Data
public class CustomUser extends User {

	   private MemberVO member;

	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	public CustomUser(MemberVO vo) {
		super(vo.getUserid(), vo.getUserpw(), 
				  vo.getAuthList().stream()
				  .map(auth->new SimpleGrantedAuthority(auth.getAuth()))
				  .collect(Collectors.toList()));
		this.member = vo;
	}
	
	
	
	
	
	

}
