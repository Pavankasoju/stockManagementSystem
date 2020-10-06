package com.abridged.stock_management_system.service;

import java.util.List;

import com.abridged.stock_management_system.dto.CompanyResponse;
import com.abridged.stock_management_system.dto.Company;

/**
 * This is CompanyService interface and here we declared methods
 * 
 * @author  
 */
public interface CompanyService {

	/**
	 * This method is used to call addCompanyInfo() method
	 * 
	 * @param info {@code Object}, response {@code Object}
	 * @return {@code true} if details added successfully , otherwise {@code false}
	 */
	boolean addCompany(Company info, CompanyResponse response);

	/**
	 * This method is used to call getAllCompanyInfo() method
	 * 
	 * @param nothing
	 * @return {@code List<Company>} if details are present , otherwise {@code null}
	 */
	List<Company> getAllCompany();

	/**
	 * This method is used to call getCompanyDetails() method
	 * 
	 * @param companyId {@code String}
	 * @return {@code Object} if details are present , otherwise {@code null}
	 */
	Company getCompanyDetails(String companyId, CompanyResponse response);

	/**
	 * This method is used to call updateCompanyInfo() method
	 * 
	 * @param info {@code Object}
	 * @return {@code true} if details are updated , otherwise {@code false}
	 */
	boolean updateCompany(Company info, String companyId, CompanyResponse response);

	/**
	 * This method is used to call deleteCompanyInfo() method
	 * 
	 * @param companyId {@code String}
	 * @return {@code true} if details are deleted , otherwise {@code false}
	 */
	boolean deleteCompany(String companyId, CompanyResponse response);

	/**
	 * This method is used to call checkCompanyID method
	 * 
	 * @param companyId {@code String}
	 * @return {@code true} if companyId is present , otherwise {@code false}
	 */
	boolean checkCompanyID(String companyId);
}
