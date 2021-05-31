package org.zerock.service;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTest {
	 @Setter(onMethod = @__({ @Autowired }))
	  private BoardService service;
	  
	  @Ignore
	  @Test
	  public void testGetList() {
	
	    service.getList().forEach(board -> log.info(board));
	  }
	  
	  @Test
	  public void testGetListWithPaging() {
		  service.getListWithPaging(new  Criteria(3, 5))
		           .forEach(board->log.info(board));
	  }
	  
	  
}
