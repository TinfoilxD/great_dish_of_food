package com.revature.gspj.gdf.context;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Helper class used to get a application context independent of the web application dispatcherservlet
 * Used mainly for test classes.
 * 
 */
public class GDFContextHelper {
	
	private static ApplicationContext context = new ClassPathXmlApplicationContext("gdf_spring.xml");
		
	
	public static ApplicationContext getContext(){
		return context;
	}
	
}
