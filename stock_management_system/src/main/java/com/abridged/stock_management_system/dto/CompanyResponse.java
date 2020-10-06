package com.abridged.stock_management_system.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * This is CompanyResponse Class
 * 
 * @author 
 */
@SuppressWarnings("serial")
@Data
public class CompanyResponse  implements Serializable{

	private int statusCode;
	private String message;
	private String companyIdMessage;
	private String companyNameMessage;
	private String managerNameMessage;
	private String managerIdMessage;
	private String emailMessage;
	private String mobileNoMessage;
	private String passwordMessage;
	private List<Company> companyList;
	private Company company;
	private List<Manager> managerList;
	private Manager manager;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCompanyIdMessage() {
		return companyIdMessage;
	}
	public void setCompanyIdMessage(String companyIdMessage) {
		this.companyIdMessage = companyIdMessage;
	}
	public String getCompanyNameMessage() {
		return companyNameMessage;
	}
	public void setCompanyNameMessage(String companyNameMessage) {
		this.companyNameMessage = companyNameMessage;
	}
	public String getManagerNameMessage() {
		return managerNameMessage;
	}
	public void setManagerNameMessage(String managerNameMessage) {
		this.managerNameMessage = managerNameMessage;
	}
	public String getManagerIdMessage() {
		return managerIdMessage;
	}
	public void setManagerIdMessage(String managerIdMessage) {
		this.managerIdMessage = managerIdMessage;
	}
	public String getEmailMessage() {
		return emailMessage;
	}
	public void setEmailMessage(String emailMessage) {
		this.emailMessage = emailMessage;
	}
	public String getMobileNoMessage() {
		return mobileNoMessage;
	}
	public void setMobileNoMessage(String mobileNoMessage) {
		this.mobileNoMessage = mobileNoMessage;
	}
	public String getPasswordMessage() {
		return passwordMessage;
	}
	public void setPasswordMessage(String passwordMessage) {
		this.passwordMessage = passwordMessage;
	}
	public List<Company> getCompanyList() {
		return companyList;
	}
	public void setCompanyList(List<Company> companyList) {
		this.companyList = companyList;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public List<Manager> getManagerList() {
		return managerList;
	}
	public void setManagerList(List<Manager> managerList) {
		this.managerList = managerList;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	
	
}
