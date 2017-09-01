package com.revature.gspj.gdf.controller;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.gspj.gdf.bean.Dish;
import com.revature.gspj.gdf.bean.DishType;
import com.revature.gspj.gdf.service.DishService;
import com.revature.gspj.gdf.wrapper.DishDishType;

@Controller
public class DishController {
	
	@Autowired
	DishService service;
	private Logger logger = Logger.getLogger(DishController.class);
	public void setService(DishService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/dish/all", method = RequestMethod.GET)
	@ResponseBody
	public Set<Dish> getAllDishes(){
		return service.getAllDishes();
	}
	
	@RequestMapping(value = "/dish/create", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void createDish(@RequestBody Dish dish){
		service.createDish(dish);
	}
	
	
	@RequestMapping(value = "/dish/addType", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void addDishTypeToDish(@RequestBody DishDishType ddt){
		service.addDishTypeToDish(ddt);
	}
	
	@RequestMapping(value = "/dish/getTypes", method= RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<DishType> getDishTypesForDish(@RequestBody Dish dish){
		return service.getDishTypesForDish(dish);
	}
	
	@RequestMapping(value = "/dish/removeType", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void removeDishTypeFromDish(@RequestBody DishDishType ddt){
		service.removeDishTypeFromDish(ddt);
	}
}
