package com.niit.s190127.ecomm.test;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.s190127.ecomm.dao.CustomerOrderDao;
import com.niit.s190127.ecomm.model.CustomerOrder;

public class CustomerOrderDAOJunitTesting {

	static CustomerOrderDao customerOrderDAO;
	
	@BeforeClass
	public static void runFirst()
	{
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.s190127.ecomm");
		context.refresh();
		
		customerOrderDAO=(CustomerOrderDao) context.getBean("customerOrderDAO");
		
		
	}	
	
	//Junit test case to check insert process of customer order dao class
    @Ignore
	@Test
	public void additionCustomerOrderTest() 
	{
		
		CustomerOrder customerOrder=new CustomerOrder();
		customerOrder.setDateOfOrder(new Date());
		customerOrder.setOrderPrice(6000);
		customerOrder.setPaymentMode("Card");
		customerOrder.setUserName("Rohan");
		assertTrue("Problem in processing customer order", customerOrderDAO.orderProcess(customerOrder));
	}

	//Junit test case to check update process of customer order dao class
	@Ignore
	@Test
	public void updationCustomerOrderTest() 
	{
		assertTrue("Problem in processing customer order", customerOrderDAO.updateCartStatus("Rohan"));		
	}
	

}
