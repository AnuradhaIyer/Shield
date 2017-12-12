package edu.sjsu.customer.portal.dao;

import edu.sjsu.customer.portal.model.Customer;

public interface CustomerDAO {

	/**
	 * @author Anushri Srinath Aithal
	 * @param customer
	 * @return
	 */
	Customer insert(Customer customer);
	
	Customer getCustomer(String custId);

	Customer getCustomerByEmail(String email);
	
}
