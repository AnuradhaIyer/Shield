package edu.sjsu.customer.portal.dao;

import java.util.List;

import edu.sjsu.customer.portal.model.Orders;
/**
	 * @author Anuradha Rajashekar
	 */

public interface OrdersDAO {

	Orders insertOrder(Orders order);
	
	List<Orders> getOrders(String custId);

	List<Orders> getUnprocessedOrders();

	void updateOrders(List<Orders> ordersToUpdate);
}
