package com.ict.erp.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.common.DBCon;
import com.ict.erp.common.GetFile;
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

	@Override
	public int insertMovieInfo(MovieInfo mi) throws SQLException {
		md.setConnection(DBCon.getCon());
		try {
			return md.insertMovieInfo(mi);
			
		}catch(SQLException e) {
			throw e;
		}
		
	}

	@Override
	public MovieInfo getMI(MovieInfo mi) throws Exception, SQLException{
		md.setConnection(DBCon.getCon());
		
		try {
			
			return md.selectMI(mi);
			
		}catch(SQLException e) {
			throw e;
		}
	}

	@Override
	public int updateMovieInfo(MovieInfo mi) throws SQLException,Exception {
		md.setConnection(DBCon.getCon());
		
		try {
			MovieInfo m = md.selectMI(mi);
			
			return md.updateMovieInfo(mi);
			
		}catch(SQLException e) {
			throw e;
		}
	}

	@Override
	public int deleteMovieInfo(int num) throws SQLException, Exception {
		md.setConnection(DBCon.getCon());
		
		try {
			return md.deleteMovieInfo(num);
		}catch(SQLException e) {
			throw e;
		}
	}
	

}
