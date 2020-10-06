package com.abridged.stock_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abridged.stock_management_system.dao.CompanyDAO;
import com.abridged.stock_management_system.dto.Company;
import com.abridged.stock_management_system.dto.CompanyResponse;
import com.abridged.stock_management_system.validation.InputValidation;
import com.abridged.stock_management_system.validation.InputValidationImpl;

/**
 * This is CompanyServiceImpl class which implements CompanyService interface
 * 
 * @author 
 */
@Service
public class CompanyServiceImpl implements CompanyService {

	InputValidation inputValidation = new InputValidationImpl();

	@Autowired
	private CompanyDAO companyDAO;

	/**
	 * This method is used to call addCompanyInfo() method
	 * 
	 * @param info {@code Object}, response {@code Object}
	 * @return {@code true} if details added successfully , otherwise {@code false}
	 */
	@Override
	public boolean addCompany(Company info, CompanyResponse response) {
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		boolean flag4 = false;
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
		if (flag1 && flag2 && flag3 && flag4) {
			return companyDAO.addCompanyInfo(info);
		} else {
			response.setStatusCode(401);
			response.setMessage("Please check your details");
		}
		return false;
	}

	/**
	 * This method is used to call getAllCompanyInfo() method
	 * 
	 * @param nothing
	 * @return {@code List<Company>} if details are present , otherwise {@code null}
	 */
	@Override
	public List<Company> getAllCompany() {
		return companyDAO.getAllCompanyInfo();
	}

	/**
	 * This method is used to call getCompanyDetails() method
	 * 
	 * @param companyId {@code String}
	 * @return {@code Object} if details are present , otherwise {@code null}
	 */
	@Override
	public Company getCompanyDetails(String companyId, CompanyResponse response) {
		boolean flag = false;
		String validCompanyId = null;
		if (inputValidation.numberValidation(companyId)) {
			validCompanyId = companyId;
			flag = true;
		} else {
			response.setCompanyIdMessage("Company ID should contains only numbers");
		}
		if (flag) {
			return companyDAO.getCompanyDetails(validCompanyId);
		} else {
			response.setStatusCode(401);
			response.setMessage("Please check your details");
		}
		return null;
	}

	/**
	 * This method is used to call updateCompanyInfo() method
	 * 
	 * @param info {@code Object}
	 * @return {@code true} if details are updated , otherwise {@code false}
	 */
	@Override
	public boolean updateCompany(Company info, String companyId, CompanyResponse response) {
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		boolean flag4 = false;
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
		if (flag1 && flag2 && flag3 && flag4) {
			return companyDAO.updateCompanyInfo(info);
		} else {
			response.setStatusCode(401);
			response.setMessage("Please check your details");
		}
		return false;
	}

	/**
	 * This method is used to call deleteCompanyInfo() method
	 * 
	 * @param compayId {@code String}
	 * @return {@code true} if details are deleted , otherwise {@code false}
	 */
	@Override
	public boolean deleteCompany(String companyId, CompanyResponse response) {
		boolean flag = false;
		String validCompanyId = null;
		if (inputValidation.numberValidation(companyId)) {
			validCompanyId = companyId;
			flag = true;
		} else {
			response.setCompanyIdMessage("Company ID should contains only numbers");
		}
		if (flag) {
			return companyDAO.deleteCompanyInfo(validCompanyId);
		} else {
			response.setStatusCode(401);
			response.setMessage("Please check your details");
		}
		return false;
	}

	/**
	 * This method is used to call deleteCompanyInfo() method
	 * 
	 * @param companyId {@code String}
	 * @return {@code true} if details are deleted , otherwise {@code false}
	 */
	@Override
	public boolean checkCompanyID(String companyId) {
		return companyDAO.checkCompanyID(companyId);
	}
}
