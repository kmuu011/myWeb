package com.ict.erp.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.DepartDAO;
import com.ict.erp.dao.impl.DepartDAOImpl;
import com.ict.erp.service.DepartService;
import com.ict.erp.vo.DepartInfo;
import com.ict.erp.vo.PageInfo;

public class DepartServiceImpl implements DepartService {
	
	DepartDAO dd = new DepartDAOImpl();

	@Override
	public List<DepartInfo> getDepartInfoList(DepartInfo di) throws SQLException {

		dd.setConnection(DBCon.getCon());
		try {
	
			PageInfo pi = di.getPi();
			pi.initPage(dd.totalCount("depart_info"),20,20);
			return dd.selectDepartInfoList(di);
			
		} catch(SQLException e) {
			throw e;
		} finally {
			DBCon.closeCon();
		}
	}

	@Override
	public DepartInfo getDepartInfo(int diNum) throws SQLException {
		dd.setConnection(DBCon.getCon());
		DepartInfo di = null;
		
		try {
		di = dd.select(diNum);
		} catch (SQLException e) {
			throw e;
		} finally {
			DBCon.closeCon();
		}
		return di;
	}

	@Override
	public Map<String, Object> insertDepartInfo(DepartInfo di) throws SQLException {
		dd.setConnection(DBCon.getCon());
		Map<String, Object> rMap = new HashMap<String, Object>();
		
		try {
			int cnt = dd.insertDepartInfo(di);
			rMap.put("cnt", cnt);
			rMap.put("msg", "실패했습니다.");
			if(cnt==1) {
				rMap.put("msg", "성공했습니다.");
			}
			
		
		} catch(SQLException e) {
			throw e;
		} finally {
			DBCon.closeCon();
		}
		
		return rMap;
	}

	@Override
	public Map<String, Object> updateDepartInfo(DepartInfo di) throws SQLException {
		dd.setConnection(DBCon.getCon());
		Map<String, Object> rMap = new HashMap<String, Object>();
		
		try {
			int result = dd.updateDepartInfo(di);
			System.out.println(result);
			
			if(result == 1) {
				rMap.put("msg", "수정 성공!");
			}else {
				rMap.put("msg", "수정 실패!");
			}
			
			
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.closeCon();
		}
		

		return rMap;
	}

	@Override
	public Map<String, Object> deleteDepartInfo(List<Integer> diNums) throws SQLException {
		dd.setConnection(DBCon.getCon());
		Map<String,Object> rMap = new HashMap<String,Object>();
		
		try {
			int total = diNums.size();
			int result = dd.deleteDepartInfo(diNums);
			
			if(total == result) {
				rMap.put("msg", result+"개의 부서가 정상적으로 삭제되었습니다.");
			} else if(total != result) {
				rMap.put("msg", total+"개중" + result+"개 부서만 삭제 완료되었습니다.");
			} else {
				rMap.put("msg", "삭제가 실패하였습니다.");
			}
			
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.closeCon();
		}
		
		return rMap;
	}

	@Override
	public List<DepartInfo> getDepartInfoSearch(String sch, String op) throws SQLException {

		return dd.selectDepartInfoSearch(sch, op);
	}

}
