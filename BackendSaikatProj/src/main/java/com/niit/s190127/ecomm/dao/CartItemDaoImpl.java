package com.niit.s190127.ecomm.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.s190127.ecomm.model.CartItem;

@Repository("cartItemDAO")
@Transactional
public class CartItemDaoImpl implements CartItemDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean amendCartItem(CartItem cartItem) {
		// Method to add/update a cart item
		
		try
		{
			
		sessionFactory.getCurrentSession().saveOrUpdate(cartItem);
		return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}

	@Override
	public boolean removeCartItem(CartItem cartItem) {
		// Method to delete a cart item
		
		try
		{
		sessionFactory.getCurrentSession().delete(cartItem);
		return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}

	@Override
	public CartItem retrieveCartItem(int cartId) {
		// Method to get a CartItem
		 
		Session session = sessionFactory.openSession();
		CartItem cartItem = session.get(CartItem.class, cartId);
		session.close();
		return cartItem;
	}

	@Override
	public List<CartItem> listCartItems(String userName) {
		// Method to get a list of CartItems
		 Session session = sessionFactory.openSession();
		 Query query = session.createQuery("from CartItem where username=:uname and status='Created'");
		 query.setParameter("uname", userName);
		 @SuppressWarnings("unchecked")
		 List<CartItem>  cartItemList = query.getResultList();
		 session.close();
		 return cartItemList;
	}

}
