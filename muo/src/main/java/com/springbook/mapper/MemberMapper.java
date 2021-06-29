package com.springbook.mapper;

import java.util.List;

import com.springbook.domain.AuthVO;
import com.springbook.domain.Criteria;
import com.springbook.domain.MemberVO;

public interface MemberMapper {
	public MemberVO read(String userid);

	public void registerMember(MemberVO member);

	public void registerAuth(AuthVO auth);
	
	public MemberVO get(int mb_seq);
	public int delete(int mb_seq);
	public int update(MemberVO vo);
	public List<MemberVO> getList();
	public List<MemberVO> getListWithPaging(Criteria cri);
	int getTotalCount(Criteria cri);
	public String findPW(MemberVO vo);

}
