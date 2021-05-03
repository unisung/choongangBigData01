package com.springbook.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.springbook.biz.board.common.JDBCUtil;
import com.springbook.biz.user.UserVO;

//@Repository("userDAO")
public class UserDAO {
	// JDBC 관련 변수
			private Connection conn = null;
			private PreparedStatement stmt = null;
			private ResultSet rs = null;
		
			//SQL문
			private final String USER_INSERT = "insert into users(id, password,name,role) values(?,?,?,?)";
			private final String USER_GET = "select * from users where id=?";
			
			//회원 등록
			public void insertUser(UserVO user) {
				System.out.println("===> JDBC로 insertUser() 기능 처리");
				try {
					    conn = JDBCUtil.getConnetcion();
					    stmt = conn.prepareStatement(USER_INSERT);
					    stmt.setString(1, user.getId());
					    stmt.setString(2, user.getPassword());
					    stmt.setString(3, user.getName());
					    stmt.setString(4, user.getRole());
					    
					    stmt.executeUpdate();
					
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					JDBCUtil.close(stmt, conn);
				}
			}

			//회원 조회
			public UserVO getUser(UserVO user) {
				UserVO userVo=null;
				System.out.println("===> JDBC로 getUser() 기능 처리");
				try {
					    conn = JDBCUtil.getConnetcion();
					    stmt = conn.prepareStatement(USER_GET);
					    stmt.setString(1, user.getId());
					  
					   rs= stmt.executeQuery();
					  if(rs.next()) {
						  userVo = new UserVO();
						  userVo.setId(rs.getString(1));
						  userVo.setPassword(rs.getString(2));
						  userVo.setName(rs.getString(3));
						  userVo.setRole(rs.getString(4));
					  }
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					JDBCUtil.close(stmt, conn);
				}
				return userVo;
			}
}
