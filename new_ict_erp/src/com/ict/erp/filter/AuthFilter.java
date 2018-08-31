package com.ict.erp.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ict.erp.utils.Utils;


public class AuthFilter implements Filter {


    public AuthFilter() {
    	
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hsr = (HttpServletRequest)request;
		HttpSession hs = hsr.getSession();
		String uri = hsr.getRequestURI();
		String cmd = Utils.getCmd(uri);
		
		System.out.println(uri);
		
		if(hs.getAttribute("user")==null) {

		}
		
		chain.doFilter(request, response);
	}


	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
