package com.revature.gspj.gdf.dao;


import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.gspj.gdf.bean.OrderType;
import com.revature.gspj.gdf.dao.OrderTypeDAO;
import com.revature.gspj.gdf.dao.OrderTypeDAOImplNotUsedDeleteEventually;

public class OrderTypeDAOTest {
	
	/* Methods to be tested:
	 * List<OrderType> getAllTypes();
	 * OrderType getTypeFromId(int id);
	 */
	
	private static Logger logger;
	private static SessionFactory sessionFactory;
	private Session session;
	private OrderTypeDAO testDAO;
	
	@BeforeClass
	public static void setUp(){
		logger = Logger.getLogger(OrderTypeDAOTest.class);
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}
	@Before
	public void beforeTest(){
		
		session = sessionFactory.openSession();
		testDAO = new OrderTypeDAOImplNotUsedDeleteEventually(session); //can refactor this later to inject the dao object
		//testDAO.setSession(session); not possible because setSession does not exist in interface
	}
	@After
	public void afterTest(){
		session.close();
	}
	
	@AfterClass
	public static void dismantle(){
		sessionFactory.close();
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
