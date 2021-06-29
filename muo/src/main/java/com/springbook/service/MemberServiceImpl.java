package com.springbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springbook.domain.AuthVO;
import com.springbook.domain.Criteria;
import com.springbook.domain.MemberVO;
import com.springbook.mapper.MemberMapper;

import lombok.Data;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
@Service
@Log4j
@Data
public class MemberServiceImpl implements MemberService {

	
	@Setter(onMethod_=@Autowired)
	private PasswordEncoder  pwencoder;
	
	@Setter(onMethod_=@Autowired)
	private MemberMapper memberMapper;
	
	@Override
	@Transactional
	public void registerMember(MemberVO vo) {
		/* 회원 비밀번호 암호화 처리 */
    vo.setMb_pw(pwencoder.encode(vo.getMb_pw()));
       /* 기본 권한 부여 처리 */
	AuthVO auth = new AuthVO(vo.getMb_id(), "ROLE_MEMBER");
	
	memberMapper.registerMember(vo);
	memberMapper.registerAuth(auth);	
	}

	@Override
	public MemberVO get(int mb_seq) {
		return memberMapper.get(mb_seq);
	}

	@Override
	public boolean modify(MemberVO member) {
		return memberMapper.update(member)==1;
	}

	@Override
	public boolean remove(int mb_seq) {
		return memberMapper.delete(mb_seq)==1;
	}

	@Override
	public List<MemberVO> getListWithPaging(Criteria cri) {
		return memberMapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		return memberMapper.getTotalCount(cri);
	}

	@Override
	public List<MemberVO> getList() {
		return memberMapper.getList();
	}

	@Override
	public String findPW(MemberVO member) {
		return memberMapper.findPW(member);
	}
	

}