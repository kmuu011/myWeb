package com.ict.erp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.erp.service.TestService;
import com.ict.erp.service.impl.TestServiceImpl;
import com.ict.erp.utils.Utils;
import com.ict.erp.vo.TInfo;


public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	TestService ts = new TestServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = Utils.getCmd(uri);
		System.out.println(uri);
		
		try {
		if(cmd==null || cmd.equals("")) {
			uri = "/views/notfound";
		}else if(cmd.equals("tList")){
			String shType = request.getParameter("shType");
			String shText = request.getParameter("shText");
			
			TInfo ti = null;
			
			if(shText != null) {
				ti = new TInfo();
				
				if(shType.equals("tiNum")) {
					ti.setTiNum(Integer.parseInt(shText));
				}else if(shType.equals("tiName")) {
					ti.setTiName(shText);
				}else if(shType.equals("tiId")) {
					ti.setTiId(shText);
				}else if(shType.equals("tiText")) {
					ti.setTiText(shText);
				}
			}
			
			request.setAttribute("tList", ts.getList(ti));
			
		} else if(cmd.equals("view")) {
			int tiNum = Integer.parseInt(request.getParameter("tiNum"));
			request.setAttribute("tInfo", ts.getTestInfo(tiNum));
		} else if(cmd.equals("insert")) {
			
		} else if(cmd.equals("insertOK")) {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String text = request.getParameter("txt");
			int result = ts.insert(id, name, text);
			String msg = null;
			System.out.println(result);
			
			if(result == 1) {
				uri = "/test/insert";
				msg = "중복된 아이디입니다.";
				request.setAttribute("msg", msg);
				
			} else if(result == 0) {
				msg = "정보 입력 성공!";
				request.setAttribute("msg", msg);
				
			}
			
			
		}
		
		} catch(Exception e) {
			uri = "/error";
			request.setAttribute("error", e.getMessage());
		}
		
		uri = "/views" + uri;
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
