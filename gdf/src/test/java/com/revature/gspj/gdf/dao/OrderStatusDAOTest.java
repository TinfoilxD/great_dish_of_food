package com.revature.gspj.gdf.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.revature.gspj.gdf.bean.OrderStatus;
import com.revature.gspj.gdf.context.GDFContextHelper;
import com.revature.gspj.gdf.dao.DishTypeDAO;
import com.revature.gspj.gdf.dao.OrderStatusDAO;
import com.revature.gspj.gdf.dao.UserTypeDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:gdf_spring.xml"})
@TransactionConfiguration
@Transactional
public class OrderStatusDAOTest {

	/*
	 * Methods to be tested:
	 * List<OrderStatus> getAllStasus();
	 * OrderStatus getStatusFromId(int id);
	 */
	
	@Autowired
	private OrderStatusDAO testDAO;
	private static Logger logger = Logger.getLogger(OrderStatusDAOTest.class);;
	
	public void setTestDAO(OrderStatusDAO testDAO) {
		this.testDAO = testDAO;
	}
	
	
	 
		//testDAO = (OrderStatusDAO) GDFContextHelper.getContext().getBean(OrderStatusDAO.class);
	
	
	
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
