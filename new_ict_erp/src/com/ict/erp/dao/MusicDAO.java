package com.ict.erp.dao;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.vo.MusicInfo;

public interface MusicDAO extends CommonDAO{
	
	public List<MusicInfo> selectMusicInfo() throws SQLException;
	
	public MusicInfo selectInfo(MusicInfo msi) throws SQLException;
	
	public int insertMusicInfo(MusicInfo msi) throws SQLException;

	public int deleteMusicInfo(MusicInfo msi) throws SQLException;
	
	public int updateMusicInfo(MusicInfo msi) throws SQLException;
}
