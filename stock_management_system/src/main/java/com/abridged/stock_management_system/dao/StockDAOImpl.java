package com.abridged.stock_management_system.dao;

import java.math.RoundingMode;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.abridged.stock_management_system.dto.Company;
import com.abridged.stock_management_system.dto.Stock;

/**
 * This is InvestorStockDAOImpl class which implements InvestorStockDAO
 * interface
 * 
 * @author 
 */
@Repository
public class StockDAOImpl implements StockDAO {

	@PersistenceUnit
	private EntityManagerFactory factory;

	/**
	 * This method is used to buy Stock method
	 * 
	 * @param stock {@code Object}
	 * @return {@code true} if buy successfully , otherwise {@code false}
	 */
	@Override
	public boolean buyStock(Stock stock) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Company info = manager.find(Company.class, stock.getCompanyId());
		String stockName = info.getCompanyName();
		int noOfStocks = stock.getTotalNoOfStocks();
		double initialPrice = info.getStockPrice();
		double quantity = Double.valueOf(stock.getQuantity());
		double avgPrice = quantity * initialPrice;
		double increase = (avgPrice - initialPrice);
		double percentage = (increase / initialPrice) * 100;
		double percentChange = (percentage / initialPrice) * 100;

		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		String percent = df.format(percentChange);
		double percentageChange = Double.parseDouble(percent);

		try {
			manager.persist(stock);
			String jpql = "update Stock s set s.stockName=:name,s.type=:type, s.avgPrice=:price, s.profitLoss=:profitLoss where s.stockId=:id";
			Query query = manager.createQuery(jpql);
			query.setParameter("name", stockName);
			query.setParameter("price", avgPrice);
			query.setParameter("type", "buy");
			query.setParameter("profitLoss", percentageChange);
			query.setParameter("id", stock.getStockId());
			int i = query.executeUpdate();
			int quantity1 = stock.getQuantity();
			int totalNoOfStocks = quantity1 + noOfStocks;
			if (i != 0) {
				String queryStatusStrig = "update Stock s set s.status=:status, s.totalNoOfStocks=:stock where s.stockId=:id";
				Query queryStatus = manager.createQuery(queryStatusStrig);
				queryStatus.setParameter("status", "completed");
				queryStatus.setParameter("stock", totalNoOfStocks);
				queryStatus.setParameter("id", stock.getStockId());
				queryStatus.executeUpdate();
			} else {
				String queryStatusStrig = "update Stock s set s.status=:status where s.stockId=:id";
				Query queryStatus = manager.createQuery(queryStatusStrig);
				queryStatus.setParameter("status", "failed");
				queryStatus.setParameter("id", stock.getStockId());
				queryStatus.executeUpdate();
			}
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * This method is used to sell Stock method
	 * 
	 * @param stock {@code Object}
	 * @return {@code true} if sell successfully , otherwise {@code false}
	 */
	@Override
	public boolean sellStock(Stock stock) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Company info = manager.find(Company.class, stock.getCompanyId());
		String stockName = info.getCompanyName();
		double costPrice = info.getStockPrice();
		double sellingPrice = stock.getAvgPrice();
		double quantity = Double.valueOf(stock.getQuantity());
		double totalSellingPrice = quantity * sellingPrice;
		double increase = (totalSellingPrice - costPrice);
		double percentage = (increase / costPrice) * 100;
		double percentChange = (percentage / costPrice) * 100;
		int noOfStocks = stock.getTotalNoOfStocks();
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		String percent = df.format(percentChange);
		double percentageChange = Double.parseDouble(percent);

		try {
			manager.persist(stock);
			String jpql = "update Stock s set s.stockName=:name,s.type=:type, s.avgPrice=:price, s.profitLoss=:profitLoss where s.stockId=:id";
			Query query = manager.createQuery(jpql);
			query.setParameter("name", stockName);
			query.setParameter("price", totalSellingPrice);
			query.setParameter("type", "sell");
			query.setParameter("profitLoss", percentageChange);
			query.setParameter("id", stock.getStockId());
			int i = query.executeUpdate();
			int quantity1 = stock.getQuantity();
			int totalNoOfStocks = noOfStocks - quantity1;
			if (i != 0) {
				String queryStatusStrig = "update Stock s set s.status=:status, s.totalNoOfStocks=:stock where s.stockId=:id";
				Query queryStatus = manager.createQuery(queryStatusStrig);
				queryStatus.setParameter("status", "completed");
				queryStatus.setParameter("stock", totalNoOfStocks);
				queryStatus.setParameter("id", stock.getStockId());
				queryStatus.executeUpdate();
			} else {
				String queryStatusStrig = "update Stock s set s.status=:status where s.stockId=:id";
				Query queryStatus = manager.createQuery(queryStatusStrig);
				queryStatus.setParameter("status", "failed");
				queryStatus.setParameter("id", stock.getStockId());
				queryStatus.executeUpdate();
			}
			transaction.commit();
			manager.close();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * This method is used to getAllStock method
	 * 
	 * @param
	 * @return {@code List<InvestorStockDetails>} if stocks are present , otherwise
	 *         {@code null}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Stock> getAllStock() {
		EntityManager manager = factory.createEntityManager();
		String jpql = "select s from Stock s";
		Query query = manager.createQuery(jpql);
		List<Stock> stockList = query.getResultList();
		manager.close();
		return stockList;
	}

	/**
	 * This method is used to getInvestorStock
	 * 
	 * @param investorId {@code String}
	 * @return {@code List<Stock>} if stocks are present , otherwise {@code null}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Stock> getInvestorStock(String investorId) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		String jpql = "select s from Stock s";
		Query query = manager.createQuery(jpql);
//		query.setParameter("id", investorId);
		List<Stock> record = query.getResultList();
		ArrayList<Stock> stockArrayList = new ArrayList<Stock>();
		stockArrayList.addAll(record);
		int count = 0;
		for (int i = 0; i < stockArrayList.size(); i++) {
			if (stockArrayList.get(i).getInvestorId().contentEquals(investorId)) {
				count = 1;
			} else {
				count = 0;
			}
		}
		if (count == 0) {
			return null;
		} else {
			return record;
		}
	}

	/**
	 * This method is used to check stockId
	 * 
	 * @param stockId {@code int}
	 * @return {@code true} if stockId is present , otherwise {@code false}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean checkStockID(int stockId) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "select s from Stock s";
		Query query = manager.createQuery(jpql);
		List<Stock> stockIDList = query.getResultList();
		ArrayList<Stock> stockArrayList = new ArrayList<Stock>();
		stockArrayList.addAll(stockIDList);
		int count = 0;
		for (int i = 0; i < stockArrayList.size(); i++) {
			if (stockArrayList.get(i).getStockId() == stockId) {
				count = 1;
			} else {
				count = 0;
			}
		}
		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}
}
