package com.abridged.stock_management_system.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * This is InvestorResponse Class
 * 
 * @author 
 */
@SuppressWarnings("serial")
@Data
public class InvestorResponse implements Serializable {

	private int statusCode;
	private String message;
	private String investorIdMessage;
	private String investorNameMessage;
	private String emailMessage;
	private String passwordMessage;
	private String mobileNoMessage;
	private List<Investor> investorList;
	private Investor investor;
	private Stock stock;
	private List<Stock> stockList;
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
	public String getInvestorIdMessage() {
		return investorIdMessage;
	}
	public void setInvestorIdMessage(String investorIdMessage) {
		this.investorIdMessage = investorIdMessage;
	}
	public String getInvestorNameMessage() {
		return investorNameMessage;
	}
	public void setInvestorNameMessage(String investorNameMessage) {
		this.investorNameMessage = investorNameMessage;
	}
	public String getEmailMessage() {
		return emailMessage;
	}
	public void setEmailMessage(String emailMessage) {
		this.emailMessage = emailMessage;
	}
	public String getPasswordMessage() {
		return passwordMessage;
	}
	public void setPasswordMessage(String passwordMessage) {
		this.passwordMessage = passwordMessage;
	}
	public String getMobileNoMessage() {
		return mobileNoMessage;
	}
	public void setMobileNoMessage(String mobileNoMessage) {
		this.mobileNoMessage = mobileNoMessage;
	}
	public List<Investor> getInvestorList() {
		return investorList;
	}
	public void setInvestorList(List<Investor> investorList) {
		this.investorList = investorList;
	}
	public Investor getInvestor() {
		return investor;
	}
	public void setInvestor(Investor investor) {
		this.investor = investor;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public List<Stock> getStockList() {
		return stockList;
	}
	public void setStockList(List<Stock> stockList) {
		this.stockList = stockList;
	}
	
	
}
