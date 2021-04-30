package org.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	private final String BOARD_LIST="select * from board order by seq";
	private final String BORAD_GET="select * from board where seq=?";
	private final String BORAD_UPDATE="update board set title=?, content=? where seq=?";
	private final String BORAD_DELETE="delete board where seq=?";
	
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

	public List<BoardVO> getBoardList(BoardVO vo) {
		List<BoardVO> list = new ArrayList<BoardVO>();
		 conn=JDBCUtil.getConnetcion();
		 try {
			    //연결
			     conn=JDBCUtil.getConnetcion();
			    
			    stmt =conn.prepareStatement(BOARD_LIST);
			    rs = stmt.executeQuery();
			    while(rs.next()) {
			    	   BoardVO board = new BoardVO();
			    	   board.setSeq(rs.getInt(1));
			    	   board.setTitle(rs.getString(2));
			    	   board.setWriter(rs.getString(3));
			    	   board.setContent(rs.getString(4));
			    	   board.setRegdate(rs.getDate(5));
			    	   board.setCnt(rs.getInt(6));
			    	    
			    	   list.add(board); 
			    }
		 }catch(Exception e) {
			 e.printStackTrace();
		 }finally {
			 JDBCUtil.close(rs, stmt, conn);
		 }
		return list;
	}

	public void updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		
	}

	public void delete(BoardVO vo) {
		// TODO Auto-generated method stub
		
	}

	public BoardVO getBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}