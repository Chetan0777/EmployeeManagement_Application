package com.masai.service;

import java.util.List;

import com.masai.exception.EmployeeException;
import com.masai.model.Employee;

public interface EmployeeService {
	
	public Employee findEmployeeReportingManager(Integer employeeId)throws EmployeeException;
	
	public Employee createEmployee(Employee employee)throws EmployeeException;
	
	public List<Employee> findEmployeesAllReportees(Integer employeeId)throws EmployeeException;

	public List<Employee> findEmployeeDetails(Integer employeeId)throws EmployeeException;
	
}
