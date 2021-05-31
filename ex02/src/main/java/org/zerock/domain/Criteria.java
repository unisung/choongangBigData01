package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	private int pageNum;
	private int amount;
	
	/* 매개변수 2개 짜리 생성자*/
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}

  /* 사용자 정의 default생성자 */
	public Criteria() {
      this(1,10);	//동일 클래스내의 다른 생성자 호출 this();
	}
	
	

}
