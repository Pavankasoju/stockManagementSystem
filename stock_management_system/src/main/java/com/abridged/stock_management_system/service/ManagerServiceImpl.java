package com.abridged.stock_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abridged.stock_management_system.dao.ManagerDAO;
import com.abridged.stock_management_system.dto.Manager;
import com.abridged.stock_management_system.dto.CompanyResponse;
import com.abridged.stock_management_system.dto.LoginResponse;
import com.abridged.stock_management_system.validation.InputValidation;
import com.abridged.stock_management_system.validation.InputValidationImpl;

/**
 * This is CompanyManagerServiceImpl class which implements
 * CompanyManagerService interface
 * 
 * @author 
 */
@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerDAO managerDAO;

	static InputValidation inputValidation = new InputValidationImpl();

	/**
	 * This method is used to call managerLogin method
	 * 
	 * @param managerId {@code String}, password {@code String},response
	 *                  {@code Object}
	 * @return {@code true} if login successfully , otherwise {@code false}
	 */
	@Override
	public boolean managerLogin(String managerId, String password, LoginResponse response) {
		String validManagerId = null;
		String validPassword = null;
		boolean flag1 = false;
		boolean flag2 = false;
		if (inputValidation.numberValidation(managerId)) {
			validManagerId = managerId;
			flag1 = true;
		} else {
			response.setIdMessage("Manager ID should contains only numbers");
		}
		if (inputValidation.passwordValidation(password)) {
			validPassword = password;
			flag2 = true;
		} else {
			response.setPasswordMessage(
					"Password must contain alphabets, numbers, one symbol and length should be 6-16");
		}
		if (flag1 && flag2) {
			return managerDAO.managerLogin(validManagerId, validPassword);
		} else {
			response.setStatusCode(401);
			response.setMessage("Please check manager ID or password");
		}
		return false;
	}

	/**
	 * This method is used to call forgot password method
	 * 
	 * @param managerId {@code String}, password {@code String}, mobileNo
	 *                  {@code long}
	 * @return {@code true} if password set successfully , otherwise {@code false}
	 */
	@Override
	public boolean managerForgotPassword(String managerId, String password, String mobileNo, LoginResponse response) {
		String validManagerId = null;
		String validPassword = null;
		String validMobileNo = null;
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		if (inputValidation.numberValidation(managerId)) {
			validManagerId = managerId;
			flag1 = true;
		} else {
			response.setIdMessage("Manager ID should contains only numbers");
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
			return managerDAO.managerForgotPassword(validManagerId, validPassword, validMobileNo);
		} else {
			response.setStatusCode(401);
			response.setMessage("Please check manager ID or password");
		}
		return false;
	}

	/**
	 * This method is used to call addCompanyManagerInfo() method
	 * 
	 * @param info {@code Object}
	 * @return {@code true} if details added successfully , otherwise {@code false}
	 */
	@Override
	public boolean addManager(Manager info, CompanyResponse response) {
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		boolean flag4 = false;
		boolean flag5 = false;
		boolean flag6 = false;
		boolean flag7 = false;
		if (inputValidation.numberValidation(info.getCompanyId())) {
			info.setCompanyId(info.getCompanyId());
			flag1 = true;
		} else {
			response.setCompanyIdMessage("Company ID should contains only numbers");
		}
		if (inputValidation.stringValidation(info.getCompanyName())) {
			info.setCompanyName(info.getCompanyName());
			flag2 = true;
		} else {
			response.setCompanyNameMessage("Please enter only alphabets");
		}
		if (inputValidation.numberValidation(info.getManagerId())) {
			info.setManagerId(info.getManagerId());
			flag3 = true;
		} else {
			response.setManagerIdMessage("Manager ID should contains only numbers");
		}
		if (inputValidation.stringValidation(info.getManagerName())) {
			info.setManagerName(info.getManagerName());
			flag4 = true;
		} else {
			response.setManagerNameMessage("Please enter only alphabets");
		}
		if (inputValidation.emailValidation(info.getEmail())) {
			info.setEmail(info.getEmail());
			flag5 = true;
		} else {
			response.setEmailMessage("Please enter valid  email (Ex:abc@gmail.com)");
		}
		if (inputValidation.contactNumberValidation(info.getMobileNo())) {
			info.setMobileNo(info.getMobileNo());
			flag6 = true;
		} else {
			response.setMobileNoMessage("Contact Number must 10 digits and start with 7 or 8 or 9");
		}
		if (inputValidation.passwordValidation(info.getPassword())) {
			info.setPassword(info.getPassword());
			flag7 = true;
		} else {
			response.setPasswordMessage(
					"Password must contain alphabets, numbers, one symbol and length should be 6-16");
		}
		if (flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7) {
			return managerDAO.addManager(info);
		} else {
			response.setStatusCode(401);
			response.setMessage("Please Check Your Details");
		}
		return false;
	}

	/**
	 * This method is used to call getAllCompanyManagerInfo() method
	 * 
	 * @param nothing
	 * @return {@code List<Manager>} if details are present , otherwise {@code null}
	 */
	@Override
	public List<Manager> getAllManager() {
		return managerDAO.getAllManager();
	}

	/**
	 * This method is used to call getCompanyManagerDetails() method
	 * 
	 * @param managerId {@code String}
	 * @return {@code Object} if details are present , otherwise {@code null}
	 */
	@Override
	public Manager getManager(String managerId, CompanyResponse response) {
		boolean flag = false;
		String validManagerId = null;
		if (inputValidation.numberValidation(managerId)) {
			validManagerId = managerId;
			flag = true;
		} else {
			response.setCompanyIdMessage("Manager ID should contains only numbers");
		}
		if (flag) {
			return managerDAO.getManagerDetails(validManagerId);
		} else {
			response.setStatusCode(401);
			response.setMessage("Please check your details");
		}
		return null;
	}

	/**
	 * This method is used to call updateCompanyManagerInfo() method
	 * 
	 * @param info {@code Object}
	 * @return {@code true} if details are updated , otherwise {@code false}
	 */
	@Override
	public boolean updateManager(Manager info, CompanyResponse response) {
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		boolean flag4 = false;
		boolean flag5 = false;
		boolean flag6 = false;
		boolean flag7 = false;
		if (inputValidation.numberValidation(info.getCompanyId())) {
			info.setCompanyId(info.getCompanyId());
			flag1 = true;
		} else {
			response.setCompanyIdMessage("Company ID should contains only numbers");
		}
		if (inputValidation.stringValidation(info.getCompanyName())) {
			info.setCompanyName(info.getCompanyName());
			flag2 = true;
		} else {
			response.setCompanyNameMessage("Please enter only alphabets");
		}
		if (inputValidation.numberValidation(info.getManagerId())) {
			info.setManagerId(info.getManagerId());
			flag3 = true;
		} else {
			response.setManagerIdMessage("Manager ID should contains only numbers");
		}
		if (inputValidation.stringValidation(info.getManagerName())) {
			info.setManagerName(info.getManagerName());
			flag4 = true;
		} else {
			response.setManagerNameMessage("Please enter only alphabets");
		}
		if (inputValidation.emailValidation(info.getEmail())) {
			info.setEmail(info.getEmail());
			flag5 = true;
		} else {
			response.setEmailMessage("Please enter valid  email (Ex:abc@gmail.com)");
		}
		if (inputValidation.contactNumberValidation(info.getMobileNo())) {
			info.setMobileNo(info.getMobileNo());
			flag6 = true;
		} else {
			response.setMobileNoMessage("Contact Number must 10 digits and start with 7 or 8 or 9");
		}
		if (inputValidation.passwordValidation(info.getPassword())) {
			info.setPassword(info.getPassword());
			flag7 = true;
		} else {
			response.setPasswordMessage(
					"Password must contain alphabets, numbers, one symbol and length should be 6-16");
		}
		if (flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7) {
			return managerDAO.updateManager(info);
		} else {
			response.setStatusCode(401);
			response.setMessage("Please Check Your Details");
		}
		return false;
	}

	/**
	 * This method is used to call deleteCompanyManagerInfo() method
	 * 
	 * @param info {@code Object}
	 * @return {@code true} if details are deleted , otherwise {@code false}
	 */
	@Override
	public boolean deleteManager(String managerId, CompanyResponse response) {
		boolean flag = false;
		String validManagerId = null;
		if (inputValidation.numberValidation(managerId)) {
			validManagerId = managerId;
			flag = true;
		} else {
			response.setCompanyIdMessage("Manager ID should contains only numbers");
		}
		if (flag) {
			return managerDAO.deleteManager(validManagerId);
		} else {
			response.setStatusCode(401);
			response.setMessage("Please check your details");
		}
		return false;
	}

	/**
	 * This method is used to call updateStockPrice method
	 * 
	 * @param companyId {@code String}, updatedPrice {@code double}
	 * @return {@code true} if Stock Price Updated Successfully , otherwise
	 *         {@code false}
	 */
	@Override
	public boolean updateStockPrice(String companyId, double updatedPrice) {
		return managerDAO.updateStockPrice(companyId, updatedPrice);
	}

	/**
	 * This method is used to call checkManagerId method
	 * 
	 * @param managerId {@code String}
	 * @return {@code true} if managerId is present , otherwise {@code false}
	 */
	@Override
	public boolean checkManagerID(String managerId) {
		return managerDAO.checkManagerID(managerId);
	}
}
