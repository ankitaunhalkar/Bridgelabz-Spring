package com.bridgelabz.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.bridgelabz.dao.UserDao;
import com.bridgelabz.dao.UserDaoImpl;
import com.bridgelabz.interceptor.RegisterInterceptor;
import com.bridgelabz.service.UserServices;
import com.bridgelabz.service.UserServicesImpl;

@EnableWebMvc
@Configuration
@PropertySource(value = {"classpath:application.properties"})
@ComponentScan(basePackages = {"com.bridgelabz"})
public class ServletConfig extends WebMvcConfigurerAdapter{
	 @Autowired
	   private Environment env;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean
    public InternalResourceViewResolver jspViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setPrefix("/WEB-INF/views/");
        bean.setSuffix(".jsp");
        return bean;
    }
	
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	registry.addInterceptor(new RegisterInterceptor()).addPathPatterns("/registerProcess");
    }
    
    @Bean
    public UserDao userDao() {
    	return new UserDaoImpl();
    }
   
    @Bean
    public UserServices userServices() {
    	return new UserServicesImpl();
    }
    
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
    	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);	
		return jdbcTemplate;
    	
    }
    
    @Bean
    public DataSource dataSource() {
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
    	dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
    	dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
    	dataSource.setUsername(env.getRequiredProperty("jdbc.username"));
    	dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
    	return dataSource;
    }
}
