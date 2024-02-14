package com.app.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.employee.entity.Employee;
import com.app.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	public void deleteEmployee(Long id){
		employeeRepository.deleteById(id);
	}
}
