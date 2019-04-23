package com.luv2code.springboot.demo.restCRUDdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.demo.restCRUDdemo.dao.EmployeeRepository;
import com.luv2code.springboot.demo.restCRUDdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	// repository handles all DBA methods and @Transactional
	private EmployeeRepository employeeRepository;
	
	// use qualifier to determine which DAO impl to use
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findById(int theId) {
		
		//JPA repository uses optionals
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee = null;
		
		if(result.isPresent()) {
			theEmployee = result.get();
		} else {
			// we didn't find employee
			throw new RuntimeException("Did not find employee by id - " + theId);
		}
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

}
