 package com.niit.s190127.ecomm.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.s190127.ecomm.dao.CartItemDao;
import com.niit.s190127.ecomm.model.CartItem;

public class CartItemDAOJunitTesting {
	static CartItemDao cartItemDAO;

	@BeforeClass
	public static void runFirst()
	{
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.s190127.ecomm");
		context.refresh();
		
		cartItemDAO=(CartItemDao) context.getBean("cartItemDAO");
		
		
	}
	

	//Test case to check add method of cartItemdao class
	@Ignore
	@Test
	public void addCartItemTest()
	{
		CartItem cartItem=new CartItem();
		cartItem.setProductId(1);
		cartItem.setQuantity(1);
		cartItem.setPrice(5000);
		cartItem.setProductName("wrist watch");
		cartItem.setStatus("active");
		cartItem.setUserName("Kris");
		assertTrue("Problem in Adding the cartItem",cartItemDAO.amendCartItem(cartItem));
		
	}
	

	//Test case to check update method of cartItemdao class
	@Ignore
	@Test
	public void updationCategoryTest()
	{
		CartItem cartItem= cartItemDAO.retrieveCartItem(155);
		cartItem.setPrice(2000);
		cartItem.setProductName("refregerator");
		assertTrue("Problem in updating cartItem",cartItemDAO.amendCartItem(cartItem));
		
	}
	
	//Test case to check get method of cartItemdao class
	@Ignore
	@Test
	public void retrievalCartItemTest()
	{
		CartItem cartItem= cartItemDAO.retrieveCartItem(155);
		System.out.println("cartItem price:"+cartItem.getPrice());
		System.out.println("cartItem product name:"+cartItem.getProductName());
		System.out.println("cartItem user:"+cartItem.getUserName());
		assertTrue("Problem in retrieving cartItem",(cartItem!=null));
		
	}
	
	//Test case to check delete method of cartItem dao class
	@Ignore
	@Test
	public void deletionCartItemTest()
	{
		CartItem cartItem= cartItemDAO.retrieveCartItem(155);
		assertTrue("Problem in deleting cartItem",cartItemDAO.removeCartItem(cartItem));
		
	}
	
	
	//Test case to check listcartItem method of cartItem dao class
	@Ignore
	@Test
	public void listingCartItemsTest()
	{
		List<CartItem> listCartItems = cartItemDAO.listCartItems("Rohan");
		
		assertTrue("Problem in listing cartItem",listCartItems.size()>0);
		
		for(CartItem cartItem: listCartItems)
		{
			
			System.out.print("cartItem price:"+cartItem.getPrice());
			System.out.print("cartItem product name:"+cartItem.getProductName());
			System.out.println("cartItem user:"+cartItem.getUserName());
			System.out.println("cart item status:"+cartItem.getStatus());
		}
		
	}
    

}
