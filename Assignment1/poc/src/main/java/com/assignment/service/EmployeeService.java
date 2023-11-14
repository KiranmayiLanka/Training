package com.assignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.dao.EmployeeDao;
import com.assignment.entities.Employee;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao dao;
	
	public Employee addEmployee (Employee employee) {
		return  dao.save(employee);
//		return employee;
	}
	public List<Employee> allemployee() {
        return dao.findAll();
    }
	
	public Employee getEmployeebyId(long id) {
		Optional<Employee> employee = dao.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }
        else {
            return null;
        }
    
	}
	
	public Employee updateemployee(long id, Employee employee) {
		
		Employee currentEmployee = dao.findById(id).get();
		currentEmployee.setName(employee.getName());
		currentEmployee.setEmail(employee.getEmail());
		currentEmployee.setPhoneno(employee.getPhoneno());
		currentEmployee.setCreated_by(employee.getCreated_by());
		currentEmployee.setCreated_on(employee.getCreated_on());
		return dao.save(currentEmployee);
	}
	public void deleteEmployee (long id) {
		dao.deleteById(id);
		
	}
	
	
	
	
	
		
	

}
