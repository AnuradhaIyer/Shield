package edu.sjsu.customer.portal.response;

import java.io.Serializable;
import java.util.List;

public class GetOrdersResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	List<OrdersDTO> ordersList;

	public GetOrdersResponse() {
	}

	public GetOrdersResponse(List<OrdersDTO> ordersList) {
		super();
		this.ordersList = ordersList;
	}

	public List<OrdersDTO> getOrdersList() {
		return ordersList;
	}

	public void setOrdersList(List<OrdersDTO> ordersList) {
		this.ordersList = ordersList;
	}

	@Override
	public String toString() {
		return "GetOrdersList [ordersList=" + ordersList + "]";
	}

}

