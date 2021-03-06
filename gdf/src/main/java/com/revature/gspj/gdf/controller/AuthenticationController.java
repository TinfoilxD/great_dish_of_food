package com.revature.gspj.gdf.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.revature.gspj.gdf.bean.DishType;
import com.revature.gspj.gdf.bean.GDFUser;
import com.revature.gspj.gdf.service.GDFUserService;
import com.revature.gspj.gdf.wrapper.Credentials;
import com.revature.gspj.gdf.service.DishTypeService;

@Controller
public class AuthenticationController {
	
	@Autowired
	private GDFUserService service;
	private Logger logger = Logger.getLogger(AuthenticationController.class);
	
	
	public void setService(GDFUserService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/loginAuthentication", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public GDFUser userLogin(@RequestBody Credentials credentials,HttpServletResponse response,HttpServletRequest request){
		try{
			GDFUser user = service.authenticate(credentials);
			HttpSession session = request.getSession();
			session.setAttribute("user",user);
			return user;
		}catch(IllegalArgumentException e){
			logger.debug("message", e);
			response.setStatus(401);
		}
		return null;
	}
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	@ResponseBody
	public void logout(HttpServletRequest request){
		service.logout(request);
	}

	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	@ResponseBody
	public void register(@RequestBody GDFUser user){
		logger.debug(user);
		service.registerUser(user);
	}
	
}

	

	   
	


