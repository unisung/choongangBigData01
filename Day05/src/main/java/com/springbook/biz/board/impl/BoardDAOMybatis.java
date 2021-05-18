package com.springbook.biz.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository
public class BoardDAOMybatis {
	@Autowired
	private SqlSessionTemplate mybatis;

	public void insertBoard(BoardVO vo) {
		System.out.println("===> Mybatis로 insertBoard() 기능 실행");
		mybatis.insert("BoardDAO.insertBoard",vo);
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		return mybatis.selectList("BoardDAO.getBoardList", vo);
	}

	public void updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		
	}

	public void delete(BoardVO vo) {
		// TODO Auto-generated method stub
		
	}

	public BoardVO getBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getTotalCount(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void insertReplyBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		
	}

	public void updateReSeq(BoardVO vo) {
		// TODO Auto-generated method stub
		
	}

	public List<BoardVO> getReplies(BoardVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public void upGood(BoardVO vo) {
		// TODO Auto-generated method stub
		
	}

	public void upBad(BoardVO vo) {
		// TODO Auto-generated method stub
		
	}

	public List<BoardVO> getBoardList2(BoardVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
