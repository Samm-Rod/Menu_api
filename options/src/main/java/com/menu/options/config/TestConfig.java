package com.menu.options.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.menu.options.entities.Category;
import com.menu.options.entities.Order;
import com.menu.options.entities.OrderItems;
import com.menu.options.entities.Payment;
import com.menu.options.entities.Product;
import com.menu.options.entities.User;
import com.menu.options.entities.enums.TypeOrder;
import com.menu.options.repositories.CategoryRepository;
import com.menu.options.repositories.OrderItemRepository;
import com.menu.options.repositories.OrderRepository;
import com.menu.options.repositories.ProductRepository;
import com.menu.options.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository uRepository;
	@Autowired
	private OrderRepository oRepository;
	@Autowired
	private ProductRepository pRepository;
	@Autowired
	private OrderItemRepository oIRepository;
	@Autowired
	private CategoryRepository cRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Drinks"); 
		Category cat2 = new Category(null, "Burguers"); 
		Category cat3 = new Category(null, "Foods"); 
		Category cat4 = new Category(null, "Pizza");
		
		cRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
		
		
		User u1 = new User(null,"Sammuel","222.222.222-22");
		User u2 = new User(null,"Maria","000.000.000-00");
		
		Product p1 = new Product(null, "Drink", "Juice Orange", 10.0); 
		Product p2 = new Product(null, "Burguer", "X-Tudo", 21.0); 
		Product p3 = new Product(null, "Burguer", "X-Salada", 12.0); 
		Product p4 = new Product(null, "Food", "Potatos", 4.0); 
		Product p5 = new Product(null, "Pizza", "Calabresa", 23.80); 
		
		p1.getCategories().add(cat1);
		p2.getCategories().add(cat2);
		p3.getCategories().add(cat2);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat4);
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), TypeOrder.DRINKS, "Juice Orange", u1);
		Order o2 = new Order(null, Instant.parse("2024-06-20T23:53:07Z"), TypeOrder.BURGERS, "X-Bacon", u1);
		Order o3 = new Order(null, Instant.parse("2024-06-20T23:53:07Z"), TypeOrder.FOODS, "Potato", u1);
		Order o4 = new Order(null, Instant.parse("2024-06-20T23:53:07Z"), TypeOrder.DRINKS, "Coke", u2);
		Order o5 = new Order(null, Instant.parse("2024-06-20T23:53:07Z"), TypeOrder.PIZZAS, "Calabresa", u2);

		uRepository.saveAll(Arrays.asList(u1, u2));
		oRepository.saveAll(Arrays.asList(o1, o2, o3, o4, o5));
		pRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		OrderItems oi1 = new OrderItems(o1, p1, 1, p1.getPrice());
		OrderItems oi2 = new OrderItems(o1, p2, 1, p2.getPrice());
		OrderItems oi3 = new OrderItems(o1, p4, 2, p4.getPrice());
		OrderItems oi4 = new OrderItems(o2, p4, 2, p4.getPrice());
		OrderItems oi5 = new OrderItems(o2, p1, 1, p1.getPrice());
		
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
		Payment pay2 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o2);
		o1.setPayment(pay1);
		o2.setPayment(pay2);
		
		oIRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4, oi5));
		oRepository.save(o1);
		oRepository.save(o2);
		
		
		
		
	}
}
