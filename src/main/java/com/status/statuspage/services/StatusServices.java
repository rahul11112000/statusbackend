package com.status.statuspage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.status.statuspage.entity.Application;
import com.status.statuspage.entity.Component;
import com.status.statuspage.entity.StatusUpdate;
import com.status.statuspage.repository.ApplicationRepository;
import com.status.statuspage.repository.ComponentRepository;
import com.status.statuspage.repository.StatusRepository;

@Service
public class StatusServices {
	@Autowired
	ComponentRepository componentRepository;
	
	@Autowired
	StatusRepository statusRepository;
	

	public StatusUpdate saveStatus(StatusUpdate statusUpdate,int id) {
		Component component = componentRepository.findById(id).get();
		statusUpdate.setComponent(component);
		return statusRepository.save(statusUpdate);
		
	}
	
	public List<StatusUpdate> getAllStatus(int appId){
		Component component = componentRepository.findById(appId).get();
		return statusRepository.findByComponent(component);
		
	}
	
	public StatusUpdate getStatus(int id) {
		return statusRepository.findById(id).get();
	}
	
	public StatusUpdate updateStatus(StatusUpdate statusUpdate,int id) {
		StatusUpdate status = statusRepository.findById(id).get(); 
		status.setStatus(statusUpdate.getStatus());
		status.setName(statusUpdate.getName());
		return statusRepository.save(status);
	}
	
	
	public ResponseEntity<String> deleteStatus(int id) {
		statusRepository.deleteById(id);
		return ResponseEntity.ok("Status Deleted Successfully");
	}
}
