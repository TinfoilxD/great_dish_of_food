package com.revature.gspj.gdf.aspects;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.revature.gspj.gdf.bean.GDFUser;
import com.revature.gspj.gdf.bean.Order;

@Aspect
public class EmployeeAspect {
	
	@Before(value="execution(* getAllOrders())")
	public void getAllOrders(JoinPoint joinPoint,HttpServletRequest request) throws Exception{
		//Object returnedValue = null;
		// before 
		System.out.println("BeforeAspect " + joinPoint.getSignature().getName());
		// call method
		
			GDFUser user = (GDFUser) request.getSession().getAttribute("user");
			//returnedValue = joinPoint.proceed();
			if(user.getType().getId()!=1){
				throw new Exception("not allowed");
			}
			
		
	
		//return returnedValue;
	}
	
	
	

}
