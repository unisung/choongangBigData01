package com.springbook.biz.board.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.BoardVO2;

@Repository
public class BoardDAOJPA {
	@PersistenceContext
	private EntityManager em;

	public void insertBoard(BoardVO vo) {
		System.out.println("===> JPA로 insertBoard() 기능 실행");
		em.persist(vo);
		BoardVO board = em.find(BoardVO.class,vo.getSeq());
		board.setRe_ref(vo.getSeq());
		em.merge(board);
	}
	
	public void updateRef(BoardVO vo) {
		System.out.println("===> JPA로 updateRe_Ref() 기능 실행");
		vo.setRe_ref(vo.getSeq());
		em.merge(vo);
	}
	
	
public List<BoardVO> getBoardList(BoardVO vo) {
	  System.out.println("===> JPA로 getBoardList() 기능 실행"); 
	  String jpql="from BoardVO b order by b.re_ref, b.seq"; 
	  return em.createQuery(jpql).getResultList(); 
}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("===> JPA로 updateBoard() 기능 실행");
		em.merge(vo);
	}

	public void delete(BoardVO vo) {
		System.out.println("===> JPA로 delete() 기능 실행");
		em.remove(em.find(BoardVO.class, vo.getSeq()));
	}

	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> JPA로 getBoard() 기능 실행");
		System.out.println("vo.getSeq()---------:"+vo.getSeq());
		return em.find(BoardVO.class, vo.getSeq());
	}

	public int getTotalCount(BoardVO vo) {
		String jpql="select count(b) from BoardVO b";		
		switch (vo.getSearchCondition()) {
		case "TITLE": jpql=jpql+" where b.title like '%'||:searchKeyword||'%'";
				break;
		case "CONTENT": jpql=jpql+" where b.content like '%'||:searchKeyword||'%'";
			break;
		}
		
		 System.out.println("getBoardListJPADAO-jpql:"+jpql);
		 
			TypedQuery<Long> query =em.createQuery(jpql,Long.class);
		
		if(vo.getSearchCondition().equals("TITLE") || vo.getSearchCondition().equals("CONTENT"))
			query.setParameter("searchKeyword", vo.getSearchKeyword());
		
		 long totalCount = query.getSingleResult();
		 System.out.println("totalCount:"+totalCount);
		return (int)totalCount;
	}

	public void insertReplyBoard(BoardVO vo) {
		System.out.println("===> JPA로 insertReplyBoard() 기능 실행");
		BoardVO board = vo;
		em.persist(board);
	}

	public void updateReSeq(BoardVO vo) {
		System.out.println("===> JPA로 updateReSeq() 기능 실행");
		System.out.println("vo.getRe_ref()"+vo.getRe_ref());
		System.out.println("vo.getRe_seq()"+vo.getRe_seq());
		String jpql="update BoardVO b set b.re_seq=b.re_seq+1 where b.re_ref=:re_ref and b.re_seq > :re_seq";
		em.createQuery(jpql)
		.setParameter("re_ref", vo.getRe_ref())
		.setParameter("re_seq", vo.getRe_seq())
		.executeUpdate();
	}

	public List<BoardVO> getReplies(BoardVO vo) {
		System.out.println("===> JPA로 getBoardList() 기능 실행");
		String jpql="from BoardVO b where b.re_ref =:re_ref and b.re_seq >0 order by b.re_ref, b.seq";
		return em.createQuery(jpql).setParameter("re_ref",vo.getRe_ref()).getResultList();
	}

	public void upGood(BoardVO vo) {
		System.out.println("===> JPA로 upGood() 기능 실행");
		//BoardVO board = em.find(BoardVO.class, vo.getSeq());
		//board.setGood(vo.getGood()+1);
		//em.merge(board);
		vo.setGood(vo.getGood()+1);
		em.merge(vo);
	}

	public void upBad(BoardVO vo) {
		System.out.println("===> JPA로 upBad() 기능 실행");
		vo.setBad(vo.getBad()+1);
		em.merge(vo);
	}

	public List<BoardVO> getBoardList2(BoardVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateBoardCnt(BoardVO vo) {
		System.out.println("===> JPA로 updateBoardCnt() 기능 실행");
	    vo.setCnt(vo.getCnt()+1);
		em.merge(vo);
	}

	public BoardVO2 getBoard2(BoardVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
