package com.ict.erp.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ict.erp.common.DBCon;
import com.ict.erp.common.TBean;
import com.ict.erp.dao.DepartDAO;
import com.ict.erp.vo.DepartInfo;

public class DepartDAOImpl extends CommonDAOImpl implements DepartDAO {

	@Override
	public List<DepartInfo> selectDepartInfoList(DepartInfo di) throws SQLException {
		List<DepartInfo> dList = null;
		ps = null;
		rs = null;
		
		String sql = "select * from("
			+ "select di.*,rownum as rNum from("
			+ "select * from depart_info"
			+ " order by dinum desc) di "
			+ " where rownum<=?) "
			+ " where rNum>=? ";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, di.getPi().getlNum());
			ps.setInt(2, di.getPi().getsNum());
			
			rs = ps.executeQuery();
			
			dList = TBean.convertRS(rs, DepartInfo.class);
		System.out.println(dList);
		} catch(SQLException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				close();
				
			} catch (Exception e) {
				System.out.println("클로즈영역 문제 발생");
				System.out.println(e.getMessage());
			}
		}
		return dList;
	}
	
	@Override
	public DepartInfo select(int diNum) throws SQLException {
		DepartInfo di = null;
		String sql = "select * from depart_info where dinum=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, diNum);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				di = new DepartInfo(rs.getInt("dinum"), rs.getString("diCode"), rs.getString("diName"), rs.getString("diDesc"));
			}
			
		}catch(SQLException e) {
			throw e;
		}finally {
			close();
		}
		
		return di;
	}

	@Override
	public int insertDepartInfo(DepartInfo di) throws SQLException {
		try {
			String sql = "insert into depart_info values(seq_dinum.nextval,?,?,?)";
			
			 ps = con.prepareStatement(sql);
			
			ps.setString(1, di.getDiCode());
			ps.setString(2, di.getDiName());
			ps.setString(3, di.getDiDesc());
			return ps.executeUpdate();
			
		}catch (SQLException e) {
			throw e;
			
		} finally {
			close();
		}
	}

	@Override
	public int updateDepartInfo(DepartInfo di) throws SQLException {
		int result = 0;
		String sql = "update depart_info set dicode=?, diname=?, didesc=? where dinum=?";
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setString(1, di.getDiCode());
			ps.setString(2, di.getDiName());
			ps.setString(3, di.getDiDesc());
			ps.setInt(4, di.getDiNum());
			
			result = ps.executeUpdate();
			
		}catch(SQLException e) {
			throw e;
		}finally {
			close();
		}
		
		return result;
	}

	@Override
	public int deleteDepartInfo(List<Integer> diNums) throws SQLException {
		int result = 0;
		try {
			String sql = "delete from depart_info where dinum=?";
			
			ps = con.prepareStatement(sql);
			
			for(int num:diNums) {
				ps.setInt(1, num);
				result += ps.executeUpdate();
			}
			
		}catch(SQLException e) {
			throw e;
		}finally {
			close();
		}
		
		return result;
	}

	@Override
	public List<DepartInfo> selectDepartInfoSearch(String sch, String op) throws SQLException {
		List<DepartInfo> dList = null;
		
		try {
		con = DBCon.getCon();
		
		String sql = "select dinum, dicode, diname, didesc from depart_info ";
		
		if(op.equals("diNum")) {
			sql += "where dinum like '%' || ? || '%' order by dinum";
		} else if(op.equals("diCode")) {
			sql += "where dicode like '%' || ? || '%' order by dinum";
		} else if(op.equals("diName")) {
			sql += "where diname like '%' || ? || '%' order by dinum";
		} else if(op.equals("diDesc")) {
			sql += "where didesc like '%' || ? || '%' order by dinum";
		}
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		if(op.equals("diNum")) {
			ps.setInt(1, Integer.parseInt(sch));
		} else if(op.equals("diCode")) {
			ps.setString(1, sch);
		} else if(op.equals("diName")) {
			ps.setString(1, sch);
		} else if(op.equals("diDesc")) {
			ps.setString(1, sch);
		}
		
		ResultSet rs = ps.executeQuery();
		
		dList = new ArrayList<DepartInfo>();
		
		while(rs.next()) {
			DepartInfo di = new DepartInfo(rs.getInt("dinum"),rs.getString("dicode"),rs.getString("diname"),rs.getString("didesc"));
			dList.add(di);
		}
		
		} catch(SQLException e) {
			throw e;
		} finally {
			DBCon.closeCon();
		}
		
		return dList;
	}



	
}
