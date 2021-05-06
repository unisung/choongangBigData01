package com.springbook.view.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.user.UserVO;

/* POJO 클래스*/
@Controller
public class BoardController {
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model, BoardDAO boardDAO) {
	   List<BoardVO> boardList = boardDAO.getBoardList(vo);
	     for(BoardVO board:boardList)  System.out.println(board);	     
	     model.addAttribute("boardList", boardList);
	     return "getBoardList.jsp";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model, BoardDAO boardDAO) {
		System.out.println("vo:"+vo);
		
		vo = boardDAO.getBoard(vo);
		
		System.out.println("vo:"+vo);
		
		model.addAttribute("board",vo);
		
		return "getBoard.jsp";
	}
	
	@RequestMapping(value="/updateBoard.do",method=RequestMethod.POST)
	public String updateBoard(BoardVO vo, BoardDAO dao) {
		//request.setCharacterEncoding("utf-8");
		System.out.println("board:"+vo);
		dao.updateBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping(value="/insertBoard.do",method=RequestMethod.GET)
	public String insertBoardForm(@ModelAttribute("user") UserVO user) {
		user.setName("홍길동");
		return "insertBoard.jsp";
	}
	
	@RequestMapping(value="/insertBoard.do",method=RequestMethod.POST)
	public String insertBoard(@ModelAttribute("board")BoardVO board,BoardDAO dao) {
		System.out.println("board:"+board);
		dao.insertBoard(board);
		return "redirect:getBoardList.do";
	}
	
	
	@RequestMapping(value="/deleteBoard.do",method=RequestMethod.GET)
	public String deleteBoard(@ModelAttribute("board")BoardVO board,BoardDAO dao) {
		System.out.println("board:"+board);
		dao.deleteBoard(board);
		return "redirect:getBoardList.do";
	}
	
	

}
