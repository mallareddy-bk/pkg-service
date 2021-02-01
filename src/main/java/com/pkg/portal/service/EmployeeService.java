/**
 * 
 */
package com.pkg.portal.service;

import java.util.List;

import com.pkg.portal.model.employee.Employee;

/**
 * @author Mallareddy Belageri
 *
 */
public interface EmployeeService {
	
	void createEmployee(Employee employee);
	
	List<Employee> findEmployees();

	Employee getEmployeeByEmpId(String empId);
	
	Employee getEmployeeByEmailId(String emailId);

}
