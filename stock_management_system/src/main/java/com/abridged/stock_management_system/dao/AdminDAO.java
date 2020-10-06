package com.abridged.stock_management_system.dao;

/**
 * This is AdminDAO interface and here we declared methods
 * 
 * @author 
 */
public interface AdminDAO {

	/**
	 * This method is used to do admin login
	 * 
	 * @param username {@code String}, password {@code String}
	 * @return {@code true} if login successfully , otherwise {@code false}
	 */
	boolean adminLogin(String username, String password);
}
