package com.springboot2angular.springboot2jpacrudapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot2angular.springboot2jpacrudapplication.model.Employee;

@Repository 
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	
	

}
