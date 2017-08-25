package com.revature.gspj.gdf.dao;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.gspj.gdf.bean.GDFUser;
import com.revature.gspj.gdf.context.GDFContextHelper;

import com.revature.gspj.gdf.dao.GDFUserDAO;

public class GDFUserDAOTest {
	
	private static Logger logger;
	private static GDFUserDAO testDAO;
	private SessionFactory sessionFactory;
	
	/*
	 * Methods to test
	 * void createUser(GDFUser user);
	 * GDFUser getUser(String username, String password); //use for validation
	 * GDFUser getUserFromId(int id);
	 * void editUser(GDFUser user);
	 */
	@BeforeClass
	public static void setUp(){
		logger = Logger.getLogger(GDFUserDAOTest.class);
		testDAO = (GDFUserDAO) GDFContextHelper.getContext().getBean("gdfUserDAO");
	}

	@Test
	public void test1() {
		GDFUser user = testDAO.getUser("pjakson","1234");
		assertEquals(user.getLastName(),"Jackson");
		
	}
	
	@Test
	public void test2() {
		GDFUser user = testDAO.getUserFromId(1);
		assertEquals(user.getLastName(),"Jackson");
		
	}
	


}
