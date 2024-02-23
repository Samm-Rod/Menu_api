package com.menu.options.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.menu.options.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
