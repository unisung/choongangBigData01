package org.springbook.biz.board.impl;

import org.springbook.biz.board.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl 
        implements BoardService{
	@Autowired
	private BoardDAO dao;

	@Override
	public void insertBoard(BoardVO vo) {
		dao.insertBoard(vo);
		
	}

}
