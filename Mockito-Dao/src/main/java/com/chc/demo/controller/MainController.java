package com.chc.demo.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chc.demo.entity.EmployeeEntity;
import com.chc.demo.service.EmployeeInfo;

@RestController
public class MainController {
	@Autowired
	private EmployeeInfo empServ;
	
	
	@GetMapping("/emp/{name}")
	public ResponseEntity<Object> getEmpByName(@PathVariable final String name){
		return  ResponseEntity.ok(empServ.getEmpByName(name));
	}
	
	@PostMapping(path = "/emp/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeEntity> setEmp(@NotNull @Valid @RequestBody final EmployeeEntity employee ){
		return ResponseEntity.ok(empServ.create(employee));
	}

}
