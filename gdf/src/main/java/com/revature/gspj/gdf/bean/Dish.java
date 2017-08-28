package com.revature.gspj.gdf.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="DISH")
public class Dish {
	
	@Id
	@Column(name="dish_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="dishSeq")
	@SequenceGenerator(name="dishSeq", sequenceName="DISH_ID_SEQ")
	private int id;
	@Column(name="dish_price")
	private double price;
	@Column(name="dish_name")
	private String name;
	@ManyToMany
	@JoinTable(name="CATEGORIES")
	List<DishType> types;
	
	public Dish() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dish(int id, double price, String name) {
		super();
		this.id = id;
		this.price = price;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
