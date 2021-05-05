package com.springbook.biz.board.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.board.BoardVO;

public class BoardServicedTest_old {

public static void main(String[] args) {
AbstractApplicationContext factory = 
 new GenericXmlApplicationContext("applicationContext11.xml");
		 
	BoardService service =(BoardService)factory.getBean("boardService");
	
	BoardVO board = new BoardVO();
	board.setTitle("게시글 테스트1");
	board.setWriter("홍길동");
	board.setContent("게시글 테스트 내용 1");
	
	service.insertBoard(board);
	
	System.out.println("완료");
	
	
	//게시글 리스트
	List<BoardVO> list = service.getBoardList(board);
	for(BoardVO vo:list)
		 System.out.println(vo);
	
	System.out.println("---------------------------------");
	board.setSeq(3);
	
	//한 건 조회
	BoardVO boardVO = service.getBoard(board);
	
	System.out.println(boardVO);
	
	//수정
	board.setSeq(3);
	board.setTitle("테스트 글 3번 수정");
	board.setContent("테스트 글 3번 수정 내용");
	//수정 처리
	service.updateBoard(board);
	
	System.out.println("-------------------------------------");
	//수정결과 조회
	boardVO = service.getBoard(board);
	System.out.println(boardVO);
	
	//삭제
	board.setSeq(1);
	//삭제 처리
	service.deleteBoard(board);
	
	//결과 보기
	list = service.getBoardList(board);
	for(BoardVO vo:list)
		 System.out.println(vo);
	
	System.out.println("---------------------------------");
	
    //자원해제
	factory.close();
	}
}
