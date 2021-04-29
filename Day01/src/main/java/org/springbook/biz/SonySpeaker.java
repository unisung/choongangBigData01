package org.springbook.biz;

import org.springframework.stereotype.Component;

@Component("sony")
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
	@Override
	public String toString() {
		return "SonySpeaker [소니스피커]";
	}

	
}
