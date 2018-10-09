package com.ict.erp.controller;


import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ict.erp.common.GetFile;
import com.ict.erp.common.IBean;
import com.ict.erp.common.TBean;
import com.ict.erp.service.MovieService;
import com.ict.erp.service.impl.MovieServiceImpl;
import com.ict.erp.utils.Utils;
import com.ict.erp.vo.MovieInfo;

@WebServlet(
		urlPatterns = "/movie/*",
		name= "MovieServlet",
		loadOnStartup = 1
		)

public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Log log = LogFactory.getLog(this.getClass());

	private String uri;
	
	private static final int THRESHOLD_SIZE = 1024*1024*5;//5MB
	private static final int UP_TOTAL_SIZE = 1024*1024*100;//100MB
	private static final int UP_FILE_SIZE = 1024*1024*20;//20MB
	
	private static final File TEMP_REPOSITORY = new File(System.getProperty("java.io.tmpdir"));
	
	private static final String UP_PATH = "C:\\jsp_study\\workspace\\gits\\myWeb\\new_ict_erp\\WebContent";
	
	MovieService ms = new MovieServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		uri = request.getRequestURI();
		String cmd = Utils.getCmd(uri);
		
		try {
			
			if(cmd.equals("movieList")) {
				request.setAttribute("miList", ms.getMovieInfo());
			} else if( cmd.equals("movieView")) {
				MovieInfo mi = new MovieInfo();
				mi.setTmNum(Integer.parseInt(request.getParameter("tmNum")));

				request.setAttribute("mi", ms.getMI(mi));
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(cmd);
		
		doService(request,response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		uri = request.getRequestURI();
		String cmd = Utils.getCmd(uri);
		request.setCharacterEncoding("utf-8");
		
		try {
			
			if(cmd.equals("movieInsert")){
				
				MovieInfo mi = IBean.parseRequest(GetFile.gFile(request), MovieInfo.class);
				
				System.out.println(mi);
				
				request.setAttribute("cnt", ms.insertMovieInfo(mi));
				
			}else if(cmd.equals("movieUpdate")) {
				
				MovieInfo mi = IBean.parseRequest(GetFile.gFile(request), MovieInfo.class);
				GetFile.delFile(ms.getMI(mi));
				
				request.setAttribute("cnt", ms.updateMovieInfo(mi));
				
				uri = "/movie/movieList";
			}else if(cmd.equals("movieDelete")){
				MovieInfo mi = IBean.parseRequest(GetFile.gFile(request), MovieInfo.class);
				GetFile.delFile(ms.getMI(mi));
				request.setAttribute("cnt", ms.deleteMovieInfo(mi.getTmNum()));
				
				uri = "/movie/movieList";
			}
			
			
		}catch(Exception e) {
			throw new ServletException(e);
		}
		
		doService(request, response);
		
	}
	
	
	public void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		uri = "/views" + uri;
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}

}
