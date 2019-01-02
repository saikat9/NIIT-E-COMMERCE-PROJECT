package com.niit.s190127.ecomm.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.s190127.ecomm.model.CartItem;
import com.niit.s190127.ecomm.model.Category;
import com.niit.s190127.ecomm.model.CustomerOrder;
import com.niit.s190127.ecomm.model.Product;
import com.niit.s190127.ecomm.model.Supplier;
import com.niit.s190127.ecomm.model.UserDetail;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.niit.s190127.ecomm")
public class H2DBConnConfig {

	//Method which will return H2 data source to be used as bean
	@Bean(name="H2Conn")
	public DataSource getH2Conn()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/S190127");
		dataSource.setUsername("root");
		System.out.println("--Data source object created--");
		return dataSource;
	}
	
	//Method which will create local session factory builder  to be used as bean
	@Bean(name="sessionFactory")
	public SessionFactory genSessionFactory()
	{
		Properties hibernateProp = new Properties();
		hibernateProp.put("hibernate.hbm2ddl.auto","update");
		hibernateProp.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		LocalSessionFactoryBuilder factory = new LocalSessionFactoryBuilder(getH2Conn());
		factory.addProperties(hibernateProp);
		factory.addAnnotatedClass(Category.class);
		factory.addAnnotatedClass(Product.class);
		factory.addAnnotatedClass(UserDetail.class);
		factory.addAnnotatedClass(Supplier.class);
		factory.addAnnotatedClass(CartItem.class);
		factory.addAnnotatedClass(CustomerOrder.class);
		System.out.println("--Session factory object created--");
		return factory.buildSessionFactory();
		
		
	}
	
	//Method to create transaction manager to be used as bean
	@Bean(name="txnManager")
	public HibernateTransactionManager genTransactionManager(SessionFactory sessionFactory)
	{
	System.out.println("--Transaction manager object created--");	
	return new HibernateTransactionManager(sessionFactory);
	}
}
