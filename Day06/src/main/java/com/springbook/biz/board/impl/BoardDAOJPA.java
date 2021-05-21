package com.springbook.biz.board.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.BoardVO2;

@Repository
public class BoardDAOJPA {
	@PersistenceContext
	private EntityManager em;

	public void insertBoard(BoardVO vo) {
		
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> JPA로 getBoardList() 기능 실행");
		String jpql="from BoardVO b order by b.re_ref, b.seq";
		return em.createQuery(jpql).getResultList();
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

	public void updateBoardCnt(BoardVO vo) {
		// TODO Auto-generated method stub
		
	}

	public BoardVO2 getBoard2(BoardVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
