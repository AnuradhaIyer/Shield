package edu.sjsu.customer.portal.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.CollectionUtils;

import edu.sjsu.customer.portal.dao.OrdersDAO;
import edu.sjsu.customer.portal.model.OrderStatus;
import edu.sjsu.customer.portal.model.Orders;

/**
 * 
 * @author Anushri Srinath Aithal
 *
 */
@Configuration
@EnableScheduling
public class OrderStatusChangeScheduler {

	private static final Logger LOG = Logger.getLogger(OrderStatusChangeScheduler.class);
	@Autowired
	OrdersDAO ordersDao;

	@Scheduled(cron = "0 0/15 * * * ?")
	public void changeOrderStatus() {
		List<Orders> orders = ordersDao.getUnprocessedOrders();
		List<Orders> ordersToUpdate = new ArrayList<Orders>();
		if (CollectionUtils.isEmpty(orders)) {
			LOG.info("No orders to process");
			return;
		}
		for(Orders order : orders) {
			if(OrderStatus.CREATED.toString().equals(order.getOrderStatus())) {
				order.setOrderStatus(OrderStatus.PICKED.toString());
			}else if(OrderStatus.PICKED.toString().equals(order.getOrderStatus())) {
				order.setOrderStatus(OrderStatus.SHIPPED.toString());
			}else if(OrderStatus.SHIPPED.toString().equals(order.getOrderStatus())) {
				order.setOrderStatus(OrderStatus.DELIVERED.toString());
			}
			ordersToUpdate.add(order);
		}
		
		ordersDao.updateOrders(ordersToUpdate);
	}
}
