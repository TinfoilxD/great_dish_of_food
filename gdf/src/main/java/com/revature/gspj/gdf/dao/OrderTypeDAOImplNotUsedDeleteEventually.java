package com.revature.gspj.gdf.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.revature.gspj.gdf.bean.OrderType;

public class OrderTypeDAOImplNotUsedDeleteEventually implements OrderTypeDAO {

	private Session session;
	
	public OrderTypeDAOImplNotUsedDeleteEventually(){
		
	}
	
	public OrderTypeDAOImplNotUsedDeleteEventually(Session session) {
		super();
		this.session = session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	public List<OrderType> getAllTypes(){
		String hql = "from OrderType";
		Query query = session.createQuery(hql);
		return query.list();
	}

	@Override
	public OrderType getTypeFromId(int id) {
		String hql = "from OrderType where id = 1";
		Query query = session.createQuery(hql);
		return (OrderType) query.uniqueResult();
	}
	
}
