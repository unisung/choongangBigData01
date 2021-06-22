package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.CalendarVO;
import org.zerock.domain.ScheduleListVO;
import org.zerock.domain.ScheduleVO;

public interface CalendarMapper {
	
	//@Select("select * from tbl_board where bno > 0")
	public List<CalendarVO> getList(CalendarVO calendar);
	
	
	public void insertSelectKey(CalendarVO calendar);

	public List<ScheduleListVO> getScheduleList(CalendarVO calendar);

	public ScheduleVO getSchedule(CalendarVO calendar);

	public ScheduleVO getScheduleByDate(CalendarVO calendar);

	public void modify(CalendarVO calendar);

	public int remove(CalendarVO calendar);
}