package com.nt.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.EmployeeDto;
import com.nt.entity.Employee;

import com.nt.mapper.EmployeeMapper;
import com.nt.repository.Employee1Repository;


@Service
public class EmployeeServiceMgmtImpl implements EmployeeService {
	
	@Autowired
	private Employee1Repository repo;

	@Override
	public String registerEmployee(EmployeeDto employeeDto) {
		  // Convert the DTO to an Employee entity
	    Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
	    // Save the employee entity to the database
	    repo.save(employee);
	    // Return a success message
	    return "Employee with ID " + employee.getId() + " has been successfully registered.";
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeid) {
		Employee employee = repo.findById(employeeid)
	            .orElseThrow(() -> new IllegalArgumentException("Employee not found with ID: " + employeeid));
	    return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		
		List<Employee> employees = repo.findAll();
	    return employees.stream()
	                    .map(EmployeeMapper::mapToEmployeeDto)
	                    .toList();
	}

	@Override
	public String updateEmployee(EmployeeDto employeeDto) {
		
		 // Load the object from the repository
	    Optional<Employee> existingEmployee = repo.findById(employeeDto.getId());

	    if (existingEmployee.isPresent()) {
	        // Update the entity using the DTO
	        Employee employee = existingEmployee.get();
	        employee.setFirstName(employeeDto.getFirstName());
	        employee.setLastName(employeeDto.getLastName());
	        employee.setEmail(employeeDto.getEmail());
	        // Add other fields as required...

	        // Save the updated entity
	        repo.save(employee);

	        return "Employee with ID " + employeeDto.getId() + " has been updated.";
	    }

	    return "Employee with ID " + employeeDto.getId() + " not found.";
	}

	@Override
	public String deleteById(EmployeeDto employeeDto) {
		 Long id = employeeDto.getId();

	        // Check if the employee exists
	        Optional<Employee> employeeOpt = repo.findById(id);
	        if (employeeOpt.isPresent()) {
	            repo.deleteById(id);
	            return "Employee with ID " + id + " has been deleted successfully.";
	        } else {
	            return "Employee with ID " + id + " not found.";
	        }
	}
}
