package com.ict.erp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;

public class Test {
	
	private Map<String,HttpServlet> sContainer;
	
	Test(){
		sContainer = new HashMap<String,HttpServlet>();
	}

	
	public void init(String url) {
			sContainer.put(url, new LevelServlet());
		
	}
	
	
	public HttpServlet getContainer(String url) {
		if(sContainer.containsKey(url)) {
			init(url);
		}
		return sContainer.get(url);
	}
	
	public static void main(String[] args) {
		String url = "level";
		Test t = new Test();
		t.getContainer(url);
		
	}
	
}
