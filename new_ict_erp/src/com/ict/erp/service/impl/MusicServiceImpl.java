package com.ict.erp.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.MusicDAO;
import com.ict.erp.dao.impl.MusicDAOImpl;
import com.ict.erp.service.MusicService;
import com.ict.erp.vo.MusicInfo;

public class MusicServiceImpl implements MusicService{
	
	MusicDAO md = new MusicDAOImpl();

	@Override
	public List<MusicInfo> getMusicInfo() throws SQLException {
		md.setConnection(DBCon.getCon());
		
		try {
			
			return md.selectMusicInfo();
			
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.closeCon();
		}
		
		
	}

	@Override
	public MusicInfo doLike(MusicInfo msi) throws SQLException {
		
		return null;
	}

}
