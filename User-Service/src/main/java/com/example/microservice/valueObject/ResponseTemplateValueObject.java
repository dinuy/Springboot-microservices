package com.example.microservice.valueObject;

import com.example.microservice.entity.User;

public class ResponseTemplateValueObject {

	private User user;
	private Department department;

	public ResponseTemplateValueObject() {

	}

	public ResponseTemplateValueObject(User user, Department department) {

		this.user = user;
		this.department = department;

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}
