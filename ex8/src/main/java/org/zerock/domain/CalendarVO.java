package org.zerock.domain;

import lombok.Data;

@Data
public class CalendarVO {
	private String id;
	private String y;
	private String m;
	private String d;
	private int seq;
	private String startTime;
	private String endTime;
	private String title;
	private String content;
	

}