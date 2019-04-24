package com.chc.demo.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chc.demo.model.Employee;
import com.chc.demo.service.EmployeeInfo;

@RestController
public class MainController {
	@Autowired
	private EmployeeInfo empServ;
	
	
	@GetMapping("/hi")
	public ResponseEntity<Object> sayHi() {
		return new ResponseEntity<>("Hello Rams",HttpStatus.OK);
	}
	
	@GetMapping("/emp/{empId}")
	public ResponseEntity<Object> getEmpById(@PathVariable final int empId){
		return  ResponseEntity.ok(empServ.getEmpById(empId));
	}
	
	@PostMapping(path = "/emp/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> setEmp(@NotNull @Valid @RequestBody final Employee employee ){
		return ResponseEntity.ok(empServ.create(employee));
	}

}
