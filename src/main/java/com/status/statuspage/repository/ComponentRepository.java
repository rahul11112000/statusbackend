package com.status.statuspage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.status.statuspage.entity.Application;
import com.status.statuspage.entity.Component;

public interface ComponentRepository extends JpaRepository<Component, Integer>{
	
	List<Component> findByApplication(Application application);
}
