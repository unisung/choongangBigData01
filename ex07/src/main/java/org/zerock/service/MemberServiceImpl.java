package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.AuthVO;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.MemberMapper;

import lombok.Data;
import lombok.Setter;

@Service
@Data
public class MemberServiceImpl implements MemberService{
	@Setter(onMethod_=@Autowired)
	private PasswordEncoder  pwencoder;
	
	@Setter(onMethod_=@Autowired)
	private MemberMapper memberMapper;
	
	@Override
	@Transactional
	public void registerMember(MemberVO member) {
		/* 회원 비밀번호 암호화 처리 */
    member.setUserpw(pwencoder.encode(member.getUserpw()));
       /* 기본 권한 부여 처리 */
	AuthVO auth = new AuthVO(member.getUserid(), "ROLE_MEMBER");
	
	memberMapper.registerMember(member);
	memberMapper.registerAuth(auth);	
	}

}
