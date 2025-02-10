package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Employee;

public interface Employee1Repository extends JpaRepository<Employee, Long> {

}
