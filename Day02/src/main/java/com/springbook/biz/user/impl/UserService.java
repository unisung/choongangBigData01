package com.springbook.biz.user.impl;

import java.sql.SQLException;
import java.util.List;

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
    
    //회원 로그인 처리
    public UserVO getLogin(UserVO vo);
    
    //아이디 패스로 회원 존재 여부확인
    public int getUserCntByPass(UserVO vo);
    
    //회원 리스트
	public List<UserVO> getUsers(UserVO vo);
	
}
