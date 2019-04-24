package com.chc.demo.service;

import org.springframework.stereotype.Service;

import com.chc.demo.model.Employee;

@Service
public class EmployeeInfo {

	public Employee getEmpById(int id) {
		/*
		 * Business logic for the stored procedure
		 */
		return new Employee(id, "ramesh", "12345");
	}

	public Employee create(Object obj) {
		/*
		 * Logic to save the object to database
		 */
		return (Employee) obj;
	}

}
