package com.javaguides.springboot.service.impl;

import org.springframework.stereotype.Service;

import com.javaguides.springboot.model.Employee;
import com.javaguides.springboot.repository.EmployeeRepository;
import com.javaguides.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

}
