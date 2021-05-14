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
			                                BoardDAO boardDAO	) throws  Exception{
		
	
		System.out.println("x");
		//vo=null;
		
		//String msg=null;
	    //System.out.println(msg.length());
		
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
	   
	   int lastPage = (int) Math.ceil(totalCount / (double)10);// 125=> 125/1.0 =>13
	    
	   //if(totalCount%10==0) totalCount/10;// 50/10 =5;
	   // else if(totalCount%10!=0) totalCount/10 +1;//52/10 =5*10+2;
	    
	   int endPage = ((int)Math.ceil(Integer.parseInt(vo.getPageNum()) / (double)10)) * 10;
	   // 12/10.0 =>1.2=>2*10=>20
	   
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
	     
	    // boolean test=true;
	    // if(test) 
	 	//throw new Exception("일반오류");
	    
	     return "getBoardList";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(
			//@RequestParam("pageNum") String pageNum,
			//@RequestParam("searchCondition") String searchCondition,
			//@RequestParam("searchKeyword") String searchKeyword,
			BoardVO vo, Model model, BoardDAO boardDAO) {
		
		System.out.println("pageNum:"+vo.getPageNum());
		System.out.println("searchCondition:"+vo.getSearchCondition());
		System.out.println("searchKeyword:"+vo.getSearchKeyword());
		 
		System.out.println("vo:"+vo);
		
		String pageNum=vo.getPageNum();
		String searchCondition=vo.getSearchCondition();
		String searchKeyword=vo.getSearchKeyword();
		
		//vo = boardDAO.getBoard(vo);
		vo = service.getBoard(vo);
		
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
		return "insertBoard";
	}
	
	@RequestMapping(value="/insertBoard.do",method=RequestMethod.POST)
	public String insertBoard(BoardVO board,	BoardDAO dao) throws Exception {
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
        //부모글(원글)인 경우 re_lev=0, re_seq=0
		board.setRe_lev(0);
		board.setRe_seq(0);
		
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
	
	/* replyForm으로 이동 */
	@RequestMapping(value="replyBoard.do", method=RequestMethod.GET)
	public String replyBoard(BoardVO vo, Model model) {
		//service.getBoard(vo);
		//vo.setRe_ref(1);
		//vo.setRe_lev(2);
		//vo.setRe_seq(3);
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
        +"&searchKeyword="+URLEncoder.encode(vo.getSearchKeyword(), "UTF-8");
	}
	
}