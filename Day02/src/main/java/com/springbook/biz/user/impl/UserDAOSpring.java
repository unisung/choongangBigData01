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

@Repository("dao")
public class UserDAOSpring {//POJO
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private Connection conn=null;
	private PreparedStatement stmt=null;
	private ResultSet rs=null;
	
	String str;
	
	private final String USER_INSERT = "insert into users(id, password,name,role) values(?,?,?,?)";
	private final String USER_GET = "select * from users where id=?";
	
	public void insertUser(UserVO vo) {
		System.out.println("===> SPRING JDBC로 insertUser() 기능 처리" );
		jdbcTemplate.update(USER_INSERT, vo.getId(),vo.getPassword(),vo.getName(),vo.getRole());
	}

	public UserVO getUser(UserVO vo) {
		Object[] args= {vo.getId()};
		return jdbcTemplate.queryForObject(USER_GET, args, new UserRowMapper());
	}
	
}
