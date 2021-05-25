package org.zerock.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.mapper.TimeMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TimeMapperTests {

	 @Setter(onMethod_=@Autowired)
	 private TimeMapper timeMapper;
	 
	 @Test
	 public void testGetTime() {
		 log.info("test"+timeMapper.getClass().getName());
		 log.info("test"+timeMapper.getTime());
		 log.info("test2"+timeMapper.getTime2());
	 }
}
