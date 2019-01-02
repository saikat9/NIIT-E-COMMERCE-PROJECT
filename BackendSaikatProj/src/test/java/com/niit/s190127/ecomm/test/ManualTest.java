package com.niit.s190127.ecomm.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ManualTest {

	//Simple class file to manually test db config file
	public static void main(String[] args) {
		
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
      context.scan("com.niit.s190127.ecomm");
      context.refresh();
      context.close();
	}
	
}
