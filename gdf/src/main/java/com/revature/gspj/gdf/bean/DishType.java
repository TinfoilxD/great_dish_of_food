package com.revature.gspj.gdf.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="DISH_TYPE")
public class DishType {
	
	@Id
	@Column(name="dish_type_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="dishTypeSeq")
	@SequenceGenerator(name="dishTypeSeq", sequenceName="DISH_TYPE_ID_SEQ",allocationSize=1)
	private int id;
	@Column(name="dish_type")
	private String type;
	
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

	@Override
	public String toString() {
		return "DishType [id=" + id + ", type=" + type + "]";
	}
	
	
	
	
	
	
	
	
	
}
