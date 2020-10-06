package com.abridged.stock_management_system.dao;

import java.util.List;

import com.abridged.stock_management_system.dto.Company;

/**
 * This is CompanyDAO interface and here we declared methods
 * 
 * @author 
 */
public interface CompanyDAO {

	/**
	 * This method is used to add company information
	 * 
	 * @param info {@code Object}
	 * @return {@code true} if details added successfully , otherwise {@code false}
	 */
	boolean addCompanyInfo(Company info);

	/**
	 * This method is used to get all company information
	 * 
	 * @param nothing
	 * @return {@code List<CompanyInfo>} if details are present , otherwise
	 *         {@code null}
	 */
	List<Company> getAllCompanyInfo();

	/**
	 * This method is used to get company information
	 * 
	 * @param companyId {@code String}
	 * @return {@code Object} if details are present , otherwise {@code null}
	 */
	Company getCompanyDetails(String companyId);

	/**
	 * This method is used to update company information
	 * 
	 * @param info {@code Object}
	 * @return {@code true} if details are updated , otherwise {@code false}
	 */
	boolean updateCompanyInfo(Company info);

	/**
	 * This method is used to delete company information
	 * 
	 * @param info {@code Object}
	 * @return {@code true} if details are deleted , otherwise {@code false}
	 */
	boolean deleteCompanyInfo(String companyId);

	/**
	 * This method is used to check companyId
	 * 
	 * @param companyId {@code String}
	 * @return {@code true} if companyId is present , otherwise {@code false}
	 */
	boolean checkCompanyID(String companyId);

}
