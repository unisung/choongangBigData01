package com.springbook.service;

import java.util.List;

import com.springbook.domain.Criteria;
import com.springbook.domain.MemberVO;

public interface MemberService {
	public MemberVO get(int mb_seq);
	public boolean modify(MemberVO member);
	public boolean remove(int mb_seq);
	
	public List<MemberVO> getList();
	public List<MemberVO> getListWithPaging(Criteria cri);
	public int getTotal(Criteria cri);
	public void registerMember(MemberVO member);
	
	public String findPW(MemberVO member);
}
