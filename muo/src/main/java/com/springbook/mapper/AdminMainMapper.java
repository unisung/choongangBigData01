package com.springbook.mapper;

import java.util.List;

import com.springbook.domain.NoticeVO;
import com.springbook.domain.QNAVO;

public interface AdminMainMapper {

	public int getRemainCount(); 
	
	public int getSoldOut();
	
	public int getSale();
	
	public int getNewOrder();
	
	public int getProgress();
	
	public int getArrival();
	
	public int getChange();
	
	public int getRefund();
	
	public List<QNAVO> getQnaList();
	
	public List<NoticeVO> getNoticeList();
}
