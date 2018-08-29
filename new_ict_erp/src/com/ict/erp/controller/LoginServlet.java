package com.ict.erp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.erp.service.LoginService;
import com.ict.erp.service.impl.LoginServiceImpl;
import com.ict.erp.utils.Utils;
import com.ict.erp.vo.MemberInfo;


@WebServlet(
		urlPatterns = "/login/*", 
		name="LoginServlet",
		loadOnStartup=1 //<<프리로딩 : 서버가 켜지자마자 생성해둠 , 레이지로딩 = 호출이될때 생성댐
		)

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	LoginService ls = new LoginServiceImpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = Utils.getCmd(request.getRequestURI());
		

		
		doService(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = Utils.getCmd(request.getRequestURI());
		
		request.setCharacterEncoding("UTF-8");
		try {
		
			if(cmd.equals("login")) {
				String miId = request.getParameter("miId");
				String miPwd = request.getParameter("miPwd");
				
				MemberInfo mi = new MemberInfo();
				
				mi.setMiId(miId);
				mi.setMiPwd(miPwd);
				
				ls.login(mi);
				
			}
		
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		doGet(request, response);
	}
	
	public void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uri = "/views" + req.getRequestURI();
		RequestDispatcher rd = req.getRequestDispatcher(uri);
		rd.forward(req, res);
		
	}

}
