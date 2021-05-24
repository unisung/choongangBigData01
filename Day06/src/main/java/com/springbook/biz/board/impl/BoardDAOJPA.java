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
	  String jpql ="select b from BoardVO b ";
	  switch(vo.getSearchCondition()) {
	  /* named binding변수 :변수명 */
	  case "TITLE": jpql=jpql+" where title like '%'||:searchKeyword||'%' ";
		  break;
	  case "CONTENT": jpql=jpql+" where content like '%'||:searchKeyword||'%' ";
		  break;
	  }
	  
	   jpql = jpql + " order by b.re_ref desc, b.re_seq";
	   
	   System.out.println("getBoardList-sql:"+jpql);
	   
	   TypedQuery<BoardVO> query = em.createQuery(jpql,BoardVO.class);

	   //searchCondtion이 CONTENT나 TITLE일때만 파라미터설정
	   if(vo.getSearchCondition().length()>0) // "" <->null
	    query.setParameter("searchKeyword", vo.getSearchKeyword());
	   //1~10까지 데이타 추출
	   query.setFirstResult(vo.getStartRow());//페이지의 시작행
	   query.setMaxResults(vo.getEndRow() - vo.getStartRow()+1);//n-m+1 :한 페이지당 출력 행수 
	   
	   return query.getResultList();
}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("===> JPA로 updateBoard() 기능 실행");
		System.out.println("updateBoard- vo-----:"+vo);
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
		case "TITLE": jpql=jpql+" where b.title like '%'||?1|'%'";
				break;
		case "CONTENT": jpql=jpql+" where b.content like '%'||?1||'%'";
			break;
		}
		 System.out.println("getBoardListJPADAO-jpql:"+jpql);
			TypedQuery<Long> query =em.createQuery(jpql,Long.class);
		
		if(vo.getSearchCondition().equals("TITLE") || vo.getSearchCondition().equals("CONTENT"))
			query.setParameter(1, vo.getSearchKeyword());
			//query.setParameter("searchKeyword", vo.getSearchKeyword());
		
		//쿼리결과 한건의 데이타 추출 getSingleResult();
		 long totalCount = query.getSingleResult();
		 System.out.println("totalCount:"+totalCount);
		return (int)totalCount;
	}

	public void insertReplyBoard(BoardVO vo) {
		System.out.println("===> JPA로 insertReplyBoard() 기능 실행");
		em.persist(vo);
	}

	public void updateReSeq(BoardVO vo) {
		System.out.println("===> JPA로 updateReSeq() 기능 실행");
		System.out.println("vo.getRe_ref()"+vo.getRe_ref());
		System.out.println("vo.getRe_seq()"+vo.getRe_seq());
		String jpql=
	"update BoardVO b set b.re_seq=b.re_seq+1 where b.re_ref=?1 and b.re_seq > ?2";
		em.createQuery(jpql)	
		.setParameter(1, vo.getRe_ref())
		.setParameter(2, vo.getRe_seq())
		.executeUpdate();
	}

	public List<BoardVO> getReplies(BoardVO vo) {
		System.out.println("===> JPA로 getBoardList() 기능 실행");
		String jpql="from BoardVO b where b.re_ref =:re_ref and b.re_seq >0 order by b.re_ref, b.seq";
		return em.createQuery(jpql).setParameter("re_ref",vo.getRe_ref()).getResultList();
	}

	public void upGood(BoardVO vo) {
		System.out.println("===> JPA로 upGood() 기능 실행");
		System.out.println("upGood1:"+vo);
		BoardVO board = em.find(BoardVO.class, vo.getSeq());
		board.setGood(board.getGood()+1);
		System.out.println("upGood2:"+board);
		em.merge(board);
	}

	//파라미터로 넘어온 BoardVO가 seq값만 있으므로 DB에서 전체 정보를 얻고나서, 속성 수정후 저장.
	public void upBad(BoardVO vo) {
		System.out.println("===> JPA로 upBad() 기능 실행");
		BoardVO board = em.find(BoardVO.class, vo.getSeq());
		board.setBad(board.getBad()+1);
		em.merge(board);
	}

	public List<BoardVO> getBoardList2(BoardVO vo) {
		return null;
	}

	//파라미터로 넘어온 BoardVO가 정보를 완전히 저장한경우,수정할 속성만 처리.
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
