package org.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springbook.biz.board.BoardVO;
import org.springbook.biz.board.common.JDBCUtil;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component("dao")
@Repository("dao")
public class BoardDAO {
	private Connection conn=null;
	private PreparedStatement stmt=null;
	private ResultSet rs=null;
	
	private final String BOARD_INSERT="insert into board(seq, title, writer,content) "
			                                             + " values((select nvl(max(seq),0)+1 from board),?,?,?)";
	
	public void insertBoard(BoardVO vo) {
		 System.out.println("===> JDBC로 insert() 기능 처리" );
		 conn=JDBCUtil.getConnetcion();
		 try {
			    //연결
			     conn=JDBCUtil.getConnetcion();
			     conn.setAutoCommit(false);
			    stmt =conn.prepareStatement(BOARD_INSERT);
			    stmt.setString(1,vo.getTitle() );
			    stmt.setString(2, vo.getWriter());
			    stmt.setString(3, vo.getContent());
			    
			    stmt.executeUpdate();
			    conn.commit();
		 }catch(Exception e) {
			  try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			 e.printStackTrace();
		 }finally {
			 try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 JDBCUtil.close(stmt, conn);
		 }
		
	}
	
}
