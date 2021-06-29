package com.springbook.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;
@Data
public class MemberVO {
	private int mb_seq;
	private String mb_id;  //userid
	private String mb_pw;  //userpw
	private String mb_name;  //userName
	private String mb_nickname;
	private String mb_phone;
	private String mb_gender;
	private String mb_email;
	private String mb_zipcode;
	private String mb_addr;
	private String mb_detailAddr;
	private String mb_notes;//참고사항
	private int mb_point;
	private String mb_grade;
	private int mb_eventNum;//이벤트참여횟수
	private Date mb_joinDate;
	
	private boolean enabled;  //권한 관련 
	private List<AuthVO> authList;

}