package org.zerock.temp;

import java.util.HashMap;
import java.util.Map;

public class TempClass {

	private Map<Integer,String> map 
	  =new HashMap<Integer,String>();
	
	public TempClass() {
		map.put(new Integer("10"),"홍길동");
		map.put(new Integer(10),"홍길동");
		map.put(20, "일지매");//AutoBoxing-기본타입이 Wrapper타입으로 변환
		map.put(20, "임꺽정");
	}
	
	public static void main(String[] args) {
       new TempClass();
	}

}
