package com.abridged.stock_management_system.service;

import java.util.List;

import com.abridged.stock_management_system.dto.Stock;

/**
 * This is InvestorStockService interface where we declared methods
 * 
 * @author 
 */
public interface StockService {

	/**
	 * This method is used to call buyStock method
	 * 
	 * @param stock {@code Object}
	 * @return {@code true} if buy successfully , otherwise {@code false}
	 */
	boolean buyStock(Stock stock);

	/**
	 * This method is used to call sellStock method
	 * 
	 * @param stock {@code Object}
	 * @return {@code true} if sell successfully , otherwise {@code false}
	 */
	boolean sellStock(Stock stock);

	/**
	 * This method is used to call getAllStock method
	 * 
	 * @param nothing
	 * @return {@code List<Stock>} if stocks are present , otherwise {@code null}
	 */
	List<Stock> getAllStock();

	/**
	 * This method is used to call getInvestorStock method
	 * 
	 * @param investorId {@code String}
	 * @return {@code List<Stock>} if stocks are present , otherwise {@code null}
	 */
	List<Stock> getInvestorStock(String investorId);

	/**
	 * This method is used to call checkStockId method
	 * 
	 * @param stockId {@code int}
	 * @return {@code true} if stockId is present , otherwise {@code false}
	 */
	boolean checkStockID(int stockId);

}
