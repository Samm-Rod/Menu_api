package com.menu.options.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.menu.options.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
