package com.revature.gspj.gdf.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.revature.gspj.gdf.bean.Credentials;
import com.revature.gspj.gdf.bean.DishType;
import com.revature.gspj.gdf.bean.GDFUser;
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



	@RequestMapping(value = "/gdf/login", method = { RequestMethod.POST, RequestMethod.GET },
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public GDFUser create(@RequestBody Credentials credentials){
		System.out.println("in conrtroller");
		return service.authenticate(credentials);
	}
	
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	@ResponseBody
//	public GDFUser getUser(@RequestBody Credentials credentials){
//		return service.authenticate(credentials);
//	}

}
