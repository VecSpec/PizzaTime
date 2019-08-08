package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Order;
import com.revature.dao.OrderDao;
import com.revature.util.ConnFactory;

public class OrderDaoImpl implements OrderDao {
	
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public Order getOrder(Integer orderID) throws SQLException {
		Order order = null;
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM ORDER WHERE ORDERID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, orderID);
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
			order = new Order(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
		}
		return order;
	}

	@Override
	public List<Order> getPastOrders() throws SQLException {
		List<Order> orderList = new ArrayList<Order>();
		Connection conn = cf.getConnection();
		//Statement - compiles on SQL side. Generally terrible. Allows for SQL Injection. Headaches. DON'T DO IT.
		Statement stmt = conn.createStatement();
		//SEMICOLON built into query. Nice. :D
		ResultSet rs = stmt.executeQuery("SELECT * FROM ORDER");
		Order order = null;
		while (rs.next())
		{
			//ResultSet columns start at 1.
			order = new Order(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
			orderList.add(order);
		}
		return orderList;
	}

}
