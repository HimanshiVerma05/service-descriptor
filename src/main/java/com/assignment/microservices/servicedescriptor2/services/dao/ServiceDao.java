package com.assignment.microservices.servicedescriptor2.services.dao;

public class ServiceDao {
    
	private Double price;
	private int id;	
	private String description;
	private String serviceName;
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public ServiceDao(int id,String description, Double price,String serviceName) {
		this.id = id;
		this.price = price;
		this.serviceName = serviceName;
		this.description = description;
	}
}
