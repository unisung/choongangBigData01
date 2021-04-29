package org.zerock.temp;

//추상메소드가 유일하게 한개만 존재하는 인터페이스 - 함수적 인터페이스
@FunctionalInterface
public interface MyFunctionalInterface {
	void method1();
	//void method2();
	default void mymethod() {}
}
