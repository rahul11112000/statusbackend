package com.status.statuspage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
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
import com.status.statuspage.entity.StatusUpdate;
import com.status.statuspage.repository.ApplicationRepository;
import com.status.statuspage.repository.ComponentRepository;
import com.status.statuspage.services.ComponentServices;
import com.status.statuspage.services.StatusServices;

@RestController
@RequestMapping("/status")
public class StatusController {
	@Autowired
	StatusServices statusServices;
	
	@Autowired
	ApplicationRepository applicationRepository;
	
	@Autowired
	ComponentRepository componentRepository;
	
	@Autowired
    private SimpMessagingTemplate messagingTemplate;
	
	@GetMapping("/")
	public String first() {
		return "Status Admin";
	}
	
	@GetMapping("/application")
	public List<Application> getApplications(){
		return applicationRepository.findAll();
	}
	
	@GetMapping("/get-all/component/{app_id}")
	public List<Component> getComponents(@PathVariable int app_id){
		Application application = applicationRepository.findById(app_id).get();
		return  componentRepository.findByApplication(application);
	}
	
	@PostMapping("/create/status/{com_id}")
	public StatusUpdate createStatus(@RequestBody StatusUpdate statusUpdate,@PathVariable int com_id) {
		
		return statusServices.saveStatus(statusUpdate, com_id);
		
	}
	
	@GetMapping("/get-all/status/{com_id}")
	public List<StatusUpdate> getAllStatusList(@PathVariable int com_id){
		return statusServices.getAllStatus(com_id);
	}
	
	@GetMapping("/get/status/{status_id}")
	public StatusUpdate getStatus(@PathVariable int status_id) {
		return statusServices.getStatus(status_id);
	}
	
	@PutMapping("/update/status/{status_id}")
	public StatusUpdate updateStatus(@RequestBody StatusUpdate status,@PathVariable int status_id) {
		
		StatusUpdate statusUpdate = statusServices.updateStatus(status, status_id);
		
		messagingTemplate.convertAndSend("/topic/status-updates", statusUpdate);
		
		return statusUpdate;
	}
	
	@DeleteMapping("/delete/status/{status_id}")
	public ResponseEntity<String> deleteStatus(@PathVariable int status_id) {
		
		return statusServices.deleteStatus(status_id);
	}
}
