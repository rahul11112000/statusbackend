package com.status.statuspage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.status.statuspage.entity.Application;
import com.status.statuspage.entity.Users;
import com.status.statuspage.repository.ApplicationRepository;
import com.status.statuspage.repository.UserRepository;

@Service
public class ApplicationServices {
	
	@Autowired
	ApplicationRepository applicationRepository;
	
	@Autowired
	UserRepository userRepository;

	public Application saveApp(Application application,Authentication authentication) {
		Users user = userRepository.findByEmail(authentication.getName()).get();
		application.setUser(user);
		return applicationRepository.save(application);
		
	}
	
	public List<Application> getAll(Authentication authentication){
		Users user = userRepository.findByEmail(authentication.getName()).get();
		return applicationRepository.findByUser(user);
		
	}
	
	public Application getApp(int id) {
		return applicationRepository.findById(id).get();
	}
	
	public Application updateApp(Application application,int id) {
		Application app = applicationRepository.findById(id).get(); 
		app.setName(application.getName());
		app.setDescription(application.getDescription());
		return applicationRepository.save(app);
	}
	
	
	public ResponseEntity<String> deleteApp(int id) {
		applicationRepository.deleteById(id);
		return ResponseEntity.ok("Application Deleted Successfully");
	}
	
	
	
}
