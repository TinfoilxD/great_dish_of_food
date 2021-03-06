package com.revature.gspj.gdf.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.gspj.gdf.bean.Dish;
import com.revature.gspj.gdf.bean.GDFUser;
import com.revature.gspj.gdf.bean.Order;
import com.revature.gspj.gdf.bean.OrderLine;
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
	public Set<Order> getAllOrders() {
		List orderList = sessionFactory.getCurrentSession().createCriteria(Order.class).list();
		return new HashSet<Order>(orderList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Order> getOrdersForUser(GDFUser user) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Order.class);
		List orderList = cr.add(Restrictions.eq("user.id",user.getId())).list();
		return new HashSet<Order>(orderList); 
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Order> getOrdersForStatus(OrderStatus status) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Order.class);
		List orderList = cr.add(Restrictions.eq("status.id",status.getId())).list();
		return new HashSet<Order>(orderList);  
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Order> getOrdersForType(OrderType type) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Order.class);
		List orderList = cr.add(Restrictions.eq("type.id",type.getId())).list();
		return new HashSet<Order>(orderList);   
	}


	@Override
	public Order getOrderFromId(int id) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Order.class);
		return (Order) cr.add(Restrictions.eq("id",id)).uniqueResult();
	}

	@Override
	public void editOrder(Order order) {
		sessionFactory.getCurrentSession().saveOrUpdate(order);

	}

	@Override
	public void deleteOrder(Order order) {
		sessionFactory.getCurrentSession().delete(order);

	}

	@Override
	public void createOrder(Order order) {
		sessionFactory.getCurrentSession().save(order);

	}

	@Override
	public void addOrderLineToOrder(OrderLine orderLine) {
		sessionFactory.getCurrentSession().saveOrUpdate(orderLine);
		
	}

	@Override
	public void removeOrderLineFromOrder(OrderLine orderLine) {
		sessionFactory.getCurrentSession().delete(orderLine);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderLine> getOrderLinesForOrder(Order order) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(OrderLine.class);
		return cr.add(Restrictions.eq("orderLines.id",order.getId())).list();
	}

}
