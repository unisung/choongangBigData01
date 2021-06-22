package org.zerock.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	private int pageNum;
	private int amount;
	
	private String type;
	private String keyword;
	
	private String y;
	private String m;
	private String id;
	
	
	/* 매개변수 2개 짜리 생성자*/
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}

  /* 사용자 정의 default생성자 */
	public Criteria() {
      this(1,10);	//동일 클래스내의 다른 생성자 호출 this();
	}
	
	public String[] getTypeArr(){
		return type==null ? new String[] {} : type.split("");//TCW -> ["T"]["C"]["W"], {"T","C","W"}
	}
	
	public String getListLink() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				                                       .queryParam("pageNum", this.pageNum)
				                                       .queryParam("amount",this.amount)
				                                       .queryParam("type",this.getType())
				                                       .queryParam("keyword",this.getKeyword());
		return builder.toUriString();
	}

	public String getCalendarLink() {
		UriComponentsBuilder builder = 
				  UriComponentsBuilder.fromPath("")
				                                .queryParam("id", this.id)
				                                .queryParam("y", this.y)
				                                .queryParam("m", this.m)
				                                ;
		return builder.toUriString();//
	}
}
