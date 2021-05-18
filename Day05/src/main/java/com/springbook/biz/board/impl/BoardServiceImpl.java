package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.common.LogAdvice;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDAOMybatis dao;

	//0번글은 등록이 안되도록 예외 처리 설정
	@Override
	public void insertBoard(BoardVO vo) {
	 dao.insertBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {

		return dao.getBoardList(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
;
		dao.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {

		dao.delete(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
       //  dao.updateBoardCount(vo);
		return dao.getBoard(vo);
	}

	@Override
	public int getTotalCount(BoardVO vo) {
		return dao.getTotalCount(vo);
	}

	@Override
	public void insertReplyBoard(BoardVO vo) {
	  dao.insertReplyBoard(vo);
	  
	}

	@Override
	public void updateReSeq(BoardVO vo) {
		dao.updateReSeq(vo);
		
	}

	@Override
	public List<BoardVO> getReplies(BoardVO vo) {
		return dao.getReplies(vo);
	}

	@Override
	public void upGood(BoardVO vo) {
		dao.upGood(vo);
	}

	@Override
	public void upBad(BoardVO vo) {
	   dao.upBad(vo);
	}

	@Override
	public List<BoardVO> getBoardList2(BoardVO vo) {
		return dao.getBoardList2(vo);
	}
}
