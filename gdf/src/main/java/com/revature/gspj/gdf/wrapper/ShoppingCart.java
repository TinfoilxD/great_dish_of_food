package com.revature.gspj.gdf.wrapper;

import java.util.Map;

import com.revature.gspj.gdf.bean.Dish;
import com.revature.gspj.gdf.bean.Order;

public class ShoppingCart {
	private Order order;
	private Map<Dish, Integer> orderLines;
	public ShoppingCart() {
		super();
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Map<Dish, Integer> getOrderLines() {
		return orderLines;
	}
	public void setOrderLines(Map<Dish, Integer> orderLines) {
		this.orderLines = orderLines;
	}
	
	
}
