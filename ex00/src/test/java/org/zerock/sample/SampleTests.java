package org.zerock.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTests {
	@Setter(onMethod_=@Autowired)
	private Restaurant restaurant;
	@Setter(onMethod_=@Autowired)
	private SampleHotel hotel;
	
	@Ignore//테스트 대상에서 제외 
	@Test
	public void testExists() {
		assertNotNull(restaurant);//assert+메소드 :결과 true/false 
		
		log.info(restaurant);
		log.info("------------------------");
		log.info(restaurant.getChef());
	}
	
	@Test
	public void testExists2() {
		assertNotNull(hotel);//assert+메소드 :결과 true/false 
		
		log.info(hotel);
		log.info("------------------------");
		log.info(hotel.getChef());
	}
	

}





