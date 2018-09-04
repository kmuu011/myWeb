package com.ict.erp.dao;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.vo.MovieInfo;

public interface MovieDAO extends CommonDAO{
	
	public List<MovieInfo> selectMovieInfo() throws SQLException;
	public int insertMovieInfo(MovieInfo mi) throws SQLException;
	public MovieInfo selectMI(MovieInfo mi) throws Exception, SQLException;
	public int updateMovieInfo(MovieInfo mi) throws SQLException;
	public int deleteMovieInfo(int num) throws SQLException;
	
	

}
