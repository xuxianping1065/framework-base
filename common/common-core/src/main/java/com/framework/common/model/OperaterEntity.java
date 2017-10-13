package com.framework.common.model;

import java.util.Date;

/**
 * 有操作者的实体需要实现的接口（包括创建人、创建人ip、创建时间、修改人、修改人ip、修改时间）
 * 
 * @version 1.0
 * @author xxp
 */
public interface OperaterEntity extends BaseEntity {
	
	/**
	 * 获取创建人
	 * @return
	 */
	public String getCman();

	/**
	 * 设置创建人
	 * @param cman
	 */
	public void setCman(String cman);
	
	/**
	 * 获取创建人ip
	 * @return
	 */
	public String getCip();

	/**
	 * 设置创建人ip
	 * @param cip
	 */
	public void setCip(String cip);

	/**
	 * 获取创建时间
	 * @return
	 */
	public Date getCdt();

	/**
	 * 设置创建时间
	 * @param cdt
	 */
	public void setCdt(Date cdt);

	/**
	 * 获取修改人
	 * @return
	 */
	public String getEman();

	/**
	 * 设置修改人
	 * @param eman
	 */
	public void setEman(String eman);

	/**
	 * 获取修改人ip
	 * @return
	 */
	public String getEip();

	/**
	 * 设置修改人ip
	 * @param eip
	 */
	public void setEip(String eip);

	/**
	 * 获取修改时间
	 * @return
	 */
	public Date getEdt();

	/**
	 * 设置修改时间
	 * @param edt
	 */
	public void setEdt(Date edt);

}
