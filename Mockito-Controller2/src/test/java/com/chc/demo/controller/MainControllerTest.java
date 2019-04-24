package com.chc.demo.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.chc.demo.model.Employee;
import com.chc.demo.service.EmployeeInfo;
import com.chc.demo.utils.Utils;

@RunWith(SpringRunner.class)
@WebMvcTest(value = MainController.class)
public class MainControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	EmployeeInfo employeeInfo;

	static Utils utils;

	@BeforeClass
	public static void initialize() {
		utils = new Utils();
	}

	@Test
	public void testPostEmp_checkStatus() throws Exception {		
		Employee mockEmp = new Employee();
		mockEmp.setId(1111);
		mockEmp.setName("remo");
		mockEmp.setSal("10000");

		// Object to Json
		String inputInJson = utils.mapToJson(mockEmp);

		String URI = "/emp/";
		Mockito.when(employeeInfo.create(Mockito.any(Employee.class))).thenReturn(mockEmp);

		mockMvc.perform(MockMvcRequestBuilders.post(URI).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputInJson).accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());
	}

	@Test
	public void testGetEmp_checkStatus() throws Exception {
		int id = 123458;
		Employee mockEmp = new Employee();
		mockEmp.setId(id);
		mockEmp.setName("ramesh");
		mockEmp.setSal("12345");

		Mockito.when(employeeInfo.getEmpById(Mockito.any(Integer.class))).thenReturn(mockEmp);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/emp/{id}", id).accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("ramesh"));
	}

}
