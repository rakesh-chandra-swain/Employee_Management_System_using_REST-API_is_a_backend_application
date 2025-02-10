package com.nt.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.nt.dto.EmployeeDto;

import com.nt.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
		@Autowired
		private EmployeeService service;
		
		@PostMapping("/add")
		public ResponseEntity<String> enrollEmployee(@RequestBody EmployeeDto employeeDto){
			try {
				//use service
				String resultMsg=service.registerEmployee(employeeDto);
				return new ResponseEntity<String>(resultMsg,HttpStatus.CREATED);
			}
			catch(Exception e) {
				return new ResponseEntity<String>("Problem is Employee Enrollment",HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		@GetMapping("/add/{id}")
		public ResponseEntity<?> getEmployeeFindById(@PathVariable("id") Long employeeid){
			try {
				//use service
				EmployeeDto employee=service.getEmployeeById(employeeid);
				return new ResponseEntity<>(employee,HttpStatus.OK);
			}
			catch(Exception e) {
				return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		@GetMapping("/all")
		public ResponseEntity<?> showAllEmployee(){
			try {
				//use Service
				List<EmployeeDto> employee=service.getAllEmployee();
				return new ResponseEntity<List<EmployeeDto>>(employee,HttpStatus.OK);
			}
			catch(Exception e) {
				return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		@PutMapping("/update")
		public ResponseEntity<?> updateAllEmployee(@RequestBody EmployeeDto employeeDto){
			try {
				//use service
				String msg=service.updateEmployee(employeeDto);
				return new ResponseEntity<String>(msg,HttpStatus.OK);
			}
			catch(Exception e) {
				return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		@DeleteMapping("/deleteById")
		public ResponseEntity<?> deleteById( @RequestBody EmployeeDto employeeDto){
			try {
				//use service
				String msg=service.deleteById(employeeDto);
				return new ResponseEntity<String>(msg,HttpStatus.OK);
			}
			catch(Exception e) {
				return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		}

