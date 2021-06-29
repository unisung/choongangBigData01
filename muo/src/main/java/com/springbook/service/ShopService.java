package com.springbook.service;

import java.util.List;
import java.util.Map;

import com.springbook.domain.Criteria;
import com.springbook.domain.ProductVO;
import com.springbook.domain.ShopCriteria;
import com.springbook.domain.ShopCriteria2;

public interface ShopService {
	
	public List<ProductVO> getList(ShopCriteria shop);  // 카테고리별 상품목록 조회

	public List<ProductVO> getListNew(ShopCriteria2 shop2);	// new 카테고리

	public List<ProductVO> getListBest(ShopCriteria2 shop2);	// best 카테고리

	public List<ProductVO> getListSale(ShopCriteria2 shop2);	// sale 카테고리
	
	public int getTotalCount(ShopCriteria shop);	// 분류별 개수
	
	public int getTotalCountNew(ShopCriteria2 shop2);		// new 개수

	public int getTotalCountBest(ShopCriteria2 shop2);		// best 개수
	
	public int getTotalCountSale(ShopCriteria2 shop2);		// sale 개수

	public ProductVO get(String it_number);
	
	
	
}

