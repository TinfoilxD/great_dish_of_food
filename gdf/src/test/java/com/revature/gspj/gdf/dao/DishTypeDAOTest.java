package com.revature.gspj.gdf.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.gspj.gdf.bean.DishType;
import com.revature.gspj.gdf.context.GDFContextHelper;
import com.revature.gspj.gdf.dao.DishTypeDAO;

public class DishTypeDAOTest {

	/*
	 * Methods to be tested:
	 * 	void createType();
	 *  List<DishType> getAllTypes();
	 *  DishType getTypeFromId(int id);
	 *  void updateType(DishType type);
	 */

	private static Logger logger;
	private static DishTypeDAO testDAO;
	
	@BeforeClass
	public static void setUp(){
		logger = Logger.getLogger(OrderStatusDAOTest.class);
		testDAO = (DishTypeDAO) GDFContextHelper.getContext().getBean("dishTypeDAO");

	}

	@Test
	public void test1(){
		DishType type = testDAO.getTypeFromId(1);
		logger.trace(type);
		assertEquals("Chicken",type.getType());
	}
	@Test
	public void test2(){
		List<DishType> types = testDAO.getAllTypes();
		logger.trace(types);
		assertTrue(types.size() > 0);
		
	}
}
