package com.ict.erp.service;

import java.sql.SQLException;

import com.ict.erp.vo.MemberInfo;

public interface LoginService {
	public MemberInfo login(MemberInfo mi) throws SQLException;
	

}
