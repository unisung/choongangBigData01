package org.zerock.polymorphism6;

public class SonySpeaker implements Speaker {
	public SonySpeaker() {
		System.out.println("====> SonySpeaker 객체 생성");
	}
	@Override
	public void volumeUp() {
		System.out.println("====> SonySpeaker 소리높임");
	}
	@Override
	public void volumeDown() {
		System.out.println("====>SonySpeaker 소리 줄임");
	}

}
