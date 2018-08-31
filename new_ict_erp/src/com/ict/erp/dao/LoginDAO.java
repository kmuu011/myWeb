package com.ict.erp.dao;

import com.ict.erp.vo.MemberInfo;

import java.sql.SQLException;

public interface LoginDAO extends CommonDAO{
	public int login(MemberInfo mi) throws SQLException;

}
