package com.springbook.view.board;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.board.impl.BoardService;

/* POJO 클래스*/
@Controller
@SessionAttributes("board")
public class BoardController {
	@Autowired
	private BoardService service;
	

	  @ModelAttribute("conditionMap") 
	  public Map<String,String>searchConditionMap(){ 
		  Map<String,String> conditionMap=new
	  HashMap<String,String>(); 
		conditionMap.put("제목","TITLE");
	  conditionMap.put("내용","CONTENT"); 
	  return conditionMap; 
	  }
	 
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model, 
			                                BoardDAO boardDAO	) {
		System.out.println("x");
		System.out.println("페이지번호: " +vo.getPageNum());
		
		//System.out.println("searchCondition: " +vo.getSearchCondition()==null?"null":vo.getSearchCondition().length());
		//System.out.println("searchKeyword: " +vo.getSearchKeyword()==null?"null":vo.getSearchKeyword().length());
		
		System.out.println("-----searchKeyword: "+vo.getSearchKeyword());
		
		if(vo.getSearchCondition()==null || vo.getSearchCondition().length()==0)  
			   vo.setSearchCondition(null);
		
		if(vo.getPageNum()==null) vo.setPageNum("1");
		
		int startRow= (Integer.parseInt(vo.getPageNum()) -1 )*10 +1;
		int endRow = startRow + 9;
		vo.setStartRow(startRow);
		vo.setEndRow(endRow);
		
	   List<BoardVO> boardList = service.getBoardList(vo);
	   int totalCount = service.getTotalCount(vo);
	   int total=(int)Math.ceil(totalCount / 10.0);//정수/실수=>실수 10.0->10, 10.3->11
	     System.out.println("검색조건:"+vo.getSearchCondition());
	     model.addAttribute("boardList", boardList);
	     model.addAttribute("total",total);
	     model.addAttribute("searchCondition",vo.getSearchCondition());
	     model.addAttribute("searchKeyword",vo.getSearchKeyword());
	     model.addAttribute("pageNum",vo.getPageNum());
	     
	     return "getBoardList.jsp";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(
			@RequestParam("pageNum") String pageNum,
			@RequestParam("searchCondition") String searchCondition,
			@RequestParam("searchKeyword") String searchKeyword,
			BoardVO vo, Model model, BoardDAO boardDAO) {
		
		System.out.println("pageNum:"+pageNum);
		System.out.println("searchCondition:"+searchCondition);
		System.out.println("searchKeyword:"+searchKeyword);
		
		 vo.setPageNum(pageNum);
		 vo.setSearchCondition(searchCondition);
		 vo.setSearchCondition(searchCondition);
		 
		System.out.println("vo:"+vo);
		
		
		//vo = boardDAO.getBoard(vo);
		vo = service.getBoard(vo);
		
		vo.setPageNum(pageNum);
		vo.setSearchCondition(searchCondition);
		vo.setSearchKeyword(searchKeyword);
		
		System.out.println("vo:"+vo);
		
		/* model저장시 sessionAttributes에도 저장 */
		model.addAttribute("board",vo);
		
		return "getBoard.jsp";
	}
	
	
	@RequestMapping(value="/updateBoard.do",method=RequestMethod.POST)
	public String updateBoard(@ModelAttribute("board") BoardVO board, BoardDAO dao) 
			                                                throws IllegalStateException, IOException {
		//request.setCharacterEncoding("utf-8");
		System.out.println("board:"+board);
		
		//파일업로드 
		MultipartFile uploadFile = board.getUploadFile();
				//클라이언트에서 파일을 전송했으면
		if(!uploadFile.isEmpty()) {
					String fileName = uploadFile.getOriginalFilename();//pc에서 업로드시 파일명
					//UUID.randomUUID();
					fileName=fileName.substring(0,fileName.lastIndexOf("."));
				     String fileName2=uploadFile.getOriginalFilename();

					String extend=fileName2.substring(fileName2.lastIndexOf(".")+1);//파일명.jpg
					
					System.out.println("파일명:"+fileName);
					System.out.println("확장자:"+extend);
					
					//파일명 중복방지 처리 UUID.randomUUID()
					fileName=fileName+"-"+UUID.randomUUID()+"."+extend;
					System.out.println("파일명:"+fileName);
					
					uploadFile.transferTo(new File("c:/upload/"+fileName));
					board.setImg(fileName);
			}
		
	//dao.updateBoard(vo);
		service.updateBoard(board);
		
	  System.out.println("-----------------------------업데이트 후 board: "+board);
		return "redirect:getBoardList.do?pageNum="+board.getPageNum()
		           +"&searchCondition="+board.getSearchCondition()
		           +"&searchKeyword="+URLEncoder.encode(board.getSearchKeyword(), "UTF-8");
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
			//UUID.randomUUID();
			fileName=fileName.substring(0,fileName.lastIndexOf("."));
		     String fileName2=uploadFile.getOriginalFilename();
		     
		     
			String extend=fileName2.substring(fileName2.lastIndexOf(".")+1);//파일명.jpg
		//	String extend = 
//uploadFile.getOriginalFilename().substring(uploadFile.getOriginalFilename().lastIndexOf(".")+1);
			
			System.out.println("파일명:"+fileName);
			System.out.println("확장자:"+extend);
			
			//파일명 중복방지 처리 UUID.randomUUID()
			fileName=fileName+"-"+UUID.randomUUID()+"."+extend;
			System.out.println("파일명:"+fileName);
			
			uploadFile.transferTo(new File("c:/upload/"+fileName));
			board.setImg(fileName);
		}

		//dao.insertBoard(board);
		service.insertBoard(board);
		
		return "redirect:getBoardList.do";
	}
	
	
	@RequestMapping(value="/deleteBoard.do",
			method=RequestMethod.GET)
	public String deleteBoard(@ModelAttribute("board")BoardVO board,
			BoardDAO dao) throws UnsupportedEncodingException {
		System.out.println("board:"+board);
		//dao.deleteBoard(board);
		service.deleteBoard(board);
		return "redirect:getBoardList.do?pageNum="+board.getPageNum() 
				   +"&searchCondition="+board.getSearchCondition() 
				   +"&searchKeyword="+URLEncoder.encode(board.getSearchKeyword(), "UTF-8");
	}
	
}
