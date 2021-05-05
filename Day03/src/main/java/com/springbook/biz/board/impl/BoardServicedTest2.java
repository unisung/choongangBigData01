package com.springbook.biz.board.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.board.BoardVO;

public class BoardServicedTest2 {

public static void main(String[] args) {
AbstractApplicationContext factory = 
 new GenericXmlApplicationContext("applicationContext12.xml");
		 
	BoardService service =(BoardService)factory.getBean("boardService");
	
	BoardVO board = new BoardVO();
	board.setSeq(993);
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
	
	
    //자원해제
	factory.close();
	}
}
