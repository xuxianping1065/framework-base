package com.framework.common.service;

import java.util.List;
import java.util.Map;

import com.framework.common.dao.BaseDao;
import com.framework.common.model.BaseEntity;
import com.framework.common.model.Page;

/**
 * 基础服务的实现类
 * @version 1.0
 * @author xxp
 */
public abstract class AbstractBaseService<E extends BaseEntity> implements BaseService<E> {

	/**
	 * 获得基础Dao
	 * @return
	 */
	public abstract BaseDao<E> getBaseDao();

	@Override
	public E save(E entity) {
		getBaseDao().save(entity);
		return entity;
	}

	@Override
	public E update(E entity) {
		getBaseDao().update(entity);
		return entity;
	}

	@Override
	public void delete(Integer id) {
		getBaseDao().delete(id);
	}
	
	@Override
	public E get(Integer id) {
		return getBaseDao().get(id);
	}

	@Override
	public Page<E> queryForPage(Map<String, Object> paraMap) {
		return getBaseDao().queryForPage(paraMap);
	}

	@Override
	public List<E> queryForList(Map<String, Object> paraMap) {
		return getBaseDao().queryForList(paraMap);
	}

	@Override
	public int queryTotal(Map<String, Object> paraMap) {
		return getBaseDao().queryTotal(paraMap);
	}
	
}
