package com.assignment.microservices.servicedescriptor2.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.assignment.microservices.servicedescriptor2.entity.ServiceEntity;
import com.assignment.microservices.servicedescriptor2.repository.ServiceRepository;
import com.assignment.microservices.servicedescriptor2.services.ServiceDetails;
import com.assignment.microservices.servicedescriptor2.services.dao.ServiceDao;


@RestController
public class ServiceDescriptorController {
	
	@Autowired
    private ServiceRepository serviceRepository;
	
	@Resource
	ServiceDetails serviceDetails;

	
	
	 @GetMapping("/service/{id}")
	    public ResponseEntity < ServiceEntity > getServiceById(@PathVariable(value = "id") Long serviceId)
	     {
		 Optional<ServiceEntity> serviceFind = serviceRepository.findById(serviceId);
			ServiceEntity service=new ServiceEntity();
			if(serviceFind.isPresent())
			{
				System.out.println("service with id found");
				service=serviceFind.get();
			return ResponseEntity.ok().body(service);
		}
	        return null;
	    }
	
	@GetMapping("getServices")
	public List<ServiceEntity> getAllServices()
	{
		return serviceRepository.findAll();
	}
	
@PostMapping(value = "addService", consumes = MediaType.APPLICATION_JSON_VALUE)
	
	public Long addService(@RequestBody ServiceEntity newService)
	{
		
	ServiceEntity service=new ServiceEntity();
	
	service.setPrice(newService.getPrice());
	service.setDescription(newService.getDescription());
	service.setServiceName(newService.getServiceName());
		
     final ServiceEntity newServicee = serviceRepository.save(service);
     return newServicee.getId();
		
	
	}

@PutMapping("/updateService/{id}")
public ResponseEntity < ServiceEntity > updateUser(@PathVariable(value = "id") Long serviceId,
     @RequestBody ServiceEntity serviceDetails)  {
	Optional<ServiceEntity> serviceFind = serviceRepository.findById(serviceId);
	ServiceEntity service=new ServiceEntity();
	if(serviceFind.isPresent())
	{
		service=serviceFind.get();
		service.setPrice(serviceDetails.getPrice());
		service.setDescription(serviceDetails.getDescription());
		service.setServiceName(serviceDetails.getServiceName());
	
    final ServiceEntity updatedService = serviceRepository.save(service);
    return ResponseEntity.ok(updatedService);
	}
	
		return null;
}

@DeleteMapping("/deleteService/{id}")
public Map < String, Boolean > deleteService(@PathVariable(value = "id") Long serviceId)
 {
    Optional<ServiceEntity> serviceFind = serviceRepository.findById(serviceId);
    ServiceEntity service=new ServiceEntity();
	if(serviceFind.isPresent()) {    
    service=serviceFind.get();
    serviceRepository.delete(service);
    Map < String, Boolean > response = new HashMap < > ();
    response.put("deleted", Boolean.TRUE);
    return response;
 }
return null;

}
	

}
