package com.ict.erp.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.erp.common.ICTUtils;
import com.ict.erp.service.MemberService;
import com.ict.erp.service.impl.MemberServiceImpl;
import com.ict.erp.utils.Utils;
import com.ict.erp.vo.MemberInfo;



public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberService ms = new MemberServiceImpl();
	
	String uri;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		uri = request.getRequestURI();
		String cmd = Utils.getCmd(uri);
		System.out.println(cmd);
	
		try {
			
			if(cmd.equals("memberList")) {
				request.setAttribute("miList", ms.selectMiList(null));
				
			}else if(cmd.equals("memberInsert")) {
				request.setAttribute("selector", ms.getSelect());
				
			}else if(cmd.equals("memberView")) {
				
				String miNumStr = request.getParameter("miNum");
				MemberInfo mi = new MemberInfo();
				mi.setMiNum(Long.parseLong(miNumStr));
				
				request.setAttribute("selector", ms.getSelect());
				request.setAttribute("mi", ms.selectMi(mi));
						
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		} 

		doService(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		uri = request.getRequestURI();
		String cmd = Utils.getCmd(uri);
		System.out.println(cmd);
		request.setCharacterEncoding("utf-8");
		
		try {
		
		if(cmd.equals("memberInsert")){
			String miName = request.getParameter("miName");
			String miId = request.getParameter("miId");
			String miPwd = request.getParameter("miPwd");
			String miEmail = request.getParameter("miEmail");
			String miDesc = request.getParameter("miDesc");
			String miPhone = request.getParameter("miPhone");
			String miZipcode = request.getParameter("miZipcode");
			String miAddress1 = request.getParameter("miAddress1");
			String miAddress2 = request.getParameter("miAddress2");
			String diCode = request.getParameter("diCode");
			long liLevel = Long.parseLong(request.getParameter("liLevel"));
			MemberInfo mi = new MemberInfo();
			mi.setMiName(miName);
			mi.setMiId(miId);
			mi.setMiPwd(miPwd);
			mi.setMiEmail(miEmail);
			mi.setMiDesc(miDesc);
			mi.setMiPhone(miPhone);
			mi.setMiZipcode(miZipcode);
			mi.setMiAddress1(miAddress1);
			mi.setMiAddress2(miAddress2);
			mi.setDiCode(diCode);
			mi.setLiLevel(liLevel);
//			MemberInfo mi = ICTUtils.parse(request, MemberInfo.class);
			System.out.println(mi);
			request.setAttribute("rMap", ms.insertMi(mi));
			
		} else if(cmd.equals("memberUpdate")) {
			MemberInfo mi = ICTUtils.parse(request, MemberInfo.class);
			System.out.println(mi);
			
			request.setAttribute("rMap", ms.updateMi(mi));
			uri = "/member/memberView";
			
			
		} else if(cmd.equals("memberDelete")) {
			MemberInfo mi = new MemberInfo();
			
			String miNumStr = request.getParameter("miNum");
			
			mi.setMiNum(Long.parseLong(miNumStr));
			
			request.setAttribute("rMap", ms.deleteMi(mi));
			
			uri = "/member/memberView";
			
			
			
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		doService(request, response);
	}
	
	public void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		uri = "/views" + uri;
		RequestDispatcher rd = req.getRequestDispatcher(uri);
		rd.forward(req, res);
		
	}

}
