package org.springbook.biz;

import org.springframework.stereotype.Component;

@Component("apple")
public class AppleSpeaker extends Object implements Speaker {
	public AppleSpeaker() {
		System.out.println("====> AppleSpeaker 객체 생성");
	}
	@Override
	public void volumeUp() {
		System.out.println("====> AppleSpeaker 소리높임");
	}
	@Override
	public void volumeDown() {
		System.out.println("====>AppleSpeaker 소리 줄임");
	}
	@Override
	public String toString() {
		return "AppleSpeaker [애플스피커]";
	}
	
	
}
