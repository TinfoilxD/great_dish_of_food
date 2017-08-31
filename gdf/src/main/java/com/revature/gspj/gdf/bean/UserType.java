package com.revature.gspj.gdf.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_TYPE")
public class UserType implements Serializable {
		@Id
		@Column(name="user_type_id")
		private int id;
		@Column(name="user_type")
		private String type;
		
		public UserType() {
			super();
			// TODO Auto-generated constructor stub
		}

		public UserType(int id, String type) {
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
		
		
		
		
		
}
