package com.menu.options.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.menu.options.entities.Product;
import com.menu.options.repositories.ProductRepository;
import com.menu.options.services.exception.DatabaseExceptions;
import com.menu.options.services.exception.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	
	public Product getById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(obj));
	}
	
	public List<Product> getAll(){
		return repository.findAll();
	}
	
	public Product insert(Product obj) {
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
	
	public Product update(Long id, Product obj) {
		try {
			Product entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		}catch(EntityNotFoundException e) {
			e.printStackTrace();
			throw new ResourceNotFoundException(id);
		}
		
	}

	private void updateData(Product entity, Product obj) {
		entity.setDescription(obj.getDescription());
		entity.setPrice(obj.getPrice());
		entity.setName(obj.getName());
	}
	
	
	
	
	
	
}
