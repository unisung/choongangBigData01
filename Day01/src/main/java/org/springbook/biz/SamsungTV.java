package org.springbook.biz;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

@Component("tv")
public class SamsungTV implements TV{
	  
	//@Inject
	@Resource(name="apple")
	private Speaker speaker;

	@Override
	public void powerOn() {
		System.out.println("SamsungTV 전원온.");
		
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV 전원오프.");
		
	}

	@Override
	public void volumeUp() {
		speaker.volumeUp();
		//System.out.println("SamsungTV 볼륨업.");
		
	}

	@Override
	public void volumeDown() {
		speaker.volumeDown();
		//System.out.println("SamsungTV 볼륨다운.");
		
	}

}
