package com.nttdata.hibernate.dao;

import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.idao.ICustomerDao;
import com.nttdata.hibernate.models.Customer;
/**
 * Class CustomerDaoImpl. Implements methods from ICustomerDao interface.
 * 
 * @author Samuel Calderón González
 *
 */
public class CustomerDaoImpl implements ICustomerDao {
	
	private Session session;
	
	/**
	 * Constructor
	 * 
	 * @param session
	 */
	public CustomerDaoImpl(Session session) {
		this.session = session;
	}
	
	/**
	 * Returns all customers
	 */
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Customer> getAllCustomers() {
		sessionCheck();
		return (List<Customer>) session.createQuery("FROM Customer").list();
	}
	
	/**
	 * Returns a specific customer
	 * 
	 * @param id: Customer's id
	 */
	@Override
	public Customer getCustomer(int id) {
		sessionCheck();
		return session.get(Customer.class, id);
	}
	
	/**
	 * Insert a customer
	 */
	@Override
	public void insertCustomer(Customer customer) {
		sessionCheck();
 		session.save(customer);
 		session.getTransaction().commit();
 		System.out.println("Customer "+customer.getName()+" inserted succesfully");
	}

	
	/**
	 * Update a customer
	 */
	@Override
	public void updateCustomers(Customer customer) {
		sessionCheck();
 		session.saveOrUpdate(customer);
 		session.getTransaction().commit();
 		System.out.println("Customer "+customer.getName()+" updated succesfully");
	}
	
	/**
	 * Delete a customer
	 */
	@Override
	public void deleteCustomer(Customer customer) {
		sessionCheck();
 		session.remove(customer);
 		session.getTransaction().commit();
 		System.out.println("Customer "+customer.getName()+" deleted succesfully");
	}
	
	/**
	 * Starts session if it hasn't been started already.
	 */
	private void sessionCheck() {
		if(!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
	}
	

}
