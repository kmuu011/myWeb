package com.ict.erp.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.dao.TestDAO;
import com.ict.erp.dao.impl.TestDAOImpl;
import com.ict.erp.service.TestService;
import com.ict.erp.vo.TInfo;

public class TestServiceImpl implements TestService{
	
	TestDAO td = new TestDAOImpl();

	@Override
	public List<TInfo> getList(TInfo ti) throws SQLException {
		
		return td.selectList(ti);
	}

	@Override
	public TInfo getTestInfo(int tiNum) throws SQLException {

		return td.selectTestInfo(tiNum);
	}

	@Override
	public int insert(String tiId, String tiName, String tiText) throws SQLException {
		return td.insertTest(tiId, tiName, tiText);
	}

	
}
