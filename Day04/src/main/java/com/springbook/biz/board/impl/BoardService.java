package com.springbook.biz.board.impl;

import java.util.List;

import com.springbook.biz.board.BoardVO;

public interface BoardService {
	void insertBoard(BoardVO vo);
	List<BoardVO> getBoardList(BoardVO vo);
	void updateBoard(BoardVO vo);
	void deleteBoard(BoardVO vo);
	BoardVO getBoard(BoardVO vo);
	int getTotalCount(BoardVO vo);
	void insertReplyBoard(BoardVO vo);
	void updateReSeq(BoardVO vo);
	List<BoardVO> getReplies(BoardVO vo);
	void upGood(BoardVO vo);
	void upBad(BoardVO vo);
	List<BoardVO> getBoardList2(BoardVO vo);

}
