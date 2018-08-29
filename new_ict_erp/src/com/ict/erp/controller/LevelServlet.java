package com.ict.erp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.erp.service.LevelService;
import com.ict.erp.service.impl.LevelServiceImpl;
import com.ict.erp.utils.Utils;
import com.ict.erp.vo.LevelInfo;


public class LevelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private LevelService ls = new LevelServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rPath = request.getContextPath();
		String uri = request.getRequestURI();
		String cmd = Utils.getCmd(uri);
		uri = uri.replaceFirst(rPath, "");
		
		try {

		if(cmd==null || cmd.equals("")) {
			uri = "/views/notfound";

			
		}else if(cmd.equals("lvlList")) {
			String sch = request.getParameter("search");
			String op = request.getParameter("op");
			
			if(sch == null || sch.equals("")) {
				request.setAttribute("liList", ls.getLiList(null));
				uri= "/views/level/lvlList";
			} else {
				List<LevelInfo> sList = ls.getSearch(sch, op);
				request.setAttribute("liList", sList);
				
				uri = "/views/level/lvlList";
			}
			
		}else if (cmd.equals("saveLevelList")){
			List<LevelInfo> iList = new ArrayList<LevelInfo>();
			String[] liNames = request.getParameterValues("liName");
			String[] liLevels = request.getParameterValues("liLevel");
			String[] liDesces = request.getParameterValues("liDesc");
			
			for(int i=0 ; i<liNames.length ; i++) {
				int level = Integer.parseInt(liLevels[i]);
				LevelInfo li = new LevelInfo(0,level,liNames[i],liDesces[i]);
				iList.add(li);
			}
			
			Map<String,List<LevelInfo>> map = new HashMap<String,List<LevelInfo>>();
			map.put("iList", iList);
			map.put("uList", new ArrayList<LevelInfo>());
			
			Map<String,Object> rMap = ls.insertNUpdateLiList(map);
			request.setAttribute("rMap", rMap);
			uri = "/views/level/lvlList";
			
			
		}else if(cmd.equals("deleteLevelList")){
			String[] liNumStrs = request.getParameterValues("liNum");
			int[] liNums = new int[liNumStrs.length];
			for(int i=0;i<liNumStrs.length;i++) {
				liNums[i] = Integer.parseInt(liNumStrs[i]);
			}
			request.setAttribute("rMap", ls.deleteLiList(liNums));
			uri = "/views/level/lvlList";
			
		}else {
			uri = "/views/notfound";
		}
		
		
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
			uri = "/views/error";
			System.out.println("에러남");
		}
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	public void doService() {
		
	}
}
