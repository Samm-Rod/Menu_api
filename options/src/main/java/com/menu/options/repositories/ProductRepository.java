package com.menu.options.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.menu.options.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
