package com.assignment.microservices.servicedescriptor2.services;

import com.assignment.microservices.servicedescriptor2.services.dao.ServiceDao;


public interface ServiceDetails {

	ServiceDao getServiceByNumber(int number);
}
