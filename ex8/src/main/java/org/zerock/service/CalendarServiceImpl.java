package org.zerock.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.CalendarVO;
import org.zerock.domain.ScheduleListVO;
import org.zerock.domain.ScheduleVO;
import org.zerock.mapper.CalendarMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class CalendarServiceImpl implements CalendarService {
     @Setter(onMethod_=@Autowired)
	private CalendarMapper mapper; 
	


	@Override
	public List<CalendarVO> getList(CalendarVO vo) {
		log.info("calendarService: " + vo);
		return mapper.getList(vo);
	}

	@Override
	public List<ScheduleListVO> getScheduleList(CalendarVO calendar) {
		return mapper.getScheduleList(calendar);
	}

	@Override
	public ScheduleVO getSchedule(CalendarVO calendar) {
		// TODO Auto-generated method stub
		return mapper.getScheduleByDate(calendar);
	}

	@Override
	public void modify(CalendarVO calendar) {
		mapper.modify(calendar);
		
	}

	@Transactional
	@Override
	public boolean remove(CalendarVO calendar) {
		return mapper.remove(calendar)==1;
	}

	@Override
	public void register(CalendarVO calendar) {
		mapper.insertSelectKey(calendar);
		
	}

}
