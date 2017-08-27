package com.revature.gspj.gdf.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.gspj.gdf.bean.DishType;
import com.revature.gspj.gdf.service.DishTypeService;


@Controller
public class DishTypeController {
	
	@Autowired
	private DishTypeService service;
	private Logger logger = Logger.getLogger(DishTypeController.class);
	
	public void setService(DishTypeService service) {
		this.service = service;
	}


	@RequestMapping(value = "/dishType/all", method = RequestMethod.GET)
	@ResponseBody
	public List<DishType> getAll(){
		return service.getAllTypes();
	}
	
	@RequestMapping(value = "/dishType/create", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void create(@RequestBody DishType dish){
		service.createType(dish);
	}
}
