package com.ict.erp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.erp.service.MusicService;
import com.ict.erp.service.impl.MusicServiceImpl;
import com.ict.erp.utils.Utils;
import com.ict.erp.vo.MusicInfo;


@WebServlet(
		urlPatterns = "/music/*",
		name = "MusicServlet",
		loadOnStartup = 1
		)
public class MusicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String uri;
	
	MusicService ms = new MusicServiceImpl();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		uri = request.getRequestURI();
		String cmd = Utils.getCmd(uri);
		System.out.println(cmd);
		try {
			if(cmd.equals("musicList")) {
				request.setAttribute("music", ms.getMusicInfo());
			}else if(cmd.equals("mLike")) {
				MusicInfo msi = new MusicInfo();
				String mcNum = request.getParameter("mcNum");
				String mcLike = request.getParameter("mcLike");
				
				msi.setMcNum(Integer.parseInt(mcNum));
				msi.setMcLike(Integer.parseInt(mcLike));
				
				
				
				
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println(cmd);
		
		doService(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	public void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		uri = "/views" + uri;
		RequestDispatcher rd = req.getRequestDispatcher(uri);
		rd.forward(req, res);
		
	}

}
