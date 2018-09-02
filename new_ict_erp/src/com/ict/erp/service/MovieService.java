package com.ict.erp.service;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.vo.MovieInfo;

public interface MovieService {
	public List<MovieInfo> getMovieInfo() throws SQLException;

	

}
