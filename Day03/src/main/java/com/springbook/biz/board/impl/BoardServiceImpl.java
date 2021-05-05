package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.common.LogAdvice;

@Service("boardService")
public class BoardServiceImpl 
        implements BoardService{
	//@Autowired
	//private BoardDAO dao;
	@Autowired
	private BoardDAOSpring dao;

	//0번글은 등록이 안되도록 예외 처리 설정
	@Override
	public void insertBoard(BoardVO vo) {
      // if(vo.getSeq()==0)
      //   throw new IllegalArgumentException("0번 글은 등록 할 수 없습니다.");
	 dao.insertBoard(vo);
	 //dao.insertBoard(vo);
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

}
