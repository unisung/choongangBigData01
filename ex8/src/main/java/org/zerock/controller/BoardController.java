package org.zerock.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardAttachVO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import oracle.jdbc.proxy.annotation.Pre;

@Controller
@RequestMapping("/board/*")
@Log4j
@AllArgsConstructor
public class BoardController {
	
	private BoardService service;
	
	/* 게시글 리스트 */
	@GetMapping("/list")
	public void list(Model model, Criteria cri) {
		log.info("list");

		model.addAttribute("list", service.getListWithPaging(cri));
		int total = service.getTotal(cri);
		
		log.info("total:"+total);
		model.addAttribute("pageMaker", new PageDTO(cri, total)); 
	}
	
	/* 게시글 등록 폼*/
	@GetMapping("/register")
	@PreAuthorize("isAuthenticated()")
	public void registerForm(BoardVO board) {
	}
	
	/* 등록 처리 */
	@PostMapping("/register")
	@PreAuthorize("isAuthenticated()")
	public String register(BoardVO board, RedirectAttributes rttr ) {
	  log.info("==================");
	  log.info("register:"+board);
	  
	  if(board.getAttachList()!=null) {
		  board.getAttachList().forEach(new Consumer<BoardAttachVO>() {

			@Override
			public void accept(BoardAttachVO attach) {
				log.info(attach);
			}
		});
	  }//if 끝.
	  
	  log.info("===================");
	  
	  service.register(board);
	  
	  System.out.println("신규등록한 글번호: " +board.getBno());
	  rttr.addFlashAttribute("result", board.getBno());//등록한 글 번호를 list로 전달
		
		return "redirect:/board/list";
	}
	
	/* 게시글 상세보기 */
	@GetMapping("/get")
	public void get(@RequestParam("bno") Long bno, Model model, 
			                @ModelAttribute("cri") Criteria cri
			                ,RedirectAttributes rttr) {
		System.out.println("cri:"+cri);
		BoardVO board=service.get(bno);
		model.addAttribute("board",board);
		rttr.addFlashAttribute("result", "");
		
	}
	
	/* 첨부파일 리스트 */
	@GetMapping(value="/getAttachList", 
			            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<BoardAttachVO>> getAttachList(Long bno){
		log.info("getAttachList " + bno);
		
		return new ResponseEntity<>(service.getAttachList(bno), HttpStatus.OK);
	}
	
	/* 수정페이지 이동 */
	@GetMapping("/modify")
	public void modify(@ModelAttribute("board")BoardVO board, Model model,
			                      @ModelAttribute("cri") Criteria cri) {
		System.out.println("modify-get-cri:"+cri);
		model.addAttribute("board",service.get(board.getBno()));
	}
	
	/* 게시글 수정 처리 */
	@PreAuthorize("principal.username==#board.writer")
	@PostMapping("/modify")
	public String modify(BoardVO board, @ModelAttribute("cri") Criteria cri,
			                          RedirectAttributes rttr) {
		if(service.modify(board))
			rttr.addFlashAttribute("result","success");
		
		System.out.println("modify-post-cri:" +cri);
		
		//수정처리 후 리다이렉트한 페이지로 원래페이지번호, 페이지당 글 수 값 전달
		return "redirect:/board/list"+cri.getListLink();
	}
	
	
	/* 게시글 삭제 처리 */
	// #writer 파라미터 writer값 비교
	@PreAuthorize("principal.username==#writer")
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, 
									 @ModelAttribute("cri") Criteria cri,
									 			RedirectAttributes  rttr,
									 String writer
			  ) {
		System.out.println("remove-post-cri: "+cri);
		
		/* 게시글 삭제 전 - 해당 글번호의 첨부파일 정보 얻기 */
		List<BoardAttachVO> attachList = service.getAttachList(bno);
		
		if(service.remove(bno)) {
		// 게시글 삭제 후, 첨부파일도 삭제처리 	
		   deleteFiles(attachList);	
		   rttr.addFlashAttribute("result","success");
		  }
		
		//수정처리 후 리다이렉트한 페이지로 원래페이지번호, 페이지당 글 수 값 전달
		return "redirect:/board/list" +cri.getListLink();
	}
	
	/* bno에 해당하는 첨부파일 삭제 c:/upload/파일들 */
	private void deleteFiles(List<BoardAttachVO> attachList) {
		//첨부파일 리스트가 없거나 첨부파일리스트 사이즈가 0이면 리턴.
		if(attachList == null || attachList.size()==0) return;
		
		log.info("delete attach files..................");
		log.info(attachList);
		
		attachList.forEach(new Consumer<BoardAttachVO>() {
			@Override
			public void accept(BoardAttachVO attach) {
				 try {
					 /* 파일 삭제*/
					  Path file = Paths.get("c:\\upload\\"+attach.getUploadPath()+"\\" 
				                                      + attach.getUuid()+"_"+attach.getFileName());
					 Files.deleteIfExists(file);
					 
					 /* 이미지면 썸네일도 삭제 */
					 if(Files.probeContentType(file).startsWith("image")) {
						 Path thumbnail = Paths.get("c:\\upload\\"+attach.getUploadPath()+"\\s_"
					                                  +attach.getUuid()+"_"+attach.getFileName());
						 
					 Files.deleteIfExists(thumbnail);
					 }
					  
				 }catch(Exception e) {
					 e.printStackTrace();
					 log.error("delete file error" + e.getMessage());
				 }//end try-catch.
			}//end accept
		});//end forEach
		
		
	}
	

}
