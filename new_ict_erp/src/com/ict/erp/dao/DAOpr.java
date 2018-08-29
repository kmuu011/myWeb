package com.ict.erp.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ict.erp.vo.PList;

public interface DAOpr {
	public List<PList> selectP(Connection con) throws SQLException;
	
	public int insert(Connection con, String name, String txt) throws SQLException;
	

}
