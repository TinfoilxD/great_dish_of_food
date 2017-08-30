package com.revature.gspj.gdf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.gspj.gdf.bean.OrderStatus;
import com.revature.gspj.gdf.dao.OrderStatusDAO;

@Service
public class OrderStatusService {
	
	@Autowired
	private OrderStatusDAO dao;
	
	public void setDao(OrderStatusDAO dao) {
		this.dao = dao;
	}
	
	@Transactional
	public List<OrderStatus> getAllOrderStatus(){
		return dao.getAllStatus();
	}
	
	public OrderStatus getOrderStatusById(int id){
		return dao.getStatusFromId(id);
	}

}
