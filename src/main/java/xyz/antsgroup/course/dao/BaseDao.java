package xyz.antsgroup.course.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T,ID extends Serializable>{

	/**
	 * 根据对象保存记录
	 * @param entity
	 * @throws Exception 
	 */
	public int save(T entity) throws Exception;
	
	/**
	 * 根据对象删除记录
	 * @param entity
	 */
	public void delete(ID id) throws Exception;
	
	/**
	 * 根据对象更新记录
	 * @param entity
	 * @throws Exception 
	 */
	public void update(T entity) throws Exception;
	
	/**
	 * 根据id获取记录
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	public T get(ID id) throws Exception;
	
	/*
	 * 根据sql进行查询
	 * @param sql
	 * @return
	 */
	public List<T> queryByCondition(String sql) throws Exception;
	
	/**
	 * 获取所有的记录
	 * @return
	 * @throws Exception 
	 */
	public List<T> getAll() throws Exception;
	
	/**
	 * 根据ID[]批量删除记录
	 * @param id
	 * @throws Exception 
	 */
	public void batchDelete(ID[] ids) throws Exception;
}

