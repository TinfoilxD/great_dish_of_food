package com.revature.gspj.gdf.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.gspj.gdf.bean.OrderType;
@Repository
@Transactional
public class OrderTypeDAOImpl implements OrderTypeDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderType> getAllTypes() {
		return sessionFactory.getCurrentSession()
				.createCriteria(OrderType.class)
				.list();
	}

	@Override
	public OrderType getTypeFromId(int id) {
		return (OrderType) sessionFactory.getCurrentSession()
				.createCriteria(OrderType.class)
				.add(Restrictions.eq("id",id))
				.uniqueResult();
	}
	
}
