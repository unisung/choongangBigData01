package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.common.JDBCUtil;

//@Component("dao")
@Repository("dao")
public class BoardDAOSpring {
	@Autowired
	//private JdbcTemplate spring;
	private JdbcTemplate jdbcTemplate;
	
	
	private Connection conn=null;
	private PreparedStatement stmt=null;
	private ResultSet rs=null;
	
	private final String BOARD_INSERT="insert into board(seq, title, writer,content) "
			                                             + " values((select nvl(max(seq),0)+1 from board),?,?,?)";

	private final String BOARD_LIST="select * from board order by seq";
	private final String BOARD_GET="select * from board where seq=?";
	private final String BOARD_UPDATE="update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE="delete board where seq=?";
	private final String BOARD_COUNT_UPDATE = "update board set cnt=cnt+1 where seq=?";
	
	/* 게시글 조회 건수 증가*/
	public void updateBoardCount(BoardVO vo) {
		System.out.println("===>SPRING JDBC로 updateBoardCount() 기능 처리" );
		
		jdbcTemplate.update(BOARD_COUNT_UPDATE, vo.getSeq());
	}
	
	/* 게시글 입력 메소드 */
	public void insertBoard(BoardVO vo) {
		 System.out.println("===>SPRING JDBC로 insert() 기능 처리" );
		 //jdbcTemplate.update(BOARD_INSERT,vo.getTitle(),vo.getWriter(), vo.getContent());	
		 jdbcTemplate.update(BOARD_INSERT,vo.getTitle(),vo.getWriter(), vo.getContent());
	}

	/* 게시글 리스트 출력 */
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===>SPRING JDBC로 getBoardList() 기능 처리" );
		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
	}

	/* 게시글 수정 */
	public void updateBoard(BoardVO vo) {
		 System.out.println("===> SPRING JDBC로 upDateBoard() 기능 처리" );
		 jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}

	
	/* 게시글 삭제 */
	public void delete(BoardVO vo) {
		System.out.println("===> SPRING JDBC로 deleteBoard() 기능 처리" );
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	}

	/* 게시글 상세 보기 */
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> SPRING JDBC로 getBoard() 기능 처리" );
		updateBoardCount(vo);
		Object[] args = {vo.getSeq()};
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	}
	
}
