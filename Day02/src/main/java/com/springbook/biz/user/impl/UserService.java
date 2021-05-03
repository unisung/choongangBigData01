package com.springbook.biz.user.impl;

import java.sql.SQLException;

import com.springbook.biz.user.UserVO;

public interface UserService {
	//CRUD 기능 구현
	
	//회원등록
	public void insertUser(UserVO vo) throws Exception;
	//회원 조회
	public UserVO getUser(UserVO vo) throws SQLException;
	//회원탈퇴
	public void deleteUser(UserVO vo) throws SQLException;
	
	//회원수정
	public void updateUser(UserVO vo) throws Exception;
	
	//동일아이디 존재 체크
    public int getUserCnt(UserVO vo);
	
}
