package com.javaguides.springboot.service;

import org.springframework.stereotype.Service;

import com.javaguides.springboot.model.Employee;


public interface EmployeeService  {
	Employee saveEmployee(Employee employee);
}
