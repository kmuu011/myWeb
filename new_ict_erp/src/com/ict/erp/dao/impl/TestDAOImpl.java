package com.ict.erp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.TestDAO;
import com.ict.erp.vo.TInfo;

public class TestDAOImpl implements TestDAO{

	@Override
	public List<TInfo> selectList(TInfo ti) throws SQLException {
		try {
		Connection con = DBCon.getCon();
		String sql = "select tinum, tiid, tiname, titext from test_info order by tinum";
		
		if(ti !=null) {
			if(ti.getTiNum() != 0) {
				sql +=" where tiNum=?";
			} else if (ti.getTiId() != null) {
				sql += " where tiId like '%' || ? || '%'";
			} else if (ti.getTiName() != null) {
				sql += " where tiname like '%' || ? || '%'";
			} else if (ti.getTiText() != null) {
				sql += " where titext like '%' || ? || '%'";
			}
		}
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		if(ti !=null) {
			if(ti.getTiNum() != 0) {
				ps.setInt(1, ti.getTiNum());
			} else if (ti.getTiId() != null) {
				ps.setString(1, ti.getTiId());
			} else if (ti.getTiName() != null) {
				ps.setString(1, ti.getTiName());
			} else if (ti.getTiText() != null) {
				ps.setString(1, ti.getTiText());
			}
		}
		
		ResultSet rs = ps.executeQuery();
		
		List<TInfo> tiList = new ArrayList<TInfo>();
		
		while(rs.next()) {
			ti = new TInfo(rs.getInt("tinum"), rs.getString("tiid"), rs.getString("tiname"), rs.getString("titext"));
			tiList.add(ti);
		}
		
		return tiList;
	} catch(Exception e) {
		throw e;
	} finally {
		DBCon.closeCon();

	}
		
		
		
	}

	@Override
	public TInfo selectTestInfo(int tiNum) throws SQLException {
		
		try {
			Connection con = DBCon.getCon();
			String sql = "select tinum, tiid, tiname, titext from test_info where tinum=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, tiNum);
			
			ResultSet rs = ps.executeQuery();
			TInfo ti = null;
			
			if(rs.next()) {
			
			ti = new TInfo(rs.getInt("tinum"), rs.getString("tiid"), rs.getString("tiname"), rs.getString("titext"));
			}
			return ti;
		}catch(Exception e) {
			throw e;
		} finally {
			DBCon.closeCon();
		}
	}

	@Override
	public int insertTest(String tiId, String tiName, String tiText) throws SQLException {
		try {
		Connection con = DBCon.getCon();
		String sql = "select count(1) from test_info where tiid=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, tiId);
		
		ResultSet rs = ps.executeQuery();
		rs.next();

		if(rs.getInt(1) == 0) {
			sql = "insert into test_info values(ti_seq.nextval, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, tiId);
			ps.setString(2, tiName);
			ps.setString(3, tiText);
			
			ps.execute();
			
			return 0;
		}
		
		return rs.getInt(1);
		
		
		} catch(Exception e) {
			throw e;
		} finally {
			DBCon.closeCon();
		}
		
	}
	
	public static void main(String[] args) {
		TestDAO td = new TestDAOImpl();
		
		try {
			System.out.println(td.insertTest("SS", "oni", "damn"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
