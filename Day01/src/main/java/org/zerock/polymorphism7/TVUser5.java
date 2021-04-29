package org.zerock.polymorphism7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser5 {
 public static void main(String[] args) {
	  /* 객체간의 결합도 낮추기 */
	 // Inverson of Control
	  AbstractApplicationContext factory = 
			      new GenericXmlApplicationContext("applicationContext8.xml");
	
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
	System.out.println(tv);// to.toString() <--- 객체 참조변수가 print()의 매개변수로 넘어가면 toString()자동호출
		
	 }

}
