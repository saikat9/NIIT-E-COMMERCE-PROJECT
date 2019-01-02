package com.niit.s190127.ecomm.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.s190127.ecomm.dao.GenericDao;
import com.niit.s190127.ecomm.model.Category;



public class CategoryDAOJunitTesting {

	static GenericDao categoryDAO;

	@BeforeClass
	public static void runFirst()
	{
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.s190127.ecomm");
		context.refresh();
		
		categoryDAO=(GenericDao)context.getBean("categoryDAO");
		
		
	}
	

	//Test case to check add method of categorydao class
	
	@Test
	public void additionCategoryTest()
	{
		Category category=new Category();
		category.setCategoryName("Gadget");
		category.setCategoryDesc("Hand gadget like cell phone etc");
		assertTrue("Problem in Adding the Category",categoryDAO.addition(category));
		category.setCategoryName("Furniture");
		category.setCategoryDesc("Furniture to decorate home");
		assertTrue("Problem in Adding the Category",categoryDAO.addition(category));
		
	}
	
	//Test case to check update method of categorydao class
	@Ignore
	@Test
	public void updationCategoryTest()
	{
		Category category= (Category)categoryDAO.retrieval(24);
		category.setCategoryDesc("Furniture to decorate office");
		assertTrue("Problem in updating category",categoryDAO.updation(category));
		
	}
	
	//Test case to check getCategory method of categorydao class
	@Ignore
	@Test
	public void retrievalCategoryTest()
	{
		Category category= (Category)categoryDAO.retrieval(24);
		System.out.println("Category Id:"+category.getCategoryId());
		System.out.println("Category Name:"+category.getCategoryName());
		System.out.println("Category Description:"+category.getCategoryDesc());
		assertTrue("Problem in retrieving category",(category!=null));
		
	}
	
	//Test case to check delete method of categorydao class
	@Ignore
	@Test
	public void deletionCategoryTest()
	{
		Category category= (Category)categoryDAO.retrieval(24);
		assertTrue("Problem in deleting category",categoryDAO.deletion(category));
		
	}
	
	
	
	//Test case to check listCategories method of categorydao class
	@Ignore
	@Test
	public void listingCategoriesTest()
	{
		List<Object> listCategories = categoryDAO.listing();
		
		assertTrue("Problem in listing categories",listCategories.size()>0);
		
		for(Object obj: listCategories)
		{
			Category category=(Category) obj;
			System.out.print("Category Id:"+category.getCategoryId());
			System.out.print("Category Name:"+category.getCategoryName());
			System.out.println("Category Description:"+category.getCategoryDesc());
		}
		
	}
	
  
    
	
}
