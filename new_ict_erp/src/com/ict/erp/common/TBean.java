package com.ict.erp.common;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.BeanProcessor;

import com.ict.erp.vo.BeanInfo;

public class TBean {
	
	public static <E> List<E> convertRS(ResultSet rs, Class<?> clazz) throws Exception {
		
		List<E> list = new ArrayList<E>();
		
		BeanProcessor bp = new BeanProcessor();
		
		while(rs.next()) {
			list.add((E)bp.toBean(rs, clazz));
		}
		
		return list;
	}

	public static <T> T parseRequest(HttpServletRequest request, Class<?> clazz) throws Exception{
		T obj;
		
		obj = (T)clazz.newInstance();
		
		BeanUtils.populate(obj, request.getParameterMap());
		
		return obj;
	}
	


}
