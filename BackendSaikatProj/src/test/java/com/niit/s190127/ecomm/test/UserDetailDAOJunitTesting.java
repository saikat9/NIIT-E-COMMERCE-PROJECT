package com.niit.s190127.ecomm.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.s190127.ecomm.dao.UserDetailDao;
import com.niit.s190127.ecomm.model.UserDetail;

public class UserDetailDAOJunitTesting {
	static UserDetailDao userDetailDAO;

	@BeforeClass
	public static void runFirst()
	{
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.s190127.ecomm");
		context.refresh();
		
		userDetailDAO=(UserDetailDao) context.getBean("userDetailDAO");
		
		
	}
	
	//Test case to check register method of user detail class
	@Ignore
	@Test
	public void registerUserTest()
	{
		UserDetail userDetail=new UserDetail();
		userDetail.setAddress("Salt lake Kolkata");
		userDetail.setCustomerName("Vijay Khanna");
		userDetail.setEmailId("vijay.khanna@gmail.com");
		userDetail.setEnabled("Yes");
		userDetail.setMobileNo("9876754676");
		userDetail.setPassword("password");
		userDetail.setRole("User");
		userDetail.setUsername("vijay");
		assertTrue("Problem in registering user detail ",userDetailDAO.registerUser(userDetail));
		System.out.println(userDetail.getMessage());
		System.out.println(userDetail.getEnabled());

	}
	
	//Test case to check update method of user detail class
	@Ignore
	@Test
	public void updationUserTest()
	{
		UserDetail userDetail= userDetailDAO.fetchUser("Rohan");
		userDetail.setAddress("KOLKATA");
		userDetail.setCustomerName("Rohan Das");
		userDetail.setEmailId("rohan.das@gmail.com");
		userDetail.setEnabled("No");
		userDetail.setMobileNo("9876754679");
		
		assertTrue("Problem in updating user detail",userDetailDAO.modifyUser(userDetail));
		
	}
	
	//Test case to check fetch method of user detail class
	@Ignore
	@Test
	public void retrievalUserTest()
	{
		UserDetail userDetail= userDetailDAO.fetchUser("Rohan");
		System.out.println("Address:"+userDetail.getAddress());
		System.out.println("CustomerName"+userDetail.getCustomerName());
		System.out.println("EmailId:"+userDetail.getEmailId());
		System.out.println("MobileNo:"+userDetail.getMobileNo());
		System.out.println("Password:"+userDetail.getPassword());
		System.out.println("Role:"+userDetail.getRole());
		System.out.println("Username:"+userDetail.getUsername());
		assertTrue("Problem in retrieving user detail",(userDetail!=null));
		
	}
	

}
