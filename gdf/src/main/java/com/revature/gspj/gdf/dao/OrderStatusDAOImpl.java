package com.revature.gspj.gdf.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.gspj.gdf.bean.OrderStatus;

@Repository
public class OrderStatusDAOImpl implements OrderStatusDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<OrderStatus> getAllStatus() {
			
		return sessionFactory.getCurrentSession()
				.createQuery("FROM OrderStatus").list();
	}

	@Override
	@Transactional
	public OrderStatus getStatusFromId(int id) {
		
		return (OrderStatus) sessionFactory.getCurrentSession()
				.createQuery("FROM OrderStatus where id = :id")
				.setInteger("id", id).uniqueResult();
		
	}

	@Override
	@Transactional
	public OrderStatus getStatusFromName(String status) {
		return (OrderStatus) sessionFactory.getCurrentSession()
				.createCriteria(OrderStatus.class)
				.add(Restrictions.eq("status", status))
				.uniqueResult();
	}

}
