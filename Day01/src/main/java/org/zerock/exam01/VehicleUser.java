package org.zerock.exam01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class VehicleUser {
public static void main(String[] args) {
	//spring컨테이너을 이용하여 DI를 구현 하세요.
AbstractApplicationContext factory = 
	new GenericXmlApplicationContext("myApplicationContext.xml");
	
	 Vehicle vehicle = (Vehicle)factory.getBean("vehicle");
	 
	 
	 vehicle.start();
	 vehicle.speedUp();
	 vehicle.speedDown();
	 vehicle.stop();
	 
	 
 }
}
