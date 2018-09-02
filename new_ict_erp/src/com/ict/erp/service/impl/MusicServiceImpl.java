package com.ict.erp.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.MusicDAO;
import com.ict.erp.dao.impl.MusicDAOImpl;
import com.ict.erp.service.MusicService;
import com.ict.erp.vo.MusicInfo;

public class MusicServiceImpl implements MusicService{
	
	private MusicDAO md = new MusicDAOImpl();

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

	@Override
	public Map<String, Object> getInsert(MusicInfo msi) throws SQLException {
		md.setConnection(DBCon.getCon());
		Map<String,Object> rMap = new HashMap<String,Object>();
		
		try {
			int result = md.insertMusicInfo(msi);
			
			rMap.put("msg", "등록 실패!");
			
			if(result ==1) {
				rMap.put("msg", "등록 성공!");
			}
			
			return rMap;
		}catch(SQLException e) {
			throw e;
		} finally {
			DBCon.closeCon();
		}
		
	}

	@Override
	public MusicInfo getInfo(MusicInfo msi) throws SQLException {
		md.setConnection(DBCon.getCon());
		
		try {
			return md.selectInfo(msi);
			
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.closeCon();
		}
		
	}
	
	@Override
	public Map<String, Object> getDelete(MusicInfo msi) throws SQLException {
		md.setConnection(DBCon.getCon());
		Map<String,Object> rMap = new HashMap<String,Object>();

		try {
			
			int result = md.deleteMusicInfo(msi);
			
			rMap.put("msg", "삭제 실패!");
			
			if(result ==1) {
				rMap.put("msg", "삭제 성공!");
			}
			
			return rMap;
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.closeCon();
		}
		
	}

	@Override
	public Map<String, Object> getUpdate(MusicInfo msi) throws SQLException {
		md.setConnection(DBCon.getCon());
		Map<String,Object> rMap = new HashMap<String,Object>();
		
		try {
			int result = md.updateMusicInfo(msi);
			
			rMap.put("msg", "수정 실패!");
			
			if(result ==1) {
				rMap.put("msg", "수정 성공!");
			}
			
			return rMap;
			
		}catch (SQLException e) {
			throw e;
		}finally {
			DBCon.closeCon();
		}
				
	}

}
