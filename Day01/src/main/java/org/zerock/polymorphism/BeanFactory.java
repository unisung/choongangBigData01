package org.zerock.polymorphism;

public class BeanFactory {
	//Bean이름을 입력받아서 해당 객체를 생성해주는 클래스
	public Object getBean(String beanName) {
		if(beanName.equals("samsung")) {
			return new SamsungTV();
		}else if(beanName.equals("lg")) {
			return new LgTV();
		}
		return null;
	}

}
