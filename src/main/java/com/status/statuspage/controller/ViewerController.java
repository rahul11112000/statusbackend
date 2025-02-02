package com.status.statuspage.controller;

import java.util.List;

import org.hibernate.sql.results.graph.instantiation.internal.ArgumentDomainResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.status.statuspage.entity.Application;
import com.status.statuspage.entity.Component;
import com.status.statuspage.entity.StatusUpdate;
import com.status.statuspage.repository.ApplicationRepository;
import com.status.statuspage.repository.ComponentRepository;
import com.status.statuspage.repository.StatusRepository;

@RestController
@RequestMapping("/viewer")
public class ViewerController {
	
	@Autowired
	ApplicationRepository applicationRepository;
	
	@Autowired
	ComponentRepository componentRepository;
	
	@Autowired
	StatusRepository statusRepository;
	
	@GetMapping("/application")
	public List<Application> getApplications(){
		return applicationRepository.findAll();
	}
	
	@GetMapping("/get-all/component/{app_id}")
	public List<Component> getComponents(@PathVariable int app_id){
		Application application = applicationRepository.findById(app_id).get();
		return  componentRepository.findByApplication(application);
	}
	
	@GetMapping("/get/status/{com_id}")
	public List<StatusUpdate> getStatus(@PathVariable int com_id){
		Component component = componentRepository.findById(com_id).get();
		return statusRepository.findByComponent(component);
	}
}
