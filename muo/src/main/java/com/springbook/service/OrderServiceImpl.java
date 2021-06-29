package com.springbook.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.domain.OrderVO;
import com.springbook.mapper.OrderMapper;
import com.springbook.mapper.ProductMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {		
		@Autowired
		private OrderMapper orderRep;
		
		@Override
		public List<OrderVO> orderList(){
			return orderRep.orderList();
		}
		
		@Override
		public List<Map<String, String>> orderView(Long od_num) {
			/*
			 * List<OrderVO> orderView = orderRep.orderView(od_num);
			 * 
			 * String productList = ""; int sumOfdiscountAmt = 0; int sumOfamount = 0; int
			 * resultAmt = 0;
			 * 
			 * for (OrderVO order : orderView) { if(!productList.equals("")) { productList
			 * += "\r\n"; }
			 * 
			 * productList += order.getProductNm() + "(" + order.getCnt() + "개)";
			 * sumOfdiscountAmt += order.getDiscountAmt(); sumOfamount +=
			 * order.getOd_amount(); }
			 * 
			 * resultAmt = sumOfamount - sumOfdiscountAmt;
			 * 
			 * List<Map<String, String>> list = new ArrayList<Map<String, String>>();
			 * Map<String, String> hash = new HashMap<String, String>(); hash.put("orderNo",
			 * orderView.get(0).getOrderNo()); hash.put("productList", productList);
			 * hash.put("recipient", orderView.get(0).getRecipient()); hash.put("addr",
			 * orderView.get(0).getAddr()); hash.put("phone", orderView.get(0).getPhone());
			 * hash.put("discountAmt", sumOfdiscountAmt+""); hash.put("amount",
			 * sumOfamount+""); hash.put("resultAmt", resultAmt+""); hash.put("paymentNm",
			 * orderView.get(0).getPaymentNm()); hash.put("deliveryCd",
			 * orderView.get(0).getDeliveryCd()); hash.put("orderDt",
			 * orderView.get(0).getOrderNo().toString()); list.add(hash);
			 * 
			 * return list;
			 */
			
			return null;   // 수정 중, 임시작성 이후 삭제
		}
		
		@Override
		public String orderUpdate(OrderVO order) {
			String resultStr = "";
			
			try {
				int result = orderRep.orderUpdate(order);
				
				if(result > 0) {
					resultStr = "success";
				} else {
					resultStr ="fail";
				}
			} catch (Exception e) {
				e.printStackTrace();
				resultStr ="fail";
			}
			
			return resultStr;
		}
	}