package org.zerock.polymorphism;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser4 {
 public static void main(String[] args) {
	  /* 객체간의 결합도 낮추기 */
	 //SamsungTV tv = new SamsungTV();
	//LgTV tv = new LgTV();
	// TV tv = new SamsungTV();//promotion
	 //TV tv = new LgTV();//promotion
	 
	 // Inverson of Control
	  AbstractApplicationContext factory = 
			      new GenericXmlApplicationContext("applicationContext.xml");
	
	  //dependency injection	
	 TV tv = (TV)factory.getBean("tv"); /// id가 tv인 bean객체를 리턴.
	 
		tv.powerOn();
		
		tv.volumeUp();
		tv.volumeDown();
		
		tv.powerOff();
	 }

}
