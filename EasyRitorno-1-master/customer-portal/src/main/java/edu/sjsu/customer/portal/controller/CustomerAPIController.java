package edu.sjsu.customer.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
@Controller
@RequestMapping("/customer")
public class CustomerAPIController {

	@Autowired
	CustomerAPIService apiService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String startPage(ModelMap model) {
		return "index";
	}
	
	/**
	 * @author Anushri Srinath Aithal
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/add/customer", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CreateCustomerRequest request) {
		ResponseEntity<CustomerDTO> responseEntity = null;
		try {
			CustomerDTO response = apiService.createCustomer(request);
			responseEntity = new ResponseEntity<CustomerDTO>(response, HttpStatus.OK);
		} catch (Exception e) {
			CustomerDTO response = new CustomerDTO();
			response.setMessage(e.getMessage());
			response.setStatusCode(HttpStatus.EXPECTATION_FAILED.toString());
			responseEntity = new ResponseEntity<CustomerDTO>(response, HttpStatus.EXPECTATION_FAILED);
		}
		return responseEntity;
	}
	
	/**
	 * @author Anushri Srinath Aithal
	 * @param email
	 * @return
	 */
	@RequestMapping(value = "/get/customer", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<CustomerDTO> getCustomerDetails(@RequestParam String email) {
		ResponseEntity<CustomerDTO> responseEntity = null;
		try {
			if(email == null) {
				throw new Exception("User Not Found");
			}
			CustomerDTO response = apiService.getCustomerDetails(email);
			responseEntity = new ResponseEntity<CustomerDTO>(response, HttpStatus.OK);
		} catch (Exception e) {
			CustomerDTO response = new CustomerDTO();
			response.setMessage(e.getMessage());
			response.setStatusCode(HttpStatus.EXPECTATION_FAILED.toString());
			responseEntity = new ResponseEntity<CustomerDTO>(response, HttpStatus.EXPECTATION_FAILED);
		}
		return responseEntity;
	}
	
	/**
	 * 
	 * @author Ashwini Shankar Narayan
	 */
	
	@RequestMapping(value = "/submitOrder", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponseEntity<OrdersDTO> createOrder(@RequestBody CreateOrderRequest request) {
		ResponseEntity<OrdersDTO> responseEntity = null;
		try {
			OrdersDTO response = apiService.createOrder(request);
			responseEntity = new ResponseEntity<OrdersDTO>(response, HttpStatus.OK);
		} catch (Exception e) {
			OrdersDTO response = new OrdersDTO();
			response.setMessage(e.getMessage());
			response.setStatusCode(HttpStatus.EXPECTATION_FAILED.toString());
			responseEntity = new ResponseEntity<OrdersDTO>(response, HttpStatus.EXPECTATION_FAILED);
		}
		return responseEntity;
	}
	
	/**
	 * 
	 * @author Ashwini Shankar Narayan
	 */
	@RequestMapping(path = "/getOrders", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<GetOrdersResponse> getOrdersList(@RequestParam String customerId) {
		System.out.println("Calling getOrders");
		ResponseEntity<GetOrdersResponse> responseEntity = null;
		try {
			GetOrdersResponse orderList = apiService.getOrdersList(customerId);
			System.out.println("Order List:" + orderList);
			responseEntity = new ResponseEntity<GetOrdersResponse>(orderList, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<GetOrdersResponse>(new GetOrdersResponse(),
					HttpStatus.EXPECTATION_FAILED);
		}
		return responseEntity;
	}
	
}
