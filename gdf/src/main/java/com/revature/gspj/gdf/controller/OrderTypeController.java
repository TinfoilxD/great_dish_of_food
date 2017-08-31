package com.revature.gspj.gdf.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.gspj.gdf.bean.OrderStatus;
import com.revature.gspj.gdf.bean.OrderType;
import com.revature.gspj.gdf.service.OrderStatusService;
import com.revature.gspj.gdf.service.OrderTypeService;

@Controller
public class OrderTypeController {
	
	@Autowired
	private OrderTypeService service;
	
	private Logger logger = Logger.getLogger(OrderTypeController.class);
	public void setService(OrderTypeService service) {
		this.service = service;
	}
	
	@RequestMapping(value="orderType/all", method = RequestMethod.GET)
	@ResponseBody
	public List<OrderType> getAll(){
		return service.getAllOrderTypes();
	}
		
	

}
