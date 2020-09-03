package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		Session session = sessionFactory.getCurrentSession();

		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);

		List<Customer> customers = query.getResultList();

		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int customerId) {
		Session session = sessionFactory.getCurrentSession();

		Customer customer = session.get(Customer.class, customerId);

		return customer;
	}

	@Override
	public void deleteCustomer(int customerId) {

		Session session = sessionFactory.getCurrentSession();

		Customer customer = session.get(Customer.class, customerId);

		session.delete(customer);

	}

	@Override
	public List<Customer> searchName(String searchName) {
		searchName = searchName.toLowerCase();

		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = null;

		if (searchName != null && searchName.length() > 0) {
			query = session.createQuery(
					"FROM Customer as c WHERE lower(firstName) like :searchName OR lower(lastName) like :searchName",
					Customer.class);
			query.setParameter("searchName", searchName);

		} else {
			return getCustomers();
		}

		List<Customer> customers = query.getResultList();

		return customers;
	}

}
