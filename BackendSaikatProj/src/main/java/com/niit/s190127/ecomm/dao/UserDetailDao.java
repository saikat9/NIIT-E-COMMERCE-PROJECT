package com.niit.s190127.ecomm.dao;

import com.niit.s190127.ecomm.model.UserDetail;

// DAO interface for user detail related activities
public interface UserDetailDao {

	public boolean registerUser(UserDetail userDetail);
	public boolean modifyUser(UserDetail userDetail);
	public UserDetail fetchUser(String username);
	
}
