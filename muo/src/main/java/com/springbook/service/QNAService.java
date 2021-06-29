package com.springbook.service;

import java.util.List;

import com.springbook.domain.Criteria;
import com.springbook.domain.QNAVO;

public interface QNAService {
	
	public void register(QNAVO vo);
	
	public QNAVO getQNA(Long qna_bno);
	
	public boolean modify(QNAVO vo);
		
	public boolean remove(Long qna_bno);
	
	public List<QNAVO> getList();
	
	public List<QNAVO> getListWithPaging(Criteria cri);
	
	public int getTotalCount(Criteria cri);
	
}
