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
	
	/* ref와 seq를 확인하여 원본 글에 다른 답변 글이 있으면, 
	 * 답변 글 중 답변 글보다 상위에 있는 글의 seq보다 높은 글의 seq값을 1씩 증가 시킨다.
	 */
	private final String BOARD_SEQ_UPDATE="update board set re_seq=re_seq+1 where re_ref=? and re_seq > ?";
	
	/* 파일명 저장 추가 */
	private final String BOARD_INSERT="insert into board(seq, title, writer,content,uploadfile,re_ref, re_lev, re_seq) "
			                                             + " values((select nvl(max(seq),0)+1 from board),?,?,?,?,(select nvl(max(seq),0)+1 from board),?,?)";
	/* 답변 저장 */
	private final String BOARD_REPLY_INSERT="insert into board(seq, title, writer,content,uploadfile,re_ref, re_lev, re_seq) "
                                                                   + " values((select nvl(max(seq),0)+1 from board),?,?,?,?,?,?,?)";

	//private final String BOARD_LIST="select * from board order by seq desc";
	//private final String BOARD_LIST_TITLE="select * from board where title like '%'||?||'%' order by seq desc";
	//private final String BOARD_LIST_CONTENT="select * from board where content like '%'||?||'%' order by seq desc";
	
	private final String BOARD_LIST
	         ="select *from "
			+ " (select rownum rn, a.* "
			+ " from "
			+ " (select * "
			+ " from board "
			+ " order by re_ref desc, re_seq ) a) "
			+ " where rn between ? and ?";
	
	private final String BOARD_LIST_TITLE
	        ="select * from "
			+ " (select rownum rn, a.* "
			+ " from "
			+ " (select * "
			+ " from board where title like '%'||?||'%' "
			+ " order by re_ref desc, re_seq ) a) "
			+ " where rn between ? and ?";
	
	private final String BOARD_LIST_CONTENT
	        ="select * from "
			+ " (select rownum rn, a.* "
			+ " from "
			+ " (select * "
			+ " from board where content like '%'||?||'%' "
			+ " order by  re_ref desc, re_seq ) a) "
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
		  return jdbcTemplate.queryForObject(GET_TOTAL_CNT,Integer.class);
		  
		}else if(vo.getSearchCondition().equals("TITLE")) {
		  return jdbcTemplate.queryForObject(GET_TOTAL_TITLE,new String[] {vo.getSearchKeyword()}, Integer.class );
		  
		}else if(vo.getSearchCondition().equals("CONTENT")) {
			  return jdbcTemplate.queryForObject(GET_TOTAL_CONTENT,new String[] {vo.getSearchKeyword()},Integer.class );
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
				                         vo.getImg(), vo.getRe_lev(), vo.getRe_seq());
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

	public void insertReplyBoard(BoardVO vo) {
		System.out.println("===> SPRING JDBC로 insertReplyBoard() 기능 처리" );
		jdbcTemplate.update(BOARD_REPLY_INSERT, vo.getTitle(),vo.getWriter(), vo.getContent(),vo.getImg(), 
				                        vo.getRe_ref(), vo.getRe_lev(), vo.getRe_seq());
	}

	public void updateReSeq(BoardVO vo) {
		System.out.println("===> SPRING JDBC로 insertReplyBoard() 기능 처리" );
		jdbcTemplate.update(BOARD_SEQ_UPDATE, vo.getRe_ref(), vo.getRe_seq());
	}

	 private final String BOARD_REPLIES ="select * from board where re_ref=? and seq != re_ref";
	 
	public List<BoardVO> getReplies(BoardVO vo) {
		System.out.println("===> SPRING JDBC로 getReplies() 기능 처리" );
		return jdbcTemplate.query(BOARD_REPLIES,new Object[]{vo.getRe_ref()} , new BoardRowMapper());
	}

	private final String BOARD_GOOD_UP="update board set good=good+1 where seq=?";
	private final String BOARD_BAD_UP="update board set bad=bad+1 where seq=?";
	
	public void upGood(BoardVO vo) {
		System.out.println("===> SPRING JDBC로 upGood() 기능 처리" );
		jdbcTemplate.update(BOARD_GOOD_UP, vo.getSeq());
		
	}
	public void upBad(BoardVO vo) {
		System.out.println("===> SPRING JDBC로 upGood() 기능 처리" );
		jdbcTemplate.update(BOARD_BAD_UP, vo.getSeq());
	}

}
