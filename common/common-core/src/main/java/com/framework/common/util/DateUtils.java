package com.framework.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 * 
 * @version 1.0
 * @author xxp
 */
public class DateUtils {
	
	/** 
	 * 时间格式(yyyy-MM-dd) 
	 */
	public final static String DATE_PATTERN = "yyyy-MM-dd";
	
	/** 
	 * 时间格式(yyyy-MM-dd HH:mm:ss) 
	 */
	public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 格式化时间为默认格式（yyyy-MM-dd）的字符串
	 * @param date
	 * @return
	 */
	public static String format(Date date) {
		return format(date, DATE_PATTERN);
	}

	/**
	 * 格式化时间为指定格式的字符串
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String format(Date date, String pattern) {
		if (date != null) {
			SimpleDateFormat df = new SimpleDateFormat(pattern);
			return df.format(date);
		}
		return null;
	}
	
	
	/**
	 * 解析时间格式字符串
	 * @param dateStr
	 * @param pattern
	 * @return
	 */
	public static Date parseDate(String dateStr, String pattern){
		if( StringUtils.isNotBlank(dateStr) ){
			try {
				SimpleDateFormat df = new SimpleDateFormat(pattern);
				return df.parse(dateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
