package com.springbook.service;

import java.util.List;
import java.util.Map;

import com.springbook.domain.Criteria;
import com.springbook.domain.OrderVO;
import com.springbook.domain.ProductVO;

public interface OrderService {

	List<OrderVO> orderList();

	List<Map<String, String>> orderView(Long od_num);

	String orderUpdate(OrderVO order);

}


//public List<ProductVO> getList();
//
//public List<ProductVO> getListWithPaging(Criteria cri);
//
//public int getTotalCount(Criteria cri);