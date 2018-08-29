package com.ict.erp.service;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.vo.TInfo;

public interface TestService {
	public List<TInfo> getList(TInfo ti) throws SQLException;
	public TInfo getTestInfo(int tiNum) throws SQLException;
	public int insert(String tiId, String tiName, String tiText) throws SQLException;
	

}
