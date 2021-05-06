package com.springbook.view.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

/* POJO 클래스*/
@Controller
public class BoardController {
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
	     BoardDAO boardDAO =new BoardDAO();
	   List<BoardVO> boardList = boardDAO.getBoardList(vo);
	     
	     for(BoardVO board:boardList)
	    	  System.out.println(board);
	     
	     model.addAttribute("boardList", boardList);
		
	     return "getBoardList.jsp";
	}
	

}
