package com.ict.erp.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.DAOpr;
import com.ict.erp.dao.impl.DAOprImpl;
import com.ict.erp.service.Servicepr;
import com.ict.erp.vo.PList;

public class ServiceprImpl implements Servicepr{
	
	private DAOpr dp = new DAOprImpl();

	@Override
	public void getList(HttpServletRequest request) throws SQLException {
		try {
		List<PList> pList =  dp.selectP(DBCon.getCon());
		request.setAttribute("pList", pList);
		
		}catch(SQLException e) {
			throw e;
		} finally {
			DBCon.closeCon();
		}
	}

	@Override
	public int getInsert(String name, String txt) throws SQLException {
		try {
			int result = dp.insert(DBCon.getCon(), name, txt);
			
			
			
			return result;
			
		}catch(SQLException e) {
			throw e;
		} finally {
			DBCon.closeCon();
		}
		
		
	}
	
	

}
