package org.zerock.mapper;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	 @Setter(onMethod = @__({ @Autowired }))
	  private BoardMapper mapper;
	  
	 @Ignore
	  @Test
	  public void testGetList() {
	
	    mapper.getList().forEach(board -> log.info(board));
	  }
	  
	  @Test
	  public void testPaging() {
		  Criteria cri=new Criteria();//1페이지, 페이지당 10개 글
		  
		  cri.setPageNum(3);
		  cri.setAmount(10);
		  List<BoardVO> list = mapper.getListWithPaging(cri);
		  list.forEach(board->log.info(board));
	  }
}
