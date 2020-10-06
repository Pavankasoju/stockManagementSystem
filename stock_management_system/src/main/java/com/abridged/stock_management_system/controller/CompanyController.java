package com.abridged.stock_management_system.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abridged.stock_management_system.dto.Company;
import com.abridged.stock_management_system.dto.Manager;
import com.abridged.stock_management_system.dto.Stock;
import com.abridged.stock_management_system.dto.CompanyResponse;
import com.abridged.stock_management_system.dto.Investor;
import com.abridged.stock_management_system.dto.InvestorResponse;
import com.abridged.stock_management_system.dto.LoginResponse;
import com.abridged.stock_management_system.exception.ManagerIDFoundException;
import com.abridged.stock_management_system.service.InvestorService;
import com.abridged.stock_management_system.service.ManagerService;
import com.abridged.stock_management_system.service.StockService;

/**
 * This is CompanyController Class
 * 
 * @author
 */

@RestController
public class CompanyController {

	@Autowired
	private ManagerService managerService;
	@Autowired
	private InvestorService investorService2;
	@Autowired
	private StockService stockService2;

	/**
	 * This method is used to call managerLogin method
	 * 
	 * @param managerId {@code String}, password {@code String}
	 * @return response {@code Object}
	 */
	@GetMapping(path = "/managerLogin/{managerId}/{password}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public LoginResponse managerLogin(@PathVariable(name = "managerId") String managerId,
			@PathVariable(name = "password") String password, ModelMap map) {
		LoginResponse response = new LoginResponse();
		boolean isLogin = managerService.managerLogin(managerId, password, response);
		if (isLogin) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setMessage("Login Successful");
		} else {
			response.setStatusCode(401);
			response.setMessage("Login Failed");
			response.setUsernameMessage(response.getUsernameMessage());
			response.setPasswordMessage(response.getPasswordMessage());
		}
		return response;
	}

	/**
	 * This method is used to call forgot password method
	 * 
	 * @param info {@code Object}
	 * @return response {@code Object}
	 */
	@PutMapping(path = "/managerForgotPassword", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public LoginResponse managerForgotPassword(@RequestBody Manager info) {
		LoginResponse response = new LoginResponse();
		String managerId = info.getManagerId();
		String password = info.getPassword();
		String mobileNo = info.getMobileNo();
		boolean isPasswordChange = managerService.managerForgotPassword(managerId, password, mobileNo, response);
		if (isPasswordChange) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setMessage("Password Change Successful");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setIdMessage(response.getIdMessage());
			response.setPasswordMessage(response.getPasswordMessage());
			response.setMobileNoMessage(response.getMobileNoMessage());
		}
		return response;
	}

	/**
	 * This method is used to add company manager details
	 * 
	 * @param info {@code Object}
	 * @return response {@code Object}
	 */

	@PostMapping(path = "/addManager", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public CompanyResponse addCompanyManagerDetails(@RequestBody Manager info) {
		CompanyResponse response = new CompanyResponse();
		String mgrId = info.getManagerId();
		boolean mgrIdPresent = false;
		mgrIdPresent = managerService.checkManagerID(mgrId);
		if (mgrIdPresent)
			throw new ManagerIDFoundException();
		else {
			boolean isAdded = managerService.addManager(info, response);
			if (isAdded) {
				response.setStatusCode(200);
				response.setMessage("Success");
				response.setMessage("Manager Details Added Successfully");
			} else {
				response.setStatusCode(401);
				response.setMessage("Failure");
				response.setManagerIdMessage(response.getManagerIdMessage());
				response.setManagerNameMessage(response.getManagerNameMessage());
				response.setCompanyIdMessage(response.getCompanyIdMessage());
				response.setCompanyNameMessage(response.getCompanyNameMessage());
				response.setEmailMessage(response.getEmailMessage());
				response.setPasswordMessage(response.getPasswordMessage());
				response.setMobileNoMessage(response.getMobileNoMessage());
			}
		}

		return response;
	}

	/**
	 * This method is used to get company manager details
	 * 
	 * @param managerId {@code String}
	 * @return response {@code Object}
	 */

	@GetMapping(path = "/getManager/{managerId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public CompanyResponse getCompanyManagerDetails(@PathVariable(name = "managerId") String managerId, ModelMap map) {
		CompanyResponse response = new CompanyResponse();
		Manager info = managerService.getManager(managerId, response);
		if (info != null) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setManager(info);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setMessage("Please Check Manager ID");
			response.setManagerIdMessage(response.getManagerIdMessage());
		}
		return response;
	}

	/**
	 * This method is used to update company manager details
	 * 
	 * @param info {@code Object}
	 * @return response {@code Object}
	 */

	@PutMapping(path = "/updateManager", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public CompanyResponse updateCompanyManagerInfo(@RequestBody Manager info) {
		CompanyResponse response = new CompanyResponse();
		boolean isUpdated = managerService.updateManager(info, response);
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
	 * This method is used to update stock price
	 * 
	 * @param info {@code Object}
	 * @return response {@code Object}
	 */

	@PutMapping(path = "/updateStockPrice", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public CompanyResponse updateStockPrice(@RequestBody Company info) {
		CompanyResponse response = new CompanyResponse();
		String companyId = info.getCompanyId();
		double updatedPrice = info.getStockPrice();
		boolean isUpdated = managerService.updateStockPrice(companyId, updatedPrice);
		if (isUpdated) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setMessage("Stock Price Updated Successfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setMessage("Stock Price not updated");
		}
		return response;
	}
	
	
	/**
	 * This method is used to get all investor details
	 * 
	 * @param nothing
	 * @return response {@code Object}
	 */
	@GetMapping(path = "/getAllInvestor", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public InvestorResponse getAllInvestor() {
		List<Investor> listRecord = investorService2.getAllInvestor();
		InvestorResponse response = new InvestorResponse();
		if (listRecord != null) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setMessage("All Investor Details");
			response.setInvestorList(listRecord);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setMessage("Investor details is not present");
		}
		return response;
	}
	
	
	

	/**
	 * This method is used to get investor stock details
	 * 
	 * @param investorId {@code String}
	 * @return response {@code Object}
	 */

	@GetMapping(path = "/getInvestorStockDetails/{investorId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public InvestorResponse getInvestoStockDetails(@PathVariable(name = "investorId") String investorId, ModelMap map) {
		List<Stock> info = stockService2.getInvestorStock(investorId);
		InvestorResponse response = new InvestorResponse();
		if (info != null) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setMessage("Stock Details Are Present");
			response.setStockList(info);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setMessage("Stock Details Not Present");
		}
		return response;
	}

	
	
	
}
