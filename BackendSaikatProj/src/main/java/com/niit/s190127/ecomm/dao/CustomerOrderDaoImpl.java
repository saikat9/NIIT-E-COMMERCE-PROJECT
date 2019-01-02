package com.niit.s190127.ecomm.dao;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.s190127.ecomm.model.CustomerOrder;

@Repository("customerOrderDAO")
@Transactional
public class CustomerOrderDaoImpl implements CustomerOrderDao {

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public boolean orderProcess(CustomerOrder customerOrder) {
		// TODO Auto-generated method stub
		try 
		{
			sessionFactory.getCurrentSession().saveOrUpdate(customerOrder);
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		}
	}
	@Override
	public boolean updateCartStatus(String userName) {
		// TODO Auto-generated method stub
		try 
		{
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("update CartItem set status='Ordered' where username=:uname");
			query.setParameter("uname", userName);
			int row_upd=query.executeUpdate();
			if(row_upd>0)
			    return true;
			else
				return false;	
			
		} 
		catch (Exception ex) 
		{
			System.out.println("Exception:"+ex);
			return false;
		}
	}

}
