package com.menu.options.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.menu.options.entities.User;
import com.menu.options.repositories.UserRepository;
import com.menu.options.services.exception.DatabaseExceptions;
import com.menu.options.services.exception.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	// Get All Users
	public List<User> getAllUsers(){
		return repository.findAll();
	}
	
	// Get By Id Users
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	//Create Users
	public User create(User obj) {
		return repository.save(obj);
	}
	
	// Update register
	public User update(Long id, User obj) {
		try {
			User entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		}catch(EntityNotFoundException e) {
			e.printStackTrace();
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setCpf(obj.getCpf());
	}
	
	// Remove
	public void remove(Long id) {
		try {
			repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseExceptions(e.getMessage());
		}
	}
	
	
	
	
}
