package com.menu.options.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.menu.options.entities.OrderItems;

public interface OrderItemRepository extends JpaRepository<OrderItems, Long>{

}
