package com.ict.erp.dao.impl;

import java.sql.SQLException;

import com.ict.erp.dao.LoginDAO;
import com.ict.erp.vo.MemberInfo;

public class LoginDAOImpl extends CommonDAOImpl implements LoginDAO{

	@Override
	public MemberInfo login(MemberInfo mi) throws SQLException {
		String sql = "select count(1) from member_info where miid=? and mipwd=?";
		int result = 0;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mi.getMiId());
			ps.setString(2, mi.getMiPwd());
			rs = ps.executeQuery();
			rs.next();
			
			result = rs.getInt(1);
			
			if(result == 1) {
				sql = "select minum, miid, miname, dicode, lilevel from member_Info";
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					
				}
				
			}else if(result ==0) {
				return null;
			}
			
			
			
			
			
		}catch(SQLException e) {
			throw e;
		} finally {
			close();
		}
		
		return null;
	}

}
