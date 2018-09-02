package com.ict.erp.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ict.erp.vo.MusicInfo;

public interface MusicService {
	
	public List<MusicInfo> getMusicInfo() throws SQLException; 
	
	public MusicInfo getInfo(MusicInfo msi) throws SQLException;
	
	public MusicInfo doLike(MusicInfo msi) throws SQLException;
	
	public Map<String, Object> getInsert(MusicInfo msi) throws SQLException;
	
	public Map<String, Object> getDelete(MusicInfo msi) throws SQLException;
	
	public Map<String, Object> getUpdate(MusicInfo msi) throws SQLException;

}
