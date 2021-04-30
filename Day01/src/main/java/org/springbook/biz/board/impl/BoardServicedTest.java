package org.springbook.biz.board.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springbook.biz.board.BoardVO;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServicedTest {

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
	
    //자원해제
	factory.close();
	}
}
