package com.abridged.stock_management_system.dao;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.abridged.stock_management_system.dto.Investor;

/**
 * This is InvestorDAOImpl class which implements InvestorDAO interface
 * 
 * @author 
 */
@Repository
public class InvestorDAOImpl implements InvestorDAO {

	@PersistenceUnit
	private EntityManagerFactory factory;

	/**
	 * This method is used to call investorLogin method
	 * 
	 * @param investorId {@code String}, password {@code String}
	 * @return {@code true} if login successfully , otherwise {@code false}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean investorLogin(String investorId, String password) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "Select investor from Investor investor";
		Query query = manager.createQuery(jpql);
		List<Investor> list = query.getResultList();
		int count = 0;
		for (Investor info : list) {
			if (info.getInvestorId().contentEquals(investorId) && info.getPassword().contentEquals(password))
				count = 1;
		}
		manager.close();
		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * This method is used for forgot password method
	 * 
	 * @param investorId {@code String} password {@code String}, mobileNo
	 *                   {@code String}
	 * @return {@code true} if password set successfully , otherwise {@code false}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean investorForgotPassword(String investorId, String password, String mobileNo) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "Select investor from Investor investor";
		Query query = manager.createQuery(jpql);
		List<Investor> list = query.getResultList();
		int count = 0;
		for (Investor info : list) {
			if (info.getMobileNo().contentEquals(mobileNo) && info.getInvestorId().contentEquals(investorId))
				count++;
		}
		manager.close();
		if (count != 0) {
			EntityManager manager2 = factory.createEntityManager();
			EntityTransaction transaction2 = manager2.getTransaction();
			transaction2.begin();
			try {
				Investor record2 = manager2.find(Investor.class, investorId);
				record2.setPassword(password);
				transaction2.commit();
				return true;

			} catch (Exception e) {
				transaction2.rollback();
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * This method is used to add investor information
	 * 
	 * @param info {@code Object}
	 * @return {@code true} if details added successfully , otherwise {@code false}
	 */
	@Override
	public boolean addInvestor(Investor info) {
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
	 * This method is used to get all investor information
	 * 
	 * @param nothing
	 * @return {@code List<InvestorInfo>} if details are present , otherwise
	 *         {@code null}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Investor> getAllInvestor() {
		EntityManager manager = factory.createEntityManager();
		String jpql = "select investor from Investor investor";
		Query query = manager.createQuery(jpql);
		List<Investor> investorList = query.getResultList();
		manager.close();
		return investorList;
	}

	/**
	 * This method is used to get investor information
	 * 
	 * @param investorId {@code String}
	 * @return {@code Object} if details are present , otherwise {@code null}
	 */
	@Override
	public Investor getInvestorDetails(String investorId) {
		EntityManager manager = factory.createEntityManager();
		Investor record = manager.find(Investor.class, investorId);
		manager.close();
		return record;
	}

	/**
	 * This method is used to update investor information
	 * 
	 * @param info {@code Object}
	 * @return {@code true} if details are updated , otherwise {@code false}
	 */
	@Override
	public boolean updateInvestor(Investor info) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		String jpql = "update Investor investor set investor.investorName=:name,investor.email=:email,investor.password=:pwd,investor.mobileNo=:mobile,investor.bankName=:bank,investor.branchName=:branch, investor.accountNo=:account,investor.balance=:balance where investor.investorId=:id";
		Query query = manager.createQuery(jpql);
		query.setParameter("name", info.getInvestorName());
		query.setParameter("email", info.getEmail());
		query.setParameter("pwd", info.getPassword());
		query.setParameter("mobile", info.getMobileNo());
		query.setParameter("bank", info.getBankName());
		query.setParameter("branch", info.getBranchName());
		query.setParameter("account", info.getAccountNo());
		query.setParameter("balance", info.getBalance());
		query.setParameter("id", info.getInvestorId());
		int i = query.executeUpdate();
		transaction.commit();
		if (i != 0) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to delete investor information
	 * 
	 * @param investorId {@code it}
	 * @return {@code true} if details are deleted , otherwise {@code false}
	 */
	@Override
	public boolean deleteInvestor(String investorId) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		String jpql = "delete from Investor investor where investor.investorId=:id";
		Query query = manager.createQuery(jpql);
		query.setParameter("id", investorId);
		int i = query.executeUpdate();
		transaction.commit();
		if (i != 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method is used to check investorId
	 * 
	 * @param investorId {@code String}
	 * @return {@code true} if investorId is present , otherwise {@code false}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean checkInvestorID(String investorId) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "select investor from Investor investor";
		Query query = manager.createQuery(jpql);
		List<Investor> investorIDList = query.getResultList();
		ArrayList<Investor> investorArrayList = new ArrayList<Investor>();
		investorArrayList.addAll(investorIDList);
		int count = 0;
		for (int i = 0; i < investorArrayList.size(); i++) {
			if (investorArrayList.get(i).getInvestorId().contentEquals(investorId)) {
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
