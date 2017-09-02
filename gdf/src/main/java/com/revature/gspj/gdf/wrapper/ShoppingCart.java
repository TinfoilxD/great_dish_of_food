package com.revature.gspj.gdf.wrapper;

import java.util.List;

import com.revature.gspj.gdf.bean.Order;

public class ShoppingCart {
	private Order order;
	private List<CartItem> orderLines;
	public ShoppingCart() {
		super();
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public List<CartItem> getOrderLines() {
		return orderLines;
	}
	public void setOrderLines(List<CartItem> orderLines) {
		this.orderLines = orderLines;
	}
	
	
}
