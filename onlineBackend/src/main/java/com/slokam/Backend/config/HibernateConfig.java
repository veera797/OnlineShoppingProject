package com.slokam.Backend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"com.slokam.Backend.DTO"})
@EnableTransactionManagement
public class HibernateConfig {
	private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/onlineshopping";
	private final static String DATABASE_DRIVER = "org.h2.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME = "sa";
	private final static String DATABASE_PASSWORD = "";
	
	@Bean
	public DataSource getDataSource()
	{
		BasicDataSource dataSource=new BasicDataSource();
		//providing the database connection information
		dataSource.setUrl(DATABASE_URL);
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		
		return dataSource;
		
	}
	
	//Session factory bean will be created
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource)

	{
		
		LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.slokam.Backend.DTO");
		return builder.buildSessionFactory();
		
	}

	//All the hibernate properties will be returned in this method
	private Properties getHibernateProperties() {
		Properties properties=new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		return properties;
	}
	
	@Bean
	//HibernateTransactionManager bean will be created
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transctionManager=new HibernateTransactionManager(sessionFactory);
		return transctionManager;
	
		
	}
}
