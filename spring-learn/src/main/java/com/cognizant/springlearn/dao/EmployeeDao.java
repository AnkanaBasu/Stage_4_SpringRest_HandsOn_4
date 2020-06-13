package com.cognizant.springlearn.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.EmployeeNotFoundException;

@Repository
public class EmployeeDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDao.class);
    private static List<Employee> EMPLOYEE_LIST;
    
	@SuppressWarnings("unchecked")
	public EmployeeDao() {
		@SuppressWarnings("resource")
		ApplicationContext ctx=new ClassPathXmlApplicationContext("employee.xml");
		EMPLOYEE_LIST=(List<Employee>) ctx.getBean("employeeList");
	}

	public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
		LOGGER.debug("Start Method UpdateEmployee");
		Employee emp=getEmployeeById(employee.getId());
		emp.setName(employee.getName());
		emp.setDateOfBirth(employee.getDateOfBirth());
		emp.setSalary(employee.getSalary());
		emp.setDepartment(employee.getDepartment());
		emp.setSkill(employee.getSkill());
		LOGGER.debug("End Method UpdateEmployee");
	}
	public List<Employee> getAllEmployees() {
		return EMPLOYEE_LIST;
	}
	public Employee getEmployeeById(int id) throws EmployeeNotFoundException {
		for (Employee e : EMPLOYEE_LIST) {

			if (e.getId() == id) {
				return e;

			}

		}
		throw new EmployeeNotFoundException("Employee not found");
	}
		
		
	public void deleteEmployee(int id) throws EmployeeNotFoundException {
		LOGGER.info("Start Method DeleteEmployee");
		Employee employee=null;
		employee=getEmployeeById(id);
		EMPLOYEE_LIST.remove(employee);
		LOGGER.info("End Method DeleteEmployee");
	}
}
