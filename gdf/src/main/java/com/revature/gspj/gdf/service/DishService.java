package com.revature.gspj.gdf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.gspj.gdf.bean.Dish;
import com.revature.gspj.gdf.bean.DishType;
import com.revature.gspj.gdf.dao.DishDAO;
import com.revature.gspj.gdf.dao.DishTypeDAO;
import com.revature.gspj.gdf.wrapper.DishDishType;

@Service
@Transactional
public class DishService {
	
	@Autowired
	private DishDAO dao;
	@Autowired
	private DishTypeDAO typeDAO;

	public void setDao(DishDAO dao) {
		this.dao = dao;
	}
	
	public void createDish(Dish dish){
		dao.createDish(dish);
	}
	
	public List<Dish> getAllDishes(){
		return dao.getAllDishes();
	}
	
	public void addDishTypeToDish(DishDishType ddt){
		// these dish and types need to be resolved to the ones that exist in the session because 
		// @JsonIgnore ignored their set properties which is needed for update.
		int dishId = ddt.getDish().getId();
		int dishTypeId = ddt.getType().getId();
		Dish dish = dao.getDishById(dishId);
		DishType type = typeDAO.getTypeFromId(dishTypeId);
		dao.addDishTypeToDish(type, dish);
	}
}
