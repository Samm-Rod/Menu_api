package com.menu.options.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.menu.options.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
