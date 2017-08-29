package com.revature.gspj.gdf.wrapper;

import com.revature.gspj.gdf.bean.Dish;
import com.revature.gspj.gdf.bean.DishType;

public class DishDishType {
	private Dish dish;
	private DishType type;
	public DishDishType() {
		super();
	}
	public Dish getDish() {
		return dish;
	}
	public void setDish(Dish dish) {
		this.dish = dish;
	}
	public DishType getType() {
		return type;
	}
	public void setType(DishType type) {
		this.type = type;
	}
	
}
