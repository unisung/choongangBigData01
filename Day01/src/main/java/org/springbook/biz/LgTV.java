package org.springbook.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component("tv")
public class LgTV implements TV{
	  
	@Autowired
	@Qualifier("sony")
	private Speaker speaker;

	@Override
	public void powerOn() {
		System.out.println("LgTV 전원온.");
		
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV 전원오프.");
		
	}

	@Override
	public void volumeUp() {
		speaker.volumeUp();
		//System.out.println("LgTV 볼륨업.");
		
	}

	@Override
	public void volumeDown() {
		speaker.volumeDown();
		//System.out.println("LgTV 볼륨다운.");
		
	}

}
