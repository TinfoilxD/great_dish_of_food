package com.revature.gspj.gdf.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.gspj.gdf.bean.Dish;
import com.revature.gspj.gdf.bean.DishType;

@Repository
public class DishTypeDAOImpl implements DishTypeDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void createType(DishType type) {
		sessionFactory.getCurrentSession().save(type);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DishType> getAllTypes() {
		return sessionFactory.getCurrentSession()
				.createCriteria(DishType.class).list();
	}

	@Override
	@Transactional
	public DishType getTypeFromId(int id) {
		return (DishType) sessionFactory.getCurrentSession()
				.createCriteria(DishType.class)
				.add(Restrictions.eq("id",id))
				.uniqueResult();
	}

	@Override
	@Transactional
	public void updateType(DishType type) {
		sessionFactory.getCurrentSession().saveOrUpdate(type);
		
	}


}
