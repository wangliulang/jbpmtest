package com.icss.framework.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("mybatisBaseDao")
public class MyBatisBaseDAO extends SqlSessionDaoSupport implements IMyBatisBaseDAO{
	
	//private  ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:applicationContext-database.xml");
	//private  SqlSessionFactory sessionFactory= (SqlSessionFactory)ac.getBean("sqlSessionFactory");
	
	/*@Autowired 
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {  
        super.setSqlSessionFactory(sqlSessionFactory);  
    }*/
	
	@Autowired
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	
	/**
	 * 多条数据条件查询	 
	 * @param mapper
	 * @param object
	 */
	public List<Object> find(String mapper, Object object) {
		if(object != null) {
			return this.getSqlSession().selectList(mapper, object);
		}
		return this.getSqlSession().selectList(mapper);
	}
	
	/**
	 * 单条数据条件查询	 
	 * @param mapper
	 * @param object
	 */
	public Object findOne(String mapper, Object object) {
		if(object != null) {
			return this.getSqlSession().selectOne(mapper, object);
		}
		return this.getSqlSession().selectOne(mapper);
	}
	
	/**
	 * 插入单条数据
	 * @param mapper
	 * @param object
	 */
	public void insertOne(String mapper, Object object) {
		this.getSqlSession().insert(mapper, object);
 	}
	
	/**
	 * 插入多条数据
	 * @param mapper
	 * @param objList
	 */
	public void insertBatch(String mapper, List<Object> objectList) {
		for(Object item : objectList) {
			this.getSqlSession().insert(mapper, item);
		}
	}
	
	/**
	 * 更新单条数据
	 * @param mapper
	 * @param object
	 */
	public void updateOne(String mapper, Object object) {
		this.getSqlSession().update(mapper, object);
 	}
	
	/**
	 * 更新多条数据
	 * @param mapper
	 * @param objList
	 */
	public void updateBatch(String mapper, List<Object> objectList) {
		for(Object item : objectList) {
			this.getSqlSession().update(mapper, item);
		}
	}
	
	/**
	 * 删除数据
	 * @param mapper
	 * @param objList
	 */
	public void delete(String mapper, Object object) {
		if(object != null) {
			this.getSqlSession().delete(mapper, object);
		}
		this.getSqlSession().delete(mapper);
	}
}
