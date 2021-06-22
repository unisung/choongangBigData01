package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.mapper.SampleMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class SampleTxServiceImpl implements SampleTxService {

	 @Setter(onMethod_=@Autowired)
	 private SampleMapper mapper;
	
	@Transactional
	@Override
	public void addData(String value) {
	 log.info("mapper........");
	 
	 mapper.insertCol1(value);
	 mapper.insertCol2(value);
	 
	 log.info("end......");

	}

}
