package com.ict.erp.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.MovieDAO;
import com.ict.erp.dao.impl.MovieDAOImpl;
import com.ict.erp.service.MovieService;
import com.ict.erp.vo.MovieInfo;

public class MovieServiceImpl implements MovieService{
	
	MovieDAO md = new MovieDAOImpl();

	@Override
	public List<MovieInfo> getMovieInfo() throws SQLException {
		md.setConnection(DBCon.getCon());
		try {
			
			return md.selectMovieInfo();
		}catch(SQLException e) {
			throw e;
		} finally {
			DBCon.closeCon();
		}
		
		
	}
	

}
