package com.abridged.stock_management_system.dao;

import java.util.List;

import com.abridged.stock_management_system.dto.Investor;

/**
 * This is InvestorDAO interface where we declared methods
 * 
 * @author  
 */
public interface InvestorDAO {

	/**
	 * This method is used to call investorLogin method
	 * 
	 * @param investorId {@code String}, password {@code String}
	 * @return {@code true} if login successfully , otherwise {@code false}
	 */
	boolean investorLogin(String investorId, String password);

	/**
	 * This method is used for forgot password method
	 * 
	 * @param investorId {@code String} password {@code String}, mobileNo
	 *                   {@code String}
	 * @return {@code true} if password set successfully , otherwise {@code false}
	 */
	boolean investorForgotPassword(String investorId, String password, String mobileNo);

	/**
	 * This method is used to add investor information
	 * 
	 * @param info {@code Object}
	 * @return {@code true} if details added successfully , otherwise {@code false}
	 */
	boolean addInvestor(Investor info);

	/**
	 * This method is used to get all investor information
	 * 
	 * @param nothing
	 * @return {@code List<InvestorInfo>} if details are present , otherwise
	 *         {@code null}
	 */
	List<Investor> getAllInvestor();

	/**
	 * This method is used to get investor information
	 * 
	 * @param investorId {@code String}
	 * @return {@code Object} if details are present , otherwise {@code null}
	 */
	Investor getInvestorDetails(String investorId);

	/**
	 * This method is used to update investor information
	 * 
	 * @param info {@code Object}
	 * @return {@code true} if details are updated , otherwise {@code false}
	 */
	boolean updateInvestor(Investor info);

	/**
	 * This method is used to delete investor information
	 * 
	 * @param investorId {@code it}
	 * @return {@code true} if details are deleted , otherwise {@code false}
	 */
	boolean deleteInvestor(String investorId);

	/**
	 * This method is used to check investorId
	 * 
	 * @param investorId {@code String}
	 * @return {@code true} if investorId is present , otherwise {@code false}
	 */
	boolean checkInvestorID(String investorId);

}
