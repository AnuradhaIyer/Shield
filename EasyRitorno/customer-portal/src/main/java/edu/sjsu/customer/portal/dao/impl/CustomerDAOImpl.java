package edu.sjsu.customer.portal.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import edu.sjsu.customer.portal.dao.CustomerDAO;
import edu.sjsu.customer.portal.model.Customer;

/**
 * 
 * @author Anushri Srinath Aithal
 *
 */
@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private MongoOperations mongoOperations;

	/**
	 * @author Anushri Srinath Aithal
	 */
	@Override
	public Customer insert(Customer customer) {
		mongoOperations.insert(customer);
		return customer;
	}

	@Override
	public Customer getCustomer(String customerId) {
		Query searchQuery = new Query(Criteria.where("id").is(customerId));
		Customer toReturnCust = mongoOperations.findOne(searchQuery, Customer.class);
		return toReturnCust;
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		Query searchQuery = new Query(Criteria.where("email").is(email));
		Customer toReturnCust = mongoOperations.findOne(searchQuery, Customer.class);
		return toReturnCust;
	}

}
