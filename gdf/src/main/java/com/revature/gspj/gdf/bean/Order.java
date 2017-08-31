package com.revature.gspj.gdf.bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="ORDERS")
public class Order implements Serializable {
	
	@Id
	@Column(name="order_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="orderSeq")
	@SequenceGenerator(name="orderSeq",sequenceName=("ORDER_ID_SEQ"))
	private int id;
	
	
	@Column(name="order_submitted")
	private LocalDateTime submitted;
	
	
	@Column(name="order_resolved")
	private LocalDateTime resolved;
	
	
	@ManyToOne
	@JoinColumn(name="order_type")
	private OrderType type;
	
	
	@ManyToOne
	@JoinColumn(name="order_status")
	private OrderStatus status;
	
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private GDFUser user;
	
	@JsonIgnore
	@OneToMany(mappedBy="order")
	private Set<OrderLine> orderLines;
	
	
	
	public Order() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getSubmitted() {
		return submitted;
	}
	public void setSubmitted(LocalDateTime submitted) {
		this.submitted = submitted;
	}
	public LocalDateTime getResolved() {
		return resolved;
	}
	public void setResolved(LocalDateTime resolved) {
		this.resolved = resolved;
	}
	public OrderType getType() {
		return type;
	}
	public void setType(OrderType type) {
		this.type = type;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public GDFUser getUser() {
		return user;
	}
	public void setUser(GDFUser user) {
		this.user = user;
	}
	
	
	public Set<OrderLine> getOrderLines() {
		return orderLines;
	}
	public void setOrderLines(Set<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", submitted=" + submitted + ", resolved=" + resolved + ", type=" + type
				+ ", status=" + status + ", user=" + user + "]";
	}
	
	
}
