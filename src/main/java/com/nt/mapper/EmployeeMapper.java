package com.nt.mapper;

import com.nt.dto.EmployeeDto;
import com.nt.entity.Employee;

public class EmployeeMapper {
	 // Static method to map an EmployeeTable object to an EmployeeDto object
		public static EmployeeDto mapToEmployeeDto(Employee employee) {
			return new EmployeeDto(
					employee.getId(),
					employee.getFirstName(),
					employee.getLastName(),
					employee.getEmail()
					);
		}
		 // Static method to map an EmployeeDto object to an EmployeeTable object
		public static Employee mapToEmployee(EmployeeDto employeedto) {
			return new Employee(
					employeedto.getId(),
					employeedto.getFirstName(),
					employeedto.getLastName(),
					employeedto.getEmail()
					);
					
		}
}
