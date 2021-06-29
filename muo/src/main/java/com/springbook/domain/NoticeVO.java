package com.springbook.domain;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class NoticeVO {
	private int nt_num;
	private String nt_title;
	private String nt_content;
	private MultipartFile nt_img;
	private Date nt_date;
	private int nt_cnt;
}
