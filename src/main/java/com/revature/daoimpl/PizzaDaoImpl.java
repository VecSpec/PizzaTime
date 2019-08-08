package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Order;
import com.revature.beans.Pizza;
import com.revature.dao.PizzaDao;
import com.revature.util.ConnFactory;

public class PizzaDaoImpl implements PizzaDao {
	
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public Pizza getPizza(Integer pizzaID) throws SQLException {
		Pizza za = null;
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM PIZZA WHERE PIZZAID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, pizzaID);
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
			za = new Pizza(rs.getInt(1), rs.getString(2), rs.getDouble(3));
		}
		return za;
	}

	@Override
	public List<Pizza> getPizzaList() throws SQLException {
		List<Pizza> pizzaList = new ArrayList<Pizza>();
		Connection conn = cf.getConnection();
		//Statement - compiles on SQL side. Generally terrible. Allows for SQL Injection. Headaches. DON'T DO IT.
		Statement stmt = conn.createStatement();
		//SEMICOLON built into query. Nice. :D
		ResultSet rs = stmt.executeQuery("SELECT * FROM PIZZA");
		Pizza za = null;
		while (rs.next())
		{
			//ResultSet columns start at 1.
			za = new Pizza(rs.getInt(1), rs.getString(2), rs.getDouble(3));
			pizzaList.add(za);
		}
		return pizzaList;
	}

	// To change pizza type from existing order to another one.
	@Override
	public void changePizza(Integer pizzaID, Integer newPizzaID) throws SQLException {
		// TODO Auto-generated method stub

	}

}
