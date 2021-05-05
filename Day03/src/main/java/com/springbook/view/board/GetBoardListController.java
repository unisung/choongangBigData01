package com.springbook.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
//import com.springbook.view.controller.Controller;
import com.springbook.biz.board.impl.BoardService;

public class GetBoardListController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse respnose) {
	     BoardVO vo = new BoardVO();
	     BoardDAO boardDAO =new BoardDAO();
	   List<BoardVO> boardList = boardDAO.getBoardList(vo);
	     
	     for(BoardVO board:boardList)
	    	  System.out.println(board);
	     
	     ModelAndView mav = new ModelAndView();
	     mav.addObject("boardList", boardList);
	     mav.setViewName("getBoardList"); //  /WEB-INF/board/+getBoardList + .jsp
		return mav;
	}


}
