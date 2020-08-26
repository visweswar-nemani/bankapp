package bankapp;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;
import javax.validation.Validator;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = { "bankapp.controller","bankapp.DAO","bankapp.service","bankapp.api","bankapp.Events"})
@PropertySource(value = { "classpath:application.properties" })
@EnableWebMvc
@EnableTransactionManagement

public class Configurations {
	


	@Bean
	@Lazy
	public DataSource setDataSource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUrl("jdbc:h2:mem:testdb");
		datasource.setDriverClassName("org.h2.Driver");
		/*
		 * datasource.setUsername("sa"); datasource.setPassword("");
		 */
		
		return datasource;
	}

	@Bean
	public JdbcTemplate setJdbcTemplate(DataSource datasource) {
		return new JdbcTemplate(datasource);
	}

	
	@Bean(initMethod = "start", destroyMethod = "stop")
	public org.h2.tools.Server h2WebConsole() throws SQLException {
		return org.h2.tools.Server.createWebServer("-web", "-webAllowOthers", "-webDaemon", "-webPort", "8082");
	}
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean
	public LocalSessionFactoryBean setSessionFactory() {
		LocalSessionFactoryBean sessionFactory= new LocalSessionFactoryBean();
		sessionFactory.setDataSource(setDataSource());
		sessionFactory.setPackagesToScan(new String[] {"bankapp.DAO"});
		//set hibernate properties
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;	
		
	}
	
	@Bean
	@Autowired
	public  HibernateTransactionManager setTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txnmanager = new  HibernateTransactionManager();
		txnmanager.setSessionFactory(sessionFactory);
		return txnmanager;
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	public Properties hibernateProperties() {
		return new Properties() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
			setProperty("hibernate.hbm2ddl.auto","create-drop");
			setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
			setProperty("hibernate.show_sql","true");
			setProperty("hibernate.hbm2ddl.import_files","import.sql");
			
		}
	}	;
	
	}
	
	

}
