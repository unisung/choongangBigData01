package org.springbook.biz;

import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV{

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
		System.out.println("LgTV 볼륨업.");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("LgTV 볼륨다운.");
		
	}

}
