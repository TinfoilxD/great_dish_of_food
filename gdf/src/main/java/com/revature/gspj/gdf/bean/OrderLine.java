package com.revature.gspj.gdf.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ORDER_LINE")
public class OrderLine implements Serializable{
	
	
	private static final long serialVersionUID = 7656508497606832699L; //needed for idclass composite key
	
	
	@Id
	@Column(name="order_line_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="orderLineSeq")
	@SequenceGenerator(name="orderLineSeq", sequenceName="ORDER_LINE_ID_SEQ")
	private int id;
	
	
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;
	
	
	
	@ManyToOne
	@JoinColumn(name="dish_id")
	private Dish dish;
	
	
	
	@Column(name="quantity")
	private int quantity;
	
	
	public OrderLine() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Dish getDish() {
		return dish;
	}
	public void setDish(Dish dish) {
		this.dish = dish;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderLine [id=" + id + ", order=" + order + ", dish=" + dish + ", quantity=" + quantity + "]";
	}
	
	
	
	
}
