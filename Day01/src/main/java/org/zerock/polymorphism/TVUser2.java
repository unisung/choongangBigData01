package org.zerock.polymorphism;

public class TVUser2 {
 public static void main(String[] args) {
	  /* 객체간의 결합도 낮추기 */
	 //SamsungTV tv = new SamsungTV();
	//LgTV tv = new LgTV();
	// TV tv = new SamsungTV();//promotion
	 TV tv = new LgTV();//promotion

	tv.powerOn();
	
	tv.volumeUp();
	tv.volumeDown();
	
	tv.powerOff();
}
}
