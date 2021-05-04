package com.springbook.biz.user.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
     @Autowired
     private UserDAOSpring userDao;
	
	@Override
	public void insertUser(UserVO vo) throws Exception {
		userDao.insertUser(vo);
	}

	@Override
	public UserVO getUser(UserVO vo) throws SQLException {
		return userDao.getUser(vo);
	}

	@Override
	public void deleteUser(UserVO vo) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(UserVO vo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public int getUserCnt(UserVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
