package com.status.statuspage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.status.statuspage.entity.Application;
import com.status.statuspage.entity.Component;
import com.status.statuspage.repository.ApplicationRepository;
import com.status.statuspage.services.ComponentServices;

@RestController
@RequestMapping("/com-admin")
public class ComponentController {

	@Autowired
	ComponentServices componentServices;
	
	@Autowired
	ApplicationRepository applicationRepository;
	
	@GetMapping("")
	public String first() {
		return "Component Admin";
	}
	
	@GetMapping("/application")
	public List<Application> getApplications(){
		return applicationRepository.findAll();
	}
	
	@PostMapping("/create/component/{app_id}")
	public Component createComponent(@RequestBody Component component,@PathVariable int app_id) {
		
		return componentServices.saveComponent(component, app_id);
		
	}
	
	@GetMapping("/get-all/component/{app_id}")
	public List<Component> getAllComponentList(@PathVariable int app_id){
		return componentServices.getAllComponents(app_id);
	}
	
	@GetMapping("/get/component/{com_id}")
	public Component getComponent(@PathVariable int com_id) {
		return componentServices.getComponent(com_id);
	}
	
	@PutMapping("/update/component/{com_id}")
	public Component updaComponent(@RequestBody Component component,@PathVariable int com_id) {
		return componentServices.updateComponent(component, com_id);
	}
	
	@DeleteMapping("/delete/component/{com_id}")
	public ResponseEntity<String> deleteComponentEntity(@PathVariable int com_id) {
		
		return componentServices.deleteComponent(com_id);
	}
	
}
