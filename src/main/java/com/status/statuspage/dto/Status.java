package com.status.statuspage.dto;

public enum Status {
	Operational,  //The service is working normally.
	MajorOutage,  //The entire service is down.
	Maintenance,  //The service is undergoing planned maintenance.
}
