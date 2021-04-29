package org.zerock.exam01;

public class Truck implements Vehicle {
	@Override
	public void start() { 	System.out.println("트럭이 달린다.");}

	@Override
	public void speedUp() { 	System.out.println("트럭 속도 업.");	}

	@Override
	public void speedDown() {System.out.println("트럭 속도 다운.");	}

	@Override
	public void stop() {System.out.println("트럭 정지.");	}

}
