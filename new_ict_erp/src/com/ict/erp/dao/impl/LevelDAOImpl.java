package com.ict.erp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.LevelDAO;
import com.ict.erp.vo.LevelInfo;

public class LevelDAOImpl implements LevelDAO{
	
	private Connection con = null;
	
	
	@Override
	public void setConnection(Connection con) {
		this.con = con;
	}

	@Override
	public List<LevelInfo> selectLiList(LevelInfo li) throws SQLException {
		con = DBCon.getCon();
		String sql = "select linum, lilevel, liname, lidesc from level_info order by linum";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		List<LevelInfo> liList = new ArrayList<LevelInfo>();
		
		while(rs.next()) {
			li = new LevelInfo(rs.getInt("liNum"),rs.getInt("liLevel"), rs.getString("liName"), rs.getString("liDesc"));
			liList.add(li);
		}
		
		DBCon.closeCon();
		return liList;
	}
	
	@Override
	public int insertLiList(List<LevelInfo> liList) throws SQLException {
		String sql = "insert into level_info(liNum,liLevel, liName, liDesc)";
		sql += "values(seq_liNum.nextval,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		int cnt = 0;
		
		for(LevelInfo li:liList) {
			ps.setInt(1, li.getLiLevel());
			ps.setString(2, li.getLiName());
			ps.setString(3, li.getLiDesc());
			cnt += ps.executeUpdate();
		}
		ps.close();
		return cnt;
	}

	@Override
	public int deleteLiList(int[] liNums) throws SQLException {
		String sql = "delete from level_info where liNum=?";
		PreparedStatement ps = con.prepareStatement(sql);
		int cnt = 0;
		for(int liNum:liNums) {
			ps.setInt(1, liNum);
			cnt += ps.executeUpdate();
		}
		ps.close();
		return cnt;
	}

	@Override
	public int updateLiList(List<LevelInfo> liList) throws SQLException {
		String sql = "update level_info";
		sql += " set liLevel=?,";
		sql += " liName=?,";
		sql += " liDesc=? ";
		sql += " where liNum=?";
		PreparedStatement ps = con.prepareStatement(sql);
		int cnt = 0;
		for(LevelInfo li:liList) {
			ps.setInt(1, li.getLiLevel());
			ps.setString(2, li.getLiName());
			ps.setString(3, li.getLiDesc());
			ps.setInt(4, li.getLiNum());
			cnt += ps.executeUpdate();
		}
		ps.close();
		return cnt;
	}

	@Override
	public List<LevelInfo> selectLi(String sch, String op) throws SQLException {
		
		String sql = "select linum, lilevel, liname, lidesc from level_info ";
		if(op.equals("liNum")) {
			sql += "where liNum like '%' || ? || '%'";
		} else if(op.equals("liLevel")) {
			sql += "where liLevel like '%' || ? || '%'";
		} else if(op.equals("liName")) {
			sql += "where liName like '%' || ? || '%'";
		} else if(op.equals("liDesc")) {
			sql += "where liDesc like '%' || ? || '%'";
		}
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		if(op.equals("liNum")) {
			ps.setInt(1, Integer.parseInt(sch));
		} else if(op.equals("liLevel")) {
			ps.setInt(1, Integer.parseInt(sch));
		} else if(op.equals("liName")) {
			ps.setString(1, sch);
		} else if(op.equals("liDesc")) {
			ps.setString(1, sch);
		}
		
		ResultSet rs = ps.executeQuery();
		List<LevelInfo> sList = new ArrayList<LevelInfo>();

		

		while(rs.next()) {
			LevelInfo li = new LevelInfo(rs.getInt("linum"),rs.getInt("lilevel"), rs.getString("liname"), rs.getString("lidesc"));
			sList.add(li);
		}
		
		return sList;
	}
	


}
