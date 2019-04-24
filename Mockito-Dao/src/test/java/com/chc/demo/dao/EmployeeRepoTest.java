package com.chc.demo.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.chc.demo.entity.EmployeeEntity;
@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepoTest {

	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	EmployeeRepo empRepo;
	
	@Test
	public void findByEmpNameTest() {
		EmployeeEntity emp = new EmployeeEntity(123,"sample",12345);
		EmployeeEntity savedInDb = entityManager.persist(emp);
		
		EmployeeEntity getFromDb = empRepo.findByEmpName(savedInDb.getName());
		assertThat(savedInDb.getId()).isEqualTo(getFromDb.getId());
	}

}
