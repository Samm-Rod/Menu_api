package com.menu.options.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.menu.options.entities.User;
import com.menu.options.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class OrderResouce {

	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> list = service.getAllUsers();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> getById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(User obj){
		obj = service.create(obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> remove(@PathVariable Long id){
		service.remove(id);
		return ResponseEntity.noContent().build();
	}

	
	
	
	
	
	
	
	
	
	
}
