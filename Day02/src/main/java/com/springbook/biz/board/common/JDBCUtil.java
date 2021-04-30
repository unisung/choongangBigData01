package com.springbook.biz.board.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtil {
	//연결 메소드
	public static Connection getConnetcion() {
		try {
			   Class.forName("oracle.jdbc.driver.OracleDriver");
			   return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sa", "sa");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	/* 입력,수정,삭제 */
	public static void close(Statement stmt, Connection con ) {
		if(stmt!=null) {
			try {
				  if(!stmt.isClosed()) stmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				stmt=null;
			}
		}
		if(con!=null) {
			try {
				  if(!con.isClosed()) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				con=null;
			}
		}
	}
	
	/* 조회 */
	public static void close(ResultSet  rs, Statement stmt, Connection con ) {
		if(rs!=null) {
			try {
				  if(!rs.isClosed()) rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				rs=null;
			}
		}
		
		if(stmt!=null) {
			try {
				  if(!stmt.isClosed()) stmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				stmt=null;
			}
		}
		if(con!=null) {
			try {
				  if(!con.isClosed()) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				con=null;
			}
		}
	}

}
