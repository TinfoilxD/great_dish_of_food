package com.revature.gspj.gdf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.gspj.gdf.bean.Dish;
import com.revature.gspj.gdf.dao.DishDAO;

@Service
@Transactional
public class DishService {
	
	@Autowired
	private DishDAO dao;

	public void setDao(DishDAO dao) {
		this.dao = dao;
	}
	
	public void createDish(Dish dish){
		dao.createDish(dish);
	}
	
	public List<Dish> getAllDishes(){
		return dao.getAllDishes();
	}
}
