package org.zerock.domain;

import java.util.List;

import lombok.Data;

@Data
public class ScheduleListVO {
	private String id;
	private String y;
	private String m;
	private  String d;
    private List<ScheduleVO> scheduleList;
	

}