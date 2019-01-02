package com.niit.s190127.ecomm.dao;

import java.util.List;

/**
 * @author DELL
 * Common Dao interface for all model class objects
 */
public interface GenericDao {

	public boolean addition(Object obj);
	public boolean deletion(Object obj);
	public boolean updation(Object obj);
	public Object  retrieval(int Id);
	public List<Object> listing();
	List<Object> listingCategoryWise(int categoryId);	
}
