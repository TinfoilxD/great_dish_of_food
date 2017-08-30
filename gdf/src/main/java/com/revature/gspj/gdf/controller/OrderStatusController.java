package com.revature.gspj.gdf.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.gspj.gdf.bean.Dish;
import com.revature.gspj.gdf.bean.OrderStatus;
import com.revature.gspj.gdf.service.DishService;
import com.revature.gspj.gdf.service.OrderStatusService;

@Controller
public class OrderStatusController {
	
	@Autowired
	OrderStatusService service;
	
	private Logger logger = Logger.getLogger(OrderStatusService.class);
	public void setService(OrderStatusService service) {
		this.service = service;
	}
	
	@RequestMapping(value="orderStatus/all", method = RequestMethod.GET)
	@ResponseBody
	public List<OrderStatus> getAllOrderStatus(){
		return service.getAllOrderStatus();
	}
	
	@RequestMapping(value="orderStatus/{id}", method = RequestMethod.GET)
	@ResponseBody
	public OrderStatus findById(@PathVariable int id) {
		return service.getOrderStatusById(id);
	}

}
