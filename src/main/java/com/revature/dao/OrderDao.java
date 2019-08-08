package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Order;

public interface OrderDao {
	
	public abstract Order getOrder(Integer orderID) throws SQLException;
	
	public abstract List<Order> getPastOrders() throws SQLException;

}
