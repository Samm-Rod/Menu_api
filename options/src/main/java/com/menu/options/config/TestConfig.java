package com.menu.options.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.menu.options.entities.Order;
import com.menu.options.entities.User;
import com.menu.options.entities.enums.TypeOrder;
import com.menu.options.repositories.OrderRepository;
import com.menu.options.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository uRepository;
	@Autowired
	private OrderRepository oRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null,"Sammuel","222.222.222-22");
		User u2 = new User(null,"Maria","000.000.000-00");
		
		

		Order o1 = new Order(null, TypeOrder.DRINKS, "Juice Orange", 12.5, u1);
		Order o2 = new Order(null, TypeOrder.BURGERS, "X-Bacon", 22.7, u1);
		Order o3 = new Order(null, TypeOrder.FOODS, "Potato", 4.8, u1);
		Order o4 = new Order(null, TypeOrder.DRINKS, "Coke", 4.5, u2);
		
		
		uRepository.saveAll(Arrays.asList(u1, u2));
		oRepository.saveAll(Arrays.asList(o1, o2, o3, o4));
		
	}
}
