package com.status.statuspage.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Component {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "application_id", nullable = false)
    private Application application;
    
}
