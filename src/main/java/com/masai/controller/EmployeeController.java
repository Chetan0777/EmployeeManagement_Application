package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.EmployeeException;
import com.masai.model.Employee;
import com.masai.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/get-employee-manager/{id}")
	public ResponseEntity<Employee> findAnEmployeeReportingManager(@PathVariable("id") Integer employeeId) throws EmployeeException {
		Employee emp = service.findEmployeeReportingManager(employeeId);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) throws EmployeeException
	{
		Employee emp = service.createEmployee(employee);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}


	@GetMapping("/get-all-reportees/{id}")
	public ResponseEntity<List<Employee>> findAnEmployeesAllReportees(@PathVariable("id") Integer employeeId) throws EmployeeException {
		List<Employee> emp = service.findEmployeesAllReportees(employeeId);
		return new ResponseEntity<List<Employee>>(emp,HttpStatus.OK);
	}
	
	@GetMapping("/get-employees/{id}")
	public ResponseEntity<List<Employee>> findAnEmployeeDetails(@PathVariable("id") Integer employeeId) throws EmployeeException {
		List<Employee> emp = service.findEmployeeDetails(employeeId);
		return new ResponseEntity<List<Employee>>(emp,HttpStatus.OK);
	}

}
