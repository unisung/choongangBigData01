package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.common.JDBCUtil;

//@Component("dao")
//@Repository("dao")
public class BoardDAO {
	private Connection conn=null;
	private PreparedStatement stmt=null;
	private ResultSet rs=null;
	
	private final String BOARD_INSERT="insert into board(seq, title, writer,content) "
			                                             + " values((select nvl(max(seq),0)+1 from board),?,?,?)";
	
	private final String BOARD_LIST="select * from board order by seq";
	private final String BOARD_GET="select * from board where seq=?";
	private final String BOARD_UPDATE="update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE="delete board where seq=?";
	
	
	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "sa", "sa");
		} catch (Exception e) {
			e.printStackTrace();
		}
		   return null;
	}
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
		conn=getConnection();
		// conn=JDBCUtil.getConnetcion();
		 System.out.println(conn==null?"미연결":"연결");
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
		 System.out.println("===> JDBC로 upDateBoard() 기능 처리" );
		 conn=JDBCUtil.getConnetcion();
		 try {
			    //연결
			     conn=JDBCUtil.getConnetcion();
			     conn.setAutoCommit(false);
			    stmt =conn.prepareStatement(BOARD_UPDATE);
			    stmt.setString(1, vo.getTitle() );
			    stmt.setString(2, vo.getContent());
			    stmt.setInt(3, vo.getSeq());
			    
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

	

	public BoardVO getBoard(BoardVO vo) {
		BoardVO board = new BoardVO();
		 conn=JDBCUtil.getConnetcion();
		 try {
			    //연결
			     conn=JDBCUtil.getConnetcion();
			    
			    stmt =conn.prepareStatement(BOARD_GET);
			    stmt.setInt(1,vo.getSeq());
			    
			    rs = stmt.executeQuery();
			    while(rs.next()) {
			    	   board.setSeq(rs.getInt(1));
			    	   board.setTitle(rs.getString(2));
			    	   board.setWriter(rs.getString(3));
			    	   board.setContent(rs.getString(4));
			    	   board.setRegdate(rs.getDate(5));
			    	   board.setCnt(rs.getInt(6));
			    }
		 }catch(Exception e) {
			 e.printStackTrace();
		 }finally {
			 JDBCUtil.close(rs, stmt, conn);
		 }
		return board;
	}
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JDBC로 deleteBoard() 기능 처리" );
		 conn=JDBCUtil.getConnetcion();
		 try {
			    //연결
			     conn=JDBCUtil.getConnetcion();
			     conn.setAutoCommit(false);
			    stmt =conn.prepareStatement(BOARD_DELETE);
			    stmt.setInt(1, vo.getSeq());
			    
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
