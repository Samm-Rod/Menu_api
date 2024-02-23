package com.menu.options.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.menu.options.entities.enums.TypeOrder;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "tb_Order")
public class Order implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	
	private Integer OrderStatus;
	
	private String description;
	//private Double price;
	
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;
	
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItems> items = new HashSet<>();
	
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Payment payment; 
	
	public Order() {
		
	}

	public Order(Long id, Instant moment, TypeOrder orderStatus, String description, User client) {
		this.id = id;
		this.moment = moment;
		setTypeOrder(orderStatus);
		this.description = description;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	//public Double getPrice() {
	//	return price;
	//}

	//public void setPrice(Double price) {
	//	this.price = price;
	//}
	
	
	



	public TypeOrder getTypeOrder() {
		return TypeOrder.valueOf(OrderStatus);
	}
	
	public void setTypeOrder (TypeOrder order) {
		if(order != null) {
			this.OrderStatus = order.getCode();
		}
	}
	
	
	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}
	
	public Set<OrderItems> getItems() {
		return items;
	}
	
	
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	
	public Double getTotal() {
		double sum = 0;
		for(OrderItems x : items) {
			sum += x.getPrice();
		}
		return sum;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}

	
}
