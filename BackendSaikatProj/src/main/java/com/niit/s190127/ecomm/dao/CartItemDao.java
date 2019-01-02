package com.niit.s190127.ecomm.dao;

import java.util.List;

import com.niit.s190127.ecomm.model.CartItem;

// DAO interface to perform cart operations
public interface CartItemDao {
	public boolean amendCartItem(CartItem cartItem);
	public boolean removeCartItem(CartItem cartItem);
	public CartItem  retrieveCartItem(int cartId);
	public List<CartItem> listCartItems(String userName);	
}
