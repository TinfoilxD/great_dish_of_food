package com.revature.gspj.gdf.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.revature.gspj.gdf.bean.UserType;

public class UserTypeDAOImpl implements UserTypeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<UserType> getAllTypes() {
		return sessionFactory.getCurrentSession()
				.createQuery("FROM UserType").list();
	}
	
	

	@Override
	@Transactional
	public UserType getTypeFromId(int id) {
		
		return (UserType) sessionFactory.getCurrentSession()
				.createQuery("From UserType where id = :id")
				.setInteger("id", id).uniqueResult();
	}

}
