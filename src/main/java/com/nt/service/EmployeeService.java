package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDto;
import com.nt.entity.Employee;

public interface EmployeeService {
	// Interface method to create a new employee
		public String registerEmployee(EmployeeDto employeeDto);
		// Interface method to retrieve an employee by their unique ID
		public EmployeeDto getEmployeeById(Long employeeid);
		// Interface method to retrieve a list of all employees
		public List<EmployeeDto> getAllEmployee();
		// Interface method to update all employees
		public String updateEmployee(EmployeeDto employeeDto);
		public String deleteById(EmployeeDto employeeDto);
}
