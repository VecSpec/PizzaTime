package com.revature.beans;

public class Pizza {

	private Integer pizzaID;
	private String pizzaType;
	private Double pizzaPrice;
	
	public Pizza()
	{
		
	}

	public Pizza(Integer pizzaID, String pizzaType, Double pizzaPrice) {
		this.pizzaID = pizzaID;
		this.pizzaType = pizzaType;
		this.pizzaPrice = pizzaPrice;
	}
	
	public Integer pizzaId() {
		return pizzaID;
	}

	public String getPizzaType() {
		return pizzaType;
	}

	public Double getPizzaPrice() {
		return pizzaPrice;
	}
	
	
	
}
