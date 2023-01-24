package com.masai.serviceimpl;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.EmployeeException;
import com.masai.model.Employee;
import com.masai.repository.EmployeeDao;
import com.masai.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDao emp;

	@Override
	public Employee findEmployeeReportingManager(Integer employeeId) throws EmployeeException 
	{
		Optional<Employee> employee1 = emp.findById(employeeId);
		if(employee1.isEmpty())
			throw new EmployeeException("Employee Not Exist");
		Employee employee = employee1.get();
		Optional<Employee> manager = emp.findById(employee.getReportingManagerId());
		if(manager.isEmpty())
			throw new EmployeeException("Manager Not Exist");
		
		return manager.get();
	}
	
	@Override
	public Employee createEmployee(Employee employee) throws EmployeeException
	{
		if(employee.getReportingManagerId() == null) {
			return emp.save(employee);
		}
		Optional<Employee> manager = emp.findById(employee.getReportingManagerId());
		if(manager.isEmpty())
			throw new EmployeeException("Manager Not Exist");
		return emp.save(employee);
		
	}

	@Override
	public List<Employee> findEmployeesAllReportees(Integer employeeId) throws EmployeeException {
		
		List<Employee> emplist = emp.findAll();
		if(emplist.size() == 0) {
			throw new EmployeeException("Reportee Not Exist");
		}
		HashSet<Integer> reasult = new HashSet<>();
		emplist.forEach(i->{
			if(i.getReportingManagerId() != null) {
				reasult.add(i.getReportingManagerId());
			}
		});
		List<Employee> employee =new ArrayList<>();
		reasult.forEach(m->{
			emplist.forEach(e->{
				if(e.getEmployeeId() == m)
					employee.add(e);
			});
		});
		if(employee.size()==0) {
			throw new EmployeeException("Reportee Not Exist");
		}
		return employee;
	}
	
	@Override
	public List<Employee> findEmployeeDetails(Integer employeeId) throws EmployeeException {
		List<Employee> emplist = emp.findByReportingManagerId(employeeId);
		if(emplist.size()==0) {
			throw new EmployeeException("Employee Not Exist");
		}
		return emplist;
	}

}
