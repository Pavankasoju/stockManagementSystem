package com.abridged.stock_management_system.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

/**
 * This is EntityManagerFactoryConfig Class
 * 
 * @author
 */

@Configuration
public class EntityManagerFactoryConfig {

	/**
	 * This is helps to create a JPA javax.persistence.EntityManagerFactory
	 * according to JPA's standard container
	 * 
	 * @param nothing
	 * @return factoryBean
	 */
	
	@Bean
	public LocalContainerEntityManagerFactoryBean getEntityManager() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("cherry");
		return factoryBean;
	}
	
}
