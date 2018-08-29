package com.ict.erp.utils;

public class Utils {
	private static final String PRE_FIX = "/WEB-INF"; 
	private static final String SUF_FIX = ".jsp";
	
	
	public static String getUrl(String uri) {
		uri = PRE_FIX + uri + SUF_FIX;
		return uri;
	}

	public static String getCmd(String uri) {
		int l = uri.lastIndexOf("/")+1;
		String cmd = uri.substring(l, uri.length());
		return cmd;
	}
}
