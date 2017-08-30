package com.revature.gspj.gdf.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.revature.gspj.gdf.bean.Dish;
import com.revature.gspj.gdf.bean.DishType;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:gdf_spring.xml"})
@TransactionConfiguration
@Transactional
public class DishDAOTest extends AbstractTransactionalJUnit4SpringContextTests {
	/*
	 * List<Dish> getAllDishes();
	 * Dish getDishById();
	 * Dish getDishByName();
	 * List<Dish> getDishesByType(Dishtype type);
	 * List<DishType> getDishTypesForDish(Dish dish);
	 * void createDish(Dish dish);
	 * void editDish(Dish dish);
	 * void deleteDish(Dish dish);
	 * void addDishTypeToDish(DishType type, Dish dish);
	 *void removeDishTypeFromDish(DishType type, Dish dish); 
	 */
	
	private static Logger logger = Logger.getLogger(DishDAOTest.class);
	
	@Autowired
	private DishDAO testDAO;
	@Autowired
	private DishTypeDAO testTypeDAO;
	
	public void setTestDAO(DishDAO testDAO) {
		this.testDAO = testDAO;
	}

	@Test
	public void test1(){
		List<Dish> dishes = testDAO.getAllDishes();
		assertTrue(dishes.size() > 0);
	}
	@Test
	public void test2(){
		Dish dish = testDAO.getDishById(1);
		assertEquals(dish.getName(),"Orange Chicken");
	}
	@Test
	public void test3(){
		Dish dish = testDAO.getDishByName("Orange Chicken");
		assertEquals(1, dish.getId());
	}
	
	@Test
	public void test4(){
		String testName = "Durian Cheesecake";
		Dish newDish = new Dish(0, 13.50, testName);
		testDAO.createDish(newDish);
		Dish savedDish = testDAO.getDishByName(testName);
		assertEquals(newDish, savedDish);
	}
	@Test
	public void test5(){
		String testName = "Orange Chicken";
		Dish savedDish = testDAO.getDishByName(testName);
		testDAO.deleteDish(savedDish);
	}
	@Test
	public void test6(){
		String testName = "Orange Chicken";
		Dish dish = testDAO.getDishByName(testName);
		List<DishType> types = testDAO.getDishTypesForDish(dish);
		logger.trace("getDishTypesforDish" + types);
		assertTrue(types.size() > 1);
	}
	@Test
	public void test7(){
		int testId = 1;
		DishType type = testTypeDAO.getTypeFromId(testId);
		logger.trace("type toString" + type);
		List<Dish> dishes = testDAO.getDishesByType(type);
		logger.trace(dishes);
		assertTrue(dishes.size() > 0);
	}
	@Test
	public void test8(){
		DishType type = testTypeDAO.getTypeFromId(4);
		Dish dish = testDAO.getDishByName("Orange Chicken");
		testDAO.addDishTypeToDish(type, dish);
	}
	

}
