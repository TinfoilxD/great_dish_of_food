package com.revature.gspj.gdf.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.gspj.gdf.bean.Credentials;
import com.revature.gspj.gdf.bean.DishType;
import com.revature.gspj.gdf.service.GDFUserService;
import com.revature.gspj.gdf.service.DishTypeService;

@Controller
public class CredentialsController {
	
	@Autowired
	private GDFUserService service;
	private Logger logger = Logger.getLogger(CredentialsController.class);
	
	public void setService(GDFUserService service) {
		this.service = service;
	}



	@RequestMapping(value = "/login", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void create(@RequestBody Credentials credentials){
		service.authenticate(credentials);
	}

}
