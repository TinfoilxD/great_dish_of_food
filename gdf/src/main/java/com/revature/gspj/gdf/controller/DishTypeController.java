package com.revature.gspj.gdf.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.gspj.gdf.bean.DishType;
import com.revature.gspj.gdf.dao.DishTypeDAO;


@Controller
public class DishTypeController {
	
	@Autowired
	private DishTypeDAO dao;
	private Logger logger = Logger.getLogger(DishTypeController.class);
	
	public void setDao(DishTypeDAO dao) {
		this.dao = dao;
	}



	@RequestMapping(value = "/dishType/create", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public DishType create(@RequestBody DishType dish){
		dao.createType(dish);
		return dish;
	}
}
