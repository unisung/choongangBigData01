package com.springbook.domain;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
// 주문관리에 필요한 변 수 _ 
public class OrderVO {
	private Long od_num;
	private int mb_seq;
	private Date od_date;
	private int od_price;
	private int od_amount;
	private String od_status;  //수정기능
	private String mb_name;
	private String dlvI_name ;

//mu_orderDetail T
	private Long odd_num;
	//private int od_num;
	private Long it_number;
	private int  cp_usenum;  
	private int odd_quantity; 
	private String it_name; 
	private int it_saleprice;

	private List<OrderDetailVO> list;
	
    private ProductVO product;
    
	private DeliveryInfo deliveryInfo;
	
	
	}


//주문번호	 od_num number(30) not null primary key,		
//고객번호	 mb_seq number(10,0) not null foreign key		
//주문날짜	 od_date date default sysdate,   		
//주문금액	od_price number(30),		
//실결제금액(총금액)	od_amount number(30),		
//주문상태(flag값)	od_status char(1) 		
//주문자이름	od_userName varchar2(14), 		
//받는사람 이름	od_recipientName varchar2(14), 		
