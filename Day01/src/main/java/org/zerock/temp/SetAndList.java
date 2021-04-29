package org.zerock.temp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
		
		
		Map<Integer,String> map 
		      = new HashMap<Integer, String>();
		
		map.put(new Integer("10"),"홍길동");
		map.put(new Integer(10),"홍길동");
		map.put(20, "일지매");//AutoBoxing-기본타입이 Wrapper타입으로 변환
		map.put(20, "임꺽정");// <- 동일키인 경우 저장시 마지막을 저장된 value가 override됨
		
		Set<Integer> keys = map.keySet();
		Iterator<Integer> itor = keys.iterator();
		while(itor.hasNext()) {
			int no = itor.next();//Auto-Unboxing
			String name = map.get(no);
			System.out.println(no+":" + name);
		}
	}
}
