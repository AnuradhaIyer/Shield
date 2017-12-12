package edu.sjsu.customer.portal.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.sjsu.customer.portal.dao.CustomerDAO;
import edu.sjsu.customer.portal.dao.OrdersDAO;
import edu.sjsu.customer.portal.model.Customer;
import edu.sjsu.customer.portal.model.OrderStatus;
import edu.sjsu.customer.portal.model.Orders;
import edu.sjsu.customer.portal.request.CreateCustomerRequest;
import edu.sjsu.customer.portal.request.CreateOrderRequest;
import edu.sjsu.customer.portal.response.CustomerDTO;
import edu.sjsu.customer.portal.response.GetOrdersResponse;
import edu.sjsu.customer.portal.response.OrdersDTO;
import edu.sjsu.customer.portal.service.CustomerAPIService;

/**
 * 
 * @author Anushri Srinath Aithal
 *
 */
@Service
public class CustomerAPIServiceImpl implements CustomerAPIService {

	@Autowired
	CustomerDAO customerDAO;

	@Autowired
	OrdersDAO ordersDAO;

	/**
	 * @author Anushri Srinath Aithal
	 */
	private static ObjectMapper mapper;

	static {
		mapper = new ObjectMapper();
	}

	/**
	 * @author Anushri Srinath Aithal
	 */
	@Override
	public CustomerDTO createCustomer(CreateCustomerRequest request) {
		CustomerDTO customerDTO = null;
		Customer customer = new Customer();
		customer.setFirstName(request.getFirstName());
		customer.setLastName(request.getLastName());
		customer.setAddress(request.getAddress());
		customer.setCity(request.getCity());
		customer.setEmail(request.getEmail());
		customer = customerDAO.insert(customer);
		if (null != customer) {
			customerDTO = mapper.convertValue(customer, CustomerDTO.class);
		}
		return customerDTO;
	}
	
	/**
	 * 
	 * @author Ashwini Shankar Narayan
	 */

	@Override
	public OrdersDTO createOrder(CreateOrderRequest request) {
		OrdersDTO ordersDTO = null;
		Orders order = new Orders();
		order.setPackType(request.getPackType());
		// order.setWeight(request.getWeight());
		order.setDeclValue(request.getDeclValue());
		order.setCustAdr(request.getCustAdr());
		order.setPickTime(request.getPickTime());
		order.setShippingAdr(request.getShippingAdr());
		order.setShippingTime(request.getShippingTime());
		order.setTotalCost(request.getTotalCost());
		order.setOrderStatus(OrderStatus.CREATED.toString());
		String customerId = request.getCustId();
		if (customerId != null) {
			Customer customer = customerDAO.getCustomer(customerId);
			order.setCustomer(customer);
		}
		order = ordersDAO.insertOrder(order);

		// trackingId logic
		// Order status logic
		if (null != order) {
			ordersDTO = mapper.convertValue(order, OrdersDTO.class);
		}
		return ordersDTO;
	}
	
	/**
	 * 
	 * @author Ashwini Shankar Narayan
	 */

	@Override
	public GetOrdersResponse getOrdersList(String custId) {
		GetOrdersResponse response = new GetOrdersResponse();
		List<OrdersDTO> ordersList = new ArrayList<OrdersDTO>();

		List<Orders> orders = ordersDAO.getOrders(custId);
		if (orders != null) {
			for (Orders order : orders) {
				OrdersDTO ordersDTO = new OrdersDTO(order.getId(), order.getCustomer(), order.getPackType(),
						order.getDeclValue(), order.getCustAdr(), order.getPickTime(), order.getShippingAdr(),
						order.getPickTime(), order.getTotalCost(), order.getOrderStatus());
				ordersList.add(ordersDTO);
			}
		}

		response.setOrdersList(ordersList);
		return response;
	}

	@Override
	public CustomerDTO getCustomerDetails(String email) {
		CustomerDTO customerDTO = null;
		Customer customer = customerDAO.getCustomerByEmail(email);
		if (null != customer) {
			customerDTO = mapper.convertValue(customer, CustomerDTO.class);
		}
		return customerDTO;
	}
}
