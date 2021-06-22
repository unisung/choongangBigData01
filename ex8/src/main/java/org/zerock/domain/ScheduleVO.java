package org.zerock.domain;

import lombok.Data;

@Data
public class ScheduleVO {
	private int seq;
	private String startTime;
	private String endTime;
	private String title;
	private String content;
}