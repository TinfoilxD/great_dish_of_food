package com.revature.gspj.gdf.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.gspj.gdf.bean.Dish;
import com.revature.gspj.gdf.bean.GDFUser;
import com.revature.gspj.gdf.bean.Order;
import com.revature.gspj.gdf.bean.OrderStatus;
import com.revature.gspj.gdf.bean.OrderType;

@Repository
@Transactional
public class OrderDAOImpl implements OrderDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getAllOrders() {
		return sessionFactory.getCurrentSession().createCriteria(Order.class).list();
	}

	@Override
	public List<Order> getOrdersForUser(GDFUser user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrdersForStatus(OrderStatus status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrdersForType(OrderType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dish> getDishesForOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getOrderFromId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editOrder(Order order) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteOrder(Order order) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createOrder(Order order) {
		// TODO Auto-generated method stub

	}

}
