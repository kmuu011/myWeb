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

import com.ict.erp.common.IBean;
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
		
		try {
			
			if(cmd.equals("movieInsert")){
				
				if(!ServletFileUpload.isMultipartContent(request)) {
					throw new ServletException("폼 인크립트가 파일 업로드에 적합하지 않습니다.");
				}
				
				DiskFileItemFactory dff = new DiskFileItemFactory();
				
				ServletFileUpload sfu = new ServletFileUpload(dff);
				
				sfu.setHeaderEncoding("utf-8");
				sfu.setSizeMax(UP_TOTAL_SIZE);
				sfu.setFileSizeMax(UP_FILE_SIZE);
				
				List<FileItem> fList = sfu.parseRequest(request);
				
				Map<String,String> params = new HashMap<String,String>();
				
				for(FileItem fi:fList) {
					
					if(fi.isFormField()) {
						params.put(fi.getFieldName(), fi.getString("utf-8"));
						
					}else{
						
						File f = new File(fi.getName());
						
						String fName = File.separator + "upload" + File.separator + System.currentTimeMillis() + fi.getName().substring(fi.getName().lastIndexOf("."));
						
						String fPath = UP_PATH + fName;
						
						File sFile = new File(fPath);
						
						fi.write(sFile);
						
						params.put(fi.getFieldName(), fName);
						
					}
					
				}
				
				MovieInfo mi = IBean.parseRequest(params, MovieInfo.class);
				
				log.debug(params);
				log.debug(mi);
				
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
