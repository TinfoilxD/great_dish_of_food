package com.revature.gspj.gdf.dao;

import java.util.List;

import com.revature.gspj.gdf.bean.Dish;
import com.revature.gspj.gdf.bean.GDFUser;
import com.revature.gspj.gdf.bean.Order;
import com.revature.gspj.gdf.bean.OrderStatus;
import com.revature.gspj.gdf.bean.OrderType;

public class OrderImpl implements OrderDAO {

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrdersForUser(GDFUser user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrdersForStatus(OrderStatus status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrdersForType(OrderType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dish> getDishesForOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getOrderFromId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editOrder(Order order) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteOrder(Order order) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createOrder(Order order) {
		// TODO Auto-generated method stub

	}

}
