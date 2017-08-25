package com.revature.gspj.gdf.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ORDER_TYPE")
public class OrderType {
	
	@Id
	@Column(name="order_type_id")
	private int id;
	@Column(name="order_type")
	private String type;
	
	public OrderType() {
		super();
	}

	public OrderType(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "OrderType [id=" + id + ", type=" + type + "]";
	}
	
	
}
