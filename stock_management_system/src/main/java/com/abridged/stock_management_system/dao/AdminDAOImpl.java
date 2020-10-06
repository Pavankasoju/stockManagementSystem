package com.abridged.stock_management_system.dao;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.abridged.stock_management_system.dto.Admin;

/**
 * This is AdminDAO interface and here we declared methods
 * 
 * @author  
 */

@Repository
public class AdminDAOImpl implements AdminDAO {

	@PersistenceUnit
	private EntityManagerFactory factory;

	/**
	 * This method is used to do admin login
	 * 
	 * @param username {@code String}, password {@code String}
	 * @return {@code true} if login successfully , otherwise {@code false}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean adminLogin(String username, String password) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "Select admin from Admin admin";
		Query query = manager.createQuery(jpql);
		List<Admin> list = query.getResultList();
		int count = 0;
		for (Admin info : list) {
			if (info.getUsername().contentEquals(username) && info.getPassword().contentEquals(password))
				count = 1;
		}
		manager.close();
		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}

}
