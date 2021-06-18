package com.example.microservice.controller;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservice.Entity.Department;
import com.example.microservice.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;




@RestController
@RequestMapping("/departments")

public class DepartmentController {
	private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department department) {
		log.info("Inside saveDepartment method of Deparment Controller"+department.toString());
		return departmentService.saveDepartment(department);	
	}
	
	@GetMapping("/{id}")
	public Department findDepartmentById(@PathVariable("id") Long departmentId) {
		log.info("Inside find department method of Deparment Controller");
		return departmentService.findDepartmentById(departmentId);
	}

}
