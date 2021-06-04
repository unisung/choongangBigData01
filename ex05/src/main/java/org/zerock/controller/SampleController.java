package org.zerock.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;
import org.zerock.domain.Ticket;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/sample")
@Log4j
public class SampleController {
	
	/* @RestController의 리턴 타입 - 1. String */
	@GetMapping(value="/getText", produces="text/plain; charset=UTF-8")
	public String getText() {
		log.info("MediaType: " +MediaType.TEXT_XML_VALUE);
		
		return "안녕하세요";
	}
	
	/* @RestController의 리턴 타입 - 2. VO -> JSON or  XML */
	@GetMapping(value="/getSample", 
			             produces= {MediaType.APPLICATION_JSON_UTF8_VALUE, 
			            		           MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample() {
		return new SampleVO(112, "스타","로드");
	}
	
	/* Collections - 리스트 */
	@GetMapping(value="/getList")
	public List<SampleVO> getList(){
		/*IntStream intStream = IntStream.range(1, 10); 
		
		Stream<SampleVO> stream    
		       = intStream.mapToObj(new IntFunction<SampleVO>() {
			@Override
			public SampleVO apply(int i) {
				return new SampleVO( i, i+"first",i+" Last");
			}
		});
		*/
		/*
		Stream<SampleVO> stream 
		    =  intStream.mapToObj(i->new SampleVO( i, i+"first",i+" Last"));  
		*/
		/*
		Stream<SampleVO> stream 
		     =IntStream.range(1,10).mapToObj(i->new SampleVO( i, i+"first",i+" Last"));  
		
		List<SampleVO> list =stream.collect(Collectors.toList());
		*/
		
		List<SampleVO> list
		=IntStream.range(1,10)
		  .mapToObj(i->new SampleVO( i, i+"first",i+" Last"))
		  .collect(Collectors.toList());
		
		List<SampleVO> list2 =new ArrayList<SampleVO>();
		for(int i=0;i<10;i++) {
			 list2.add(new SampleVO( i, i+"first",i+" Last"));
		}
	
		return list2;
	}
	
	/* collections - Map*/
	@GetMapping(value="/getMap")
	public Map<String,SampleVO> getMap(){
		Map<String, SampleVO> map=new HashMap<>();
		map.put("First", new SampleVO(111,"그루트","주니어"));
		
		return map;
	}
	
	@GetMapping(value="/getMap2")
	public Map<String,List<String>> getMap2(){
		Map<String, List<String>> map=new HashMap<>();
		 List<String> list1 = Arrays.asList("a","b","c");
		 List<String> list2 = Arrays.asList("1","2","3");
		 
		 map.put("board", list1);
		 map.put("user",list2);
		 
		return map;
	}
	
	
	/* ResponseEntity타입 */
	@GetMapping(value="/check", params= {"height","weight"})
	public ResponseEntity<SampleVO> check(Double height, Double weight){
		SampleVO vo = new SampleVO(000, ""+height, ""+ weight);
		
		ResponseEntity<SampleVO> result = null;
		
		if(height < 150){
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		}else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		return result;
	}
	
	/**  파라미터 타입- 1. PathVariable **/
	@GetMapping("/product/{cat}/{pid}")
//             /sample/product/bags/1234
	public String[] getPath(@PathVariable("cat") String cat,
			                            @PathVariable("pid") Integer pid) {
		return new String[] {"category: " + cat, "productid: " + pid};
	}
	
  /* 파라미터 타입 - 2. RequestBody - JSON */
  @PostMapping("/ticket")
  public Ticket convert(@RequestBody Ticket ticket) {
	  log.info("convert......... ticket" + ticket);
	  
	  return ticket;
  }

}
