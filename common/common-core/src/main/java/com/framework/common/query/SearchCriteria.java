package com.framework.common.query;

import java.util.HashMap;

/**
 * 查询条件封装类
 * @version 1.0
 * @author xxp
 */
public class SearchCriteria extends HashMap<String, Object>{
	private static final long serialVersionUID = 1L;

	
	public SearchCriteria addCriteria(String name, Object value) {
		this.put(name, value);
		return this;
	}
	
	
	public SearchCriteria addOrderCriteria(String orderColumn, String order){
		this.put("", orderColumn);
		this.put("", order);
		return this;
	}
}
