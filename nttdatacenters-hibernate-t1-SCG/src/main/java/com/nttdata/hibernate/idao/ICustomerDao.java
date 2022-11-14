package com.nttdata.hibernate.idao;

import java.util.List;

import com.nttdata.hibernate.models.Customer;

/**
 * Interface CustomerDao
 * 
 * @author Samuel Calderón González
 *
 */
public interface ICustomerDao {
	public List<Customer> getAllCustomers();
	public Customer getCustomer(int id);
	public void insertCustomer(Customer customer);
	public void updateCustomers(Customer customer);
	public void deleteCustomer(Customer customer);
	public List<Customer> searchByName(String name);
	public List<Customer> searchBySurname1(String surname1);
	public List<Customer> searchBySurname2(String surname2);
}
