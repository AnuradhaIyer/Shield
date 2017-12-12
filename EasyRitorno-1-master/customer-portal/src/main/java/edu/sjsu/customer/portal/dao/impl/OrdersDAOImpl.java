package edu.sjsu.customer.portal.dao.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import edu.sjsu.customer.portal.dao.OrdersDAO;
import edu.sjsu.customer.portal.model.OrderStatus;
import edu.sjsu.customer.portal.model.Orders;

@Repository
public class OrdersDAOImpl implements OrdersDAO {

	@Autowired
	MongoOperations mongoOperations;
        /**
	 * 
	 * @author Ashwini Shankar Narayan
	 */
	@Override
	public Orders insertOrder(Orders order) {
		mongoOperations.insert(order);
		return order;
	}
        /**
	 * 
	 * @author Ashwini Shankar Narayan
	 */
	@Override
	public List<Orders> getOrders(String custId) {
		Query searchQuery = new Query(Criteria.where("customer._id").is(new ObjectId(custId)));
		List<Orders> toReturn = mongoOperations.find(searchQuery, Orders.class);
		return toReturn;
	}

	@Override
	public List<Orders> getUnprocessedOrders() {
		Criteria criteria = Criteria.where("orderStatus").ne(OrderStatus.DELIVERED.toString());
		Query query = new Query(criteria);
		List<Orders> orders = mongoOperations.find(query, Orders.class);
		return orders;
	}

	@Override
	public void updateOrders(List<Orders> ordersToUpdate) {
		for (Orders order : ordersToUpdate) {
			mongoOperations.save(order);
		}
	}
}
