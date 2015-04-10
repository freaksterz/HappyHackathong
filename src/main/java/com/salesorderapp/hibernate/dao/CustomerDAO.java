package com.salesorderapp.hibernate.dao;

import com.salesorderapp.hibernate.entity.Customer;

import java.util.List;



/**
 * @author freakster
 * 
 *
 */
public interface CustomerDAO{
	//TODO define custom Exception handling for the below methods
	//TODO try generic DAO 
	
	Customer addCustomer(Customer customer);
	void removeCustomer(String custCode);
	void updateCustomer(Customer customer);
	Customer getCustomerDetails(String custCode);
	float getCreditLimit(String custCode);
	float getCurrentCredit(String custCode);
	List<Customer> getAllCustomerList();
	
	
	
	
}