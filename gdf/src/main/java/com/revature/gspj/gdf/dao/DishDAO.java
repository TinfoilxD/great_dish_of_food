package com.revature.gspj.gdf.dao;

import java.util.List;

import com.revature.gspj.gdf.bean.Dish;
import com.revature.gspj.gdf.bean.DishType;
import com.revature.gspj.gdf.bean.OrderLine;

public interface DishDAO {
	List<Dish> getAllDishes();
	List<DishType> getDishTypesForDish(Dish dish);
	List<Dish> getDishesByType(DishType type);
	Dish getDishById(int id);
	Dish getDishByName(String name);
	void createDish(Dish dish);
	void editDish(Dish dish);
	void deleteDish(Dish dish);
	void addDishTypeToDish(DishType type, Dish dish);
	void removeDishTypeFromDish(DishType type, Dish dish);
	List<OrderLine> getOrderLinesForDish(Dish dish);
}
