package com.ict.erp.common;

import java.lang.reflect.Method;

import com.ict.erp.vo.MemberInfo;


public class tt<T> {
	
	
	public static <T> T ppp(){
		Class c = MemberInfo.class;
		Method[] methods = c.getMethods();
		T obj = null;
		
		
		return null;
	}
	
	
	public static void main(String[] args) {
		Class c = MemberInfo.class;
		Method[] methods = c.getMethods();
		
		for(Method m : methods) {
			System.out.println(m.getName().toUpperCase().indexOf("SET"));
		}
	}
	
	
	
	

}
