package com.ict.erp.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.LoginDAO;
import com.ict.erp.dao.impl.LoginDAOImpl;
import com.ict.erp.service.LoginService;
import com.ict.erp.vo.MemberInfo;

public class LoginServiceImpl implements LoginService{
	LoginDAO ldao = new LoginDAOImpl();

	@Override
	public Map<String,Object> login(MemberInfo mi) throws SQLException {
		ldao.setConnection(DBCon.getCon());
		Map<String,Object> rMap = new HashMap<String,Object>();
		
		try {
			int result = ldao.login(mi);
			rMap.put("msg", "로그인 실패");
			rMap.put("result", result);
			
			if(result==1) {
				rMap.put("msg", "로그인 성공");
				rMap.put("mi", mi);
				rMap.put("result", result);		
			}
			
			return rMap;
		}catch (SQLException e) {
			throw e;
		}finally {
			DBCon.closeCon();
		}
		
	}

}
