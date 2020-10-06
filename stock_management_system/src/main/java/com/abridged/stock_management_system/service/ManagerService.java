package com.abridged.stock_management_system.service;

import java.util.List;

import com.abridged.stock_management_system.dto.Manager;
import com.abridged.stock_management_system.dto.CompanyResponse;
import com.abridged.stock_management_system.dto.LoginResponse;

/**
 * This is CompanyManagerService interface and here we declared methods
 * 
 * @author 
 */
public interface ManagerService {

	/**
	 * This method is used to call managerLogin method
	 * 
	 * @param managerId {@code String}, password {@code String},response
	 *                  {@code Object}
	 * @return {@code true} if login successfully , otherwise {@code false}
	 */

	boolean managerLogin(String managerId, String password, LoginResponse response);

	/**
	 * This method is used to call forgot password method
	 * 
	 * @param managerId {@code String}, password {@code String}, mobileNo
	 *                  {@code String}
	 * @return {@code true} if password set successfully , otherwise {@code false}
	 */
	boolean managerForgotPassword(String managerId, String password, String mobileNo, LoginResponse response);

	/**
	 * This method is used to call addCompanyManagerInfo() method
	 * 
	 * @param info {@code Object}
	 * @return {@code true} if details added successfully , otherwise {@code false}
	 */
	boolean addManager(Manager info, CompanyResponse response);

	/**
	 * This method is used to call getAllCompanyManagerInfo() method
	 * 
	 * @param nothing
	 * @return {@code List<Manager>} if details are present , otherwise {@code null}
	 */
	List<Manager> getAllManager();

	/**
	 * This method is used to call getCompanyManagerDetails() method
	 * 
	 * @param managerId {@code String}, response {@code Object}
	 * @return {@code Object} if details are present , otherwise {@code null}
	 */
	Manager getManager(String managerId, CompanyResponse response);

	/**
	 * This method is used to call updateCompanyManagerInfo() method
	 * 
	 * @param info {@code Object}, response {@code Object}
	 * @return {@code true} if details are updated , otherwise {@code false}
	 */
	boolean updateManager(Manager info, CompanyResponse response);

	/**
	 * This method is used to call deleteCompanyManagerInfo() method
	 * 
	 * @param info {@code Object},response {@code Object}
	 * @return {@code true} if details are deleted , otherwise {@code false}
	 */
	boolean deleteManager(String managerId, CompanyResponse response);

	/**
	 * This method is used to call updateStockPrice method
	 * 
	 * @param companyId {@code String}, updatedPrice {@code double}
	 * @return {@code true} if Stock Price Updated Successfully , otherwise
	 *         {@code false}
	 */
	boolean updateStockPrice(String companyId, double updatedPrice);

	/**
	 * This method is used to call checkManagerId method
	 * 
	 * @param managerId {@code String}
	 * @return {@code true} if managerId is present , otherwise {@code false}
	 */
	boolean checkManagerID(String managerId);

}
