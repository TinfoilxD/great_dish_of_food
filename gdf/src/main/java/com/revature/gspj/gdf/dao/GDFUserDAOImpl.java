package com.revature.gspj.gdf.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.revature.gspj.gdf.bean.GDFUser;

public class GDFUserDAOImpl implements GDFUserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public GDFUser getUser(String username, String password) {
		//ensure that username or password is not empty
		if (username == null || password == null
				||username.equals("") || password.equals(""))
			throw new IllegalArgumentException();
		//TODO exchange hash password here 
		return (GDFUser) sessionFactory.getCurrentSession().
				createQuery("FROM GDFUser where username = :username and password = :password")
				.setString("username",username)
				.setString("password", password)
				.uniqueResult();
	}

	@Override
	@Transactional
	public GDFUser getUserFromId(int id) {
		
		return (GDFUser) sessionFactory.getCurrentSession().
				createQuery("FROM GDFUser where id = :id")
				.setInteger("id", id)
				.uniqueResult();
	}

	@Override
	public void editUser(GDFUser user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createUser(GDFUser user) {
		// TODO Auto-generated method stub
		
	}

}
