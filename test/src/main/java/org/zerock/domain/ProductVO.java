package org.zerock.domain;


public class ProductVO {
	private int seq;
	private String img;
	private String name;
	private int price;
	
	public ProductVO(int seq, String img, String name, int price) {
		this.seq = seq;
		this.img = img;
		this.name = name;
		this.price = price;
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
