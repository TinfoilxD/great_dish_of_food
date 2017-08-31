package com.revature.gspj.gdf.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.gspj.gdf.bean.OrderType;
import com.revature.gspj.gdf.controller.OrderTypeController;
import com.revature.gspj.gdf.dao.OrderStatusDAO;
import com.revature.gspj.gdf.dao.OrderTypeDAO;

@Service
public class OrderTypeService {
	
	@Autowired
	private OrderTypeDAO dao;
	
	private Logger logger = Logger.getLogger(OrderTypeDAO.class);
	public void setDAO(OrderTypeDAO dao) {
		this.dao = dao;
	}

	public List<OrderType> getAllOrderTypes() {
		// TODO Auto-generated method stub
		return dao.getAllTypes();
	}

}
