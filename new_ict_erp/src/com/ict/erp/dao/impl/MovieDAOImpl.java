package com.ict.erp.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ict.erp.dao.MovieDAO;
import com.ict.erp.vo.MovieInfo;

public class MovieDAOImpl extends CommonDAOImpl implements MovieDAO{

	@Override
	public List<MovieInfo> selectMovieInfo() throws SQLException {
		String sql = "select * from ticket_movie";
		List<MovieInfo> miL = new ArrayList<MovieInfo>();
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				MovieInfo mi = new MovieInfo();
				mi.setTmNum(rs.getLong("tmnum"));
				mi.setTmName(rs.getString("tmname"));
				mi.setTmPrice(rs.getLong("tmprice"));
				mi.setTmStartdat(rs.getString("tmstartdat"));
				mi.setTmEnddat(rs.getString("tmenddat"));
				mi.setTmCredat(rs.getString("tmcredat"));
				mi.setTmDesc(rs.getString("tmdesc"));
				mi.setTmCnt(rs.getLong("tmcnt"));
				mi.setTmImg(rs.getString("tmimg"));
				miL.add(mi);
			}
			
			return miL;
		} catch(SQLException e) {
			throw e;
		} finally {
			close();
		}
		
	}

}
