package com.abridged.stock_management_system.service;

import java.util.List;

import com.abridged.stock_management_system.dto.Investor;
import com.abridged.stock_management_system.dto.InvestorResponse;
import com.abridged.stock_management_system.dto.LoginResponse;

/**
 * This is InvestorService interface where we declared methods
 * 
 * @author 
 */
public interface InvestorService {

	/**
	 * This method is used to call investorLogin method
	 * 
	 * @param username {@code String}, password {@code String}, response
	 *                 {@code Object}
	 * @return {@code true} if login successfully , otherwise {@code false}
	 */
	boolean investorLogin(String investorId, String password, LoginResponse response);

	/**
	 * This method is used to call forgot password method
	 * 
	 * @param investorId {@code String} password {@code String}, mobileNo
	 *                   {@code String}, response {@code Object}
	 * @return {@code true} if password set successfully , otherwise {@code false}
	 */
	boolean investorForgotPassword(String investorId, String password, String mobileNo, LoginResponse response);

	/**
	 * This method is used to call addInvestorInfo() method
	 * 
	 * @param info {@code Object}, response {@code Object}
	 * @return {@code true} if details added successfully , otherwise {@code false}
	 */
	boolean addInvestor(Investor info, InvestorResponse response);

	/**
	 * This method is used to call getAllInvestorInfo() method
	 * 
	 * @param nothing
	 * @return {@code List<Investor>} if details are present , otherwise
	 *         {@code null}
	 */
	List<Investor> getAllInvestor();

	/**
	 * This method is used to call getInvestorDetails() method
	 * 
	 * @param investorId {@code String}, response {@code Object}
	 * @return {@code Object} if details are present , otherwise {@code null}
	 */
	Investor getInvestorDetails(String investorId, InvestorResponse response);

	/**
	 * This method is used to call updateInvestorInfo() method
	 * 
	 * @param info {@code Object}, response {@code Object}
	 * @return {@code true} if details are updated , otherwise {@code false}
	 */
	boolean updateInvestor(Investor info, InvestorResponse response);

	/**
	 * This method is used to call deleteInvestorInfo() method
	 * 
	 * @param investorId {@code String}, response {@code Object}
	 * @return {@code true} if details are deleted , otherwise {@code false}
	 */
	boolean deleteInvestor(String investorId, InvestorResponse response);

	/**
	 * This method is used to call checkInvestorID method
	 * 
	 * @param investorId {@code String}
	 * @return {@code true} if investorId is present , otherwise {@code false}
	 */
	boolean checkInvestorID(String investorId);
}
