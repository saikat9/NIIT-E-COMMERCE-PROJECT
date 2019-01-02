package com.niit.s190127.ecomm.dao;

import com.niit.s190127.ecomm.model.CustomerOrder;

public interface CustomerOrderDao {
	
	//DAO interface to process customer order
	public boolean orderProcess(CustomerOrder customerOrder);
	public boolean updateCartStatus(String userName);
}
