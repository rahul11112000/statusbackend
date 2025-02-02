package com.status.statuspage.entity;

import com.status.statuspage.dto.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class StatusUpdate {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "component_id", nullable = false)
    private Component component;
    
    private Status status;
}
