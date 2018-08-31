package com.ict.erp.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.MemberDAO;
import com.ict.erp.dao.impl.MemberDAOImpl;
import com.ict.erp.service.MemberService;
import com.ict.erp.vo.MemberInfo;

public class MemberServiceImpl implements MemberService{
	
	private MemberDAO mdao = new MemberDAOImpl();

	@Override
	public List<MemberInfo> selectMiList(MemberInfo mi) throws SQLException {
		mdao.setConnection(DBCon.getCon());
		
		try {
			return mdao.selectMiList(mi);
			
		}catch(SQLException e) {
			throw e;
		} finally {
			DBCon.closeCon();
		}
	}
	

	@Override
	public MemberInfo selectMi(MemberInfo mi) throws SQLException {
		mdao.setConnection(DBCon.getCon());
		
		try {
			return mdao.selectMi(mi);
			
		}catch(SQLException e) {
			throw e;
			
		}finally {
			DBCon.getCon();
		}
	}

	@Override
	public Map<String, Object> insertMi(MemberInfo mi) throws SQLException {
		mdao.setConnection(DBCon.getCon());
		Map<String, Object> rMap = new HashMap<String, Object>();
		
		try {
			int result = mdao.insertMi(mi);
			rMap.put("msg", "등록에 실패했습니다.");			
		
			if(result == 1) {
				rMap.put("msg", "등록이 성공했습니다.");
			}
			
		}catch(SQLException e) {
			throw e;
		} finally {
			DBCon.closeCon();
		}
		
		return rMap;
	}

	@Override
	public Map<String, Object> deleteMi(MemberInfo mi) throws SQLException {
		mdao.setConnection(DBCon.getCon());
		Map<String, Object> rMap = new HashMap<String, Object>();
		
		try {
			int result = mdao.deleteMi(mi); 
			rMap.put("msg", "삭제 실패");
			
			if(result ==1) {
				rMap.put("msg", "삭제 성공!");
			}
			
		}catch(SQLException e) {
			DBCon.closeCon();
		}
		return rMap;
	}

	@Override
	public Map<String, Object> updateMi(MemberInfo mi) throws SQLException {
		mdao.setConnection(DBCon.getCon());
		Map<String, Object> rMap = new HashMap<String,Object>();

		try {
			int result = mdao.updateMi(mi);
			
			rMap.put("msg", "수정이 실패했습니다.");
			
			if(result ==1) {
				rMap.put("msg", "수정성공!");				
			}
			
			return rMap;
			
		}catch(SQLException e) {
			throw e;
		} finally {
			DBCon.closeCon();
		}
		
	}

	@Override
	public Map<String, Object> getSelect() throws SQLException {
		mdao.setConnection(DBCon.getCon());
		
		try {
			return mdao.getSelect();
			
		}catch(SQLException e) {
			throw e;
		} finally {
			DBCon.closeCon();
		}
		
	}

}
