package org.zerock.temp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetAndList {
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("홍길동","일지매","임꺽정","홍길동");
		
		for(String name:list)
			System.out.println(name);
		
		System.out.println("----------");
		
		Set<String> setList = new HashSet<String>();
		
		setList.add("홍길동");
		setList.add("일지매");
		setList.add("임꺽정");
		setList.add("홍길동");
		
		for(String name:setList)
			System.out.println(name);
		
		
		

	}

}
