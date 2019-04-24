package com.chc.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chc.demo.dao.EmployeeRepo;
import com.chc.demo.entity.EmployeeEntity;

@Service
public class EmployeeInfo {
	
	@Autowired
	EmployeeRepo repo;

	public EmployeeEntity getEmpByName(String name) {
		return repo.findByEmpName(name);
	}

	public EmployeeEntity create(EmployeeEntity obj) {
		repo.save(obj);
		return obj;
	}

}
