package com.springbook.biz.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springbook.biz.board.BoardVO;

public class BoardRowMapper implements RowMapper<BoardVO> {

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO board = new BoardVO();
		board.setSeq(rs.getInt("seq"));
		board.setTitle(rs.getString("title"));
		board.setWriter(rs.getString("writer"));
		board.setContent(rs.getString("content"));
		board.setRegdate(rs.getDate("regdate"));
		board.setCnt(rs.getInt("cnt"));
		//board.setUploadFile(null);
		board.setImg(rs.getString("uploadfile"));
		//댓글 그룹, 댓글 레벨, 댓글 순번
		board.setRe_ref(rs.getInt("re_ref"));
		board.setRe_lev(rs.getInt("re_lev"));
		board.setRe_seq(rs.getInt("re_seq"));
		
		//좋아요/싫어요
		board.setGood(rs.getInt("good"));
		board.setBad(rs.getInt("bad"));
		
		return board;
	}

}
