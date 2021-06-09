package com.assignment.microservices.servicedescriptor2.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.stereotype.Service;

import com.assignment.microservices.servicedescriptor2.services.ServiceDetails;
import com.assignment.microservices.servicedescriptor2.services.dao.ServiceDao;



@Service
public class ServiceDetailsImpl implements ServiceDetails {
	


	
	@Override	
	public ServiceDao getServiceByNumber(int number) {
		// TODO Auto-generated method stub
		Optional<ServiceDao> resultService = getAllServices().stream()
				.filter(p -> number==p.getId()).findFirst();
      //  List<ServiceDao> resultService = getAllServices()
		if (resultService.isPresent()) {
			return resultService.get();
		}
		
		System.out.println("data not present in the services");
		return null;
	}
	

	
	
	protected List<ServiceDao> getAllServices() {
		List<ServiceDao> services = new ArrayList<>();
		services.add(new ServiceDao(1, "Service for hiring electrician", 7.08D, "Electician"));
		services.add(new ServiceDao(2, "Service for hiring Yoga Trainer", 6.50D, "Yoga_Trainer"));
		services.add(new ServiceDao(3, "Service for hiring Interior Designer", 17.06D, "Interior_Designer"));
		services.add(new ServiceDao(4, "Service for hiring Salon", 15.33D, "Salon"));
		
		return services;
	}
	

}
