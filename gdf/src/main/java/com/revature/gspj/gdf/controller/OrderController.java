package com.revature.gspj.gdf.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.gspj.gdf.service.OrderService;
import com.revature.gspj.gdf.wrapper.ShoppingCart;

@Controller
public class OrderController {
	
	@Autowired
	OrderService service;
	
	@RequestMapping(value="/order/putSession", method=RequestMethod.POST)
	public void createOrderInSession(HttpServletRequest request, HttpServletResponse response){
		service.createOrderInSession(request, response);
	}
	
	@RequestMapping(value="/order/inSession", method=RequestMethod.GET)
	@ResponseBody
	public ShoppingCart getOrderInSession(HttpServletRequest request){

		return service.getOrderInSession(request);
	}
	@RequestMapping(value="/order/removeSession", method=RequestMethod.POST)
	@ResponseBody
	public void removeOrderFromSession(HttpServletRequest request){
		service.removeOrderFromSession(request);
	}
	

		
}
