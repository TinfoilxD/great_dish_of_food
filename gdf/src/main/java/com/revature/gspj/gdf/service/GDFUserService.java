package com.revature.gspj.gdf.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.gspj.gdf.bean.Credentials;
import com.revature.gspj.gdf.bean.GDFUser;
import com.revature.gspj.gdf.dao.DishTypeDAO;
import com.revature.gspj.gdf.dao.GDFUserDAO;

public class GDFUserService {
	
	
	@Autowired
	private GDFUserDAO dao;
	
	
	public void setDao(GDFUserDAO dao) {
		this.dao = dao;
	}

	public GDFUser authenticate(Credentials credentials) {
		return dao.getUser(credentials.getUsername(), credentials.getPassword());
		

		
		// TODO Auto-generated method stub
		
	}

}
