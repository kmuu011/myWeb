package com.ict.erp.service;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.vo.MusicInfo;

public interface MusicService {
	
	public List<MusicInfo> getMusicInfo() throws SQLException; 
	
	public MusicInfo doLike(MusicInfo msi) throws SQLException;

}
