package com.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;

@Configuration
public class JavaConfig {
	
     @Bean("ds")
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/ecommdb");
		ds.setUsername("root");
		ds.setPassword("");
		return ds;
	}
     
     @Bean("jdbcTemplate")
    public JdbcTemplate getTemplete() {
    	JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
    	return jdbcTemplate;
    }
     
     @Bean("studentDao")
    public StudentDao getDao() {
    	StudentDaoImpl dao = new StudentDaoImpl();
    	dao.setJdbcTemplate(getTemplete());
        return dao;
    }
    
}
