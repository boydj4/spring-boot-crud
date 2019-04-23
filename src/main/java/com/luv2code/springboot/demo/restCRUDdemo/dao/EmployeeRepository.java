package com.luv2code.springboot.demo.restCRUDdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luv2code.springboot.demo.restCRUDdemo.entity.Employee;

@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// no need for implementation code JPA handles it all
	// getall, getone, update, and delete

	public List<Employee> findAllByOrderByLastNameAsc();
	
	
}
