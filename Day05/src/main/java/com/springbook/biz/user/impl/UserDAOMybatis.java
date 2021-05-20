package com.springbook.biz.user.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.user.UserVO;

@Repository
public class UserDAOMybatis {
	@Autowired
	private SqlSessionTemplate mybatis;

	public void insertUser(UserVO vo) {
	  mybatis.insert("UserDAO.insert",vo);
	}

	public UserVO getUser(UserVO vo) {
		return mybatis.selectOne("UserDAO.getUser", vo);
	}

	public int deleteUser(UserVO vo) {
		return mybatis.delete("UserDAO.delete",vo);
	}

	public void updateUser(UserVO vo) {
		mybatis.update("UserDAO.update", vo);
	}

	public int getUserCnt(UserVO vo) {
		return mybatis.selectOne("UserDAO.getCnt", vo);
	}

	public UserVO getLogin(UserVO vo) {
		return mybatis.selectOne("UserDAO.getLogin", vo);
	}

	public int getUserCntByPass(UserVO vo) {
		return mybatis.selectOne("UserDAO.getUserCntByPass", vo);
	}

	public List<UserVO> getUsers(UserVO vo) {
		return mybatis.selectList("UserDAO.getUsers", vo);
	}
}
