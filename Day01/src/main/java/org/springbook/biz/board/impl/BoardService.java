package org.springbook.biz.board.impl;

import java.util.List;

import org.springbook.biz.board.BoardVO;

public interface BoardService {
	void insertBoard(BoardVO vo);
	List<BoardVO> getBoardList(BoardVO vo);
	void updateBoard(BoardVO vo);
	void deleteBoard(BoardVO vo);
	BoardVO getBoard(BoardVO vo);

}