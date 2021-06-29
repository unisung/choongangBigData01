package com.springbook.mapper;

import java.util.List;

import com.springbook.domain.Criteria;
import com.springbook.domain.OrderVO;
import com.springbook.domain.ProductVO;

public interface OrderMapper {

	List<OrderVO> orderList();

	//List<OrderVO> getListWithPaging(Criteria cri);
	
	List<OrderVO> orderView(Long od_num);  //파라미터 주문번호 사용

	int orderUpdate(OrderVO order);

	
	
	//int getTotalCount(Criteria cri);
}
