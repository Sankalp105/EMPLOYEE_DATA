package com.app.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.app.employee.entity.Employee;
import com.app.employee.repository.EmployeeRepository;
import com.app.employee.service.EmployeeService;

@SpringBootTest

class EmployeeApplicationTests {
	
	@Autowired
	private EmployeeService service;
	
	@MockBean
	private EmployeeRepository repository;
	
	@Test
	public void TestGetAllEmployees() {
		when(repository.findAll()).thenReturn(Stream.of(new Employee(23,"name",31,"2024-02-11 00:00:00.000000"),new Employee(24,"name2",33,"2024-02-10 00:00:00.000000")).collect(Collectors.toList()));
		assertEquals(2, service.getAllEmployees().size());
	}
	
	@Test
	public void TestDeleteEmployee() {
		Long id=(long) 3;
		service.deleteEmployee(id);
		verify(repository,times(1)).deleteById(id);
	}

}
