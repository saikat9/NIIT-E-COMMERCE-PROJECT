package com.niit.s190127.ecomm.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.s190127.ecomm.model.UserDetail;

@Repository("userDetailDAO")
@Transactional
public class UserDetailDaoImpl implements UserDetailDao

{
	
	@Autowired
	SessionFactory sessionFactory; 

	@Override
	public boolean registerUser(UserDetail userDetail) {
		// Method to register a user
		
		try
		{
			
		sessionFactory.getCurrentSession().save(userDetail);
		userDetail.setMessage("Successfully Registered");
		return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}

	@Override
	public boolean modifyUser(UserDetail userDetail) {
	// Method to update user details
		
		try
		{
		sessionFactory.getCurrentSession().update(userDetail);
		return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}

	@Override
	public UserDetail fetchUser(String username) {
		// Method to retrieve user details
		 
		Session session = sessionFactory.openSession();
		UserDetail userDetail = session.get(UserDetail.class, username);
		session.close();
		return userDetail;
	}
	
}