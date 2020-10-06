package com.abridged.stock_management_system.controller;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.abridged.stock_management_system.exception.CompanyIdFoundException;
import com.abridged.stock_management_system.exception.InvestorIdFoundException;
import com.abridged.stock_management_system.exception.ManagerIDFoundException;
import com.abridged.stock_management_system.exception.StockIdFoundException;

/**
 * This is StockManagementExceptionHandler class
 * 
 * @author
 */
@ControllerAdvice
public class StockManagementExceptionHandler {

	/**
	 * This method is used to handle managerIDException
	 * 
	 * @param exception {@code Object}
	 * @return status found
	 */
	@ExceptionHandler(value = ManagerIDFoundException.class)
	public ResponseEntity<Object> managerIDException(ManagerIDFoundException exception) {
		return new ResponseEntity<Object>("Account Already Exist", HttpStatus.FOUND);
	}

	/**
	 * This method is used to handle companyIDException
	 * 
	 * @param exception {@code Object}
	 * @return status found
	 */
	@ExceptionHandler(value = CompanyIdFoundException.class)
	public ResponseEntity<Object> companyIDException(CompanyIdFoundException exception) {
		return new ResponseEntity<Object>("Company Details Already Exist", HttpStatus.FOUND);
	}

	/**
	 * This method is used to handle investorIDException
	 * 
	 * @param exception {@code Object}
	 * @return status found
	 */
	@ExceptionHandler(value = InvestorIdFoundException.class)
	public ResponseEntity<Object> investorIDException(InvestorIdFoundException exception) {
		return new ResponseEntity<Object>("Investor Details Already Exist", HttpStatus.FOUND);
	}

	/**
	 * This method is used to handle stockIDException
	 * 
	 * @param exception {@code Object}
	 * @return status found
	 */
	@ExceptionHandler(value = StockIdFoundException.class)
	public ResponseEntity<Object> stockIDException(StockIdFoundException exception) {
		return new ResponseEntity<Object>("Stock ID Already Exist", HttpStatus.FOUND);
	}
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> exception(StockIdFoundException exception) {
		return new ResponseEntity<Object>("try again", HttpStatus.FOUND);
	}

}
