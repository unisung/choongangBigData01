package org.zerock.polymorphism;

public class TVUser3 {
 public static void main(String[] args) {
	  /* 객체간의 결합도 낮추기 */
	 //SamsungTV tv = new SamsungTV();
	//LgTV tv = new LgTV();
	// TV tv = new SamsungTV();//promotion
	 //TV tv = new LgTV();//promotion
	 
	 if(args.length>0) {
		 BeanFactory factory = new BeanFactory();
		 TV tv =(TV)factory.getBean(args[0]);
		 
		tv.powerOn();
		
		tv.volumeUp();
		tv.volumeDown();
		
		tv.powerOff();
	 }
}
}
