package com.ict.erp;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;


	

public class Test {
	
	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", "콩진호");
		map.put("age", "22");
		map.put("hobby", "스타,준우승");
		
		Person p = new Person();
		
		try {
			
			BeanUtils.populate(p, map);
			System.out.println(p);
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
