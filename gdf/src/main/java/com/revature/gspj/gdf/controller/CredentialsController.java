package com.revature.gspj.gdf.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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


	@RequestMapping(value = "/loginAuthentication", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public GDFUser userLogin(@RequestBody Credentials credentials){
		return service.authenticate(credentials);
	}
	

	   
	

}
