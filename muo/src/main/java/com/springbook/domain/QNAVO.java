package com.springbook.domain;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class QNAVO {
	private long qna_bno;
	
	private long member_bno; //참조 외래키
	private long order_bno; //참조 외래키
	
	private String qna_type;
	private String qna_title;
	private String qna_content;
	
	private MultipartFile uploadFile;
	private String qna_img;
	
	private String qna_check;
	private Date qna_regdate;
}
