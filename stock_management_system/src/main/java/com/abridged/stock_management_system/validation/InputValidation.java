package com.abridged.stock_management_system.validation;

/**
 * This is InputValidation interface and here we declared methods
 * 
 * @author 
 */
public interface InputValidation {

	/**
	 * This method is used to validate username
	 * 
	 * @param username {@code String}
	 * @return {@code true} if username matches, otherwise {@code false}
	 */
	public boolean usernameValidation(String username);

	/**
	 * This method is used to validate password
	 * 
	 * @param password {@code String}
	 * @return {@code true} if password matches, otherwise {@code false}
	 */
	public boolean passwordValidation(String password);

	/**
	 * This method is used to validate name
	 * 
	 * @param name {@code String}
	 * @return {@code true} if name matches, otherwise {@code false}
	 */
	public boolean nameValidation(String name);

	/**
	 * This method is used to validate email
	 * 
	 * @param email {@code String}
	 * @return {@code true} if email matches, otherwise {@code false}
	 */
	public boolean emailValidation(String email);

	/**
	 * This method is used to validate contactNumber
	 * 
	 * @param contactNumber {@code String}
	 * @return {@code true} if contactNumber matches, otherwise {@code false}
	 */
	public boolean contactNumberValidation(String contactNumber);

	/**
	 * This method is used to validate date
	 * 
	 * @param date {@code String}
	 * @return {@code true} if date matches, otherwise {@code false}
	 */
	public boolean dateValidation(String date);

	/**
	 * This method is used to validate string
	 * 
	 * @param choice {@code String}
	 * @return {@code true} if string matches, otherwise {@code false}
	 */
	public boolean stringValidation(String choice);

	/**
	 * This method is used to validate srNo1
	 * 
	 * @param srNo1 {@code String}
	 * @return {@code true} if srNo1 matches, otherwise {@code false}
	 */
	public boolean numberValidation(String srNo1);
}
