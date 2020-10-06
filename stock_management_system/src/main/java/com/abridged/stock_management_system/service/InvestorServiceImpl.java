	package com.abridged.stock_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abridged.stock_management_system.dao.InvestorDAO;
import com.abridged.stock_management_system.dto.Investor;
import com.abridged.stock_management_system.dto.InvestorResponse;
import com.abridged.stock_management_system.dto.LoginResponse;
import com.abridged.stock_management_system.validation.InputValidation;
import com.abridged.stock_management_system.validation.InputValidationImpl;

/**
 * This is InvestorServiceImpl class which implements InvestorService interface
 * 
 * @author  
 */
@Service
public class InvestorServiceImpl implements InvestorService {

	@Autowired
	private InvestorDAO investorDAO;

	static InputValidation inputValidation = new InputValidationImpl();

	/**
	 * This method is used to call investorLogin method
	 * 
	 * @param username {@code String}, password {@code String}, response
	 *                 {@code Object}
	 * @return {@code true} if login successfully , otherwise {@code false}
	 */
	@Override
	public boolean investorLogin(String investorId, String password, LoginResponse response) {
		String validInvestorId = null;
		String validPassword = null;
		boolean flag1 = false;
		boolean flag2 = false;
		if (inputValidation.numberValidation(investorId)) {
			validInvestorId = investorId;
			flag1 = true;
		} else {
			response.setIdMessage("Investor ID should contains only numbers");
		}
		if (inputValidation.passwordValidation(password)) {
			validPassword = password;
			flag2 = true;
		} else {
			response.setPasswordMessage(
					"Password must contain alphabets, numbers, one symbol and length should be 6-16");
		}
		if (flag1 && flag2) {
			return investorDAO.investorLogin(validInvestorId, validPassword);
		} else {
			response.setStatusCode(401);
			response.setMessage("Please check investor ID or password");
		}
		return false;
	}

	/**
	 * This method is used to call forgot password method
	 * 
	 * @param investorId {@code String} password {@code String}, mobileNo
	 *                   {@code String}, response {@code Object}
	 * @return {@code true} if password set successfully , otherwise {@code false}
	 */
	@Override
	public boolean investorForgotPassword(String investorId, String password, String mobileNo, LoginResponse response) {
		String validInvestorId = null;
		String validPassword = null;
		String validMobileNo = null;
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		if (inputValidation.numberValidation(investorId)) {
			validInvestorId = investorId;
			flag1 = true;
		} else {
			response.setIdMessage("Investor ID should contains only numbers");
		}
		if (inputValidation.passwordValidation(password)) {
			validPassword = password;
			flag2 = true;
		} else {
			response.setPasswordMessage(
					"Password must contain alphabets, numbers, one symbol and length should be 6-16");
		}
		if (inputValidation.contactNumberValidation(mobileNo)) {
			validMobileNo = mobileNo;
			flag3 = true;
		} else {
			response.setMobileNoMessage("Contact Number must 10 digits and start with 7 or 8 or 9");
		}
		if (flag1 && flag2 && flag3) {
			return investorDAO.investorForgotPassword(validInvestorId, validPassword, validMobileNo);
		} else {
			response.setStatusCode(401);
			response.setMessage("Please check Investor ID or password");
		}
		return false;
	}

	/**
	 * This method is used to call addInvestorInfo() method
	 * 
	 * @param info {@code Object}, response {@code Object}
	 * @return {@code true} if details added successfully , otherwise {@code false}
	 */
	@Override
	public boolean addInvestor(Investor info, InvestorResponse response) {
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		boolean flag4 = false;
		boolean flag5 = false;
		if (inputValidation.numberValidation(info.getInvestorId())) {
			info.setInvestorId(info.getInvestorId());
			flag1 = true;
		} else {
			response.setInvestorIdMessage("Investor ID should contains only numbers");
		}
//		if (inputValidation.nameValidation(info.getInvestorName())) {
			info.setInvestorName(info.getInvestorName());
			flag2 = true;
//		} else {
//			response.setInvestorNameMessage("Please enter only alphabets");
//		}
		if (inputValidation.emailValidation(info.getEmail())) {
			info.setEmail(info.getEmail());
			flag3 = true;
		} else {
			response.setEmailMessage("Please enter valid  email (Ex:abc@gmail.com)");
		}
		if (inputValidation.contactNumberValidation(info.getMobileNo())) {
			info.setMobileNo(info.getMobileNo());
			flag4 = true;
		} else {
			response.setMobileNoMessage("Contact Number must 10 digits and start with 7 or 8 or 9");
		}
		if (inputValidation.passwordValidation(info.getPassword())) {
			info.setPassword(info.getPassword());
			flag5 = true;
		} else {
			response.setPasswordMessage(
					"Password must contain alphabets, numbers, one symbol and length should be 6-16");
		}
		if (flag1 && flag2 && flag3 && flag4 && flag5) {
			return investorDAO.addInvestor(info);
		} else {
			response.setStatusCode(401);
			response.setMessage("Please Check Your Details");
		}
		return false;
	}

	/**
	 * This method is used to call getAllInvestorInfo() method
	 * 
	 * @param nothing
	 * @return {@code List<Investor} if details are present , otherwise {@code null}
	 */
	@Override
	public List<Investor> getAllInvestor() {
		return investorDAO.getAllInvestor();
	}

	/**
	 * This method is used to call getInvestorDetails() method
	 * 
	 * @param investorId {@code String}, response {@code Object}
	 * @return {@code Object} if details are present , otherwise {@code null}
	 */
	@Override
	public Investor getInvestorDetails(String investorId, InvestorResponse response) {
		boolean flag = false;
		String validInvestorId = null;
		if (inputValidation.numberValidation(investorId)) {
			validInvestorId = investorId;
			flag = true;
		} else {
			response.setInvestorIdMessage("Investor ID should contains only numbers");
		}
		if (flag) {
			return investorDAO.getInvestorDetails(validInvestorId);
		} else {
			response.setStatusCode(401);
			response.setMessage("Please check your details");
		}
		return null;
	}

	/**
	 * This method is used to call updateInvestorInfo() method
	 * 
	 * @param info {@code Object}, response {@code Object}
	 * @return {@code true} if details are updated , otherwise {@code false}
	 */
	@Override
	public boolean updateInvestor(Investor info, InvestorResponse response) {
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		boolean flag4 = false;
		boolean flag5 = false;
		if (inputValidation.numberValidation(info.getInvestorId())) {
			info.setInvestorId(info.getInvestorId());
			flag1 = true;
		} else {
			response.setInvestorIdMessage("Investor ID should contains only numbers");
		}
		if (inputValidation.nameValidation(info.getInvestorName())) {
			info.setInvestorName(info.getInvestorName());
			flag2 = true;
		} else {
			response.setInvestorNameMessage("Please enter only alphabets");
		}
		if (inputValidation.emailValidation(info.getEmail())) {
			info.setEmail(info.getEmail());
			flag3 = true;
		} else {
			response.setEmailMessage("Please enter valid  email (Ex:abc@gmail.com)");
		}
		if (inputValidation.contactNumberValidation(info.getMobileNo())) {
			info.setMobileNo(info.getMobileNo());
			flag4 = true;
		} else {
			response.setMobileNoMessage("Contact Number must 10 digits and start with 7 or 8 or 9");
		}
		if (inputValidation.passwordValidation(info.getPassword())) {
			info.setPassword(info.getPassword());
			flag5 = true;
		} else {
			response.setPasswordMessage(
					"Password must contain alphabets, numbers, one symbol and length should be 6-16");
		}
		if (flag1 && flag2 && flag3 && flag4 && flag5) {
			return investorDAO.updateInvestor(info);
		} else {
			response.setStatusCode(401);
			response.setMessage("Please Check Your Details");
		}
		return false;
	}

	/**
	 * This method is used to call deleteInvestorInfo() method
	 * 
	 * @param investorId {@code String}, response {@code Object}
	 * @return {@code true} if details are deleted , otherwise {@code false}
	 */
	@Override
	public boolean deleteInvestor(String investorId, InvestorResponse response) {
		boolean flag = false;
		String validInvestorId = null;
		if (inputValidation.numberValidation(investorId)) {
			validInvestorId = investorId;
			flag = true;
		} else {
			response.setInvestorIdMessage("Investor ID should contains only numbers");
		}
		if (flag) {
			return investorDAO.deleteInvestor(validInvestorId);
		} else {
			response.setStatusCode(401);
			response.setMessage("Please check your details");
		}
		return false;
	}

	/**
	 * This method is used to call checkInvestorID method
	 * 
	 * @param investorId {@code String}
	 * @return {@code true} if investorId is present , otherwise {@code false}
	 */
	@Override
	public boolean checkInvestorID(String investorId) {
		return investorDAO.checkInvestorID(investorId);
	}

}
