package org.zerock.sample;

import org.springframework.stereotype.Component;

@Component
public class SampleHotel {
	/* 스프링 4.3 이후 부터 @Autowired 안써도 됨.(단, 단일 파라미터 생성자인경우) */
	private Chef chef;

	public SampleHotel(Chef chef) {
		this.chef = chef;
	}

	public Chef getChef() {
		return chef;
	}

}
