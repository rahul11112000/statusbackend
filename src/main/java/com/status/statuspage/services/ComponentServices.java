package com.status.statuspage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.status.statuspage.entity.Application;
import com.status.statuspage.entity.Component;
import com.status.statuspage.repository.ApplicationRepository;
import com.status.statuspage.repository.ComponentRepository;

@Service
public class ComponentServices {
	
	@Autowired
	ComponentRepository componentRepository;
	
	@Autowired
	ApplicationRepository applicationRepository;
	

	public Component saveComponent(Component component,int id) {
		Application application = applicationRepository.findById(id).get();
		component.setApplication(application);
		return componentRepository.save(component);
		
	}
	
	public List<Component> getAllComponents(int appId){
		Application application = applicationRepository.findById(appId).get();
		return componentRepository.findByApplication(application);
		
	}
	
	public Component getComponent(int id) {
		return componentRepository.findById(id).get();
	}
	
	public Component updateComponent(Component component,int id) {
		Component com = componentRepository.findById(id).get(); 
		com.setName(component.getName());
		return componentRepository.save(com);
	}
	
	
	public ResponseEntity<String> deleteComponent(int id) {
		componentRepository.deleteById(id);
		return ResponseEntity.ok("Component Deleted Successfully");
	}
}
