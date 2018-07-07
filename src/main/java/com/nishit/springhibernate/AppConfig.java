/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nishit.springhibernate;

import com.nishit.springhibernate.entity.Feedback;
import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Nishit-TCS
 */
@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.nishit.springhibernate.service", "com.nishit.springhibernate.DAO" })
public class AppConfig {
    
    @Autowired
    private Environment env;
    
    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
        Properties prop = new Properties();
        
        prop.put("hibernate.connection.driver_class", env.getProperty("hibernate.connection.driver_class"));
        prop.put("hibernate.connection.url", env.getProperty("hibernate.connection.url"));
        prop.put("hibernate.connection.username", env.getProperty("hibernate.connection.username"));
        prop.put("hibernate.connection.password", env.getProperty("hibernate.connection.password"));
        
        prop.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        prop.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        prop.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        
        prop.put("hibernate.c3p0.min_size", env.getProperty("hibernate.c3p0.min_size"));
        prop.put("hibernate.c3p0.max_size", env.getProperty("hibernate.c3p0.max_size"));
        prop.put("hibernate.c3p0.acquire_increment", env.getProperty("hibernate.c3p0.acquire_increment"));
        prop.put("hibernate.c3p0.timeout", env.getProperty("hibernate.c3p0.timeout"));
        prop.put("hibernate.c3p0.max_statements", env.getProperty("hibernate.c3p0.max_statements"));
        
        bean.setHibernateProperties(prop);
        bean.setAnnotatedClasses(Feedback.class);
        return bean;
    }
    
    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager tx = new HibernateTransactionManager();
        tx.setSessionFactory(getSessionFactory().getObject());
        return tx;
    }
}
