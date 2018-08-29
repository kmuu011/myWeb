package com.ict.erp.dao;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.vo.TInfo;

public interface TestDAO {
	
	public List<TInfo> selectList(TInfo ti) throws SQLException;
	public TInfo selectTestInfo(int tiNum) throws SQLException;
	public int insertTest(String tiId, String tiName, String tiText) throws SQLException;

}
