package com.status.statuspage.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.status.statuspage.entity.Application;
import com.status.statuspage.entity.Users;

public interface ApplicationRepository extends JpaRepository<Application, Integer>{
	
	List<Application> findByUser(Users user);
	
}
