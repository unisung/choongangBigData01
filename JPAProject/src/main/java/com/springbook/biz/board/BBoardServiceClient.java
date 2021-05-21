package com.springbook.biz.board;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BBoardServiceClient {

	public static void main(String[] args) {
		EntityManagerFactory emf
		 = Persistence.createEntityManagerFactory("JPAProject");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			 //Transaction 시작
			tx.begin();
			BBoard board = new BBoard();
			board.setTitle("JPA제목");
			board.setWriter("관리자");
			board.setContent("JPA 글 잘 등록 되네요!!!!!!????????");
			
			em.persist(board);
			
			//여러건 조회
			String jpql = "select b from BBoard b order by b.seq desc";
			List<BBoard> boardList 
			      = em.createQuery(jpql,BBoard.class).getResultList();
			
			for(BBoard brd:boardList)
				  System.out.println("---->" + brd);
			
			
			//한건 조회 find(클래스타입, primary key값);
			BBoard b=new BBoard();
			b.setSeq(5);
			b=em.find(BBoard.class, b.getSeq());
			
			System.out.println("---------------------------");
			System.out.println("상세정보:"+b);
			
			
			//수정 mrege(클래스)
			b.setTitle("JPA제목-수정---");
			b.setContent("JPA수정수정....");
			
			em.merge(b);
			
			//삭제
			//db에서 seq번호에 해당하는 객체를 얻어온 후
			//그 정보에 해당하는 정보를 db에서 제거
		BBoard bb = new BBoard();
		bb.setSeq(7);
		
		bb = em.find(BBoard.class, bb.getSeq());
		
		em.remove(bb);
			
			//db반영
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			em.close();
		}
		emf.close();
	}
}
