package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Pizza;
import com.revature.daoimpl.PizzaDaoImpl;

/**
 * Servlet implementation class PizzaServlet
 */
public class PizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PizzaDaoImpl pdi = new PizzaDaoImpl();
		response.setContentType("application/json");
		ArrayList<Pizza> pizzas = null;
		
		try {
			pizzas = new ArrayList<Pizza>(pdi.getPizzaList());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out.print(pizzas);
		RequestDispatcher rd = request.getRequestDispatcher("order.html");
		rd.forward(request, response);
	}

}
