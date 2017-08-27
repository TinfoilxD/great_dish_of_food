package com.revature.gspj.gdf.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.gspj.gdf.bean.Dish;

@Repository
public class DishDAOImpl implements DishDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dish> getAllDishes() {
		return sessionFactory.getCurrentSession().createCriteria(Dish.class).list();
	}

	@Override
	public List<Dish> getDishesByType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createDish(Dish dish) {
		// TODO Auto-generated method stub

	}

	@Override
	public void editDish(Dish dish) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteDish(Dish dish) {
		// TODO Auto-generated method stub

	}

}
