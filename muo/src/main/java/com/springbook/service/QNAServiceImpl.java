package com.springbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.domain.Criteria;
import com.springbook.domain.QNAVO;
import com.springbook.mapper.QNAMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class QNAServiceImpl implements QNAService{
	
	@Setter(onMethod_= @Autowired)
	private QNAMapper mapper;

	@Override
	public void register(QNAVO vo) {
		mapper.register(vo);
	}

	@Override
	public QNAVO getQNA(Long qna_bno) { 
		// TODO Auto-generated method stub
		return mapper.getQNA(qna_bno);
	}

	@Override
	public boolean modify(QNAVO vo) {
		// TODO Auto-generated method stub
		return mapper.modify(vo)==1;
	}

	@Override
	public boolean remove(Long qna_bno) {
		// TODO Auto-generated method stub
		return mapper.remove(qna_bno) > 0;
	}

	@Override
	public List<QNAVO> getList() {
		// TODO Auto-generated method stub
		return mapper.getList();
	}

	@Override
	public List<QNAVO> getListWithPaging(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getTotalCount(cri);
	}

}
