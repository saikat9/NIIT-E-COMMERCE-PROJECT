package com.niit.s190127.ecomm.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.s190127.ecomm.model.Supplier;

@Repository("supplierDAO")
@Transactional
public class SupplierDaoImpl implements GenericDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addition(Object obj) {
		// Method to add supplier
		
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
		// Method to delete supplier
		
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
	// Method to update supplier
		
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
		// Method to get supplier
		 
		Session session = sessionFactory.openSession();
		Supplier supplier = session.get(Supplier.class, Id);
		session.close();
		return supplier;
	}

	@Override
	public List<Object> listing() {
		// Method to get a list of suppliers
		 Session session = sessionFactory.openSession();
		 Query query = session.createQuery("from Supplier");
		 @SuppressWarnings("unchecked")
		 List<Object>  listSuppliers = query.getResultList();
		 session.close();
		 return listSuppliers;
	}

	@Override
	public List<Object> listingCategoryWise(int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

}
