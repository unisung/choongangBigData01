package com.springbook.biz.user.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springbook.biz.user.UserVO;

public class UserRowMapper implements RowMapper<UserVO>{
	@Override
	public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserVO user = new UserVO();
		
		user.setId(rs.getString(1));
		user.setPassword(rs.getString(2));
		user.setName(rs.getString(3));
		user.setRole(rs.getString(4));
		
		return user;
	}

}
