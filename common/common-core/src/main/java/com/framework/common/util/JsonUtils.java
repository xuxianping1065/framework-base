package com.framework.common.util;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * JSON工具类
 * 
 * @author xxp
 */
public class JsonUtils {
	
	/**
	 * 将对象转换成json字符串
	 * @param obj
	 * @return
	 */
	public static String objectToJson(Object obj) {
		if ( obj == null ) {
			return null;
		}
		return JSON.toJSONString(obj);
	}
	
	/** 
	 * 将json字符串转换成指定类型对象
	 * @param jsonStr
	 * @param clazz
	 * @return
	 */
	public static <T> T jsonToBean(String jsonStr, Class<T> clazz) {
		if ( StringUtils.isEmpty(jsonStr) || clazz == null ) {
			return null;
		}
		return JSON.parseObject(jsonStr, clazz);
	}

	/** 
	 * 将json字符串转换成指定类型的对象列表
	 * @param jsonStr
	 * @param clazz
	 * @return
	 */
	public static <T> List<T> jsonToList(String jsonStr, Class<T> clazz) {
		if ( StringUtils.isEmpty(jsonStr) || clazz == null ) {
			return null;
		}
		return JSON.parseArray(jsonStr, clazz);
	}

	/** 
	 * 将json字符串转换成JSONObject
	 * @param jsonStr
	 * @param clazz
	 * @return
	 */
	public static JSONObject jsonToObj(String jsonStr) {
		if ( StringUtils.isEmpty(jsonStr) ) {
			return null;
		}
		return JSON.parseObject(jsonStr);
	}

}
