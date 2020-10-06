package com.abridged.stock_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abridged.stock_management_system.dto.CompanyResponse;
import com.abridged.stock_management_system.dto.Company;
import com.abridged.stock_management_system.dto.Manager;
import com.abridged.stock_management_system.dto.InvestorResponse;
import com.abridged.stock_management_system.dto.LoginResponse;
import com.abridged.stock_management_system.exception.CompanyIdFoundException;
import com.abridged.stock_management_system.service.AdminService;
import com.abridged.stock_management_system.service.ManagerService;
import com.abridged.stock_management_system.service.CompanyService;
import com.abridged.stock_management_system.service.InvestorService;
import com.abridged.stock_management_system.validation.InputValidation;
import com.abridged.stock_management_system.validation.InputValidationImpl;

/**
 * This is AdminController Class
 * 
 * @author
 */

@RestController
public class AdminController {

	InputValidation inputValidation = new InputValidationImpl();
	@Autowired
	private AdminService adminService;
	@Autowired
	private ManagerService mgrService;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private InvestorService investorService;

	/**
	 * This method is used to do admin login
	 * 
	 * @param username {@code String}, password {@code String}
	 * @return response {@code Object}
	 */

	@GetMapping(path = "/adminLogin/{username}/{password}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public LoginResponse adminLogin(@PathVariable("username") String username,
			@PathVariable("password") String password) {
		LoginResponse response = new LoginResponse();
		boolean isLogin = adminService.adminLogin(username, password, response);
		if (isLogin) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setMessage("Login Successful");
		} else {
			response.setStatusCode(401);
			response.setUsernameMessage(response.getUsernameMessage());
			response.setPasswordMessage(response.getPasswordMessage());
			response.setMessage("Login Failed!");
		}
		return response;
	}

	/**
	 * This method is used to add company details
	 * 
	 * @param info {@code Object}
	 * @return response {@code Object}
	 */

	@PostMapping(path = "/addCompany", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public CompanyResponse addCompanyDetails(@RequestBody Company info) {
		CompanyResponse response = new CompanyResponse();
		String companyId = info.getCompanyId();
		boolean companyIdPresent = false;
		companyIdPresent = companyService.checkCompanyID(companyId);
		if (companyIdPresent)
			throw new CompanyIdFoundException();
		else {
			boolean isAdded = companyService.addCompany(info, response);
			if (isAdded) {
				response.setStatusCode(200);
				response.setMessage("Success ");
				response.setMessage("Company Details Added Successfully");
			} else {
				response.setStatusCode(401);
				response.setMessage("Failure");
				response.setCompanyIdMessage(response.getCompanyIdMessage());
				response.setCompanyNameMessage(response.getCompanyNameMessage());
				response.setManagerIdMessage(response.getManagerIdMessage());
				response.setManagerNameMessage(response.getManagerNameMessage());
			}
		}
		return response;
	}

	/**
	 * This method is used to get company details
	 * 
	 * @param companyId {@code String}
	 * @return response {@code Object}
	 */

	@GetMapping(path = "/getCompany/{companyId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public CompanyResponse getCompanyDetails(@PathVariable(name = "companyId") String companyId, ModelMap map) {
		CompanyResponse response = new CompanyResponse();
		Company info = companyService.getCompanyDetails(companyId, response);
		if (info != null) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setCompany(info);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setMessage("Please Check Company ID");
			response.setCompanyIdMessage(response.getCompanyIdMessage());
		}
		return response;
	}

	/**
	 * This method is used to delete company details
	 * 
	 * @param companyId {@code String}
	 * @return response {@code Object}
	 */
	@DeleteMapping(path = "/deleteCompany/{companyId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public CompanyResponse deleteCompany(@PathVariable(name = "companyId") String companyId, ModelMap map) {
		CompanyResponse response = new CompanyResponse();
		boolean isDeleted = companyService.deleteCompany(companyId, response);
		if (isDeleted) {
			response.setStatusCode(200);
			response.setMessage("Success\n Company Details Deleted");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure \n Please Check Company ID");
		}
		return response;
	}

	/**
	 * This method is used to update company details
	 * 
	 * @param info {@code Object}
	 * @return response {@code Object}
	 */

	@PutMapping(path = "/updateCompany/{companyId}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public CompanyResponse updateCompanyInfo(@RequestBody Company info,
			@PathVariable(name = "companyId") String companyId) {
		CompanyResponse response = new CompanyResponse();
		boolean isUpdated = companyService.updateCompany(info, companyId, response);
		if (isUpdated) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setMessage("Manager Details Updated");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setMessage("Please Check CompanyId");
		}

		return response;
	}

	/**
	 * This method is used to get all company details
	 * 
	 * @param nothing
	 * @return response {@code Object}
	 */
	@GetMapping(path = "/getAllCompany", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public CompanyResponse getAllCompany() {
		List<Company> listRecord = companyService.getAllCompany();
		CompanyResponse response = new CompanyResponse();
		if (listRecord != null) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setMessage("All Company Details");
			response.setCompanyList(listRecord);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setMessage("Company Details Are Not Present");
		}
		return response;
	}

	/**
	 * This method is used to delete company manager details
	 * 
	 * @param managerId {@code String}
	 * @return response {@code Object}
	 */

	@DeleteMapping(path = "/deleteManager/{managerId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public CompanyResponse deleteCompanyManager(@PathVariable(name = "managerId") String managerId, ModelMap map) {
		CompanyResponse response = new CompanyResponse();
		boolean isDeleted = mgrService.deleteManager(managerId, response);
		if (isDeleted) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setMessage("Manager Details Deleted Successfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setMessage("Please Check ManagerID");
		}
		return response;
	}

	/**
	 * This method is used to get all company manager details
	 * 
	 * @param nothing
	 * @return response {@code Object}
	 */

	@GetMapping(path = "/getAllManager", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public CompanyResponse getAllCompanyManager() {
		List<Manager> listRecord = mgrService.getAllManager();
		CompanyResponse response = new CompanyResponse();
		if (listRecord != null) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setMessage("All Manager Details");
			response.setManagerList(listRecord);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setMessage("No Details Found");
		}
		return response;
	}

	/**
	 * This method is used to delete investor details
	 * 
	 * @param investorId {@code String}
	 * @return response {@code Object}
	 */
	@DeleteMapping(path = "/deleteInvestor/{investorId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public InvestorResponse deleteInvestor(@PathVariable(name = "investorId") String investorId, ModelMap map) {
		InvestorResponse response = new InvestorResponse();
		boolean isDeleted = investorService.deleteInvestor(investorId, response);
		if (isDeleted) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setMessage("Investor Details Deleted Successfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setMessage("Please Check Investor ID");
		}

		return response;
	}

}
