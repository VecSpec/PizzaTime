package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Pizza;

public interface PizzaDao {
	
	public abstract Pizza getPizza(Integer pizzaID) throws SQLException;
	
	public abstract List<Pizza> getPizzaList() throws SQLException;
	
	public abstract void changePizza(Integer pizzaID, Integer newPizzaID) throws SQLException;

}
