package org.zerock.polymorphism3;

public class LgTV implements TV{

	public void powerOn() {
		System.out.println("LgTV--- 전원켠다.");
	}
	public void powerOff() {
		System.out.println("LgTV--- 전원끈다.");
	}
	public void volumeUp() {
		System.out.println("LgTV--- 소리올린다.");
	}
	public void volumeDown() {
		System.out.println("LgTV--- 소리내린다.");
	}
	
}
