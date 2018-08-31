package com.ict.erp.service;

import java.sql.SQLException;
import java.util.Map;

import com.ict.erp.vo.MemberInfo;

public interface LoginService {
	public Map<String,Object> login(MemberInfo mi) throws SQLException;
	

}
