package com.status.statuspage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.status.statuspage.entity.Component;
import com.status.statuspage.entity.StatusUpdate;

public interface StatusRepository extends JpaRepository<StatusUpdate, Integer>{
	
	List<StatusUpdate> findByComponent(Component component);
}
