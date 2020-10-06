package com.abridged.stock_management_system.dao;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.abridged.stock_management_system.dto.Company;

/**
 * This is CompanyDAOImpl class which implements CompanyDAO interface
 * 
 * @author  
 */
@Repository
public class CompanyDAOImpl implements CompanyDAO {

	@PersistenceUnit
	private EntityManagerFactory factory;

	/**
	 * This method is used to add company information
	 * 
	 * @param info {@code Object}
	 * @return {@code true} if details added successfully , otherwise {@code false}
	 */
	@Override
	public boolean addCompanyInfo(Company info) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		int count = 0;
		transaction.begin();
		try {
			manager.persist(info);
			transaction.commit();
			count = 1;
		} catch (Exception e) {
			transaction.rollback();
		}
		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * This method is used to get all company information
	 * 
	 * @param nothing
	 * @return {@code List<CompanyInfo>} if details are present , otherwise
	 *         {@code null}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Company> getAllCompanyInfo() {
		EntityManager manager = factory.createEntityManager();
		String jpql = "select company from Company company";
		Query query = manager.createQuery(jpql);
		List<Company> companyList = query.getResultList();
		manager.close();
		return companyList;
	}

	/**
	 * This method is used to get company information
	 * 
	 * @param companyId {@code String}
	 * @return {@code Object} if details are present , otherwise {@code null}
	 */
	@Override
	public Company getCompanyDetails(String companyId) {
		EntityManager manager = factory.createEntityManager();
		Company record = manager.find(Company.class, companyId);
		manager.close();
		return record;
	}

	/**
	 * This method is used to update company information
	 * 
	 * @param info {@code Object}
	 * @return {@code true} if details are updated , otherwise {@code false}
	 */
	@Override
	public boolean updateCompanyInfo(Company info) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		String jpql = "update Company c set c.managerName=:mname, c.managerId=:mid, c.noOfStocks=:num,c.stockPrice=:price, c.percentageChange=:change where c.companyId=:cid";
		Query query = manager.createQuery(jpql);
		query.setParameter("mname", info.getManagerName());
		query.setParameter("mid", info.getManagerId());
		query.setParameter("num", info.getNoOfStocks());
		query.setParameter("price", info.getStockPrice());
		query.setParameter("change", info.getPercentageChange());
		query.setParameter("cid", info.getCompanyId());
		int i = query.executeUpdate();
		transaction.commit();
		if (i != 0) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to delete company information
	 * 
	 * @param info {@code Object}
	 * @return {@code true} if details are deleted , otherwise {@code false}
	 */
	@Override
	public boolean deleteCompanyInfo(String companyId) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		int i = 0;
		try {
			String jpql = "delete from Company c where c.companyId=:cid";
			Query query = manager.createQuery(jpql);
			query.setParameter("cid", companyId);
			i = query.executeUpdate();
			transaction.commit();
		} catch (Exception e) {

		}
		if (i != 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method is used to check companyId
	 * 
	 * @param companyId {@code String}
	 * @return {@code true} if companyId is present , otherwise {@code false}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean checkCompanyID(String companyId) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "select c from Company c";
		Query query = manager.createQuery(jpql);
		List<Company> companyIDList = query.getResultList();
		ArrayList<Company> companyArrayList = new ArrayList<Company>();
		companyArrayList.addAll(companyIDList);
		int count = 0;
		for (int i = 0; i < companyArrayList.size(); i++) {
			if (companyArrayList.get(i).getCompanyId().contentEquals(companyId)) {
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
