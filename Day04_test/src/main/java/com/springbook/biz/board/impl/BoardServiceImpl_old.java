package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.common.LogAdvice;

//@Service("boardService")
public class BoardServiceImpl_old 
        implements BoardService{
	@Autowired
	private BoardDAO dao;
	private LogAdvice log;
	
	
	public BoardServiceImpl_old() {
		log = new LogAdvice();
	}

	@Override
	public void insertBoard(BoardVO vo) {
		log.printLog();
		dao.insertBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		log.printLog();
		return dao.getBoardList(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		log.printLog();
		dao.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		log.printLog();
		dao.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		log.printLog();
		return dao.getBoard(vo);
	}

}
