package com.springbook.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ShopCriteria2 {
	private int pageNum;
	private int amount;

	private String type = "T";
	private String keyword = "";
	
	private String order;

	public ShopCriteria2(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}

	public ShopCriteria2() {
		this(1, 12);
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

}
