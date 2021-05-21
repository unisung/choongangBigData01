package com.springbook.biz.user.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.impl.BoardDAOMybatis;
import com.springbook.biz.user.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAOMybatis userDao;
	
	@Override
	public void insertUser(UserVO vo) throws Exception {
		userDao.insertUser(vo);
	}

	@Override
	public UserVO getUser(UserVO vo) throws SQLException {
		return userDao.getUser(vo);
	}

	@Override
	public int deleteUser(UserVO vo) throws SQLException {
		return userDao.deleteUser(vo);
	}

	@Override
	public void updateUser(UserVO vo) throws Exception {
		userDao.updateUser(vo);
	}

	@Override
	public int getUserCnt(UserVO vo) {
		return userDao.getUserCnt(vo);
	}

	@Override
	public UserVO getLogin(UserVO vo) {
		return userDao.getLogin(vo);
	}

	@Override
	public int getUserCntByPass(UserVO vo) {
		return userDao.getUserCntByPass(vo);
	}

	@Override
	public List<UserVO> getUsers(UserVO vo) {
		return userDao.getUsers(vo);
	}

}
