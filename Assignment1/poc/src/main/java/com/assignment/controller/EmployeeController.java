package com.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.entities.Employee;
import com.assignment.service.EmployeeService;
@RestController

public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/add")
	public Employee addEmployee (@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		return employee;	
	}
	
	@GetMapping("/findall")
	public List<Employee> allemployee() {
        return employeeService.allemployee();
    }
	
	@GetMapping("/findbyId/{id}")
	
		public Employee getEmployeebyId (@PathVariable long id) {
		return employeeService.getEmployeebyId(id);
	}
	
	@PutMapping("/update/{id}")
    public Employee updateemployee( @PathVariable long id, @RequestBody Employee employee) {
		return employeeService.updateemployee(id,employee);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteEmployee (@PathVariable long id) {
		employeeService.deleteEmployee(id);
	}

}
