package com.springbook.domain;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProductVO {
	
	private long it_number;
	private int it_category1;
	private String it_category2;
	
	private MultipartFile uploadFile1;
	private MultipartFile uploadFile2;
	private MultipartFile uploadFile3;

	/*이미지 파일 이름 저장*/
	private String it_img1;
	private String it_img2;
	private String it_img3;
	/**/
	
	private String it_name;
	private int it_baseprice;
	private int it_saleprice;
	private String it_option1; //색상
	private int it_option2; //사이즈
	
	//beauty 옵션 3,4
	private String it_option3; 
	private String it_option4;
	
	private String it_content;
	private int it_sale;
	private int it_remainCount;
	private int it_saleCount;
	private Date it_regDate;
}
