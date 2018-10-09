package com.ict.erp.common;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ict.erp.vo.MovieInfo;

public class GetFile {
	private Log log = LogFactory.getLog(this.getClass());

	private static final int THRESHOLD_SIZE = 1024*1024*5;//5MB
	private static final int UP_TOTAL_SIZE = 1024*1024*100;//100MB
	private static final int UP_FILE_SIZE = 1024*1024*20;//20MB
		
	private static final File TEMP_REPOSITORY = new File(System.getProperty("java.io.tmpdir"));
	
	private static final String UP_PATH = "C:\\jsp_study\\workspace\\gits\\myWeb\\new_ict_erp\\WebContent";
	
	public static Map<String,String> gFile(HttpServletRequest request) throws ServletException, FileUploadException, UnsupportedEncodingException, Exception{
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			throw new ServletException("폼태그 씹에반데;");
		}
		
		DiskFileItemFactory dfif = new DiskFileItemFactory(THRESHOLD_SIZE, TEMP_REPOSITORY);

		ServletFileUpload sfu = new ServletFileUpload(dfif);
		sfu.setHeaderEncoding("utf-8");
		sfu.setSizeMax(UP_TOTAL_SIZE);
		sfu.setFileSizeMax(UP_FILE_SIZE);
		List<FileItem> fList = sfu.parseRequest(request);
		Map<String,String> params = new HashMap<String,String>();
		
		for(FileItem fi:fList) {
			if(fi.isFormField()) {
				params.put(fi.getFieldName(), fi.getString("utf-8"));
			} else {
				String fName = File.separator + "upload" + File.separator + System.currentTimeMillis() + fi.getName().substring(fi.getName().lastIndexOf("."));
				String fPath = UP_PATH + fName;
				
				File sFile = new File(fPath);
				
				fi.write(sFile);
				
				params.put(fi.getFieldName(), fName);
				
			}
			
		}
	
		return params;
	}
	
	public static void delFile(MovieInfo m) {
		String fPath = UP_PATH + m.getTmImg();
		File dFile = new File(fPath);
		if(dFile.exists()) {
			dFile.delete();
			}
		
	}

	


}
