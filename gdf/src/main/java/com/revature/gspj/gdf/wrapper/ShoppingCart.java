package com.revature.gspj.gdf.wrapper;

import java.util.Set;

import com.revature.gspj.gdf.bean.Order;

public class ShoppingCart {
	private Order order;
	private Set<CartItem> orderLines;
	public ShoppingCart() {
		super();
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Set<CartItem> getOrderLines() {
		return orderLines;
	}
	public void setOrderLines(Set<CartItem> orderLines) {
		this.orderLines = orderLines;
	}
	
	
}
