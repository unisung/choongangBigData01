package com.springbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.domain.NoticeVO;
import com.springbook.domain.QNAVO;
import com.springbook.mapper.AdminMainMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class AdminMainServiceImpl implements AdminMainService {

	@Setter(onMethod_ = @Autowired )
	private AdminMainMapper mapper;

	@Override
	public int getRemainCount() {
		return mapper.getRemainCount();
	}

	@Override
	public int getSoldOut() {
		return mapper.getSoldOut();
	}

	@Override
	public int getSale() {
		return mapper.getSale();
	}

	@Override
	public int getNewOrder() {
		return mapper.getNewOrder();
	}

	@Override
	public int getProgress() {
		return mapper.getProgress();
	}

	@Override
	public int getArrival() {
		return mapper.getArrival();
	}

	@Override
	public int getChange() {
		return mapper.getChange();
	}

	@Override
	public int getRefund() {
		return mapper.getRefund();
	}

	@Override
	public List<QNAVO> getQnaList() {
		return mapper.getQnaList();
	}

	@Override
	public List<NoticeVO> getNoticeList() {
		return mapper.getNoticeList();
	}


	
}
