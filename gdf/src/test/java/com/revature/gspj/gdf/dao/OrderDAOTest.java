package com.revature.gspj.gdf.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.revature.gspj.gdf.bean.Order;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:gdf_spring.xml" })
@TransactionConfiguration
@Transactional
public class OrderDAOTest {

	@Autowired
	private OrderDAO testDAO;
	private static Logger logger = Logger.getLogger(OrderDAOTest.class);

	public void setTestDAO(OrderDAO testDAO) {
		this.testDAO = testDAO;
	}

	@Test
	public void testGetAllOrders() {

		List<Order> order = testDAO.getAllOrders();
		logger.info(order.size());
		assertTrue(order.size() > 0);
	}

}
