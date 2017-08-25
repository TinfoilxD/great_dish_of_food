package com.revature.gspj.gdf.dao;

import java.util.List;

import com.revature.gspj.gdf.bean.Dish;

public interface DishDAO {
	List<Dish> getAllDishes();
	List<Dish> getDishesByType();
	void createDish(Dish dish);
	void editDish(Dish dish);
	void deleteDish(Dish dish);
}
