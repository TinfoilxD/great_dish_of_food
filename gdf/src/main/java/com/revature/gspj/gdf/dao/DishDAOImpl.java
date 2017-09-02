package com.revature.gspj.gdf.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.gspj.gdf.bean.Dish;
import com.revature.gspj.gdf.bean.DishType;
import com.revature.gspj.gdf.bean.OrderLine;

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
	public Set<Dish> getAllDishes() {
		List dishList = sessionFactory.getCurrentSession()
				.createCriteria(Dish.class)
				.list();
		return new HashSet<Dish>(dishList);
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

	@Override
	public Dish getDishById(int id) {
		return (Dish) sessionFactory.getCurrentSession()
				.createCriteria(Dish.class)
				.add(Restrictions.eq("id",id))
				.uniqueResult();
	}

	@Override
	public Dish getDishByName(String name) {
		return (Dish) sessionFactory.getCurrentSession()
				.createCriteria(Dish.class)
				.add(Restrictions.eq("name",name))
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DishType> getDishTypesForDish(Dish dish) {		
		return sessionFactory.getCurrentSession()
				.createCriteria(DishType.class)
				.createAlias("dishes", "dish")
					.add(Restrictions.eq("dish.id", dish.getId()))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.list();
		
	}

	@Override
	public void addDishTypeToDish(DishType type, Dish dish) {
		Session session = sessionFactory.getCurrentSession();
		type.getDishes().add(dish);
		dish.getTypes().add(type);
		session.saveOrUpdate(type);
		session.saveOrUpdate(dish);
		
	}

	@Override
	public void removeDishTypeFromDish(DishType type, Dish dish) {
		Session session = sessionFactory.getCurrentSession();
		type.getDishes().remove(dish);
		dish.getTypes().remove(type);
		session.saveOrUpdate(type);
		session.saveOrUpdate(dish);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dish> getDishesByType(DishType type) {
		
		/*
		 * REPLACE THIS HQL WITH CRITERIA... EVENTUALLY
		 */
		String hql = "select d.id, d.name, d.price from Dish d inner join d.types dt where dt.id = :dishTypeId";
		return sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setInteger("dishTypeId", type.getId())
				.list();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderLine> getOrderLinesForDish(Dish dish) {
		return sessionFactory.getCurrentSession()
				.createCriteria(OrderLine.class)
				//	.add(Restrictions.eq("dish.id", dish.getId()))
				.list();
	}

}
