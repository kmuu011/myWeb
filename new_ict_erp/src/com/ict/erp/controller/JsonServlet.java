package com.ict.erp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ict.erp.service.MovieService;
import com.ict.erp.service.impl.MovieServiceImpl;
import com.ict.erp.vo.MovieInfo;


@WebServlet(
		urlPatterns = "/json/*"
		)
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Gson gs = new Gson();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		Map<String,String> pMap = gs.fromJson(request.getParameter("param"), Map.class);
		System.out.println(pMap);
		PrintWriter pw = response.getWriter();
		MovieService ms = new MovieServiceImpl();
		
		try {
			List<MovieInfo> mi = ms.getMovieInfo();
			String resStr = gs.toJson(mi);
			pw.println(resStr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		Map<String,String> pMap = gs.fromJson(request.getParameter("param"), Map.class);
		
		PrintWriter pw = response.getWriter();
		MovieService ms = new MovieServiceImpl();
		
		List<MovieInfo> mi;
		try {
			mi = ms.getMovieInfo();
			String resStr = gs.toJson(mi);
			pw.println(resStr);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public static void main(String[] args) {
		String jsonStr = "{\"a\":\"1\"}";
		Map<String,String> map = gs.fromJson(jsonStr, Map.class);		
		
		System.out.println(map);
		
		System.out.println(jsonStr);
	}
	
	
}
