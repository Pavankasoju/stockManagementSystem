package com.abridged.stock_management_system.dao;

import java.util.List;

import com.abridged.stock_management_system.dto.Manager;

/**
 * This is CompanyManagerDAO interface and here we declared methods
 * 
 * @author 
 */
public interface ManagerDAO {

	/**
	 * This method is used for managerLogin method
	 * 
	 * @param managerId {@code String}, password {@code String}
	 * @return {@code true} if login successfully , otherwise {@code false}
	 */
	boolean managerLogin(String managerId, String password);

	/**
	 * This method is used for forgot password method
	 * 
	 * @param managerId {@code String}, password {@code String}, mobileNo
	 *                  {@code String}
	 * @return {@code true} if password set successfully , otherwise {@code false}
	 */
	boolean managerForgotPassword(String managerId, String password, String mobileNo);

	/**
	 * This method is used to add company manager information
	 * 
	 * @param info {@code Object}
	 * @return {@code true} if details added successfully , otherwise {@code false}
	 */
	boolean addManager(Manager info);

	/**
	 * This method is used to get all company manager information
	 * 
	 * @param nothing
	 * @return {@code List<ManagerInfo>} if details are present , otherwise
	 *         {@code null}
	 */
	List<Manager> getAllManager();

	/**
	 * This method is used to get company manager information
	 * 
	 * @param managerId {@code String}
	 * @return {@code Object} if details are present , otherwise {@code null}
	 */
	Manager getManagerDetails(String managerId);

	/**
	 * This method is used to update company manager information
	 * 
	 * @param info {@code Object}
	 * @return {@code true} if details are updated , otherwise {@code false}
	 */
	boolean updateManager(Manager info);

	/**
	 * This method is used to delete company manager information
	 * 
	 * @param info {@code Object}
	 * @return {@code true} if details are deleted , otherwise {@code false}
	 */
	boolean deleteManager(String managerId);

	/**
	 * This method is used to update Stock Price and also update percentage change
	 * 
	 * @param companyId {@code String}, updatedPrice {@code double}
	 * @return {@code true} if Stock Price Updated Successfully , otherwise
	 *         {@code false}
	 */
	boolean updateStockPrice(String companyId, double updatedPrice);

	/**
	 * This method is used to check managerId
	 * 
	 * @param managerId {@code String}
	 * @return {@code true} if managerId is present , otherwise {@code false}
	 */
	boolean checkManagerID(String managerId);

}
