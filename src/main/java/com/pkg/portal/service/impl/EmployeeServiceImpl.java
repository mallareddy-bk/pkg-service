/**
 * 
 */
package com.pkg.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkg.portal.model.employee.Employee;
import com.pkg.portal.repository.EmployeeRepository;
import com.pkg.portal.service.EmployeeService;

/**
 * @author Mallareddy Belageri
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
    private EmployeeRepository repository;
	
	@Override
	public void createEmployee(Employee employee) {
		repository.save(employee);
		
	}

	@Override
	public List<Employee> findEmployees() {
		return (List<Employee>) repository.findAll();
	}

	@Override
	public Employee getEmployeeByEmpId(String empId) {
		return repository.findByEmpId(empId);
	}

	@Override
	public Employee getEmployeeByEmailId(String emailId) {
		return repository.findByEmailId(emailId);
	}

}
