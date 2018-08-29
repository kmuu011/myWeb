package com.ict.erp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ict.erp.dao.DAOpr;
import com.ict.erp.vo.PList;

public class DAOprImpl implements DAOpr{
	

	public List<PList> selectP(Connection con) throws SQLException{
		List<PList> pList = null;
		String sql = "select pno,pname,phit from pr_list order by pno";		
		
		try {
		pList = new ArrayList<PList>();
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			PList pl = new PList();
			pl.setPno(rs.getInt("pno"));
			pl.setPname(rs.getString("pname"));
			pl.setPhit(rs.getInt("phit"));
			
			pList.add(pl);
		}
		return pList;
		
		}catch(SQLException e) {
			throw e;
		}
	}
	
	public int insert(Connection con, String name, String txt) throws SQLException{
		int result = 0;
		
		String sql = "insert into pr_list values(pr_seq.nextval, ?, ?, 0)";
		
		try {
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, txt);
		
		result = ps.executeUpdate();
		
		con.commit();
		
		return result;
		}catch (SQLException e) {
			con.rollback();
			throw e;
		}
		
	}
	
	

}
