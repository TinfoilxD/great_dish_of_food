package com.revature.gspj.gdf.dao;

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

import com.revature.gspj.gdf.bean.Dish;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:gdf_spring.xml"})
@TransactionConfiguration
@Transactional
public class DishDAOTest extends AbstractTransactionalJUnit4SpringContextTests {
	/*
	 * List<Dish> getAllDishes();
	 * List<Dish> getDishesByType();
	 * void createDish(Dish dish);
	 * void editDish(Dish dish);
	 * void deleteDish(Dish dish);
	 * 
	 */
	
	private static Logger logger;
	@Autowired
	private DishDAO testDAO;
	
	public void setTestDAO(DishDAO testDAO) {
		this.testDAO = testDAO;
	}
	@BeforeClass
	public static void setUp(){
		logger = Logger.getLogger(DishDAOTest.class);
		//testDAO = (DishDAO) GDFContextHelper.getContext().getBean("dishDAOImpl");
	}
	@Test
	public void test1(){
		List<Dish> dishes = testDAO.getAllDishes();
		logger.trace(dishes);
		assertTrue(dishes.size() > 0);
	}
}
