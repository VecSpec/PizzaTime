package com.revature.beans;

public class Order {
	
	private Integer orderID;
	private String orderName;
	private Integer pizzaID;
	private String orderAddr;
	
	public Order()
	{
		
	}

	public Order(Integer orderID, String orderName, Integer pizzaID, String orderAddr) {
		this.orderID = orderID;
		this.orderName = orderName;
		this.pizzaID = pizzaID;
		this.orderAddr = orderAddr;
	}

	public Integer getOrderID() {
		return orderID;
	}

	public String getOrderName() {
		return orderName;
	}

	public Integer getPizzaID() {
		return pizzaID;
	}

	public String getOrderAddr() {
		return orderAddr;
	}

	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", orderName=" + orderName + ", orderDesc=" + pizzaID + ", orderAddr="
				+ orderAddr + "]";
	}
	
	

}
