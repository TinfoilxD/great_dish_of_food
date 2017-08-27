package com.revature.gspj.gdf.dao;

import java.util.List;

import com.revature.gspj.gdf.bean.Dish;
import com.revature.gspj.gdf.bean.DishType;

public interface DishDAO {
	List<Dish> getAllDishes();
	List<Dish> getDishesByType(DishType type);
	void createDish(Dish dish);
	void editDish(Dish dish);
	void deleteDish(Dish dish);
}
