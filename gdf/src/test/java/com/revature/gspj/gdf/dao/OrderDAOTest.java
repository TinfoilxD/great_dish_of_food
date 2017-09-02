package com.revature.gspj.gdf.dao;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.revature.gspj.gdf.bean.GDFUser;
import com.revature.gspj.gdf.bean.Order;
import com.revature.gspj.gdf.bean.OrderStatus;
import com.revature.gspj.gdf.bean.OrderType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:gdf_spring.xml" })
@TransactionConfiguration
@Transactional
public class OrderDAOTest {

	@Autowired
	private OrderDAO testDAO;
	
	@Autowired
	private GDFUserDAO GDFtestDAO;
	
	@Autowired
	private OrderStatusDAO StatusTestDAO;
	
	@Autowired
	private OrderTypeDAO TypeTestDAO;
	
	
	private static Logger logger = Logger.getLogger(OrderDAOTest.class);

	public void setTestDAO(OrderDAO testDAO) {
		this.testDAO = testDAO;
	}

	@Test
	public void testGetAllOrders() {

		List<Order> order = testDAO.getAllOrders();
		logger.info("testGetAllOrders_test " + order.size());
		assertTrue(order.size() > 0);
		assertEquals(order.size(),3);
	}
	
	@Test
	public void testGetAllOrdersByUser() {
		GDFUser user = GDFtestDAO.getUserFromId(1);
		List<Order> order = testDAO.getOrdersForUser(user);
		logger.info("testGetAllOrdersByUser_test " + user.getFirstName() + " "+order.get(0).getStatus().getStatus());
		assertTrue(order.size() > 0);
		assertEquals(order.size(),1);
		assertEquals("Delivered",order.get(0).getStatus().getStatus());
	}
	
	@Test
	public void testGetAllOrdersByStatus() {
		OrderStatus status = StatusTestDAO.getStatusFromId(2);
		List<Order> order = testDAO.getOrdersForStatus(status);
		logger.info("testGetAllOrdersByStatus_test " + " "+ order.size());
		assertTrue(order.size() > 0);
		assertEquals(2,order.get(0).getId());
		assertEquals(3,order.get(1).getId());
	}
	
	@Test
	public void testGetAllOrdersByType() {
		OrderType type = TypeTestDAO.getTypeFromId(1);
		List<Order> order = testDAO.getOrdersForType(type);
		logger.info("testGetAllOrdersByType_test " + " "+ order.size());
		assertTrue(order.size() > 0);
		assertEquals(order.size(),1);
		assertEquals(4,order.get(0).getStatus().getId());
		//assertEquals(3,order.get(1).getId());
	}
	
	@Test
	public void getOrderFromIdTest() {
		Order order = testDAO.getOrderFromId(3);
		//List<Order> order = testDAO.getOrdersForType(type);
		logger.info("getOrderFromIdTest_test " + " "+ order.getStatus().getId());
		assertEquals(2,order.getStatus().getId());
		//assertEquals(3,order.get(1).getId());
	}
	
	@Test
	public void editOrder() {
		Order order = testDAO.getOrderFromId(3);
		OrderStatus status = StatusTestDAO.getStatusFromId(3);
		assertEquals(2,order.getStatus().getId());
		order.setStatus(status);
		testDAO.editOrder(order);
		order = testDAO.getOrderFromId(3);
		logger.info("getOrderFromIdTest_test " + " "+ order.getStatus().getId());
		assertEquals(3,order.getStatus().getId());
		
	}
	
	@Test
	public void deleteOrder() {
		Order order = testDAO.getOrderFromId(3);
		assertEquals(2,order.getStatus().getId());
		testDAO.deleteOrder(order);
		order = testDAO.getOrderFromId(3);
		assertEquals(null,testDAO.getOrderFromId(3));
		
	}
	
	@Test
	public void createOrder() {
		GDFUser user = GDFtestDAO.getUserFromId(1);
		OrderStatus status = StatusTestDAO.getStatusFromId(1);
		OrderType type = TypeTestDAO.getTypeFromId(1);
		Order order = new Order();
		order.setSubmitted(Calendar.getInstance());
		order.setType(type);
		order.setStatus(status);
		order.setUser(user);
		testDAO.createOrder(order);

	}

}
