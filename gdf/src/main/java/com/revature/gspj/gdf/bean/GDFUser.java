package com.revature.gspj.gdf.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="GDF_USER")
public class GDFUser implements Serializable{
	
	@Id
	@Column(name="user_id")
	private int id;
	@Column(name="username")
	private String username;
	@Column(name="user_firstname")
	private String firstName;
	@Column(name="user_lastname")
	private String lastName;
	@Column(name="user_email")
	private String email;
	@Column(name="user_password")
	private String password;
	@ManyToOne
	@JoinColumn(name="user_type_id")
	private UserType type;
	
	public GDFUser() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "GDFUser [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", type=" + type + "]";
	}
	
	
}
