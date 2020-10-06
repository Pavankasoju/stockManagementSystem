package com.abridged.stock_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abridged.stock_management_system.dao.StockDAO;
import com.abridged.stock_management_system.dto.Stock;

/**
 * This is InvestorStockServiceImpl class which implements InvestorStockService
 * interface
 * 
 * @author 
 */
@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private StockDAO stockDAO;

	/**
	 * This method is used to call buyStock method
	 * 
	 * @param stock {@code Object}
	 * @return {@code true} if buy successfully , otherwise {@code false}
	 */
	@Override
	public boolean buyStock(Stock stock) {
		return stockDAO.buyStock(stock);
	}

	/**
	 * This method is used to call sellStock method
	 * 
	 * @param stock {@code Object}
	 * @return {@code true} if sell successfully , otherwise {@code false}
	 */
	@Override
	public boolean sellStock(Stock stock) {
		return stockDAO.sellStock(stock);
	}

	/**
	 * This method is used to call getAllStock method
	 * 
	 * @param nothing
	 * @return {@code List<Stock>} if stocks are present , otherwise {@code null}
	 */
	@Override
	public List<Stock> getAllStock() {
		return stockDAO.getAllStock();
	}

	/**
	 * This method is used to call getInvestorStock method
	 * 
	 * @param investorId {@code String}
	 * @return {@code List<Stock>} if stocks are present , otherwise {@code null}
	 */
	@Override
	public List<Stock> getInvestorStock(String investorId) {
		return stockDAO.getInvestorStock(investorId);
	}

	/**
	 * This method is used to call checkStockId method
	 * 
	 * @param stockId {@code int}
	 * @return {@code true} if stockId is present , otherwise {@code false}
	 */

	@Override
	public boolean checkStockID(int stockId) {
		return stockDAO.checkStockID(stockId);
	}

}
