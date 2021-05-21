package com.springbook.biz.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.BoardVO2;

@Repository
public class BoardDAOMybatis {
	@Autowired
	private SqlSessionTemplate mybatis;

	public void insertBoard(BoardVO vo) {
		System.out.println("===> Mybatis로 insertBoard() 기능 실행");
		mybatis.insert("BoardDAO.insertBoard",vo);
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Mybatis로 getBoardList() 기능 실행");
		return mybatis.selectList("BoardDAO.getBoardList", vo);
	}

	public void updateBoard(BoardVO vo) {
		System.out.println("===> Mybatis로 updateBoard() 기능 실행");
		 mybatis.update("BoardDAO.updateBoard", vo);
	}

	public void delete(BoardVO vo) {
		System.out.println("===> Mybatis로 updateBoard() 기능 실행");
		mybatis.delete("BoardDAO.deleteBoard",vo);
	}

	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Mybatis로 getBoard() 기능 실행");
		return mybatis.selectOne("BoardDAO.getBoard", vo);
	}
	
	public int getTotalCount(BoardVO vo) {
		System.out.println("===> Mybatis로 getTotalCount() 기능 실행");
		return mybatis.selectOne("BoardDAO.getTotalCount", vo);
	}

	public void insertReplyBoard(BoardVO vo) {
		System.out.println("===> Mybatis로 insertReplyBoard() 기능 실행");
		mybatis.insert("BoardDAO.insertReply",vo);
	}

	public void updateReSeq(BoardVO vo) {
		System.out.println("===> Mybatis로 updateReSeq() 기능 실행");
		mybatis.update("BoardDAO.updateReSeq", vo);
	}

	public List<BoardVO> getReplies(BoardVO vo) {
		System.out.println("===> Mybatis로 getReplies() 기능 실행");
		return mybatis.selectList("BoardDAO.getReplies", vo);
	}

	public void upGood(BoardVO vo) {
		System.out.println("===> Mybatis로 upGood() 기능 실행");
		mybatis.update("BoardDAO.upGood",vo);
	}

	public void upBad(BoardVO vo) {
		System.out.println("===> Mybatis로 upBad() 기능 실행");
		mybatis.update("BoardDAO.upBad",vo);
	}

	public List<BoardVO> getBoardList2(BoardVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateBoardCnt(BoardVO vo) {
		System.out.println("===> Mybatis로 updateBoardCnt() 기능 실행");
		mybatis.update("BoardDAO.updateBoardCnt", vo);
	}

	public BoardVO2 getBoard2(BoardVO vo) {
		System.out.println("===> Mybatis로 getBoard2() 기능 실행");
		return mybatis.selectOne("BoardDAO.getBoard2", vo);
	}

}
