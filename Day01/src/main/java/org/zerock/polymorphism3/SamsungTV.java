package org.zerock.polymorphism3;

public class SamsungTV implements TV{
	
	//속성(property)
	private SonySpeaker speaker;
	
	
	public SamsungTV() {}

	//생성자
	public SamsungTV(SonySpeaker speaker) {
		this.speaker = speaker;
	}
	
	//set메소드
	public void setSpeaker(SonySpeaker speaker) {
		this.speaker = speaker;
	}

	public void powerOn() {
		System.out.println("SamsungTV--- 전원켠다.");
	}

	public void powerOff() {
		System.out.println("SamsungTV--- 전원끈다.");
	}
	public void volumeUp() {
		//speaker = new SonySpeaker();
		speaker.volumeUp();
		//System.out.println("SamsungTV--- 소리올린다.");
	}
	public void volumeDown() {
		//speaker = new SonySpeaker();
		speaker.volumeDown();
		//System.out.println("SamsungTV--- 소리내린다.");
	}
	
	
	
}
