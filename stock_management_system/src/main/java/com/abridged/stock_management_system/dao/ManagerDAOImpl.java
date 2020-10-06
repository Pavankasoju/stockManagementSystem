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
import com.abridged.stock_management_system.dto.Manager;

/**
 * This is CompanyManagerDAOImpl class which implements CompanyManagerDAO
 * interface
 * 
 * @author 
 */
@Repository
public class ManagerDAOImpl implements ManagerDAO {

	@PersistenceUnit
	private EntityManagerFactory factory;

	/**
	 * This method is used for managerLogin method
	 * 
	 * @param managerId {@code String}, password {@code String}
	 * @return {@code true} if login successfully , otherwise {@code false}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean managerLogin(String managerId, String password) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "Select mgr from Manager mgr";
		Query query = manager.createQuery(jpql);
		List<Manager> list = query.getResultList();
		int count = 0;
		for (Manager info : list) {
			if (info.getManagerId().contentEquals(managerId) && info.getPassword().contentEquals(password))
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
	 * @param managerId {@code String}, password {@code String}, mobileNo
	 *                  {@code String}
	 * @return {@code true} if password set successfully , otherwise {@code false}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean managerForgotPassword(String managerId, String password, String mobileNo) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "Select mgr from Manager mgr";
		Query query = manager.createQuery(jpql);
		List<Manager> list = query.getResultList();
		int count = 0;
		for (Manager info : list) {
			if (info.getMobileNo().contentEquals(mobileNo) && info.getManagerId().contentEquals(managerId))
				count++;
		}
		manager.close();
		if (count != 0) {
			EntityManager manager2 = factory.createEntityManager();
			EntityTransaction transaction2 = manager2.getTransaction();
			transaction2.begin();
			try {
				Manager record2 = manager2.find(Manager.class, managerId);
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
	 * This method is used to add company manager information
	 * 
	 * @param info {@code Object}
	 * @return {@code true} if details added successfully , otherwise {@code false}
	 */
	@Override
	public boolean addManager(Manager info) {
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
	 * This method is used to get all company manager information
	 * 
	 * @param nothing
	 * @return {@code List<ManagerInfo>} if details are present , otherwise
	 *         {@code null}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Manager> getAllManager() {
		EntityManager manager = factory.createEntityManager();
		String jpql = "select mgr from Manager mgr";
		Query query = manager.createQuery(jpql);
		List<Manager> mgrList = query.getResultList();
		manager.close();
		return mgrList;
	}

	/**
	 * This method is used to get company manager information
	 * 
	 * @param managerId {@code String}
	 * @return {@code Object} if details are present , otherwise {@code null}
	 */
	@Override
	public Manager getManagerDetails(String managerId) {
		EntityManager manager = factory.createEntityManager();
		Manager record = manager.find(Manager.class, managerId);
		manager.close();
		return record;
	}

	/**
	 * This method is used to update company manager information
	 * 
	 * @param info {@code Object}
	 * @return {@code true} if details are updated , otherwise {@code false}
	 */
	@Override
	public boolean updateManager(Manager info) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		String jpql = "update Manager mgr set mgr.managerName=:mname,mgr.email=:mail, mgr.password=:pwd, mgr.mobileNo=:mobile where mgr.managerId=:id";
		Query query = manager.createQuery(jpql);
		query.setParameter("mname", info.getManagerName());
		query.setParameter("mail", info.getEmail());
		query.setParameter("pwd", info.getPassword());
		query.setParameter("mobile", info.getMobileNo());
		query.setParameter("id", info.getManagerId());
		int i = query.executeUpdate();
		transaction.commit();
		if (i != 0) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to delete company manager information
	 * 
	 * @param info {@code Object}
	 * @return {@code true} if details are deleted , otherwise {@code false}
	 */
	@Override
	public boolean deleteManager(String managerId) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		String jpql = "delete from Manager mgr where mgr.managerId=:mid";
		Query query = manager.createQuery(jpql);
		query.setParameter("mid", managerId);
		int i = query.executeUpdate();
		transaction.commit();
		if (i != 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method is used to update Stock Price and also update percentage change
	 * 
	 * @param companyId {@code String}, updatedPrice {@code double}
	 * @return {@code true} if Stock Price Updated Successfully , otherwise
	 *         {@code false}
	 */
	@Override
	public boolean updateStockPrice(String companyId, double updatedPrice) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Company info = manager.find(Company.class, companyId);
		double initialPrice = info.getStockPrice();

		String jpql = "update Company c set c.stockPrice=:price where c.companyId=:id";
		Query query = manager.createQuery(jpql);
		query.setParameter("price", updatedPrice);
		query.setParameter("id", companyId);
		int i = query.executeUpdate();

		double increase = (updatedPrice - initialPrice);
		double percentage = (increase / initialPrice) * 100;
		double percentChange = (percentage / initialPrice) * 100;

		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		String percent = df.format(percentChange);
		double percentageChange = Double.parseDouble(percent);

		String jpqlPercentage = "update Company c set c.percentageChange=:percentage where c.companyId=:id";
		Query queryPercentage = manager.createQuery(jpqlPercentage);
		queryPercentage.setParameter("percentage", percentageChange);
		queryPercentage.setParameter("id", companyId);
		int j = queryPercentage.executeUpdate();

		transaction.commit();
		if (i != 0 && j != 0) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to check managerId
	 * 
	 * @param managerId {@code String}
	 * @return {@code true} if managerId is present , otherwise {@code false}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean checkManagerID(String managerId) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "select mgr from Manager mgr";
		Query query = manager.createQuery(jpql);
		List<Manager> mgrIDList = query.getResultList();
		ArrayList<Manager> mgrArrayList = new ArrayList<Manager>();
		mgrArrayList.addAll(mgrIDList);
		int count = 0;
		for (int i = 0; i < mgrArrayList.size(); i++) {
			if (mgrArrayList.get(i).getManagerId().contentEquals(managerId)) {
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
