package com.ict.erp.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ict.erp.dao.MemberDAO;
import com.ict.erp.vo.MemberInfo;

public class MemberDAOImpl extends CommonDAOImpl implements MemberDAO{

	@Override
	public List<MemberInfo> selectMiList(MemberInfo mi) throws SQLException {
		String sql = "select mi.*, di.diname, li.liname FROM "
				+"MEMBER_INFO mi, DEPART_INFO di, LEVEL_INFO LI "
				+"where mi.dicode = di.DICODE "
				+"and mi.lilevel = li.lilevel";
		List<MemberInfo> miList = new ArrayList<MemberInfo>();
		
		try {
		
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				MemberInfo mmi = new MemberInfo();
				mmi.setMiNum(rs.getLong("minum"));
				mmi.setDiCode(rs.getString("diCode"));
				mmi.setMiName(rs.getString("miname"));
				mmi.setLiLevel(rs.getLong("liLevel"));
				mmi.setMiAddress1(rs.getString("miaddress1"));
				mmi.setMiAddress2(rs.getString("miaddress2"));
				mmi.setMiDesc(rs.getString("midesc"));
				mmi.setMiEmail(rs.getString("miemail"));
				mmi.setMiId(rs.getString("miid"));
				mmi.setMiPhone(rs.getString("miphone"));
				mmi.setMiZipcode(rs.getString("mizipcode"));
				mmi.setDiName(rs.getString("diname"));
				mmi.setLiName(rs.getString("liname"));
				miList.add(mmi);
				
			}
			
			return miList;
			
		} catch(SQLException e) {
			throw e;
		} finally {
			close();
		}
		
	}
	


	@Override
	public MemberInfo selectMi(MemberInfo mi) throws SQLException {
		String sql = "select * from member_info where minum=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, mi.getMiNum());
			
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				mi.setMiId(rs.getString("miid"));
				mi.setMiName(rs.getString("miname"));
				mi.setMiPwd(rs.getString("mipwd"));
				mi.setDiCode(rs.getString("diCode"));
				mi.setLiLevel(rs.getLong("liLevel"));
				mi.setMiEmail(rs.getString("miemail"));
				mi.setMiDesc(rs.getString("midesc"));
				mi.setMiPhone(rs.getString("miphone"));
				mi.setMiZipcode(rs.getString("mizipcode"));
				mi.setMiAddress1(rs.getString("miaddress1"));
				mi.setMiAddress2(rs.getString("miaddress2"));
			}
			
			return mi;
		}catch(SQLException e) {
			throw e;
			
		}finally {
			close();
		}
		
	}

	@Override
	public int insertMi(MemberInfo mi) throws SQLException {
		String sql = "insert into member_info values(seq_minum.nextval,"
				+ " ?, ?, ?, ?, ?, ?,"
				+ " ?, ?, ?, ?, ?)";
		
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mi.getMiId());
			ps.setString(2, mi.getMiName());
			ps.setString(3, mi.getMiPwd());
			ps.setString(4, mi.getDiCode());
			ps.setLong(5, mi.getLiLevel());
			ps.setString(6, mi.getMiEmail());
			ps.setString(7,mi.getMiDesc());
			ps.setString(8, mi.getMiPhone());
			ps.setString(9, mi.getMiZipcode());
			ps.setString(10, mi.getMiAddress1());
			ps.setString(11, mi.getMiAddress2());
			
			return ps.executeUpdate();
			
		}catch(SQLException e) {
			throw e;
		} finally {
			close();
		}
	}

	@Override
	public int deleteMi(MemberInfo mi) throws SQLException {
		
		return 0;
	}

	@Override
	public int updateMi(MemberInfo mi) throws SQLException {
		String sql = "update member_info set "
				+ "miid=?, miname=?, mipwd=?, dicode=?,"
				+ "lilevel=?, miemail=?, midesc=?, miphone=?, "
				+ "mizipcode=?, miaddress1=?, miaddress2=?"
				+ " where minum=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mi.getMiId());
			ps.setString(2, mi.getMiName());
			ps.setString(3, mi.getMiPwd());
			ps.setString(4, mi.getDiCode());
			ps.setLong(5, mi.getLiLevel());
			ps.setString(6, mi.getMiEmail());
			ps.setString(7, mi.getMiDesc());
			ps.setString(8, mi.getMiPhone());
			ps.setString(9, mi.getMiZipcode());
			ps.setString(10, mi.getMiAddress1());
			ps.setString(11, mi.getMiAddress2());
			ps.setLong(12, mi.getMiNum());
			
			return ps.executeUpdate();
			
			
		}catch(SQLException e) {
			throw e;
		}finally {
			close();
		}

	}



	@Override
	public Map<String, Object> getSelect() throws SQLException {
		String sql = "select diname, dicode from depart_info";
		Map<String,Object> getSelect = new HashMap<String,Object>();
		List<MemberInfo> miD = new ArrayList<MemberInfo>();
		List<MemberInfo> miL = new ArrayList<MemberInfo>();
		MemberInfo mi = null;
		
		
		
		try {
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				mi = new MemberInfo();
				mi.setDiName(rs.getString("diname"));
				mi.setDiCode(rs.getString("dicode"));
				miD.add(mi);
			}
			
			
			sql = "select liname, lilevel from level_info";
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				mi = new MemberInfo();
				mi.setLiName(rs.getString("liname"));
				mi.setLiLevel(rs.getLong("lilevel"));
				miL.add(mi);
			}
			
			getSelect.put("miD", miD);
			getSelect.put("miL", miL);
			
			return getSelect;
			
		}catch(SQLException e) {
			throw e;
		}finally {
			close();
		}

	}

}
