package com.revature.gspj.gdf.dao;

import java.util.List;

import com.revature.gspj.gdf.bean.Dish;
import com.revature.gspj.gdf.bean.GDFUser;
import com.revature.gspj.gdf.bean.Order;
import com.revature.gspj.gdf.bean.OrderLine;
import com.revature.gspj.gdf.bean.OrderStatus;
import com.revature.gspj.gdf.bean.OrderType;

public interface OrderDAO {
	List<Order> getAllOrders();
	List<Order> getOrdersForUser(GDFUser user);
	List<Order> getOrdersForStatus(OrderStatus status);
	List<Order> getOrdersForType(OrderType type);
	Order getOrderFromId(int id);
	void editOrder(Order order);
	void deleteOrder(Order order);
	void createOrder(Order order);
	void addOrderLineToOrder(OrderLine orderLine);
	void removeOrderLineFromOrder(OrderLine orderLine);
	List<OrderLine> getOrderLinesForOrder(Order order);
}
