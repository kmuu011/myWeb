package com.ict.erp.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ict.erp.dao.MusicDAO;
import com.ict.erp.vo.MusicInfo;

public class MusicDAOImpl extends CommonDAOImpl implements MusicDAO{

	@Override
	public List<MusicInfo> selectMusicInfo() throws SQLException {
		String sql = "select * from music_chart";
		List<MusicInfo> musicL = new ArrayList<MusicInfo>(); 
		try {
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				MusicInfo mui = new MusicInfo();
				mui.setMcNum(rs.getInt("mcnum"));
				mui.setMcName(rs.getString("mcname"));
				mui.setMcSinger(rs.getString("mcsinger"));
				mui.setMcVendor(rs.getString("mcvendor"));
				mui.setMcLike(rs.getInt("mclike"));
				mui.setMcDislike(rs.getInt("mcdislike"));
				mui.setMcCredat(rs.getString("mccredat"));
				mui.setMcDesc(rs.getString("mcdesc"));
				musicL.add(mui);
			}
			
			return musicL;
		
		}catch(SQLException e) {
			throw e;
			
		} finally {
			close();
		}
		
	}

	@Override
	public int insertMusicInfo(MusicInfo msi) throws SQLException {
		String sql = "insert into music_chart values(seq_music.nextval, ?, ?, ?, 0, 0, ?, ?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, msi.getMcName());
			ps.setString(2, msi.getMcSinger());
			ps.setString(3, msi.getMcVendor());
			ps.setString(4, msi.getMcCredat());
			ps.setString(5, msi.getMcDesc());
			
			return ps.executeUpdate();
			
		}catch(SQLException e) {
			throw e;
		}finally {
			close();
		}

	}

	@Override
	public MusicInfo selectInfo(MusicInfo msi) throws SQLException {
		String sql = "select * from music_chart where mcnum=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, msi.getMcNum());
			
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				msi.setMcName(rs.getString("mcname"));
				msi.setMcSinger(rs.getString("mcsinger"));
				msi.setMcVendor(rs.getString("mcvendor"));
				msi.setMcLike(rs.getInt("mclike"));
				msi.setMcDislike(rs.getInt("mcdislike"));
				msi.setMcCredat(rs.getString("mccredat"));
				msi.setMcDesc(rs.getString("mcdesc"));
			}
			
			return msi;
		}catch(SQLException e) {
			throw e;
		} finally {
			close();
		}
	}

	@Override
	public int deleteMusicInfo(MusicInfo msi) throws SQLException {
		String sql  = "delete from music_chart where mcnum=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, msi.getMcNum());
			
			return ps.executeUpdate();
			
	
		}catch(SQLException e) {
			throw e;
		} finally {
			close();
		}
	}

	@Override
	public int updateMusicInfo(MusicInfo msi) throws SQLException {
		String sql = "update music_chart where "  
					+ " mcnum=?, mcsinger=?, mcvendor=?,"  
					+ "mccredat=?, mcdesc=? where mcnum=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, msi.getMcName());
			ps.setString(2, msi.getMcSinger());
			ps.setString(3, msi.getMcVendor());
			ps.setString(4, msi.getMcCredat());
			ps.setString(5, msi.getMcDesc());
			ps.setInt(6, msi.getMcNum());
			
			return ps.executeUpdate();
		}catch (SQLException e) {
			throw e;
		}finally {
			close();
		}

	}

}
