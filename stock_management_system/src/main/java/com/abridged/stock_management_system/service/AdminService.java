package com.abridged.stock_management_system.service;

import com.abridged.stock_management_system.dto.LoginResponse;

/**
 * This is AdminService interface and here we declared methods
 * 
 * @author 
 */
public interface AdminService {

	/**
	 * This method is used to call adminLogin method
	 * 
	 * @param username {@code String}, password {@code String} ,response
	 *                 {@code Object}
	 * @return {@code true} if login successfully , otherwise {@code false}
	 */

	boolean adminLogin(String username, String password, LoginResponse response);
}
