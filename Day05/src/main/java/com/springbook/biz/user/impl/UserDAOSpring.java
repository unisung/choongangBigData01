package com.springbook.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.user.UserVO;

//@Repository("userDao")
public class UserDAOSpring {//POJO
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private Connection conn=null;
	private PreparedStatement stmt=null;
	private ResultSet rs=null;
	
	String str;
	
	//private final String USER_INSERT = "insert into users(id, password,name,role) values(?,?,?,?)";
	private final String USER_INSERT = "insert into users(id, password,name,postcode, roadAddress,jubunAddress,detailAddress,extraAddress) "
			                                            + " values(?,?,?,?,?,?,?,?)";
	private final String USER_GET = "select * from users where id=?";
	private final String USER_CNT ="select count(*) from users where id=?";
	private final String USER_LOGIN ="select * from users where id=? and password=?";
	private final String USER_CHANGE_PASS="update users set password=? where id=?";
	private final String USER_CNT_BYPASS ="select count(*) from users where id=? and password=?";
	private final String USER_LIST="select * from users order by id";
	private final String USER_DELETE="delete from users where id=?";
	
	public void insertUser(UserVO vo) {
		System.out.println("===> SPRING JDBC로 insertUser() 기능 처리" );
		jdbcTemplate.update(USER_INSERT, vo.getId(),vo.getPassword(),vo.getName(),
				                      vo.getPostcode(), vo.getRoadAddress(), vo.getJubunAddress(),
				                      vo.getDetailAddress(), vo.getExtraAddress());
	}

	public UserVO getUser(UserVO vo) {
		System.out.println("===> SPRING JDBC로 getUser() 기능 처리" );
		Object[] args= {vo.getId()};
		return jdbcTemplate.queryForObject(USER_GET, args, new UserRowMapper());
	}

	public int getUserCnt(UserVO vo) {
		System.out.println("===> SPRING JDBC로 getUserCnt() 기능 처리" );
		return jdbcTemplate.queryForObject(USER_CNT,new Object[] {vo.getId()}, Integer.TYPE);
	}
	
	public int getUserCntByPass(UserVO vo) {
		System.out.println("===> SPRING JDBC로 getUserCntByPass() 기능 처리" );
		return jdbcTemplate.queryForObject(USER_CNT_BYPASS,new Object[] {vo.getId(),vo.getPassword()},Integer.TYPE);
	}
	
	public UserVO getLogin(UserVO vo) {
		System.out.println("===> SPRING JDBC로 getLogin() 기능 처리" );
		Object[] args= {vo.getId(),vo.getPassword()};
		return jdbcTemplate.queryForObject(USER_LOGIN, args, new UserRowMapper());
	}

	public void updateUser(UserVO vo) {
		jdbcTemplate.update(USER_CHANGE_PASS, vo.getPassword(), vo.getId());
	}

	public List<UserVO> getUsers(UserVO vo) {
		return jdbcTemplate.query(USER_LIST, new UserRowMapper());
	}
	
	public int deleteUser(UserVO vo) {
		return jdbcTemplate.update(USER_DELETE,vo.getId());//삭제된 행의 수
	}
}
