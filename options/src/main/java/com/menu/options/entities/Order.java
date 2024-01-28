package com.menu.options.entities;

import java.io.Serializable;
import java.util.Objects;

import com.menu.options.entities.enums.TypeOrder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "tb_Order")
public class Order implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer type;
	private String description;
	private Double price;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;
	
	public Order() {
		
	}

	public Order(Long id, TypeOrder type, String description, Double price, User client) {
		this.id = id;
		setTypeOrder(type);
		this.description = description;
		this.price = price;
		this.client = client;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}



	public TypeOrder getTypeOrder() {
		return TypeOrder.valueOf(type);
	}
	
	public void setTypeOrder (TypeOrder order) {
		if(order != null) {
			this.type = order.getCode();
		}
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
