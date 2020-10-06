package com.abridged.stock_management_system.validation;

import java.util.regex.Matcher;

import java.util.regex.Pattern;

/**
 * This is InputValidationImplementation class and implements InputValidation
 * 
 * @author 
 */
public class InputValidationImpl implements InputValidation {

	Pattern pattern = null;
	Matcher match = null;

	/**
	 * This method is used to validate username
	 * 
	 * @param username {@code String}
	 * @return {@code true} if username matches, otherwise {@code false}
	 */
	@Override
	public boolean usernameValidation(String username) {
		pattern = Pattern.compile("^[a-z0-9_-]{3,15}$");
		match = pattern.matcher(username);
		return match.matches();
	}

	/**
	 * This method is used to validate password
	 * 
	 * @param password {@code String}
	 * @return {@code true} if password matches, otherwise {@code false}
	 */
	@Override
	public boolean passwordValidation(String password) {
		pattern = Pattern.compile("^(?=.*[0-9]).{8,15}$");
		match = pattern.matcher(password);
		return match.matches();
	}

	/**
	 * This method is used to validate name
	 * 
	 * @param name {@code String}
	 * @return {@code true} if name matches, otherwise {@code false}
	 */
	@Override
	public boolean nameValidation(String name) {
		pattern = Pattern.compile("[A-z][a-z]*+\\s[A-z][a-z]*+");
		match = pattern.matcher(name);
		return match.matches();
	}

	/**
	 * This method is used to validate email
	 * 
	 * @param email {@code String}
	 * @return {@code true} if email matches, otherwise {@code false}
	 */
	@Override
	public boolean emailValidation(String email) {
		pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@([a-z].+[com|in])$");
		match = pattern.matcher(email);
		return match.matches();
	}

	/**
	 * This method is used to validate contactNumber
	 * 
	 * @param contactNumber {@code String}
	 * @return {@code true} if contactNumber matches, otherwise {@code false}
	 */
	@Override
	public boolean contactNumberValidation(String contactNumber) {
		pattern = Pattern.compile("[7-9][0-9]{9}");
		match = pattern.matcher(contactNumber);
		return match.matches();
	}

	/**
	 * This method is used to validate date
	 * 
	 * @param date {@code String}
	 * @return {@code true} if date matches, otherwise {@code false}
	 */
	@Override
	public boolean dateValidation(String date) {
		pattern = Pattern.compile("[0-9]{4}-(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])$");
		match = pattern.matcher(date);
		return match.matches();
	}

	/**
	 * This method is used to validate string
	 * 
	 * @param choice {@code String}
	 * @return {@code true} if string matches, otherwise {@code false}
	 */
	@Override
	public boolean stringValidation(String choice) {
		pattern = Pattern.compile("([A-Za-z].*)$");
		match = pattern.matcher(choice);
		return match.matches();
	}

	/**
	 * This method is used to validate srNo1
	 * 
	 * @param srNo1 {@code String}
	 * @return {@code true} if srNo1 matches, otherwise {@code false}
	 */
	@Override
	public boolean numberValidation(String srNo1) {
		pattern = Pattern.compile("^\\d+(\\.\\d+)?");
		match = pattern.matcher(srNo1);
		return match.matches();
	}

}
