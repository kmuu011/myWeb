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

}
