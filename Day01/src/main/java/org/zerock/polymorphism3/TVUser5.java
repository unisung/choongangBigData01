package org.zerock.polymorphism3;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser5 {
 public static void main(String[] args) {
	  /* 객체간의 결합도 낮추기 */
	 // Inverson of Control
	  AbstractApplicationContext factory = 
			      new GenericXmlApplicationContext("applicationContext4.xml");
	
	   //TV tv = new SamsungTV();
	  //dependency injection	
	 TV tv = (TV)factory.getBean("tv"); /// id가 tv인 bean객체를 리턴.
	 
		tv.powerOn();
		
		tv.volumeUp();
		tv.volumeDown();
		
		tv.powerOff();
		
	System.out.println("----------------------------");	
	TV  tv2 = 	(TV)factory.getBean("tv"); /// id가 tv인 bean객체를 리턴.
	 
		tv2.powerOn();
		
		tv2.volumeUp();
		tv2.volumeDown();
		
		tv2.powerOff();
		
		
	System.out.println(tv==tv2?"동일객체":"다른객체");	
		
	 }

}
