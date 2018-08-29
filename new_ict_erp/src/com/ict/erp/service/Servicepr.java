package com.ict.erp.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ict.erp.vo.PList;


public interface Servicepr {
	
	public void getList(HttpServletRequest request) throws SQLException;
	
	public int getInsert(String name, String txt) throws SQLException;

}
