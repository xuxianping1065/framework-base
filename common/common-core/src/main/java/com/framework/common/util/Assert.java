package com.framework.common.util;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.framework.common.constant.BaseErrorEnum;
import com.framework.common.exception.BusinessException;

public class Assert {

	/**
	 * 断言字符串非空
	 * @param content 字符串
	 * @throws BusinessException 当为空时，抛出异常
	 */
	public static void notEmpty(String content) throws BusinessException {
		if (null == content || content.length() == 0) {
			throw new BusinessException(BaseErrorEnum.E11_Para_Null);
		}
	}

	/**
	 * 断言字符串非空
	 * @param content 字符串
	 * @param message 错误信息
	 * @throws BusinessException 当为空时，抛出异常
	 */
	public static void notEmpty(String content, String message) throws BusinessException {
		if (null == content || content.length() == 0) {
			throw new BusinessException(BaseErrorEnum.E11_Para_Null.getCode(), message);
		}
	}
	
	/**
	 * 断言对象非空
	 * @param object
	 * @throws BusinessException
	 */
	public static void notEmpty(Object object) throws BusinessException {
		if (null == object) {
			throw new BusinessException(BaseErrorEnum.E11_Para_Null);
		}
	}
	
	/**
	 * 断言对象非空
	 * @param object 内容
	 * @param message 错误信息
	 * @throws BusinessException 当为空时，抛出异常
	 */
	public static void notEmpty(Object object, String message) throws BusinessException {
		if (null == object) {
			throw new BusinessException(BaseErrorEnum.E11_Para_Null.getCode(), message);
		}
	}

	/**
	 * 断言集合非空
	 * @param collection
	 * @throws BusinessException
	 */
	public static void notEmpty(Collection<?> collection) throws BusinessException {
		if (null == collection || collection.isEmpty()) {
			throw new BusinessException(BaseErrorEnum.E11_Para_Null);
		}
	}

	/**
	 * 断言集合非空
	 * @param collection 内容
	 * @param message 错误信息
	 * @throws BusinessException 当为空时，抛出异常
	 */
	public static void notEmpty(Collection<?> collection, String message) throws BusinessException {
		if (null == collection || collection.isEmpty()) {
			throw new BusinessException(BaseErrorEnum.E11_Para_Null.getCode(), message);
		}
	}

	/**
	 * 断言字符串符合正则表达式
	 * @param content 字符串
	 * @param regex 正则表达式
	 * @param message 错误信息
	 * @throws BusinessException 当为空时，抛出异常
	 */
	public static void match(String content, String regex) throws BusinessException {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(content);
		if( !m.matches() ){
			throw new BusinessException(BaseErrorEnum.E10_Para_Error);
		}
	}
	
	/**
	 * 断言字符串符合正则表达式
	 * @param content 字符串
	 * @param regex 正则表达式
	 * @param message 错误信息
	 * @throws BusinessException 当为空时，抛出异常
	 */
	public static void match(String content, String regex, String message) throws BusinessException {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(content);
		if( !m.matches() ){
			throw new BusinessException(BaseErrorEnum.E10_Para_Error.getCode(), message);
		}
	}
	
	
	/**
	 * 断言字符串长度为指定长度
	 * @param content 字符串
	 * @param length 指定长度
	 * @param message 错误信息
	 * @throws BusinessException 当为空时，抛出异常
	 */
	public static void length(String content, int length, String message) throws BusinessException {
		if( null == content || content.length() != length || length < 0 ){
			throw new BusinessException(BaseErrorEnum.E10_Para_Error.getCode(), message);
		}
	}
	
	/**
	 * 断言字符串长度为指定长度区别
	 * @param content 字符串
	 * @param minLength 最小长度（包括）
	 * @param maxLength 最大长度（包括）
	 * @param message 错误信息
	 * @throws BusinessException 当为空时，抛出异常
	 */
	public static void lengthBetween(String content, int minLength, int maxLength, String message) throws BusinessException {
		if( null == content || content.length() < minLength || content.length() > maxLength ){
			throw new BusinessException(BaseErrorEnum.E10_Para_Error.getCode(), message);
		}
	}
	
	/**
	 * 断言两个对象相等
	 * @param obj1  对象1
	 * @param obj2   对象2
	 * @param message 错误信息
	 * @throws BusinessException 当为空时，抛出异常
	 */
	public static void equals(Object obj1, Object obj2, String message) throws BusinessException {
		if( null == obj1 || null == obj2 || !obj1.equals(obj2) ){
			throw new BusinessException(BaseErrorEnum.E10_Para_Error.getCode(), message);
		}
	}
	
	public static void main(String[] args) {
		try {
			Assert.match("abcdef水电费", "^[a-zA-Z][a-zA-Z\u4E00-\u9FA5]{5,17}$", "密码不合法");
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}
}
