package com.status.statuspage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.status.statuspage.entity.Application;
import com.status.statuspage.services.ApplicationServices;

@RestController
@RequestMapping("/app-admin")
public class ApplicationController {
	
	@Autowired
	ApplicationServices applicationServices;
	
	@GetMapping("")
	public String first() {
		return "Application Admin";
	}
	
	@PostMapping("/create/app")
	public Application createApp(@RequestBody Application application,Authentication authentication) {
		
		return applicationServices.saveApp(application,authentication);
		
	}
	
	@GetMapping("/get-all/app")
	public List<Application> getAllApp(Authentication authentication){
		return applicationServices.getAll(authentication);
	}
	
	@GetMapping("/get/app/{id}")
	public Application getApp(@PathVariable int id) {
		return applicationServices.getApp(id);
	}
	
	@PutMapping("/update/app/{id}")
	public Application updateApp(@RequestBody Application application,@PathVariable int id) {
		return applicationServices.updateApp(application,id);
	}
	
	@DeleteMapping("/delete/app/{id}")
	public ResponseEntity<String> deleteApp(@PathVariable int id) {
		return applicationServices.deleteApp(id);
	}
	
	
}
