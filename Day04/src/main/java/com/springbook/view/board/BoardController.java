package com.springbook.view.board;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.board.impl.BoardService;

/* POJO 클래스*/
@Controller
public class BoardController {
	@Autowired
	private BoardService service;
	
	@ModelAttribute("conditionMap")
	public Map<String,String> searchConditionMap(){
		Map<String,String> conditionMap=new HashMap<String,String>();	
		conditionMap.put("제목","TITLE");	
		conditionMap.put("내용","CONTENT");	
		return conditionMap;
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model, BoardDAO boardDAO) {
	   //List<BoardVO> boardList = boardDAO.getBoardList(vo);
	   List<BoardVO> boardList = service.getBoardList(vo);
	     for(BoardVO board:boardList)  System.out.println(board);	     
	     model.addAttribute("boardList", boardList);
	     return "getBoardList.jsp";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model, BoardDAO boardDAO) {
		System.out.println("vo:"+vo);
		
		//vo = boardDAO.getBoard(vo);
		vo = service.getBoard(vo);
		
		System.out.println("vo:"+vo);
		
		model.addAttribute("board",vo);
		
		return "getBoard.jsp";
	}
	
	@RequestMapping(value="/updateBoard.do",method=RequestMethod.POST)
	public String updateBoard(BoardVO vo, BoardDAO dao) {
		//request.setCharacterEncoding("utf-8");
		System.out.println("board:"+vo);
		//dao.updateBoard(vo);
		service.updateBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping(value="/insertBoard.do",method=RequestMethod.GET)
	public String insertBoardForm() {
		//user.setName("홍길동");
		return "insertBoard.jsp";
	}
	
	@RequestMapping(value="/insertBoard.do",method=RequestMethod.POST)
	public String insertBoard(@ModelAttribute("board")BoardVO board,	BoardDAO dao) throws Exception {
		System.out.println("board:"+board);
		//파일업로드 
		MultipartFile uploadFile = board.getUploadFile();
		//클라이언트에서 파일을 전송했으면
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();//pc에서 업로드시 파일명
			uploadFile.transferTo(new File("c:/upload/"+fileName));
		}

		//dao.insertBoard(board);
		service.insertBoard(board);
		
		return "redirect:getBoardList.do";
	}
	
	
	@RequestMapping(value="/deleteBoard.do",
			method=RequestMethod.GET)
	public String deleteBoard(@ModelAttribute("board")BoardVO board,
			BoardDAO dao) {
		System.out.println("board:"+board);
		//dao.deleteBoard(board);
		service.deleteBoard(board);
		return "redirect:getBoardList.do";
	}
	
	
	

}
