package com.example.demo.transaction.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


//import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
//https://dzone.com/articles/spring-boot-jpa-mysql-sample-app-code-example
//https://howtodoinjava.com/spring-boot2/datasource-configuration/
//https://github.com/spring-projects/spring-boot
//https://dzone.com/articles/spring-boot-transaction-management-hello-world-exa   sql statements

//https://docs.spring.io/spring/docs/3.0.x/spring-framework-reference/html/transaction.html
class ApplicationConfig {
	 @Value("${spring.datasource.driverClassName}") String driverClassName;
	    @Value("${spring.datasource.url}") String url;
	    @Value("${spring.datasource.username}") String username;
	    @Value("${spring.datasource.password}") String password;

	    
	    //I have used this method to create the datasource as I am using HikariCP which gets included in the classpath as part of the spring-boot-starter-data-jpa dependency in pom.xml
	    @Bean(name = "dataSource")
	    public DataSource getDataSource() {
	        DataSource dataSource = DataSourceBuilder
	                .create()
	                .username(username)
	                .password(password)
	                .url(url)
	                .driverClassName(driverClassName)
	                .build();
	    	
	    	
	        return dataSource;
	    }
	
	    
	    //https://netjs.blogspot.com/2018/08/connection-pooling-with-apache-dbcp-spring-example.html
	    //Enable this method when u r using dbcp jar for datasource and when u adding commons-dbcp2 as dependency in the pom.xml
//	    @Bean
//	    public BasicDataSource getDataSource(){
//	    	BasicDataSource ds = new BasicDataSource();
//	     
//	     //ds.setDriverClassName("com.mysql.jdbc.Driver");
//	     ds.setDriverClassName(driverClassName);
//	     ds.setUrl(url);
//	     ds.setUsername(username);
//	     ds.setPassword(password);
//	    
//	     return ds;
//	    }
	    
	    
	    
	    //https://docs.spring.io/spring/docs/3.0.x/spring-framework-reference/html/transaction.html#transaction-programmatic
//https://dzone.com/articles/how-does-spring-transactional
  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    vendorAdapter.setGenerateDdl(true);

    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
    factory.setJpaVendorAdapter(vendorAdapter);
    factory.setPackagesToScan("com");
    factory.setDataSource(getDataSource());
    return factory;
  }

  //https://www.javacodegeeks.com/2016/05/understanding-transactional-annotation-spring.html
  @Bean
  public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {

    JpaTransactionManager txManager = new JpaTransactionManager();
    txManager.setEntityManagerFactory(entityManagerFactory);
    return txManager;
  }
  
  //https://dzone.com/articles/spring-transaction-management
//  @Bean
//  public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//
//    TransactionManager txManager = (TransactionManager) new DataSourceTransactionManager();
//    txMan
//    return txManager;
//  }
  
}
