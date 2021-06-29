package com.springbook.domain;

public class OrderDetailVO {
 private  int odd_num;
 private String od_num; 
 private int it_number;/* 상품코드 20210623195048*/ 
 private int cp_usenum;/* 쿠폰번호*/
 private int odd_quantity;/* 수량*/ 
 private long it_saleprice;
 
public OrderDetailVO() {}

public OrderDetailVO(int odd_num, String od_num, int it_number, int cp_usenum, int odd_quantity, long it_saleprice) {
	this.odd_num = odd_num;
	this.od_num = od_num;
	this.it_number = it_number;
	this.cp_usenum = cp_usenum;
	this.odd_quantity = odd_quantity;
	this.it_saleprice = it_saleprice;
}

public int getOdd_num() {
	return odd_num;
}

public void setOdd_num(int odd_num) {
	this.odd_num = odd_num;
}

public String getOd_num() {
	return od_num;
}

public void setOd_num(String od_num) {
	this.od_num = od_num;
}

public int getIt_number() {
	return it_number;
}

public void setIt_number(int it_number) {
	this.it_number = it_number;
}

public int getCp_usenum() {
	return cp_usenum;
}

public void setCp_usenum(int cp_usenum) {
	this.cp_usenum = cp_usenum;
}

public int getOdd_quantity() {
	return odd_quantity;
}

public void setOdd_quantity(int odd_quantity) {
	this.odd_quantity = odd_quantity;
}

public long getIt_saleprice() {
	return it_saleprice;
}

public void setIt_saleprice(long it_saleprice) {
	this.it_saleprice = it_saleprice;
}

@Override
public String toString() {
	return "OrderDetailVO [odd_num=" + odd_num + ", od_num=" + od_num + ", it_number=" + it_number + ", cp_usenum="
			+ cp_usenum + ", odd_quantity=" + odd_quantity + ", it_saleprice=" + it_saleprice + "]";
} 
 

 
}
