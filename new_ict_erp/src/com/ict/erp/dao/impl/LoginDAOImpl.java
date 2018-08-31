package com.ict.erp.dao.impl;

import java.sql.SQLException;

import com.ict.erp.dao.LoginDAO;
import com.ict.erp.vo.MemberInfo;

public class LoginDAOImpl extends CommonDAOImpl implements LoginDAO{

	@Override
	public int login(MemberInfo mi) throws SQLException {
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
				sql = "select minum, miname, dicode, lilevel from member_Info where miid=?";
				ps = con.prepareStatement(sql);
				ps.setString(1, mi.getMiId());
				rs = ps.executeQuery();
				
				while(rs.next()) {
					mi.setMiNum(rs.getLong("minum"));
					mi.setMiName(rs.getString("miname"));
					mi.setDiCode(rs.getString("dicode"));
					mi.setLiLevel(rs.getLong("lilevel"));					
				}
				return result;
				
			}else if(result == 0) {
				return result;
			}
			
			
			
			return result;
			
		}catch(SQLException e) {
			throw e;
		} finally {
			close();
		}
		
	}

}
