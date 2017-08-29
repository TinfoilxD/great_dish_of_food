package com.revature.gspj.gdf.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.gspj.gdf.bean.Dish;
import com.revature.gspj.gdf.service.DishService;

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
	public List<Dish> getAllDishes(){
		return service.getAllDishes();
	}
}
