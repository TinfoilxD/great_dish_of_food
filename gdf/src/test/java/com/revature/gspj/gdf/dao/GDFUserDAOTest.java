package com.revature.gspj.gdf.dao;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.revature.gspj.gdf.bean.GDFUser;
import com.revature.gspj.gdf.context.GDFContextHelper;

import com.revature.gspj.gdf.dao.GDFUserDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:gdf_spring.xml"})
@TransactionConfiguration
@Transactional
public class GDFUserDAOTest {
	
	
	
	@Autowired
	private GDFUserDAO testDAO;
	private static Logger logger = Logger.getLogger(GDFUserDAOTest.class);
	public void setTestDAO(GDFUserDAO testDAO) {
		this.testDAO = testDAO;
	}
	
	/*
	 * Methods to test
	 * void createUser(GDFUser user);
	 * GDFUser getUser(String username, String password); //use for validation
	 * GDFUser getUserFromId(int id);
	 * void editUser(GDFUser user);
	 */
	
	@Test
	public void test1() {
		GDFUser user = testDAO.getUser("pjackson","1234");
		assertEquals(user.getLastName(),"Jackson");

		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test2() {
		GDFUser user = testDAO.getUser("pjackson","134");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test3() {
		GDFUser user = testDAO.getUser("a' or 1==1;--","a");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test4() {
		GDFUser user = testDAO.getUser("","");
	}
	@Test(expected = IllegalArgumentException.class)
	public void test5() {
		GDFUser user = testDAO.getUser(null,null);
	}
	
	
	@Test
	public void test6() {
		GDFUser user = testDAO.getUserFromId(1);
		assertEquals(user.getLastName(),"Jackson");
		
	}
	
	
	


}
