package com.example.microservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservice.Entity.Department;
import com.example.microservice.repository.DepartmentRepository;


@Service
public class DepartmentService {
	private static final Logger log = LoggerFactory.getLogger(DepartmentService.class);
	
	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		log.info("inside save department in department service class");
		return departmentRepository.save(department);
	}


	public Department findDepartmentById(Long departmentId) {
		// TODO Auto-generated method stub
		log.info("inside find department in department service class");
		return departmentRepository.findByDepartmentId(departmentId);
	}
	
	

}
