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
	
	//private final String BOARD_INSERT="insert into board(seq, title, writer,content) "
	//		                                             + " values((select nvl(max(seq),0)+1 from board),?,?,?)";
	
	/* 파일명 저장 추가 */
	private final String BOARD_INSERT="insert into board(seq, title, writer,content,uploadfile) "
			                                             + " values((select nvl(max(seq),0)+1 from board),?,?,?,?)";
	
	//private final String BOARD_LIST="select * from board order by seq desc";
	//private final String BOARD_LIST_TITLE="select * from board where title like '%'||?||'%' order by seq desc";
	//private final String BOARD_LIST_CONTENT="select * from board where content like '%'||?||'%' order by seq desc";
	
	private final String BOARD_LIST="select *"
													+ "  from"
													+ " (select rownum rn, a.*"
													+ "  from "
													+ " (select * "
													+ "  from board "
													+ "  order by seq desc) a)"
													+ " where rn between ? and ?";
	
	private final String BOARD_LIST_TITLE="select *"
																+ " from"
																+ "(select rownum rn, a.*"
																+ " from "
																+ "(select * "
																+ "  from board "
																+ "  where title like '%'||?||'%'"
																+ "  order by seq desc) a)"
																+ " where rn between ? and ?";
	
	private final String BOARD_LIST_CONTENT="select *"
																	+ " from"
																	+ "(select rownum rn, a.*"
																	+ " from "
																	+ "(select * "
																	+ "  from board "
																	+ "  where content like '%'||?||'%'"
																	+ "  order by seq desc) a)"
																	+ " where rn between ? and ?";

	/*전체 건수 */
	private final String GET_TOTAL_CNT="select count(*)  from board"; //-- 10으로 나눈 나머지가 있으면 + 1 
	private final String GET_TOTAL_CONTENT="select count(*) from board where content like '%'||?||'%'";  
	private final String GET_TOTAL_TITLE="select count(*) from board where title like '%'||?||'%'"; 
	
	private final String BOARD_GET="select * from board where seq=?";
	private final String BOARD_UPDATE="update board set title=?, content=? , uploadfile=? where seq=?";
	private final String BOARD_DELETE="delete board where seq=?";
	private final String BOARD_COUNT_UPDATE = "update board set cnt=cnt+1 where seq=?";
	
	/* 전체 건수 조회 */
	public int getTotalCount(BoardVO vo) {
		System.out.println("===>SPRING JDBC로 getTotalCount() 기능 처리" );
		if(vo.getSearchCondition()==null) {
		  return jdbcTemplate.queryForInt(GET_TOTAL_CNT);
		  
		}else if(vo.getSearchCondition().equals("TITLE")) {
		  return jdbcTemplate.queryForInt(GET_TOTAL_TITLE,vo.getSearchKeyword() );
		  
		}else if(vo.getSearchCondition().equals("CONTENT")) {
			  return jdbcTemplate.queryForInt(GET_TOTAL_CONTENT,vo.getSearchKeyword() );
		}else
			return 0;
	}
	
	/* 게시글 조회 건수 증가*/
	public void updateBoardCount(BoardVO vo) {
		System.out.println("===>SPRING JDBC로 updateBoardCount() 기능 처리" );
		jdbcTemplate.update(BOARD_COUNT_UPDATE, vo.getSeq());
	}
	/* 게시글 입력 메소드 */
	public void insertBoard(BoardVO vo) {
		 System.out.println("===>SPRING JDBC로 insert() 기능 처리" );
		 //jdbcTemplate.update(BOARD_INSERT,vo.getTitle(),vo.getWriter(), vo.getContent());	
		 jdbcTemplate.update(BOARD_INSERT,vo.getTitle(),vo.getWriter(), vo.getContent(),
				                         /*vo.getUploadFile().getOriginalFilename()*/vo.getImg());
	}

	/* 게시글 리스트 출력 */
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===>SPRING JDBC로 getBoardList() 기능 처리" );
		Object[] args= {vo.getStartRow(), vo.getEndRow()};
		if(vo.getSearchCondition()==null) {
		  return jdbcTemplate.query(BOARD_LIST, args, new BoardRowMapper());
		  
		}else if(vo.getSearchCondition().equals("TITLE")) {
		  return jdbcTemplate.query(BOARD_LIST_TITLE, new Object[] {vo.getSearchKeyword(),
				                                             vo.getStartRow(), vo.getEndRow()}, new BoardRowMapper());
		  
		}else if(vo.getSearchCondition().equals("CONTENT")) {
		 return jdbcTemplate.query(BOARD_LIST_CONTENT, new Object[] {vo.getSearchKeyword(),
				                                             vo.getStartRow(), vo.getEndRow()}, new BoardRowMapper());
		}else
			return null;
	}

	/* 게시글 수정 */
	public void updateBoard(BoardVO vo) {
		 System.out.println("===> SPRING JDBC로 upDateBoard() 기능 처리" );
		 jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), 
				   /*vo.getUploadFile().getOriginalFilename()*/vo.getImg(), vo.getSeq());
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
