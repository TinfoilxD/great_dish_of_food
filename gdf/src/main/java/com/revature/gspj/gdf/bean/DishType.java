package com.revature.gspj.gdf.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="DISH_TYPE")
public class DishType implements Serializable {
	
	@Id
	@Column(name="dish_type_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="dishTypeSeq")
	@SequenceGenerator(name="dishTypeSeq", sequenceName="DISH_TYPE_ID_SEQ",allocationSize=1)
	private int id;
	@Column(name="dish_type")
	private String type;
	@ManyToMany(mappedBy = "types")
	@JsonIgnore
	private Set<Dish> dishes;
	
	public DishType() {
		super();
		// TODO Auto-generated constructor stub
	
	}
	
	public DishType(int id, String type) {
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
	
	public Set<Dish> getDishes() {
		return dishes;
	}

	public void setDishes(Set<Dish> dishes) {
		this.dishes = dishes;
	}

	@Override
	public String toString() {
		return "DishType [id=" + id + ", type=" + type + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		DishType other = (DishType) obj;
		if (id != other.id)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
}
