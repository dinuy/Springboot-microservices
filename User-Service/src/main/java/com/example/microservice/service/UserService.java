package com.example.microservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.microservice.entity.User;
import com.example.microservice.repository.UserRepository;
import com.example.microservice.valueObject.Department;
import com.example.microservice.valueObject.ResponseTemplateValueObject;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public ResponseTemplateValueObject getUserWithDepartment(Long userId) {
		
		ResponseTemplateValueObject responseObject = new ResponseTemplateValueObject();
		User user= userRepository.findByUserId(userId);
		
		//calling Department microservice using RestTemplate
		Department department = restTemplate.getForObject("http://localhost:9001/departments/"+user.getDepartmentId(),Department.class);
		responseObject.setUser(user);
		responseObject.setDepartment(department);
		return responseObject;
	}

}
