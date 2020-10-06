package com.abridged.stock_management_system.dto;

import java.io.Serializable;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

/**
 * This is Stock Entity Class
 * 
 * @author 
 */

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "stock")
@JsonRootName("Stock")
@JsonInclude(content = Include.NON_NULL)
public class Stock implements Serializable {

	@Id
	@Column
	private int stockId;

	@Column
	private String companyId;

	@Column
	private String investorId;

	@Column
	private String stockName;

	@Column
	private int quantity;

	@Column
	private String type;

	@Column
	private double avgPrice;

	@Column
	private int totalNoOfStocks;

	@Column
	private double profitLoss;

	@Column
	private String status;

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getInvestorId() {
		return investorId;
	}

	public void setInvestorId(String investorId) {
		this.investorId = investorId;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(double avgPrice) {
		this.avgPrice = avgPrice;
	}

	public int getTotalNoOfStocks() {
		return totalNoOfStocks;
	}

	public void setTotalNoOfStocks(int totalNoOfStocks) {
		this.totalNoOfStocks = totalNoOfStocks;
	}

	public double getProfitLoss() {
		return profitLoss;
	}

	public void setProfitLoss(double profitLoss) {
		this.profitLoss = profitLoss;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
