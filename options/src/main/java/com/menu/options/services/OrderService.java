package com.menu.options.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.menu.options.entities.Order;
import com.menu.options.repositories.OrderRepository;
import com.menu.options.services.exception.DatabaseExceptions;
import com.menu.options.services.exception.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	
	public Order getById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(obj));
	}
	
	public List<Order> getAll(){
		return repository.findAll();
	}
	
	public Order insert(Order obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseExceptions(e.getMessage());
		}
	}
	
	public Order update(Long id, Order obj) {
		try {
			Order entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		}catch(EntityNotFoundException e) {
			e.printStackTrace();
			throw new ResourceNotFoundException(id);
		}
		
	}

	private void updateData(Order entity, Order obj) {
		entity.setType(obj.getType());
		entity.setDescription(obj.getDescription());
		entity.setPrice(obj.getPrice());
	}
	
	
	
	
	
	
}
