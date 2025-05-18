package com.corhuila.app_explora_neiva.repository;

// UserRepository.java

import org.springframework.data.jpa.repository.JpaRepository;

import com.corhuila.app_explora_neiva.Entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

}