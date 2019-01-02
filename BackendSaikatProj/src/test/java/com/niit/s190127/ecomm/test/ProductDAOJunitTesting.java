package com.niit.s190127.ecomm.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.s190127.ecomm.dao.GenericDao;
import com.niit.s190127.ecomm.model.Product;

public class ProductDAOJunitTesting {
	static GenericDao productDAO;

	@BeforeClass
	public static void runFirst()
	{
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.s190127.ecomm");
		context.refresh();
		
		productDAO=(GenericDao)context.getBean("productDAO");
		
		
	}
	

	//Test case to check add method of productdao class
	@Ignore
	@Test
	public void additionProductTest()
	{
		Product product=new Product();
		product.setCategoryId(1);
		product.setPrice(100);
		product.setProductDesc("Smart phone with octacore processor");
		product.setProductName("Samsung mobile");
		product.setStock(5);
		product.setSupplierId(1);		
		assertTrue("Problem in Adding the product",productDAO.addition(product));

		
	}
	
	//Test case to check update method of productdao class
	@Ignore
	@Test
	public void updationProductTest()
	{
		Product product= (Product)productDAO.retrieval(26);
		product.setProductDesc("Smart phone with dual processor");
		assertTrue("Problem in updating product",productDAO.updation(product));
		
	}
	
	//Test case to check getproduct method of productdao class
	@Ignore
	@Test
	public void retrievalProductTest()
	{
		Product product= (Product)productDAO.retrieval(26);
		System.out.println("Category Id:"+product.getCategoryId());
		System.out.println("Price:"+product.getPrice());
		System.out.println("Product Description:"+product.getProductDesc());
		System.out.println("Product ID:"+product.getProductId());
		System.out.println("Product stock:"+product.getStock());
		System.out.println("Product supplier id:"+product.getSupplierId());
		System.out.println("Product name:"+product.getProductName());
		assertTrue("Problem in retrieving product",(product!=null));
		
	}
	
	//Test case to check delete method of productdao class
    @Ignore
	@Test
	public void deletionProductTest()
	{
		Product product= (Product)productDAO.retrieval(26);
		assertTrue("Problem in deleting product",productDAO.deletion(product));
		
	}
	
	
	
	//Test case to check listing method of productdao class
	@Ignore
	@Test
	public void listingProductsTest()
	{
		List<Object> listProducts = productDAO.listing();
		
		assertTrue("Problem in listing products",listProducts.size()>0);
		
		for(Object obj: listProducts)
		{
			Product product=(Product) obj;
			System.out.print("Category Id:"+product.getCategoryId());
			System.out.print("Price:"+product.getPrice());
			System.out.print("Product Description:"+product.getProductDesc());
			System.out.print("Product ID:"+product.getProductId());
			System.out.print("Product stock:"+product.getStock());
			System.out.print("Product supplier id:"+product.getSupplierId());
			System.out.println("Product name:"+product.getProductName());
		}
		
	}
	
	//Test case to check listing method of productdao class wrt category
    @Ignore
	@Test
	public void listingCategoryWiseTest()
	{
		List<Object> listProducts = productDAO.listingCategoryWise(123);
		
		assertTrue("Problem in listing products",listProducts.size()>0);
		
		for(Object obj: listProducts)
		{
			Product product=(Product) obj;
			System.out.print("Category Id:"+product.getCategoryId());
			System.out.print("Price:"+product.getPrice());
			System.out.print("Product Description:"+product.getProductDesc());
			System.out.print("Product ID:"+product.getProductId());
			System.out.print("Product stock:"+product.getStock());
			System.out.print("Product supplier id:"+product.getSupplierId());
			System.out.println("Product name:"+product.getProductName());
		}
		
	}	
	
  
    

}
