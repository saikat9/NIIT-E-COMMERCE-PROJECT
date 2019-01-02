 package com.niit.s190127.ecomm.dao;


import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.s190127.ecomm.model.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDaoImpl implements GenericDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addition(Object obj) {
		// Method to add a category
		
		try
		{
			
		sessionFactory.getCurrentSession().save(obj);
		return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}

	@Override
	public boolean deletion(Object obj) {
		// Method to delete a category
		
		try
		{
		sessionFactory.getCurrentSession().delete(obj);
		return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}

	@Override
	public boolean updation(Object obj) {
	// Method to update a category
		
		try
		{
		sessionFactory.getCurrentSession().update(obj);
		return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}

	@Override
	public Object retrieval(int Id) {
		// Method to get a category
		 
		Session session = sessionFactory.openSession();
		Category category = session.get(Category.class, Id);
		session.close();
		return category;
	}

	@Override
	public List<Object> listing() {
		// Method to get a list of categories
		 Session session = sessionFactory.openSession();
		 Query query = session.createQuery("from Category");
		 @SuppressWarnings("unchecked")
		 List<Object>  listCategories = query.getResultList();
		 session.close();
		 return listCategories;
	}

	@Override
	public List<Object> listingCategoryWise(int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

}
