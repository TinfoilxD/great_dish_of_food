package com.revature.gspj.gdf.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.revature.gspj.gdf.bean.DishType;
import com.revature.gspj.gdf.context.GDFContextHelper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:gdf_spring.xml"})
@TransactionConfiguration
@Transactional
public class DishTypeDAOTest extends AbstractTransactionalJUnit4SpringContextTests {

	/*
	 * Methods to be tested:
	 * 	void createType();
	 *  List<DishType> getAllTypes();
	 *  DishType getTypeFromId(int id);
	 *  void updateType(DishType type);
	 */

	private static Logger logger = Logger.getLogger(OrderStatusDAOTest.class);;
	@Autowired
	private DishTypeDAO testDAO;
	
	public void setTestDAO(DishTypeDAO testDAO) {
		this.testDAO = testDAO;
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
