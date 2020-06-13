package com.cognizant.springlearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.EmployeeNotFoundException;
import com.cognizant.springlearn.dao.EmployeeDao;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}
	public Employee getEmployeeById(int id) throws EmployeeNotFoundException {
		return employeeDao.getEmployeeById(id);
	}
	public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
		employeeDao.updateEmployee(employee);
	}
	public void deleteEmployee(int id) throws EmployeeNotFoundException {
		employeeDao.deleteEmployee(id);
	}
}
