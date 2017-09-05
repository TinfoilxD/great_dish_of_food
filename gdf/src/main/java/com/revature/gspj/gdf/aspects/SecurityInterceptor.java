package com.revature.gspj.gdf.aspects;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.revature.gspj.gdf.bean.GDFUser;
import com.revature.gspj.gdf.bean.Order;
import com.revature.gspj.gdf.controller.AuthenticationController;

@Aspect
@Component
public class SecurityInterceptor {
	
	private Logger logger = Logger.getLogger(SecurityInterceptor.class);

	
	@Before(value="execution(* com.revature.gspj.gdf.dao.OrderDAOImpl.*(..))")
	public void getAllOrders(JoinPoint joinPoint) throws Exception{
		Object[] args = joinPoint.getArgs();
		logger.debug(args.length);
	}
	
	
	

}
