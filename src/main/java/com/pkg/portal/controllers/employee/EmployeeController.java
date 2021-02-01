/**
 * 
 */
package com.pkg.portal.controllers.employee;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pkg.portal.model.employee.Employee;
import com.pkg.portal.service.EmployeeService;

/**
 * @author Mallareddy Belageri
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({ "/employees" })
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	private List<Employee> employees = null;//createList();

	@GetMapping(produces = "application/json")
	public List<Employee> firstPage() {
		return employeeService.findEmployees();
	}

	@DeleteMapping(path = { "/{id}" })
	public Employee delete(@PathVariable("id") String id) {
		Employee deletedEmp = null;
		for (Employee emp : employees) {
			if (emp.getEmpId().equals(id)) {
				employees.remove(emp);
				deletedEmp = emp;
				break;
			}
		}
		return deletedEmp;
	}

	@PostMapping
	public Employee create(@RequestBody Employee employee) throws Exception {
		
		if (employee.getEmailId() == null || employee.getEmailId().isEmpty()
				|| employee.getName() == null | employee.getName().isEmpty()
				|| employee.getDesignation() == null | employee.getDesignation().isEmpty()
				|| employee.getEmailId() == null | employee.getEmailId().isEmpty()
				|| employee.getAddress() == null | employee.getAddress().isEmpty()
				|| employee.getIdentityNo() == null | employee.getIdentityNo().isEmpty()
				|| employee.getGender() == null | employee.getGender().isEmpty()
				|| employee.getPhoneNumber() == null | employee.getPhoneNumber().isEmpty()) {
			throw new Exception("Please enter all the required fields.");
		}
		
		Employee repoEmployee = null;
		
		repoEmployee = employeeService.getEmployeeByEmailId(employee.getEmailId());
		if (repoEmployee != null) {
			throw new Exception("Employee already existed with email ID: " + employee.getEmailId());
		}
		
		repoEmployee = employeeService.getEmployeeByEmpId(employee.getEmpId());
		if (repoEmployee != null) {
			throw new Exception("Record already existed with epmloyee ID: " + employee.getEmpId() + ". Please change it and retry.");
		}
		
		employee.setPassword("password123");
		employee.setCreatedDate(new Date());
		employeeService.createEmployee(employee);
		System.out.println(employees);
		return employee;
	}

	private List<Employee> createList() {
		List<Employee> tempEmployees = employeeService.findEmployees();
		return tempEmployees;
	}

	@PostMapping ("/login")
	public Employee login(@RequestBody Employee employee) throws Exception {
		Employee repoEmployee = employeeService.getEmployeeByEmpId(employee.getEmpId());
		if (repoEmployee != null && employee.getEmpId().equals(repoEmployee.getEmpId())
				&& employee.getPassword().equals(repoEmployee.getPassword())) {
			return repoEmployee;
		} else {
			throw new Exception("Invalid Employee ID or Password.");
		}
	}
	
}
