package com.ict.erp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.erp.common.DBCon;
import com.ict.erp.service.DepartService;
import com.ict.erp.service.impl.DepartServiceImpl;
import com.ict.erp.utils.Utils;
import com.ict.erp.vo.DepartInfo;
import com.ict.erp.vo.PageInfo;


@WebServlet(
		urlPatterns = "/depart/*", 
		name="DepartServlet",
		loadOnStartup=1 //<<프리로딩 : 서버가 켜지자마자 생성해둠 , 레이지로딩 = 호출이될때 생성댐
		)

public class DepartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public DepartServlet() {
		
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String cmd = Utils.getCmd(req.getRequestURI());

		DepartService ds = new DepartServiceImpl();
		
		try {
		
			if(cmd.equals("departList")) {
				String pageStr = req.getParameter("page");
				if(pageStr ==null || pageStr.equals("")) {
					pageStr = "1";
				}
				int page = Integer.parseInt(pageStr);
				PageInfo pi = new PageInfo();
				pi.setPage(page);
				DepartInfo di = new DepartInfo();
				di.setPi(pi);
				
				String sch = req.getParameter("search");
				String op = req.getParameter("op");
				
				if(sch==null || sch.trim().equals("")) {
					System.out.println("내가 실행");
					req.setAttribute("dList", (List<DepartInfo>)ds.getDepartInfoList(di));
					req.setAttribute("page", pi);
				} else {
					req.setAttribute("dList", (List<DepartInfo>)ds.getDepartInfoSearch(sch, op));
				}
				
			} else if(cmd.equals("departInsert")) {

				List<DepartInfo> diL = new ArrayList<DepartInfo>();
				String[] diCode = req.getParameterValues("diCode");
				String[] diName = req.getParameterValues("diName");
				String[] diDesc = req.getParameterValues("diDesc");
				
				for(int i=0 ; i<diCode.length ; i++) {
					DepartInfo di = new DepartInfo(0, diCode[i], diName[i], diDesc[i]);
					diL.add(di);
				}
				
				
			} else if(cmd.equals("departView")){
				int diNum = Integer.parseInt(req.getParameter("diNum"));
				
				req.setAttribute("di", ds.getDepartInfo(diNum));
			} else if(cmd.equals("departDelete")) {
				String[] diNumStr = req.getParameterValues("chk");
				
				List<Integer> diNum = new ArrayList<Integer>();
				
				for(String n:diNumStr) {
					diNum.add(Integer.parseInt(n));
				}
				
				req.setAttribute("rMap", ds.deleteDepartInfo(diNum));
				
			}
			
			}catch(Exception e) {
				e.printStackTrace();
			} finally {
				DBCon.closeCon();
			}
		doService(req,res);
	}
	

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String cmd = Utils.getCmd(req.getRequestURI());
		req.setCharacterEncoding("utf-8");

		DepartService ds = new DepartServiceImpl();
		
		try {
		
			if(cmd.equals("departInsert")) {
				
				String diCode = req.getParameter("diCode");
				String diName = req.getParameter("diName");
				String diDesc = req.getParameter("diDesc");
				
				DepartInfo di = new DepartInfo(0, diCode, diName, diDesc);
				
				req.setAttribute("rMap", ds.insertDepartInfo(di));
				
				ds.insertDepartInfo(di);
				
			} else if (cmd.equals("departUpdate")) {
				int diNum = Integer.parseInt(req.getParameter("diNum"));
				String diCode = req.getParameter("diCode");
				String diName = req.getParameter("diName");
				String diDesc = req.getParameter("diDesc");
				DepartInfo di = new DepartInfo(diNum, diCode, diName, diDesc);
				
				req.setAttribute("rMap", ds.updateDepartInfo(di));
				
			}
			
			
			}catch(Exception e) {
				e.printStackTrace();
			} finally {
				DBCon.closeCon();
			}
		doService(req,res);
	}

	
	public void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uri = "/views" + req.getRequestURI();
		RequestDispatcher rd = req.getRequestDispatcher(uri);
		rd.forward(req, res);
		
	}
}
