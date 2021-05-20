package com.springbook.view.board;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.board.BoardListVO;
import com.springbook.biz.board.BoardVO;
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
	 
	 @RequestMapping("/dataTransformXml.do")
	 @ResponseBody
	 public BoardListVO dataTransformXml(BoardVO vo) {
		 vo.setSearchCondition(null);
		 if(vo.getPageNum()==null) vo.setPageNum("1");
		 int startRow = (Integer.parseInt(vo.getPageNum())-1)*10+1;
		 int endRow = startRow +9;
		 vo.setStartRow(startRow);
		 vo.setEndRow(endRow);
		 
		 List<BoardVO> boardList = service.getBoardList(vo);
		 BoardListVO boardListVO = new BoardListVO();
		 boardListVO.setBoardList(boardList);
		 return boardListVO;
	 }
	  
	@RequestMapping("/dataTransform.do")
	@ResponseBody /* 객체를 응답 몸체(body)로 변환 */
	public List<BoardVO> dataTransform(BoardVO vo){
		System.out.println("--->/dataTransform.do");
		
		System.out.println("-----searchKeyword: "+vo.getSearchKeyword());
		
		if(vo.getSearchCondition()==null || vo.getSearchCondition().length()==0)  
			   vo.setSearchCondition(null);
		
		if(vo.getPageNum()==null) vo.setPageNum("1");
		int startRow= (Integer.parseInt(vo.getPageNum()) -1 )*10 +1;
		int endRow = startRow + 9;
		vo.setStartRow(startRow);
		vo.setEndRow(endRow);
		
		
		List<BoardVO> boardList = service.getBoardList(vo);
		for(BoardVO board:boardList) System.out.println(board);
		return boardList;
	}
	@RequestMapping("/dataTransform2.do")
	@ResponseBody /* 객체를 응답 몸체(body)로 변환 */
	public List<BoardVO> dataTransform2(BoardVO vo){
		List<BoardVO> boardList = service.getBoardList2(vo);
		return boardList;
	}
	  
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) throws  Exception{

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
	   
	   int lastPage = (int) Math.ceil(totalCount / (double)10);// 125=> 125/1.0 =>13
	    
	   int endPage = ((int)Math.ceil(Integer.parseInt(vo.getPageNum()) / (double)10)) * 10;
	   
	   if(lastPage < endPage) endPage =lastPage;
	   int startPage =(((int)((Integer.parseInt(vo.getPageNum())-1)/(double)10) + 1) -1)*10 +1;// 12/10.0=>1.2=>(1+1-1)*10=10+1=>11
	   if(startPage < 1) startPage=1;
	   
	     System.out.println("검색조건:"+vo.getSearchCondition());
	     System.out.println("startPage: " + startPage);
	     System.out.println("endPage: " +endPage);
	     System.out.println("lastPage: " + lastPage);
	     
	     model.addAttribute("boardList", boardList);
	     model.addAttribute("total",total);
	     model.addAttribute("searchCondition",vo.getSearchCondition());
	     model.addAttribute("searchKeyword",vo.getSearchKeyword());
	     model.addAttribute("pageNum",vo.getPageNum());
	     model.addAttribute("startPage",startPage);
	     model.addAttribute("endPage",endPage);
	     model.addAttribute("lastPage",lastPage);
	    
	     return "getBoardList";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model, 
			                          @RequestParam(value="flag", defaultValue="") String flag) {
		
		System.out.println("flag:"+flag);
		System.out.println("pageNum:"+vo.getPageNum());
		System.out.println("searchCondition:"+vo.getSearchCondition());
		System.out.println("searchKeyword:"+vo.getSearchKeyword());
		 
		System.out.println("vo:"+vo);
		
		String pageNum=vo.getPageNum();
		String searchCondition=vo.getSearchCondition();
		String searchKeyword=vo.getSearchKeyword();

		vo = service.getBoard(vo,flag);
		
		vo.setPageNum(pageNum);
		vo.setSearchCondition(searchCondition);
		vo.setSearchKeyword(searchKeyword);
		
		System.out.println("vo:"+vo);
		
		//
		List<BoardVO> replies=new ArrayList<BoardVO>();
		if(vo.getRe_seq()==0) {
			replies = service.getReplies(vo);
		}
		/* model저장시 sessionAttributes에도 저장 */
		model.addAttribute("board",vo);
		model.addAttribute("replies",replies);
		return "getBoard";
	}
	
	
	@RequestMapping(value="/updateBoard.do",method=RequestMethod.POST)
	public String updateBoard(@ModelAttribute("board") BoardVO board) 
			                                                throws IllegalStateException, IOException {
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
		return "insertBoard";
	}
	
	@RequestMapping(value="/insertBoard.do",method=RequestMethod.POST)
	public String insertBoard(BoardVO board) throws Exception {
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
		//null값 ""로 변환
		if(board.getImg()==null) board.setImg("");
        //부모글(원글)인 경우 re_lev=0, re_seq=0
		board.setRe_lev(0);
		board.setRe_seq(0);
		
		service.insertBoard(board);
		
		return "redirect:getBoardList.do";
	}
	
	
	@RequestMapping(value="/deleteBoard.do",
			method=RequestMethod.GET)
	public String deleteBoard(@ModelAttribute("board")BoardVO board) throws UnsupportedEncodingException {

		service.deleteBoard(board);
		return "redirect:getBoardList.do?pageNum="+board.getPageNum() 
				   +"&searchCondition="+board.getSearchCondition() 
				   +"&searchKeyword="+URLEncoder.encode(board.getSearchKeyword(), "UTF-8");
	}
	
	/* replyForm으로 이동 */
	@RequestMapping(value="replyBoard.do", method=RequestMethod.GET)
	public String replyBoard(BoardVO vo, Model model) {
		model.addAttribute("board",vo);
		return "replyBoard";
	}
	
	@RequestMapping(value="replyBoard.do", method=RequestMethod.POST)
	public String replyBoard(BoardVO vo) throws UnsupportedEncodingException {
		System.out.println("------------- 답변 VO:"+vo);
		System.out.println("페이지번호:"+vo.getPageNum());
		System.out.println("조회조건:"+vo.getSearchCondition());
		System.out.println("조회키워드:"+vo.getSearchKeyword());//"", null
		
		//답글 중 가장 최근 답글이 위로 올라가게 처리한다.
		//답글의 순서인 seq를 1증가시킴.
		service.updateReSeq(vo);
		
		vo.setRe_ref(vo.getRe_ref());//부모글의 re_ref번호를 답변글의 re_ref에 저장
		vo.setRe_lev(vo.getRe_lev()+1);//부모글에 대비 들여쓰기 레벨 증가
		vo.setRe_seq(vo.getRe_seq()+1);//부모글 대비 등록 순서 + 1
		
		service.insertReplyBoard(vo);
		
		return "redirect:getBoardList.do?pageNum="+vo.getPageNum()
        +"&searchCondition="+vo.getSearchCondition()
        +"&searchKeyword="+URLEncoder.encode(vo.getSearchKeyword(), "UTF-8");
	}
	
	@RequestMapping("updateGoodBad.do")
	public String updateGoodBad(@RequestParam("seq") String seq, 
			                                    @RequestParam("flag") String flag,
			                                    BoardVO vo                                    
			) throws UnsupportedEncodingException {
		System.out.println("seq:"+seq);
		System.out.println("flag:" + flag);
		System.out.println("vo: " +vo);

		if(flag.equals("good")) service.upGood(vo);
		else if(flag.equals("bad")) service.upBad(vo);
		
	  
		return "redirect:getBoard.do?seq="+vo.getSeq()
		+"&pageNum="+vo.getPageNum()
        +"&searchCondition="+vo.getSearchCondition()
        +"&searchKeyword="+URLEncoder.encode(vo.getSearchKeyword(), "UTF-8")
        +"&flag="+flag;
	}
	
}