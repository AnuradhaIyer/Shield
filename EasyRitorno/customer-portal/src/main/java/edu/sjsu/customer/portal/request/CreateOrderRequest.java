package edu.sjsu.customer.portal.request;

import java.io.Serializable;
/**
	 * @author Anuradha Rajashekar
	 */

public class CreateOrderRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String custId;
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

	public CreateOrderRequest() {
	}

	public CreateOrderRequest(String custId, String packType, double declValue, String custAdr,
			String pickTime, String shippingAdr, String shippingTime, double totalCost, 
			String orderStatus) {
		super();
		this.custId = custId;
		this.packType = packType;
//		this.weight = weight;
		this.declValue = declValue;
		this.custAdr = custAdr;
		this.pickTime = pickTime;
		this.shippingAdr = shippingAdr;
		this.shippingTime = shippingTime;
		this.totalCost = totalCost;
//		this.trackingId = trackingId;
		this.orderStatus = orderStatus;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
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
//
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
//
//	public void setTrackingId(String trackingId) {
//		this.trackingId = trackingId;
//	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CreateOrderRequest [custId=" + custId + ", packType=" + packType + ", declValue="
				+ declValue + ", custAdr=" + custAdr + ", pickTime=" + pickTime + ", shippingAdr=" + shippingAdr
				+ ", shippingTime=" + shippingTime + ", totalCost=" + totalCost + ",  orderStatus=" + orderStatus + "]";
	}

}
