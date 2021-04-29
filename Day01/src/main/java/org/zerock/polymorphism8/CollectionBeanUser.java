package org.zerock.polymorphism8;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanUser {

public static void main(String[] args) {
AbstractApplicationContext factory = 
 new GenericXmlApplicationContext("applicationContext9.xml");
		 
		 CollectionBean1 bean 
		    = (CollectionBean1)factory.getBean("collectionBean");
		 
		 
		 List<String> list = bean.getAddressList();
		 
		 for(String l:list) {
			 System.out.println(l);
		 }
		 
		CollectionBean2 bean2
		  =(CollectionBean2)factory.getBean("collectionBean2");
		
		/* set */
		Set<String> addrlist = bean2.getAddressList();
		
		for(String addr:addrlist)
			System.out.println(addr);
		 
      System.out.println("---------------------------");
      
      CollectionBean3 bean3
        = (CollectionBean3)factory.getBean("collectionBean3");
      Map<String,String> addressMap = bean3.getAddressList();
      
      Set<String> names=addressMap.keySet();
      Iterator<String> itor = names.iterator();
      
      while(itor.hasNext()) {
    	  String name=itor.next();
    	  String address=addressMap.get(name);
    	  System.out.println(name+":" +address);
      }
      
    System.out.println("================");
    CollectionBean4 bean4
      = (CollectionBean4)factory.getBean("collectionBean4");
      
    Properties addressP=bean4.getAddressList();
    Set<Object> names2=addressP.keySet();
    Iterator<Object> itor2 = names2.iterator();
    while(itor2.hasNext()) {
    	String name =(String)itor2.next();
    	String addr = addressP.getProperty(name);
    	System.out.println(name+":"+addr);
    }
    
	}

}
