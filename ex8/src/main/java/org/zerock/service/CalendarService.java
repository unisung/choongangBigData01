package org.zerock.service;

import java.util.List;

import org.zerock.domain.CalendarVO;
import org.zerock.domain.ScheduleListVO;
import org.zerock.domain.ScheduleVO;

public interface CalendarService {
	
	
    public boolean remove(CalendarVO calendar);

	public List<CalendarVO> getList(CalendarVO vo);

	public List<ScheduleListVO> getScheduleList(CalendarVO calendar);

	public ScheduleVO getSchedule(CalendarVO calendar);

	public void modify(CalendarVO calendar);

	public void register(CalendarVO calendar);
}
