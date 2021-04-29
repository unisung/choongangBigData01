package org.zerock.polymorphism8;

import java.util.List;
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
		 

	}

}
