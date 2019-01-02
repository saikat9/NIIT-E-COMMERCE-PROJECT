package com.niit.s190127.ecomm.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.s190127.ecomm.model.Product;

@Repository("productDAO")
@Transactional
public class ProductDaoImpl implements GenericDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addition(Object obj) {
		// Method to add a product
		
		try
		{
			
		sessionFactory.getCurrentSession().saveOrUpdate(obj);
		return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}

	@Override
	public boolean deletion(Object obj) {
		// Method to delete a product
		
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
	// Method to update a product
		
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
		// Method to get a product
		 
		Session session = sessionFactory.openSession();
		Product product = session.get(Product.class, Id);
		session.close();
		return product;
	}

	@Override
	public List<Object> listing() {
		// Method to get a list of products
		 Session session = sessionFactory.openSession();
		 Query query = session.createQuery("from Product");
		 @SuppressWarnings("unchecked")
		 List<Object>  listProducts = query.getResultList();
		 session.close();
		 return listProducts;
	}

	@Override
	public List<Object> listingCategoryWise(int categoryId) {
		// Method to get a list of products
		 Session session = sessionFactory.openSession();
		 Query query = session.createQuery("from Product where categoryId=:categoryId");
		 query.setParameter("categoryId", categoryId);
		 @SuppressWarnings("unchecked")
		 List<Object>  listProducts = query.getResultList();
		 session.close();
		 return listProducts;
	}	
}
