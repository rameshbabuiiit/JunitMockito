package com.chc.demo.service;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.chc.demo.dao.EmployeeRepo;
import com.chc.demo.entity.EmployeeEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeInfoTest {
	
	 @Autowired
	 EmployeeInfo employeeInfo;
	 
	@MockBean
	private EmployeeRepo repo;

	@Test
	public void getEmpByNameTest() throws Exception {
		EmployeeEntity emp = new EmployeeEntity(999, "testName", 9999);
		when(repo.findByEmpName(Mockito.anyString())).thenReturn(emp);
		String getName = "xyzabc";
		assertEquals(999,employeeInfo.getEmpByName(getName).getId());
	}
	
	
	@Test
	public void createTest() {
		EmployeeEntity emp = new EmployeeEntity(999, "testName", 9999);
		when(repo.save(Mockito.any(EmployeeEntity.class))).thenReturn(emp);
		assertEquals(emp,employeeInfo.create(emp));
		verify(repo,times(1)).save(emp);
	}
	
	
	
	

}
