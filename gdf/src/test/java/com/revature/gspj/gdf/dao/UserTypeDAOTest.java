package com.revature.gspj.gdf.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.gspj.gdf.bean.UserType;
import com.revature.gspj.gdf.context.GDFContextHelper;
import com.revature.gspj.gdf.dao.DishTypeDAO;
import com.revature.gspj.gdf.dao.UserTypeDAO;

public class UserTypeDAOTest {
	
	/*
	 * Methods to test:
	 * 		List<UserType> getAllTypes();
			UserType getTypeFromId(int id);
	 */

	
	private static Logger logger;
	private static UserTypeDAO testDAO;
	private SessionFactory sessionFactory;
	
	@BeforeClass
	public static void setUp(){
		logger = Logger.getLogger(OrderStatusDAOTest.class);
		testDAO = (UserTypeDAO) GDFContextHelper.getContext().getBean("userTypeDAO");
	}
	
	
	//List<UserType> getAllTypes();
	@Test
	public void test1(){
		List<UserType> types = testDAO.getAllTypes();
		logger.trace(types);
		assertTrue(types.size() > 0);
		
	}
	
	//UserType getTypeFromId(int id);
	@Test
	public void test2(){
		UserType userType = testDAO.getTypeFromId(1);
		logger.trace(userType);
		
		assertEquals(userType.getType(),"Employee");
		
		
	}
	
	

}
