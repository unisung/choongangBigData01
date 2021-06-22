package org.zerock.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/replies")
@RestController
@Log4j
@AllArgsConstructor
public class ReplyController {
	/* 스프링 4.3 이후 */
	private ReplyService service;
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping(value="/new",
			              consumes = "application/json",
			              produces= {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> create(@RequestBody ReplyVO vo){
		  log.info("ReplyVO: "+vo);
		  
		  int insertCount = service.register(vo);
		  
		  log.info("Reply INSERT COUNT:" +insertCount);
		  return insertCount==1?new ResponseEntity<>("success",HttpStatus.OK):
			  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/* 댓글 리스트 출력 */
	@GetMapping(value="/pages/{bno}/{page}",
            produces= {MediaType.APPLICATION_JSON_UTF8_VALUE, 
            		           MediaType.APPLICATION_XML_VALUE})
public ResponseEntity<ReplyPageDTO> getList(
														                 @PathVariable("page") int page, 
														                 @PathVariable("bno") Long bno){
    Criteria cri = new Criteria(page, 10);
    
    log.info("get Reply List bno: " +bno);
    
    log.info("cri: "+cri);
    
    return new ResponseEntity<ReplyPageDTO>(service.getList(cri, bno), 
    		                                                               HttpStatus.OK);
	}
	
	/* 댓글 조회 */
	@GetMapping(value="/{rno}", produces= {MediaType.APPLICATION_JSON_VALUE, 
			                                                         MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<ReplyVO> get(@PathVariable("rno") Long rno){
		log.info("get:" +rno);
		
		return new ResponseEntity<>(service.get(rno), HttpStatus.OK);
	}
	
	/*  댓글 삭제 */
	@PreAuthorize("principal.username ==#vo.replyer")
	@DeleteMapping(value="/{rno}", produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@RequestBody ReplyVO vo,
			@PathVariable("rno") Long rno){
		log.info("remove: " + rno);
		
		log.info("replyer: " + vo.getReplyer());
		
		return service.remove(rno)==1? new ResponseEntity<>("success",HttpStatus.OK)
				:new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/* 댓글 수정 */
@PreAuthorize("principal.username == #vo.replyer")
@RequestMapping(method= {RequestMethod.PUT, RequestMethod.PATCH}, /*전송방식*/
                                              value="/{rno}", /* uri - pathvariable */
                                             consumes="application/json",  /* 파라미터 타입*/
                                             produces= {MediaType.TEXT_PLAIN_VALUE}) /* 응답결과 타입 */
 public ResponseEntity<String> modify(@PathVariable("rno") Long rno,
		                                                    @RequestBody ReplyVO vo){
	vo.setRno(rno);
	
	log.info("rno: "+rno);
	log.info("modify:"+vo);
	
	return service.modify(vo)==1? new ResponseEntity<>("success",HttpStatus.OK)
			: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
}
	
}