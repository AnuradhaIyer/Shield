package edu.sjsu.customer.portal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//import java.sql.Timestamp;

@Document(collection = "orders")
public class Orders {

	@Id
	private String id;
	private Customer customer;
	private String packType;
//	private int weight;
	private double declValue;
	private String custAdr;
	private String pickTime;
	private String shippingAdr;
	private String shippingTime;
	private double totalCost;
//	private String trackingId;
	private String orderStatus;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getPackType() {
		return packType;
	}
	public void setPackType(String packType) {
		this.packType = packType;
	}
//	public int getWeight() {
//		return weight;
//	}
//	public void setWeight(int weight) {
//		this.weight = weight;
//	}
	public double getDeclValue() {
		return declValue;
	}
	public void setDeclValue(double declValue) {
		this.declValue = declValue;
	}
	public String getCustAdr() {
		return custAdr;
	}
	public void setCustAdr(String custAdr) {
		this.custAdr = custAdr;
	}
	public String getPickTime() {
		return pickTime;
	}
	public void setPickTime(String pickTime) {
		this.pickTime = pickTime;
	}
	public String getShippingAdr() {
		return shippingAdr;
	}
	public void setShippingAdr(String shippingAdr) {
		this.shippingAdr = shippingAdr;
	}
	public String getShippingTime() {
		return shippingTime;
	}
	public void setShippingTime(String shippingTime) {
		this.shippingTime = shippingTime;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
//	public String getTrackingId() {
//		return trackingId;
//	}
//	public void setTrackingId(String trackingId) {
//		this.trackingId = trackingId;
//	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	

    
}


