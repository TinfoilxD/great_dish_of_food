package com.revature.gspj.gdf.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.revature.gspj.gdf.bean.GDFUser;
import com.revature.gspj.gdf.password.PasswordManager;

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
			throw new IllegalArgumentException("Invalid Credentials");
		
		
		
		GDFUser user = (GDFUser) sessionFactory.getCurrentSession().
				createQuery("FROM GDFUser where username = :username")
				.setString("username",username)
				.uniqueResult();
		//check for password here 
		PasswordManager checkPassword = new PasswordManager();
		if(user!=null){
			if(checkPassword.checkHashedPassword(password,user.getPassword()) == true){
			return user;
			}
			else{
				throw new IllegalArgumentException("Invalid Credentials");
			}
		}
		else{
			throw new IllegalArgumentException("Invalid Credentials");
		}
		
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
