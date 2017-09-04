package com.revature.gspj.gdf.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.gspj.gdf.bean.GDFUser;
import com.revature.gspj.gdf.controller.AuthenticationController;
import com.revature.gspj.gdf.dao.GDFUserDAO;
import com.revature.gspj.gdf.dao.UserTypeDAO;
import com.revature.gspj.gdf.password.PasswordManager;
import com.revature.gspj.gdf.wrapper.Credentials;

@Service
public class GDFUserService {
	
	
	@Autowired
	private GDFUserDAO dao;
	@Autowired
	private UserTypeDAO typeDAO;
	private Logger logger = Logger.getLogger(GDFUserService.class);

	public void setDao(GDFUserDAO dao) {
		this.dao = dao;
	}

	public GDFUser authenticate(Credentials credentials) {
		
		GDFUser user = dao.getUser(credentials.getUsername(), credentials.getPassword());
		user.setPassword(null);
		return user; 
				
	}

	public void logout(HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		request.getSession().invalidate();
		
		
	}

	public void registerUser(GDFUser user) {
		user.setType(typeDAO.getTypeFromId(2));
		String password = user.getPassword();
		logger.debug(user);;
		user.setPassword(PasswordManager.hashPassword(password));
		logger.debug(user);
		dao.createUser(user);
		
	}

}
