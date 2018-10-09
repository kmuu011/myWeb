package com.ict.erp.callp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ict.erp.common.DBCon;

import oracle.jdbc.OracleTypes;
import oracle.jdbc.oracore.OracleType;

public class CallProcedure {

	
	public static void main(String[] args) {
		String sql = "{call P_GET_EMP_CUR(?,?,?)}";
		Connection con = DBCon.getCon();
		
		try {
			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, "S");
			cs.setString(2, "MA");
			cs.registerOutParameter(3, OracleTypes.CURSOR);
			cs.executeQuery();
			
			ResultSet rs = (ResultSet) cs.getObject(3);
			
			while(rs.next()) {
				System.out.println(rs.getInt("empno") + " | " + rs.getString("empname"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBCon.closeCon();
		}
	}
	
}
