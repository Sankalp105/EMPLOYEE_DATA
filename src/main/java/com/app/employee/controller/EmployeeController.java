package com.app.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.employee.entity.Employee;
import com.app.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/getAllEmployees")
	public List<Employee> getEmployees() {
		return employeeService.getAllEmployees();	
	}
	
	@RequestMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam Long id) {
		employeeService.deleteEmployee(id);
		return "Deleted succefully with id "+id; 
		
	}
}
