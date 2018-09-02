package com.ict.erp.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ict.erp.common.DBCon;
import com.ict.erp.common.TBean;
import com.ict.erp.utils.Utils;
import com.ict.erp.vo.BeanInfo;


@WebServlet(
		urlPatterns = "/bean/*",
		name = "BeanServlet",
		loadOnStartup = 1
		)

public class BeanServlet<E> extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Log log = LogFactory.getLog(this.getClass());

	String uri;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		uri = request.getRequestURI();
		String cmd = Utils.getCmd(uri);
		
		if(cmd.equals("beanList")) {
			
			String sql = "select * from bean order by bnum";
			
			Connection con = DBCon.getCon();
			
			try {
				
				PreparedStatement ps = con.prepareStatement(sql);
				
				ResultSet rs = ps.executeQuery();
				
				TBean.convertRS(rs, BeanInfo.class);
				
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		doService(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		uri = request.getRequestURI();
		String cmd = Utils.getCmd(uri);
		request.setCharacterEncoding("utf-8");
		
		try {
			
			if(cmd.equals("beanInsert")) {
				BeanInfo bi = TBean.parseRequest(request, BeanInfo.class);					
					log.debug(bi);
			}
			
		} catch (Exception e) {
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
