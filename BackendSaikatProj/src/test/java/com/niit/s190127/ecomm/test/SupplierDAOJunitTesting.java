package com.niit.s190127.ecomm.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.s190127.ecomm.dao.GenericDao;
import com.niit.s190127.ecomm.model.Supplier;

public class SupplierDAOJunitTesting {
	static GenericDao supplierDAO;

	@BeforeClass
	public static void runFirst()
	{
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.s190127.ecomm");
		context.refresh();
		
		supplierDAO=(GenericDao)context.getBean("supplierDAO");
		
		
	}
	

	//Test case to check add method of supplier dao class
    @Ignore
	@Test
	public void additionSupplierTest()
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierAddr("Salt lake Kolkata");
		supplier.setSupplierName("Chopra Ltd");
		assertTrue("Problem in Adding the supplier",supplierDAO.addition(supplier));
		
	}
	
	//Test case to check update method of supplier dao class
	@Ignore
	@Test
	public void updationSupplierTest()
	{
		Supplier supplier= (Supplier)supplierDAO.retrieval(28);
		supplier.setSupplierAddr("Kolkata");
		assertTrue("Problem in updating supplier",supplierDAO.updation(supplier));
		
	}
	
	//Test case to check getsupplier method of supplier dao class
	@Ignore
	@Test
	public void retrievalSupplierTest()
	{
		Supplier supplier= (Supplier)supplierDAO.retrieval(28);
		System.out.println("SupplierAddr:"+supplier.getSupplierAddr());
		System.out.println("SupplierId:"+supplier.getSupplierId());
		System.out.println("SupplierName:"+supplier.getSupplierName());
		assertTrue("Problem in retrieving Supplier",(supplier!=null));
		
	}
	
	//Test case to check delete method of supplier dao class
	
	@Test
	public void deletionSupplierTest()
	{
		Supplier supplier= (Supplier)supplierDAO.retrieval(28);
		assertTrue("Problem in deleting supplier",supplierDAO.deletion(supplier));
		
	}
	
	
	
	//Test case to check listsupplier method of supplier dao class
	@Ignore
	@Test
	public void listingSuppliersTest()
	{
		List<Object> listSuppliers = supplierDAO.listing();
		
		assertTrue("Problem in listing Suppliers",listSuppliers.size()>0);
		
		for(Object obj: listSuppliers)
		{
			Supplier supplier=(Supplier) obj;
			System.out.print("SupplierAddr:"+supplier.getSupplierAddr());
			System.out.print("SupplierId:"+supplier.getSupplierId());
			System.out.println("SupplierName:"+supplier.getSupplierName());
		}
		
	}
	
  
}
