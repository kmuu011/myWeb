package com.ict.erp.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ict.erp.vo.DepartInfo;

public interface DepartDAO extends CommonDAO{
	public List<DepartInfo> selectDepartInfoList(DepartInfo di) throws SQLException;
	public List<DepartInfo> selectDepartInfoSearch(String sch, String op) throws SQLException;
	public DepartInfo select(int diNum) throws SQLException;
	public int insertDepartInfo(DepartInfo di) throws SQLException;
	public int updateDepartInfo(DepartInfo di) throws SQLException;
	public int deleteDepartInfo(List<Integer> diNums) throws SQLException;
	
}
