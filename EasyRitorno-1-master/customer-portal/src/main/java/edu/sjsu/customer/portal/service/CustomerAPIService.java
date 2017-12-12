package edu.sjsu.customer.portal.service;

import edu.sjsu.customer.portal.request.CreateCustomerRequest;
import edu.sjsu.customer.portal.request.CreateOrderRequest;
import edu.sjsu.customer.portal.response.CustomerDTO;
import edu.sjsu.customer.portal.response.GetOrdersResponse;
import edu.sjsu.customer.portal.response.OrdersDTO;

public interface CustomerAPIService {

	/**
	 * @author Anushri Srinath Aithal
	 * @param request
	 * @return
	 */
	CustomerDTO createCustomer(CreateCustomerRequest request);

	OrdersDTO createOrder(CreateOrderRequest request);

	GetOrdersResponse getOrdersList(String orderId);

	CustomerDTO getCustomerDetails(String email);
}
