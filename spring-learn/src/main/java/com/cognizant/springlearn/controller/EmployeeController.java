package com.cognizant.springlearn.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.EmployeeNotFoundException;
import com.cognizant.springlearn.service.EmployeeService;

@RestController
public class EmployeeController {
@Autowired
private EmployeeService employeeService;
@GetMapping("/employees")
public List<Employee> getallEmployee() {
	return employeeService.getAllEmployees();
}

@GetMapping("/employees/{id}")
public Employee getEmployeeById(@PathVariable int id) throws EmployeeNotFoundException {
	return employeeService.getEmployeeById(id);
}

@PutMapping("/employees")
public void updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException{
	employeeService.updateEmployee(employee);
}

@DeleteMapping("/employees/{id}")
public void deleteEmployee(@PathVariable int id) throws EmployeeNotFoundException{
	employeeService.deleteEmployee(id);
}

}
