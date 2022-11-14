package com.nttdata.hibernate.daodemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.nttdata.hibernate.dao.CustomerDaoImpl;
import com.nttdata.hibernate.idao.ICustomerDao;
import com.nttdata.hibernate.models.Customer;

/**
 * Class DaoDemo. A testing class for all methods of ICustomerDao.java
 * 
 * @author Samuel Calderón González
 *
 */
public class DaoDemo {
	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		Session session = sf.openSession();

		ICustomerDao dao = new CustomerDaoImpl(session);

		Customer exampleInsert = new Customer();

		exampleInsert.setName("examplename1");
		exampleInsert.setSurname1("examplesurname1_1");
		exampleInsert.setSurname2("examplesurname2_1");
		exampleInsert.setNif("666777888");
		
		// Test insert
		dao.insertCustomer(exampleInsert);

		Customer exampleUpdate = exampleInsert;
		exampleUpdate.setNif("999999999");
		
		// Test update
		dao.updateCustomers(exampleUpdate);
		
		// Test getCustomer
		System.out.println(dao.getCustomer(exampleInsert.getId()));
		
		// Test getAllCustomers
		System.out.println(dao.getAllCustomers());
		
		// Test delete
		Customer exampleDelete = new Customer();
		exampleDelete.setName("examplename2");
		exampleDelete.setSurname1("examplesurname1_2");
		exampleDelete.setSurname2("examplesurname2_2");
		exampleDelete.setNif("666777000");
		dao.insertCustomer(exampleDelete);
		dao.deleteCustomer(exampleDelete);

		session.close();

	}

}
