package com.ict.erp.dao;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.vo.MovieInfo;

public interface MovieDAO extends CommonDAO{
	
	public List<MovieInfo> selectMovieInfo() throws SQLException;
	

}
