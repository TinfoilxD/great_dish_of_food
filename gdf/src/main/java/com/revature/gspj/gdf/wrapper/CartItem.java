package com.revature.gspj.gdf.wrapper;

import com.revature.gspj.gdf.bean.Dish;

public class CartItem {
	private Dish dish;
	private int quantity;
	public CartItem() {
		super();
	}
	public Dish getDish() {
		return dish;
	}
	public void setDish(Dish dish) {
		this.dish = dish;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
