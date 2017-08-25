package com.revature.gspj.gdf.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.gspj.gdf.bean.OrderStatus;
import com.revature.gspj.gdf.context.GDFContextHelper;
import com.revature.gspj.gdf.dao.DishTypeDAO;
import com.revature.gspj.gdf.dao.OrderStatusDAO;
import com.revature.gspj.gdf.dao.UserTypeDAO;

public class OrderStatusDAOTest {

	/*
	 * Methods to be tested:
	 * List<OrderStatus> getAllStasus();
	 * OrderStatus getStatusFromId(int id);
	 */
	
	private static Logger logger;
	private static OrderStatusDAO testDAO;
	
	@BeforeClass
	public static void setUp(){
		logger = Logger.getLogger(OrderStatusDAOTest.class);
		//testDAO = (OrderStatusDAO) GDFContextHelper.getContext().getBean(OrderStatusDAO.class);
		testDAO = (OrderStatusDAO) GDFContextHelper.getContext().getBean("orderStatusDAO");
	}
	
	
	@Test
	public void test1(){
		List<OrderStatus> status = testDAO.getAllStatus();
		logger.trace(status);
		assertTrue(status.size() > 0);
	}
	@Test
	public void test2(){
		OrderStatus status = testDAO.getStatusFromId(1);
		assertEquals("Received",status.getStatus());
	}
}
