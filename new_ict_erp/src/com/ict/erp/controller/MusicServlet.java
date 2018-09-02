package com.ict.erp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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
	private Log log = LogFactory.getLog(this.getClass());

	String uri;
	
	MusicService ms = new MusicServiceImpl();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		uri = request.getRequestURI();
		String cmd = Utils.getCmd(uri);
		System.out.println(cmd);
		
		try {
			if(cmd.equals("musicList")) {
				request.setAttribute("music", ms.getMusicInfo());
			}else if(cmd.equals("musicView")) {
				
				MusicInfo msi = new MusicInfo();
				
				int mcNum = Integer.parseInt(request.getParameter("mcNum"));
				
				msi.setMcNum(mcNum);
				request.setAttribute("msi", ms.getInfo(msi));
				System.out.println(msi);
				
				
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println(cmd);
		
		doService(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		uri = request.getRequestURI();
		String cmd = Utils.getCmd(uri);
		request.setCharacterEncoding("UTF-8");
		
		try {
			if(cmd.equals("musicInsert")) {
				MusicInfo msi = new MusicInfo();
				msi.setMcName(request.getParameter("mcName"));
				msi.setMcSinger(request.getParameter("mcSinger"));
				msi.setMcVendor(request.getParameter("mcVendor"));
				msi.setMcCredat(request.getParameter("mcCredat"));
				msi.setMcDesc(request.getParameter("mcDesc"));
				
				System.out.println(msi);
				request.setAttribute("rMap", ms.getInsert(msi));
				
			}else if(cmd.equals("musicDelete")) {
				int mcNum = Integer.parseInt(request.getParameter("mcNum"));
				MusicInfo msi = new MusicInfo();
				
				msi.setMcNum(mcNum);
				
				request.setAttribute("rMap", ms.getDelete(msi));
				
				System.out.println(msi);

				uri = "/music/musicList";
			}else if(cmd.equals("musicModify")) {
				MusicInfo msi = new MusicInfo();
				msi.setMcName(request.getParameter("mcName"));
				msi.setMcSinger(request.getParameter("mcSinger"));
				msi.setMcVendor(request.getParameter("mcVendor"));
				msi.setMcCredat(request.getParameter("mcCredat"));
				msi.setMcDesc(request.getParameter("mcDesc"));
				
				
				
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		doService(request,response);
	}
	
	
	public void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		uri = "/views" + uri;
		RequestDispatcher rd = req.getRequestDispatcher(uri);
		rd.forward(req, res);
		
	}

}
