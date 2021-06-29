package com.springbook.domain;

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

	// 매개변수 2개짜리 생성자
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}

	// 사용자 정의 default생성자
	public Criteria() {
		this(1, 10);// 동일 클래스 내의 다른생성자 호출 this();
	}

	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");// TCW->["T"]["C"]["W"],{"T","C","W"}
	}

	public String getListLink() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("").queryParam("pageNum", this.pageNum)
				.queryParam("amount", this.amount)
				.queryParam("type", this.getType())
				.queryParam("keyword", this.getKeyword());
		return builder.toUriString();
	}
}