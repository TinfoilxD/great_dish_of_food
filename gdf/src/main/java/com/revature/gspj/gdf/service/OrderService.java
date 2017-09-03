package com.revature.gspj.gdf.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.gspj.gdf.bean.GDFUser;
import com.revature.gspj.gdf.bean.Order;
import com.revature.gspj.gdf.bean.OrderLine;
import com.revature.gspj.gdf.dao.OrderDAO;
import com.revature.gspj.gdf.dao.OrderStatusDAO;
import com.revature.gspj.gdf.dao.OrderTypeDAO;
import com.revature.gspj.gdf.wrapper.CartItem;
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
	@Autowired
	private OrderStatusDAO statusDAO;
	@Autowired
	private OrderTypeDAO typeDAO;
	
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
		Set<CartItem> orderLines = new HashSet<>();
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
	public void commitOrderInSession(HttpServletRequest request){
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("shoppingCart");
		
		
		//persisting the Order object changes the id of the referenced order.
		//The empty order id will have a value
		
		Order order = cart.getOrder();
		order.setStatus(statusDAO.getStatusFromName("Received"));
		order.setType(typeDAO.getTypeFromName("Delivery"));
		order.setSubmitted(Calendar.getInstance());
		order.setUser((GDFUser) request.getSession().getAttribute("user"));
		dao.createOrder(order);
		Set<CartItem> orderLines = cart.getOrderLines();
		for(CartItem item: orderLines){
			OrderLine newOrderLine = new OrderLine();
			newOrderLine.setDish(item.getDish());
			newOrderLine.setOrder(order);
			newOrderLine.setQuantity(item.getQuantity());
			dao.addOrderLineToOrder(newOrderLine);
		}
		request.getSession().removeAttribute("shoppingCart");
	}

	public List<Order> getAllOrders() {
		return dao.getAllOrders();
	}
	
	public void createOrder(Order order) {
		dao.createOrder(order);
	}

	/**
	 * Adds a temporary cartitem into the shoppingcart held in the session.
	 * Nothing is persisted at this point.
	 * The CartItem information will be used to persist the order when it is committed.
	 * 
	 * @param item
	 * @param request
	 */
	public void addOrderLineToOrderInSession(CartItem item, HttpServletRequest request) {
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("shoppingCart");
		cart.getOrderLines().add(item);
	}


	public List<Order> updateOrders(Order order) {
		dao.editOrder(order);
		return dao.getAllOrders();
	}


	/**
	 * Alternate get order all request mapping to return orders along with its associated
	 * order lines as cartitems.
	 * @param request
	 * @return
	 */
	public Set<ShoppingCart> getAllOrdersForCustomerWithItems(HttpServletRequest request) {
		
		//list of orders in database that ignores orderlines in json parsing
		GDFUser user = (GDFUser) request.getSession().getAttribute("user");
		List<Order> orders = dao.getOrdersForUser(user);
		
		//list of empty shoppingcart sets that will be returned
		Set<ShoppingCart> orderWithItems = new HashSet<>();
		
		/*
		 * Loops through orders and converst each order to a shoppingcart item
		 */
		for(Order order: orders){
			
			ShoppingCart cart = new ShoppingCart();
			cart.setOrder(order);
			
			Set<CartItem> cartItems = new HashSet<>();
			Set<OrderLine> orderLines = order.getOrderLines();
			
			for(OrderLine orderline: orderLines){
				CartItem item = new CartItem();
				item.setDish(orderline.getDish());
				item.setQuantity(orderline.getQuantity());
				cartItems.add(item);
			}
			cart.setOrderLines(cartItems);
			orderWithItems.add(cart);
		} // end order: orders for loop
		
		return orderWithItems;
	}

}
