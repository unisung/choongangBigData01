package org.springbook.biz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser5 {
 public static void main(String[] args) {
	 // Inverson of Control
	  AbstractApplicationContext factory = 
			      new GenericXmlApplicationContext("applicationContext10.xml");
	
	  //dependency injection	
	 TV tv = (TV)factory.getBean("tv"); /// id가 tv인 bean객체를 리턴.
	 
		tv.powerOn();
		
		tv.volumeUp();
		tv.volumeDown();
		
		tv.powerOff();
			
		
	 }

}
