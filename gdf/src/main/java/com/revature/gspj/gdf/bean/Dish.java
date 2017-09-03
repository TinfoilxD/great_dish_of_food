package com.revature.gspj.gdf.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="DISH")
public class Dish implements Serializable{
	
	@Id
	@Column(name="dish_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="dishSeq")
	@SequenceGenerator(name="dishSeq", sequenceName="DISH_ID_SEQ")
	private int id;
	
	
	@Column(name="dish_price")
	private double price;
	
	
	@Column(name="dish_name")
	private String name;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="CATEGORIES",
		    joinColumns={@JoinColumn(name="dish_id")},
		    inverseJoinColumns={@JoinColumn(name="dish_type_id")})
	private Set<DishType> types;
	
	@JsonIgnore
	@OneToMany(mappedBy = "dish")
	private Set<OrderLine> orderLines;
	
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
	
	public Set<DishType> getTypes() {
		return types;
	}
	public void setTypes(Set<DishType> types) {
		this.types = types;
	}
	
	
	public Set<OrderLine> getOrderLines() {
		return orderLines;
	}
	public void setOrderLines(Set<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dish other = (Dish) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Dish [id=" + id + ", price=" + price + ", name=" + name + ", types=" + types + "]";
	}
	
	

}
