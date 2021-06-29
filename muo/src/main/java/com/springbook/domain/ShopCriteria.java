package com.springbook.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ShopCriteria {
	private int pageNum;
	private int amount;
	
	private String it_category1;
	private String it_category2;

	private String type = "T";
	private String keyword = "";
	
	private String order;

	public ShopCriteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}

	public ShopCriteria() {
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
				                                       .queryParam("keyword",this.getKeyword())
				                                       .queryParam("it_category1", this.it_category1)
				                                       .queryParam("it_category2", this.it_category2);
		return builder.toUriString();
	}

}
