package com.status.statuspage.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.status.statuspage.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{
	Optional<Users>findByEmail(String email);
}
