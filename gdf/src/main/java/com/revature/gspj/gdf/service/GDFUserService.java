package com.revature.gspj.gdf.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.gspj.gdf.bean.GDFUser;
import com.revature.gspj.gdf.dao.GDFUserDAO;
import com.revature.gspj.gdf.wrapper.Credentials;

@Service
public class GDFUserService {
	
	
	@Autowired
	private GDFUserDAO dao;
	
	
	public void setDao(GDFUserDAO dao) {
		this.dao = dao;
	}

	public GDFUser authenticate(Credentials credentials) {
		
		GDFUser user = dao.getUser(credentials.getUsername(), credentials.getPassword());
		
		
		
		user.setPassword(null);
		return user; 
				
	}

}
