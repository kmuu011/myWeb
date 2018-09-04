package com.ict.erp.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.BeanProcessor;

import com.ict.erp.common.TBean;
import com.ict.erp.dao.MovieDAO;
import com.ict.erp.vo.MovieInfo;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BEncoderStream;

public class MovieDAOImpl extends CommonDAOImpl implements MovieDAO{

	@Override
	public List<MovieInfo> selectMovieInfo() throws SQLException {
		String sql = "select * from ticket_movie order by tmnum";
		List<MovieInfo> miL = new ArrayList<MovieInfo>();
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				MovieInfo mi = new MovieInfo();
				mi.setTmNum(rs.getInt("tmnum"));
				mi.setTmName(rs.getString("tmname"));
				mi.setTmPrice(rs.getLong("tmprice"));
				mi.setTmStartDat(rs.getString("tmstartdat"));
				mi.setTmEndDat(rs.getString("tmenddat"));
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

	@Override
	public int insertMovieInfo(MovieInfo mi) throws SQLException {
		String sql = "insert into ticket_movie(tmnum, tmname, tmprice,"
				+ "tmstartdat, tmenddat, tmcredat, tmdesc, tmimg)"
				+ "values(tm_seq.nextval, ?, ?, ?, ?, to_char(SYSDATE, 'yyyymmdd'),? ,?)";
		
		ps = con.prepareStatement(sql);
		ps.setString(1, mi.getTmName());
		ps.setLong(2, mi.getTmPrice());
		ps.setString(3, mi.getTmStartDat().replaceAll("-", ""));
		ps.setString(4, mi.getTmEndDat().replaceAll("-", ""));
		ps.setString(5, mi.getTmDesc());
		ps.setString(6, mi.getTmImg());
		
		return ps.executeUpdate();
	}

	
	@Override
	public MovieInfo selectMI(MovieInfo mi) throws Exception, SQLException {
		String sql = "select * from ticket_movie where tmnum=?";
		
		ps = con.prepareStatement(sql);
		ps.setLong(1, mi.getTmNum());
		
		BeanProcessor bp = new BeanProcessor();
		
		rs = ps.executeQuery();
		
		if(rs.next()) {
			return bp.toBean(rs, MovieInfo.class);
		}
		
		return null;
	}

	@Override
	public int updateMovieInfo(MovieInfo mi) throws SQLException {
		String sql = "update ticket_movie set tmname=?, tmprice=?, tmcredat=to_char(SYSDATE, 'yyyymmdd'), tmstartdat=?, tmenddat=?, tmcnt=?, tmdesc=?, tmimg=?"
				+ "where tmnum=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mi.getTmName());
			ps.setLong(2, mi.getTmPrice());
			ps.setString(3, mi.getTmStartDat());
			ps.setString(4, mi.getTmEndDat());
			ps.setLong(5, mi.getTmCnt());
			ps.setString(6, mi.getTmDesc());
			ps.setString(7, mi.getTmImg());
			ps.setLong(8, mi.getTmNum());
			
			return ps.executeUpdate();
			
		}catch (SQLException e) {
			throw e;
		}
		
	}

	@Override
	public int deleteMovieInfo(int num) throws SQLException {
		String sql = "delete from ticket_movie where tmnum=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, num);
			
			return ps.executeUpdate();
			
		}catch(SQLException e) {
			throw e;
		}
	}

}
