package com.springbook.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.domain.Criteria;
import com.springbook.domain.ProductVO;
import com.springbook.domain.ShopCriteria;
import com.springbook.domain.ShopCriteria2;
import com.springbook.mapper.ShopMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class ShopServiceImpl implements ShopService {

	@Setter(onMethod_ = @Autowired)
	private ShopMapper mapper;


	@Override
	public List<ProductVO> getList(ShopCriteria shop) {
		return mapper.getList(shop);
	}

	@Override
	public List<ProductVO> getListNew(ShopCriteria2 shop2) {
		return mapper.getListNew(shop2);
	}

	@Override
	public List<ProductVO> getListBest(ShopCriteria2 shop2) {
		return mapper.getListBest(shop2);
	}


	@Override
	public List<ProductVO> getListSale(ShopCriteria2 shop2) {
		return mapper.getListSale(shop2);
	}
	
	@Override
	public int getTotalCount(ShopCriteria shop) {
		return mapper.getTotalCount(shop);
	}
	
	@Override
	public int getTotalCountNew(ShopCriteria2 shop2) {
		return mapper.getTotalCountNew(shop2);
	}

	@Override
	public int getTotalCountBest(ShopCriteria2 shop2) {
		return mapper.getTotalCountBest(shop2);
	}
	
	@Override
	public int getTotalCountSale(ShopCriteria2 shop2) {
		return mapper.getTotalCountSale(shop2);
	}

	@Override
	public ProductVO get(String it_number) {
		return mapper.get(it_number);
	}
	

}
