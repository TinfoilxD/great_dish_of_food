package com.revature.gspj.gdf.dao;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.revature.gspj.gdf.bean.OrderType;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:gdf_spring.xml"})
@TransactionConfiguration
@Transactional
public class OrderTypeDAOTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	/* Methods to be tested:
	 * List<OrderType> getAllTypes();
	 * OrderType getTypeFromId(int id);
	 */
	
	private static Logger logger = Logger.getLogger(OrderTypeDAOTest.class);;
	
	@Autowired
	private OrderTypeDAO testDAO;
	
	
	public void setTestDAO(OrderTypeDAO testDAO) {
		this.testDAO = testDAO;
	}

	@Test
	public void test1(){
		List list = testDAO.getAllTypes();
		logger.trace(list);
		assertTrue(list.size() > 0);
	}
	@Test
	public void test2(){
		OrderType type = testDAO.getTypeFromId(1);
		logger.trace(type);
		assertEquals("Delivery",type.getType());
	}
	

}
