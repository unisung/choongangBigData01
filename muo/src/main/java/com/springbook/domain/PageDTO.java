package com.springbook.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	private int startPage;
	private int endPage;
	private boolean prev, next; // 초기값 false

	private int total;
	private Criteria cri;
	private ShopCriteria shop;
	private ShopCriteria2 shop2;

	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;

		// 파라미터로 넘어온 페이지가 속한 페이지그룹의 시작페이지/끝페이지 계산
		this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10;
		this.startPage = this.endPage - 9;

		// 전체 글 목록 갯수로 실제 종료페이지 계산
		int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));

		// 계산식에 의한 종료페이지와 실제 페이지로 종료 페이지 재 계산
		if (realEnd < this.endPage) {
			this.endPage = realEnd;
		}

		// 이전페이지, 다음 페이지 활성화 여부 처리
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;

	}
	
	public PageDTO(ShopCriteria shop, int total) {
		this.shop = shop;
		this.total = total;

		// 파라미터로 넘어온 페이지가 속한 페이지그룹의 시작페이지/끝페이지 계산
		this.endPage = (int) (Math.ceil(shop.getPageNum() / 10.0)) * 10;
		this.startPage = this.endPage - 9;

		// 전체 글 목록 갯수로 실제 종료페이지 계산
		int realEnd = (int) (Math.ceil((total * 1.0) / shop.getAmount()));

		// 계산식에 의한 종료페이지와 실제 페이지로 종료 페이지 재 계산
		if (realEnd < this.endPage) {
			this.endPage = realEnd;
		}

		// 이전페이지, 다음 페이지 활성화 여부 처리
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;

	}
	
	public PageDTO(ShopCriteria2 shop2, int total) {
		this.shop2 = shop2;
		this.total = total;

		// 파라미터로 넘어온 페이지가 속한 페이지그룹의 시작페이지/끝페이지 계산
		this.endPage = (int) (Math.ceil(shop2.getPageNum() / 10.0)) * 10;
		this.startPage = this.endPage - 9;

		// 전체 글 목록 갯수로 실제 종료페이지 계산
		int realEnd = (int) (Math.ceil((total * 1.0) / shop2.getAmount()));

		// 계산식에 의한 종료페이지와 실제 페이지로 종료 페이지 재 계산
		if (realEnd < this.endPage) {
			this.endPage = realEnd;
		}

		// 이전페이지, 다음 페이지 활성화 여부 처리
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;

	}

}
