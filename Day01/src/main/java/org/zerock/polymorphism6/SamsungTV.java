package org.zerock.polymorphism6;

public class SamsungTV implements TV{
	
	//속성(property)
	private Speaker speaker;
	private int price;
	
	
	public SamsungTV() {}

	//생성자
	public SamsungTV(Speaker speaker) {
		this.speaker = speaker;
	}
	
	public SamsungTV(Speaker speaker, int price) {
		this.speaker = speaker;
		this.price = price;
	}

	//set메소드
	public void setSpeaker(Speaker speaker) {
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

	@Override
	public String toString() {
		return "SamsungTV [speaker=" + speaker + ", price=" + price + "]";
	}
	
	
	
}
