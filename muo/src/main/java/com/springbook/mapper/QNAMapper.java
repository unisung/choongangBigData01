package com.springbook.mapper;

import java.util.List;

import com.springbook.domain.Criteria;
import com.springbook.domain.QNAVO;

public interface QNAMapper {

	public List<QNAVO> getList();
	
	public List<QNAVO> getListWithPaging(Criteria cri);
	
	public void register(QNAVO vo);
	
	public QNAVO getQNA(Long qna_bno);
	
	public int modify(QNAVO vo);
	
	public int remove(Long qna_bno);
	
	public int getTotalCount(Criteria cri);
}
