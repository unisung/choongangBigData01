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

@Repository("userDao")
public class UserDAOSpring {//POJO
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private Connection conn=null;
	private PreparedStatement stmt=null;
	private ResultSet rs=null;
	
	String str;
	
	private final String USER_INSERT = "insert into users(id, password,name,role) values(?,?,?,?)";
	private final String USER_GET = "select * from users where id=?";
	private final String USER_CNT ="select count(*) from users where id=?";
	private final String USER_LOGIN ="select * from users where id=? and password=?";
	private final String USER_CHANGE_PASS="update users set password=? where id=?";
	
	public void insertUser(UserVO vo) {
		System.out.println("===> SPRING JDBC로 insertUser() 기능 처리" );
		jdbcTemplate.update(USER_INSERT, vo.getId(),vo.getPassword(),vo.getName(),vo.getRole());
	}

	public UserVO getUser(UserVO vo) {
		System.out.println("===> SPRING JDBC로 getUser() 기능 처리" );
		Object[] args= {vo.getId()};
		return jdbcTemplate.queryForObject(USER_GET, args, new UserRowMapper());
	}

	public int getUserCnt(UserVO vo) {
		System.out.println("===> SPRING JDBC로 getUserCnt() 기능 처리" );
		return jdbcTemplate.queryForInt(USER_CNT,vo.getId());
	}
	
	public UserVO getLogin(UserVO vo) {
		System.out.println("===> SPRING JDBC로 getLogin() 기능 처리" );
		Object[] args= {vo.getId(),vo.getPassword()};
		return jdbcTemplate.queryForObject(USER_LOGIN, args, new UserRowMapper());
	}

	public void updateUser(UserVO vo) {
		jdbcTemplate.update(USER_CHANGE_PASS, vo.getPassword(), vo.getId());
		
	}
}
