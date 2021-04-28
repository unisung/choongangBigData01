package org.zerock.polymorphism;

public class TVUser {
 public static void main(String[] args) {
	//SamsungTV tv = new SamsungTV();
	 LgTV tv = new LgTV();
	
	tv.powerOn();
	
	tv.volumeUp();
	tv.volumeDown();
	
	tv.powerOff();
}
}
