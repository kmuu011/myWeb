package com.ict.erp.service;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.vo.MovieInfo;

public interface MovieService {
	public List<MovieInfo> getMovieInfo() throws SQLException;
	public int insertMovieInfo(MovieInfo mi) throws SQLException;
	public MovieInfo getMI(MovieInfo mi) throws SQLException, Exception;
	public int updateMovieInfo(MovieInfo mi) throws SQLException, Exception;
	public int deleteMovieInfo(int num) throws SQLException, Exception;
	

}
