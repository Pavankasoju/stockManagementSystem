package com.abridged.stock_management_system.dao;

import java.util.List;

import com.abridged.stock_management_system.dto.Stock;

/**
 * This is InvestorStockDAO interface where we declared methods
 * 
 * @author  
 */
public interface StockDAO {

	/**
	 * This method is used to buy Stock method
	 * 
	 * @param stock {@code Object}
	 * @return {@code true} if buy successfully , otherwise {@code false}
	 */
	boolean buyStock(Stock stock);

	/**
	 * This method is used to sell Stock method
	 * 
	 * @param stock {@code Object}
	 * @return {@code true} if sold successfully , otherwise {@code false}
	 */
	boolean sellStock(Stock stock);

	/**
	 * This method is used to getAllStock method
	 * 
	 * @param nothing
	 * @return {@code List<InvestorStockDetails>} if stocks are present , otherwise
	 *         {@code null}
	 */
	List<Stock> getAllStock();

	/**
	 * This method is used to getInvestorStock
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
