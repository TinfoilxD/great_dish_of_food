package com.revature.gspj.gdf.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.gspj.gdf.bean.Dish;
import com.revature.gspj.gdf.bean.DishType;

@Repository
@Transactional
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
	public List<Dish> getDishesByType(DishType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createDish(Dish dish) {
		sessionFactory.getCurrentSession().save(dish);

	}

	@Override
	public void editDish(Dish dish) {
		sessionFactory.getCurrentSession().saveOrUpdate(dish);

	}

	@Override
	public void deleteDish(Dish dish) {
		sessionFactory.getCurrentSession().delete(dish);

	}

}
