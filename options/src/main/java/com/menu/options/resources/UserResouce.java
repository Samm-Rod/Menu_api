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

import com.menu.options.entities.Order;
import com.menu.options.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class UserResouce {

	@Autowired
	private OrderService service;
	
	@GetMapping
	public ResponseEntity<List<Order>> getAllOrder(){
		List<Order> list = service.getAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> getById(@PathVariable Long id){
		Order obj = service.getById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Order> insert(Order obj){
		obj = service.insert(obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Order> update(@PathVariable Long id, @RequestBody Order obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> remove(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	
	
	
	
	
	
	
	
	
	
}
