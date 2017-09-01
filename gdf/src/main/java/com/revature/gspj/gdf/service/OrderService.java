package com.revature.gspj.gdf.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.gspj.gdf.bean.Dish;
import com.revature.gspj.gdf.bean.Order;
import com.revature.gspj.gdf.dao.OrderDAO;
import com.revature.gspj.gdf.wrapper.ShoppingCart;

/**
 * This class is responsible for order dao methods.
 * It also services most of the customer requests
 *
 */
@Service
public class OrderService {
	
	@Autowired
	private OrderDAO dao;
	
	private Logger logger = Logger.getLogger(OrderStatusService.class);
	public void setDAO(OrderDAO dao) {
		this.dao = dao;
	}
	

	/**
	 * Creates a temporary order and puts it in session.
	 * The order is not committed until the customer checks out.
	 * @param request
	 * @param response
	 */
	public void createOrderInSession(HttpServletRequest request, HttpServletResponse response) {
		Order order = new Order();
		Map<Dish,Integer> orderLines = new HashMap<Dish,Integer>();
		ShoppingCart cart = new ShoppingCart();
		cart.setOrder(order);
		cart.setOrderLines(orderLines);
		request.getSession().setAttribute("shoppingCart", cart);
	}

	/**
	 * Returns the current order in session. This is used to check whether or not the customer
	 * has started an order.
	 * @param request
	 * @return
	 */
	public ShoppingCart getOrderInSession(HttpServletRequest request) {
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("shoppingCart");
		return cart;
		
	}

	/**
	 * Equivalent to the act of canceling the order. Removes the order and orderlines from session.
	 * 
	 * @param request
	 */
	public void removeOrderFromSession(HttpServletRequest request) {
		request.getSession().removeAttribute("shoppingCart");
		
	}
	
	/**
	 * Commits order to database. This means the customer checked out.
	 */
	public void commitOrderInSession(){
		/*
		 * NOT YET IMPLEMENTED
		 */
	}

	public List<Order> getAllOrders() {
		return dao.getAllOrders();
	}
	
	public void createOrder(Order order) {
		dao.createOrder(order);
	}

}
