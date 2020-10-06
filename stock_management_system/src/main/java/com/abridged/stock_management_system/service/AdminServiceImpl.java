package com.abridged.stock_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abridged.stock_management_system.dao.AdminDAO;
import com.abridged.stock_management_system.dto.LoginResponse;
import com.abridged.stock_management_system.validation.InputValidation;
import com.abridged.stock_management_system.validation.InputValidationImpl;

/**
 * This is AdminService interface and here we declared methods
 * 
 * @author 
 */

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO adminDAO;

	static InputValidation inputValidation = new InputValidationImpl();

	/**
	 * This method is used to call adminLogin method
	 * 
	 * @param username {@code String}, password {@code String},response
	 *                 {@code Object}
	 * @return {@code true} if login successfully , otherwise {@code false}
	 */
	@Override
	public boolean adminLogin(String username, String password, LoginResponse response) {
		String validUsername = null;
		String validPassword = null;
		boolean flag1 = false;
		boolean flag2 = false;
		if (inputValidation.usernameValidation(username)) {
			validUsername = username;
			flag1 = true;
		} else {
			response.setUsernameMessage("You can use _ , numbers, alphabets)\n");
		}
		if (inputValidation.passwordValidation(password)) {
			validPassword = password;
			flag2 = true;
		} else {
			response.setPasswordMessage(
					"Password must contain alphabets, numbers, one symbol and length should be 6-16)\n");
		}
		if (flag1 && flag2) {
			return adminDAO.adminLogin(validUsername, validPassword);
		} else {
			response.setStatusCode(401);
			response.setMessage("Please check username or password");
		}
		return false;
	}

}
