package com.springbook.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardRowMapper;
import com.springbook.biz.user.UserVO;

//@Component("dao")
@Repository("dao")
public class UserDAOSpring {
	@Autowired
	//private JdbcTemplate spring;
	private JdbcTemplate jdbcTemplate;
	
	
	private Connection conn=null;
	private PreparedStatement stmt=null;
	private ResultSet rs=null;
	
	private final String USER_INSERT = "insert into users(id, password,name,role) values(?,?,?,?)";
	private final String USER_GET = "select * from users where id=?";
	
	/* 게시글 입력 메소드 */
	public void insertBoard(UserVO vo) {
		 System.out.println("===>SPRING JDBC로 insert() 기능 처리" );
		 jdbcTemplate.update(USER_INSERT,vo.getTitle(),vo.getWriter(), vo.getContent());
	}


	/* 게시글 상세 보기 */
	public UserVO getBoard(UserVO vo) {
		System.out.println("===> SPRING JDBC로 getBoard() 기능 처리" );
		//Object[] args = {vo.getSeq()};
		return jdbcTemplate.queryForObject(USER_GET, args, new BoardRowMapper());
	}
	
}
