package com.revature.gspj.gdf.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.gspj.gdf.bean.Order;
import com.revature.gspj.gdf.bean.OrderStatus;
import com.revature.gspj.gdf.service.OrderService;
import com.revature.gspj.gdf.wrapper.CartItem;
import com.revature.gspj.gdf.wrapper.ShoppingCart;

@Controller
public class OrderController {

	
	
	@Autowired
	private OrderService service;
	
	private Logger logger = Logger.getLogger(OrderService.class);
	public void setService(OrderService service) {
		this.service = service;
	}
	
	
	
	
	@RequestMapping(value="order/all", method=RequestMethod.GET)
	@ResponseBody
	public Set<Order> getAllOrders(){
		return service.getAllOrders();
	}
	
	@RequestMapping(value="order/allByStatus", method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Set<Order> getAllOrdersByStatus(@RequestBody OrderStatus status){
		return service.getOrderByStatus(status);
	}
	
	@RequestMapping(value="/order/update", method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Set<Order> updateOrder(@RequestBody Order order){
		return service.updateOrders(order);
	}
	
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
	@RequestMapping(value="/order/addItem", method=RequestMethod.POST)
	@ResponseBody
	public void addOrderLineToOrderInSession(@RequestBody CartItem item, HttpServletRequest request){
		service.addOrderLineToOrderInSession(item, request);
	}
	@RequestMapping(value="/order/commitSession", method=RequestMethod.POST)
	@ResponseBody
	public void commitOrderInSession(HttpServletRequest request){
		service.commitOrderInSession(request);
	}
	@RequestMapping(value="/order/allOrdersWithItems", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Set<ShoppingCart> allOrdersForCustomerWithItems(HttpServletRequest request){
		return service.getAllOrdersForCustomerWithItems(request);
	}
	

		
}
